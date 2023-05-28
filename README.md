#  END-TO-END TEST PROJECT

##### TOOLS AND EXPLANATIONS
>- The project has been prepared based on Cucumber BDD style.    
>- Maven build management tool is used in this project by Java language.
>- In the project that includes one scenario that ability of the Librarian user to edit a book
>- For the test, the librarian logs in and update the information about a book. Then, both API and database is checked if the book is updated. 
>- A special tag(`@ui`,`@api`, and`@db`) was used in the project. Thus, the desired feature can be run in Runner.

##### HOW TO RUN TESTS
```sh
 -> Under the runner package "TestRunner" right click and run Runner. "src > test > java > runners > TestRunner"
 -> mvn test --> in the IDE console or navigate project path in command line and run.
```
##### HOW TO CREATE TEST REPORTS

1-) When you run tests with the **"mvn verify"** command from the console, you can see **Cucumber Html Report** under the target file.       
**-> target -> cucumber-html-reports > overview-steps.html** (open with chrome option)

2-) Second type of report, the project is run from **Runner** class, a **Cucumber Report link** is created in the IDE console automatically.       
 Sample link -> View your Cucumber Report at:   (Works 24 hours later than it will delete automatically)                                         
                 https://reports.cucumber.io/reports/d075d19d-4ccb-4e11-8da8-85e2220de650             
 Sample Screenshot -> **SampleCucumberReportScreeShot.png**
 
 

**Nevzat Talha Ozcan**    
QA Automation Engineer || Backend & UI Test Specialist || SDET     
https://www.linkedin.com/in/nevzattalhaozcan/
