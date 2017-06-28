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

import javax.swing.JLabel;

import com.servoy.j2db.ui.IComponent;

/**
 * @author lvostinar
 *
 */
public class EmptyJXBrowser extends JLabel implements IComponent, IJXBrowserScriptMethods
{

	public EmptyJXBrowser()
	{
		super(
			"Cannot initialize JXBrowser bean because JxBrowser library was not found. JxBrowser jars must be placed in beans folder of the application server.");
	}

	@Override
	public void setComponentEnabled(boolean enabled)
	{

	}

	@Override
	public void setComponentVisible(boolean visible)
	{

	}

	@Override
	public String getId()
	{
		return null;
	}

	@Override
	public void loadURL(String url)
	{

	}

	@Override
	public void loadHTML(String html)
	{

	}

}
