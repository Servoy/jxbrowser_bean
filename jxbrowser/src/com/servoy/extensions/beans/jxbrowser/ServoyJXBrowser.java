/*
 This file belongs to the Servoy development and deployment environment, Copyright (C) 1997-2017 Servoy BV

 This program is free software; you can redistribute it and/or modify it under
 the terms of the GNU Affero General Public License as published by the Free
 Software Foundation; either version 3 of the License, or (at your option) any
 later version.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License along
 with this program; if not, see http://www.gnu.org/licenses or write to the Free
 Software Foundation,Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301
*/

package com.servoy.extensions.beans.jxbrowser;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.JPanel;

import com.servoy.j2db.dataprocessing.IRecord;
import com.servoy.j2db.dataui.IServoyAwareVisibilityBean;
import com.servoy.j2db.plugins.IClientPluginAccess;
import com.servoy.j2db.scripting.JSMap;
import com.servoy.j2db.ui.IComponent;
import com.servoy.j2db.util.Debug;
import com.servoy.j2db.util.IDestroyable;
import com.teamdev.jxbrowser.browser.callback.InjectJsCallback;
import com.teamdev.jxbrowser.browser.event.ConsoleMessageReceived;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.js.ConsoleMessage;
import com.teamdev.jxbrowser.js.ConsoleMessageLevel;
import com.teamdev.jxbrowser.js.JsObject;
import com.teamdev.jxbrowser.navigation.event.NavigationRedirected;
import com.teamdev.jxbrowser.navigation.event.NavigationStarted;
import com.teamdev.jxbrowser.view.swing.BrowserView;

/**
 * @author lvostinar
 *
 */
public class ServoyJXBrowser extends JPanel implements IComponent, IServoyAwareVisibilityBean, IJXBrowserScriptMethods, IDestroyable
{
	private BrowserView view;
	private Engine engine;
	private ServoyMethodCaller caller;
	
	public ServoyJXBrowser(ServoyMethodCaller caller)
	{
		super();
		this.caller = caller;
		setLayout(new BorderLayout());
	}

	@Override
	public void setComponentEnabled(boolean enabled)
	{
		setEnabled(enabled);

	}

	@Override
	public void setComponentVisible(boolean visible)
	{
		super.setVisible(visible);
	}

	@Override
	public String getId()
	{
		return null;
	}

	@Override
	public void loadURL(String url)
	{
		createBrowserViewIfNeeded();
		view.getBrowser().navigation().loadUrl(url);
	}

	@Override
	public void loadHTML(String html)
	{
		createBrowserViewIfNeeded();
		view.getBrowser().mainFrame().ifPresent(mainFrame ->
        mainFrame.loadHtml(html));
	}

	@Override
	public void notifyVisible(boolean visible)
	{
		if (visible)
		{
			createBrowserViewIfNeeded();
			add(view);
		}
		else if (view != null)
		{
			if (view.getBrowser() != null) view.getBrowser().close();
			engine.close();
			remove(view);
			view = null;
			engine = null;
		}
	}

	private void createBrowserViewIfNeeded()
	{
		if (view == null)
		{
			engine = Engine.newInstance(
	                EngineOptions.newBuilder(RenderingMode.HARDWARE_ACCELERATED).build());
			view = BrowserView.newInstance(engine.newBrowser());
			view.getBrowser().set(InjectJsCallback.class, params -> {
			     JsObject window = params.frame().executeJavaScript("window");
			     if (window != null) {
			         window.putProperty("servoy", caller);
			     }
			     return InjectJsCallback.Response.proceed();
			 });
			view.getBrowser().on(ConsoleMessageReceived.class, event -> {
			    ConsoleMessage consoleMessage = event.consoleMessage();
			    if (ConsoleMessageLevel.LEVEL_ERROR_VALUE == consoleMessage.level().getNumber())
			    {
			    	Debug.error("Error from JXBrowser console: " + consoleMessage.message());
			    }
			    else if (ConsoleMessageLevel.WARNING_VALUE== consoleMessage.level().getNumber()) {
			    	Debug.warn("Warning from JXBrowser console: " + consoleMessage.message());
			    }
			});
			view.getBrowser().navigation().on(NavigationStarted.class, event -> {
			    String url = event.url();
			    if (url.startsWith("callback://"))
			    {
			    	event.navigation().stop();
			    	String methodName = null;
			    	Map<String,String> argument = null;
			    	int queryStart = url.indexOf("?");
			    	if (queryStart >= 0)
			    	{
			    		argument = new JSMap<String,String>();
			    		methodName = url.substring(11,queryStart);
			    		String queryString = url.substring(queryStart +1);
			    		String[] params = queryString.split("&");
			    		for (String param : params)
			    		{
			    			String[] splitParam = param.split("=");
			    			if (splitParam.length == 2)
			    			{
			    				argument.put(splitParam[0], splitParam[1]);
			    			}	
			    		}	
			    	}
			    	else
			    	{
			    		methodName = url.substring(11);
			    	}	
			    	caller.executeMethodInternal(methodName, argument);
			    }
			});
		}
	}

	@Override
	public void initialize(IClientPluginAccess access)
	{

	}

	@Override
	public void setSelectedRecord(IRecord record)
	{

	}

	@Override
	public void setValidationEnabled(boolean mode)
	{

	}

	@Override
	public boolean stopUIEditing(boolean looseFocus)
	{
		return true;
	}

	@Override
	public boolean isReadOnly()
	{
		return true;
	}
	
	public void destroy()
	{
		if (view != null)
		{
			if (view.getBrowser() != null) view.getBrowser().close();
			view = null;
		}
	}
}
