Documentation for PyramidWordCheck service

Assumptions  -

1. Input must be alphanumeric with no whitespaces. Any input that doesn't match these requirements is marked as invalid input

2. Pyramid word is any word whose character count is monotonously increasing. Position of character with count is not being considered

3. API endpoints -
URL					METHOD-TYPE	RESPONSE CODE	
/PyramidWordChecker/service/check       POST		0,1,8,9,10

4. Response codes meaning

RESPOSE-CODE	MEANING
0		Is a valid pyramid word
1		Is not a valid pyramid word
8		Invalid input - validation error
9		Error parsing url parameter
10		General error 

5. Tech stack
   Web service implemented in Java using JAX-RS(Jersey) specification, Dependency mgmt done using Maven, tested on Apache tomcat 9,   JRE env - 1.8 

6. Project Structure

   Service consists of 3 packages com.smishra.rest, com.smishra.utils and com.smishra.exceptions.
   rest package contains the service logic and implementation of Pyramid word check
   utils package has common string utilities
   exceptions package contains error/response codes

7. Repo contains war file PyramidWordChecker.war. Import this in eclipse IDE and import all dependencies that are suggested. Configure your java web server as a targeted runtime for the imported project - this can be done under project properties. 
Right click the project -> Run As -> Run on Server - to deploy the service

Alternatively, you can copy the war file to the webapps folder of your java web server and restart the server. 

The service should be accessible through http://localhost:8080/PyramidWordChecker/service/check

8. Sample responses -
 curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"word":"xyyzzz"}' \
  http://localhost:8080/PyramidWordChecker/service/check

  0

 curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"word":"xyzzz"}' \
  http://localhost:8080/PyramidWordChecker/service/check

  1

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"word":"xy$%^%yzzz"}' \
  http://localhost:8080/PyramidWordChecker/service/check

  8

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"word":"xy  yzzz"}' \
  http://localhost:8080/PyramidWordChecker/service/check

  8                                   	
