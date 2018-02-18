1) Создать локальную MySQL базу данных "module4_http";
2) Выполнить скрипт ..\GoJava_developer_module4\src\main\resources\sqlScripts\initDB.sql для создания таблиц;
3) В ..\GoJava_developer_module4\src\main\resources\hibernate.cfg.xml указать порт базы данных на localhost, username & password;

4.0) (запуск на tomcat сервере) в ..\GoJava_developer_module4 выполнить {mvn package}, полученный файл ..\GoJava_developer_module4\target\servlets.war скопировать в папку tomcat: %CATALINA_HOME%\webapps;
4.1) Запустить tomcat сервер, доступ к приложению по адресу http://localhost:%tomcat_port%/servlets/index

5.0)(запуск из tomcat плагина в IntelliJ IDEA)  В ..\GoJava_developer_module4\pom.xml в настойках плагина tomcat7-maven-plugin указать порт, на котором он будет запускаться;
5.1) Запустить tomcat плагин {mvn tomcat7:run}, доступ к приложению по адресу http://localhost:%tomcat_plugin_port%/index
