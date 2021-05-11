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
