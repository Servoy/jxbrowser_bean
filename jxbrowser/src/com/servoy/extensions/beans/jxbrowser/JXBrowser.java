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

import com.servoy.j2db.IServoyBeanFactory;
import com.servoy.j2db.plugins.IClientPluginAccess;
import com.servoy.j2db.ui.IComponent;
import com.servoy.j2db.util.Debug;

/**
 * @author lvostinar
 *
 */
public class JXBrowser implements IServoyBeanFactory
{
	@Override
	public String getName()
	{
		return "JXBrowser";
	}

	@Override
	public IComponent getBeanInstance(int servoyApplicationType, IClientPluginAccess access, Object[] cargs)
	{
		if (servoyApplicationType == IClientPluginAccess.WEB_CLIENT || servoyApplicationType == IClientPluginAccess.HEADLESS_CLIENT)
		{
			return new EmptyWicketJXBrowser((String)cargs[0]);
		}
		else if (isJXBrowserAvailable(getClass().getClassLoader()))
		{
			try
			{
				return new ServoyJXBrowser();
			}
			catch (Exception ex)
			{
				Debug.error(ex);
			}
			catch (NoClassDefFoundError e)
			{
				Debug.error(e);
			}
		}
		return new EmptyJXBrowser();

	}

	private static boolean isJXBrowserAvailable(ClassLoader classLoader)
	{
		try
		{
			Class.forName("com.teamdev.jxbrowser.browser.Browser", false, classLoader); //$NON-NLS-1$
			return true;
		}
		catch (Exception e)
		{
			// ignore
		}
		return false;
	}
}
