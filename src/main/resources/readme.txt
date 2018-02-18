1) Создать локальную MySQL базу данных "module4_http";
2) В ..\GoJava_developer_module4\src\main\resources\hibernate.cfg.xml указать порт базы данных на localhost, username & password;

3.0) (запуск на tomcat сервере) в ..\GoJava_developer_module4 выполнить {mvn package}, полученный файл ..\GoJava_developer_module4\target\servlets.war скопировать в папку tomcat: %CATALINA_HOME%\webapps;
3.1) Запустить tomcat сервер, доступ к приложению по адресу http://localhost:%tomcat_port%/servlets/index

4.0)(запуск из tomcat плагина в IntelliJ IDEA)  В ..\GoJava_developer_module4\pom.xml в настойках плагина tomcat7-maven-plugin указать порт, на котором он будет запускаться;
4.1) Запустить tomcat плагин {mvn tomcat7:run}, доступ к приложению по адресу http://localhost:%tomcat_plugin_port%/index
