# QA Automation V2

This is the version2 of the QA Automation platform.


**Include users on-call**
In order to execute the tests, the following maven line has to be used:

> mvn clean test -Dtest=com.helplightning.products.citron.runner.UnitTestmvn clean test -Dtest=com.helplightning.products.citron.runner.UnitTest
 
with the parameters:

> -Durl=CITRON_URL -Du1=USER_EMAIL/PASSWORD -Du2=...-Du10=USER_EMAIL/PASSWORD

Example:

> mvn clean test -Dtest=com.helplightning.products.citron.runner.UnitTest -Durl=https://containers-us.helplightning.net:34372/ -Du1=small_u1@helplightning.com/123456 -Du2=small_u2@helplightning.com/123456
  
- On the previous line, two users are going to be authenticated on the citron https://containers-us.helplightning.net:34372/ and they will wait for five minutes to be invited, uppon acceptance, they will mute their microphone

- Each user has its own mock-up video

- There is a limit of 10 users
