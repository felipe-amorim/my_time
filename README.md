## Mytime Automation Assignment

This is a smaller version of a Java project that I have been using for some time in a couple of clients, and when teaching courses, no private content is being shared.

I have modified the project to have only the technologies needed for the automation proposal; however, there may be some unused code left behind due to the short time I had to do this validation. My apologies if this does happen.

The project consists of a BDD suite of tests, containing:
- .feature file, located at ```src/test/resources/products/website/```
- object classes, located at ```src/test/java/com/mytime/products/website/objects/```
- step definition classes, located at ```src/test/java/com/mytime/products/website/stepdefs/```
- runner class, located at ```src/test/java/com/mytime/products/website/runner```

In order to execute the project, the runner file should be used, either by accessing an IDE of choice, i.e. [Intellij](https://www.jetbrains.com/idea/download/), or by using the command line:
```sh
mvn clean test -Dtest=com.mytime.products.website.runner.Run`
```

All actions are handled by the **Support** or  **Intern** classes, i.e., The **Stepdefinition** class extends the **Support** class responsible for the technology used; in this case: **CoreWeb**, this class have multiple encapsulated methods that will inherit some navigation flows for all predefined actions already set. i.e. ```find(string).get().text();```.

Those methods will then trigger the plugin's actions, i.e., **Selenium** and exception handlers, on the **LocatorWeb** and **Execute** classes.

Every action will trigger Log inputs and a new HTML report section (feature, scenario, step, action, screenshot, error, tables, and markdowns).

Three observable classes trigger some event listeners to automatically generate the HTML report file, some sections, perform validations on the code, and test structure.

    src/test/java/com/mytime/intern/plugin/ListCucumber.java
    src/test/java/com/mytime/intern/plugin/ListCucumberDetailed.java
    src/test/java/com/mytime/intern/plugin/ListCucumberExecute.java

These plugins (observables) are configured on the runner class and will trigger those event listeners:

    TestCaseStarted
    TestCaseFinished
    TestStepStarted
    TestStepFinished
    TestRunFinished
    TestRunStarted

The validations on the observables are: 
- Every scenario must begin with the keyword 'Given'.
- Every scenario must have at least one assertion.
- Every scenario must have at least one 'When' keyword.
- Every scenario must have at least one 'Then' keyword.
- Every 'Then' keyword must have at least one assertion.
- Every 'And' keyword that comes after 'Then' keyword must have at least one assertion.

The **Instances** class and some of its structure were requested by some clients and can be easily changed; however, due to a relatively short time to do this task, no further modification was done.

The HTML report is based on the latest version of [ExtentReports](https://www.extentreports.com/docs/versions/5/java/index.html) with some modifications. The screenshots can be seen at the side of its equivalent action, and once opened, it pops up a modal, where you can navigate between them. Most of this content, including the carousel, is custom-made, so you won't be able to find it on the framework's website. You can find this file at ```src/test/resources/report/```

To fully open the HTML report, open the second view on the left menu > click on the scenario name > click on the step name > *click on the _before_ or _after_

*The _before_ and _after_ elements are displayed if the action had a screenshot. Every 'Then' and subsequent 'And' keyword must have at least one screenshot.

There is also a .log file that is generated at ```src/test/resources/logs/```


### Environment

In order to execute the project, you have to install Java 8, Android SDK, and Maven (If you’re willing to run the project from a command line or a .bat file).

The following environment variables have to be configured:

JAVA_HOME

MAVEN_HOME

Google Chrome must be installed to execute drivers based on chromium
