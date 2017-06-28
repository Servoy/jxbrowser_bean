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

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.border.Border;

import org.apache.wicket.markup.html.basic.Label;

import com.servoy.j2db.ui.IComponent;

/**
 * @author lvostinar
 *
 */
public class EmptyWicketJXBrowser extends Label implements IComponent
{

	private final String id;

	public EmptyWicketJXBrowser(String id)
	{
		super(id, "JXBrowser is not supported in web client");
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setComponentEnabled(boolean)
	 */
	@Override
	public void setComponentEnabled(boolean enabled)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setComponentVisible(boolean)
	 */
	@Override
	public void setComponentVisible(boolean visible)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setLocation(java.awt.Point)
	 */
	@Override
	public void setLocation(Point location)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#getLocation()
	 */
	@Override
	public Point getLocation()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setSize(java.awt.Dimension)
	 */
	@Override
	public void setSize(Dimension size)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#getSize()
	 */
	@Override
	public Dimension getSize()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setForeground(java.awt.Color)
	 */
	@Override
	public void setForeground(Color foreground)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#getForeground()
	 */
	@Override
	public Color getForeground()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setBackground(java.awt.Color)
	 */
	@Override
	public void setBackground(Color background)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#getBackground()
	 */
	@Override
	public Color getBackground()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setFont(java.awt.Font)
	 */
	@Override
	public void setFont(Font font)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#getFont()
	 */
	@Override
	public Font getFont()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setBorder(javax.swing.border.Border)
	 */
	@Override
	public void setBorder(Border border)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#getBorder()
	 */
	@Override
	public Border getBorder()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setName(java.lang.String)
	 */
	@Override
	public void setName(String name)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#getName()
	 */
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setOpaque(boolean)
	 */
	@Override
	public void setOpaque(boolean opaque)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#isOpaque()
	 */
	@Override
	public boolean isOpaque()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setCursor(java.awt.Cursor)
	 */
	@Override
	public void setCursor(Cursor cursor)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#setToolTipText(java.lang.String)
	 */
	@Override
	public void setToolTipText(String tooltip)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.servoy.j2db.ui.IComponent#getToolTipText()
	 */
	@Override
	public String getToolTipText()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.wicket.Component#getId()
	 */
	@Override
	public String getId()
	{
		return id;
	}

}
