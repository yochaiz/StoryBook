set datetimef=%date:~0,2%-%date:~3,2%-%date:~-2% H%time:~0,2%-%time:~3,2%
set fileName="Archive\AnyOneCan D%datetimef%.zip"
zip %fileName% %cd%\app\src\main\java\com\example\yiz\anyonecan\*.java
zip %fileName% %cd%\app\src\main\res\layout\*.xml
zip %fileName% %cd%\app\src\main\res\menu\*.xml
zip %fileName% %cd%\app\src\main\res\values\*.xml
zip %fileName% %cd%\app\src\main\res\values-w820dp\*.xml