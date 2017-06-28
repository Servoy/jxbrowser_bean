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

import javax.swing.JPanel;

import com.servoy.j2db.dataprocessing.IRecord;
import com.servoy.j2db.dataui.IServoyAwareVisibilityBean;
import com.servoy.j2db.plugins.IClientPluginAccess;
import com.servoy.j2db.ui.IComponent;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

/**
 * @author lvostinar
 *
 */
public class ServoyJXBrowser extends JPanel implements IComponent, IServoyAwareVisibilityBean, IJXBrowserScriptMethods
{
	private BrowserView view;

	public ServoyJXBrowser()
	{
		super();
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
		view.getBrowser().loadURL(url);
	}

	@Override
	public void loadHTML(String html)
	{
		createBrowserViewIfNeeded();
		view.getBrowser().loadHTML(html);
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
			remove(view);
			view = null;
		}
	}

	private void createBrowserViewIfNeeded()
	{
		if (view == null)
		{
			view = new BrowserView(new Browser());
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
}
