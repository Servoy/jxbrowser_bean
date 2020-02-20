package com.servoy.extensions.beans.jxbrowser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.servoy.j2db.plugins.IClientPluginAccess;
import com.servoy.j2db.util.Debug;
import com.teamdev.jxbrowser.js.JsAccessible;
import com.teamdev.jxbrowser.js.JsObject;

public class ServoyMethodCaller {

	private IClientPluginAccess access;
	
	public ServoyMethodCaller(IClientPluginAccess access)
	{
		this.access = access;
	}
	
	@JsAccessible
	public void executeMethod(String methodname, JsObject arguments)
	{
		List<Object> argumentsList = null; 
		if (arguments != null)
		{
			argumentsList = new ArrayList<Object>();
			for (String name : arguments.propertyNames())
			{
				Object value = arguments.property(name);
				if (value instanceof Optional)
				{
					value = ((Optional)value).get();
				}	
				argumentsList.add(value);
			}
		}
		this.executeMethodInternal(methodname,  argumentsList != null ? argumentsList.toArray() : null);
	}
	
	public void executeMethodInternal(String methodname, Map<String,String> argument)
	{
		this.executeMethodInternal(methodname,  argument != null ? new Object[] {argument} : null);
	}
	
	private void executeMethodInternal(String methodname, Object[] arguments) 
	{
		String context = null;
		if (methodname != null && methodname.startsWith("forms."))
		{
			String[] parts = methodname.split("\\.");
			if (parts.length == 3)
			{
				context = parts[1];
				methodname = parts[2];
			}	
		}	
		try
		{
			this.access.executeMethod(context, methodname,  arguments, true);
		}
		catch(Exception e)
		{
			Debug.error(e);
		}
	}
}
