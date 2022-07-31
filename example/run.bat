@echo

set mypath=%~dp0
set sourceFolder=%mypath%\Source\99.The-Land-of-The-Rising-Sun
set sourceCSV=%mypath%\Source\99.The-Land-of-The-Rising-Sun.csv

java -jar maxicon.jar %sourceCSV% %sourceFolder%

pause