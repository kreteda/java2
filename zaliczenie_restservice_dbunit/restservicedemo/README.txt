Czynności wymagane do uruchomienia projektu:

1. uruchomić serwer hsqldb za pomocą polecenia ./runHSQLDBServer.sh 
2. wykonać polecenie w celu uruchomienia serwera restowego
 >  mvn jetty:run

3. Uruchomić przeglądarkę (lub innego klienta http) i sprawdzić czy serwis działa:
http://localhost:8080/restservicedemo/api/person/test
http://localhost:8080/restservicedemo/api/chair/test


