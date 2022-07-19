# Izicap-Homework
MicroService for invoking campanies information:

This Java project is a springBoot application wriiten in Java 8 version.
It consumes a public WebService and generate at the end a CSV file containing all information about companies in France, and also it offers getting information for only one compnay when its SIRET is included.

When lunching the project it will ask you for login user and password. By default this is the credentials:
username: user
password: user

-To get all information about companies, you should write this URL to your browser. It generates a CSV file that will be shown on a folder called 'csv-files' inside the project

http://localhost:8080/api/v1/SIRET/allCompanies

-To get information about only one company, you should write this URL and complete it with a SIRET number. It also generates a CSV file inside 'csv-files' folder.

http://localhost:8080/api/v1/SIRET/restCompany/{SIRETnumber}

for example
http://localhost:8080/api/v1/SIRET/restCompany/97080195700014





