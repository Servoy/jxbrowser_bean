# JXBrowser Bean

JXBrowser bean is a Servoy bean which wraps the library https://www.teamdev.com/jxbrowser . This bean is only supported in Smart Client, can be used to display any html or url inside Smart Client in Chrome engine library (Chromium). 

# JXBrowser Library

Note that JxBrowser is a commercial product, not included by default in this bean. You must buy/acquire the library from TeamDev in order for the bean to work.

# Bean Usage

The bean release is a zip file containing the actual bean (jar file). This jar, together with all JxBrowser jars (license.jar, jxbrowser.jar and os specific jars), must be placed in application_server/beans folder of your install (cannot use subdirectories). Servoy  will then automatically use these jars both in developer and Smart Client. Note that for Smart Client, the jars must be signed with same certificate. 

# Bean Api

Currently , bean has two methods, loadURL and loadHTML that can be used to display html/url code. More api could be added in future, see https://www.teamdev.com/downloads/jxbrowser/javadoc/index.html for JxBrowser API.
