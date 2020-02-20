# JXBrowser Bean

JXBrowser bean is a Servoy bean which wraps the library https://www.teamdev.com/jxbrowser . This bean is only supported in Smart Client, can be used to display any html or url inside Smart Client in Chrome engine library (Chromium). 

# JXBrowser Library

Note that JxBrowser is a commercial product, not included by default in this bean. You must buy/acquire the library from TeamDev in order for the bean to work.

# Bean Usage

The bean release is a zip file containing the actual bean (jar file). This jar, together with all JxBrowser jars (license.jar, jxbrowser.jar and os specific jars), must be placed in application_server/beans folder of your install (cannot use subdirectories). Servoy  will then automatically use these jars both in developer and Smart Client. Note that for Smart Client, the jars must all be signed if you don't use the bootstrapper. The bean jar itself is signed by servoy. 

# Bean Api

Currently , bean has two methods, loadURL and loadHTML that can be used to display html/url code. More api could be added in future, see https://www.teamdev.com/downloads/jxbrowser/javadoc/index.html for JxBrowser API.

# Bean Callback Support

In 2.0.1 release we added support for callback. This can be achieved in two ways:
1. Using servoy.executeMethod API
  We added a new property to javascript window named servoy. 'servoy' object has only one method with folowing signature:
  executeMethod(methodName,array_of_arguments)
  - methodName is full path to a method (like scopes.myscope.mymethod or forms.myform.mymethod) , the elements in the array are sent as     parameters to the callback method; this API is async so you cannot return a value from callback (sync support could be added, if         needed)
  - example: <a href="javascript:servoy.executeMethod('forms.orders.mycallback',['par1','par2','par3'])">callback test</a>
2. Using callback URL
  We intercept the navigation to a special URL:
  callback://methodName?key1=value1&key2=value2
  This will stop the navigation and just execute the callback. Method name is the same as in API (full qualified path to method) , the     URL params will be sent as an object parameter to callback method
  - example: <a href="callback://forms.orders.mycallback?par1=value1&par2=value2">callback test</a>
  This example will call forms.orders.mycallback using {par1:value1,par2:value2} as parameter
