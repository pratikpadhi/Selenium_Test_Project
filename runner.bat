Set projectLocation=C:\Users\Pratik Padhi\eclipse-workspace\Selenium_Test_Project
cd %projectLocation%
Set classPath=%projectLocation%\bin;%projectLocation%\Externallibs\*
java org.testng.TestNG testng.xml
pause