# Use Case Model

**Author**: Tengyao Song

## 1 Use Case Diagram

![Sequence diagram](images/Use%20case%20diagram.png "Sequence diagram")

## 2 Use Case Descriptions

### Enter current job

|Use Case|Enter current job|
|---:|:---:|
|Requirements|This use case allows user to enter their current job features: Title, Company, Location, Cost of living, Possible work remotely, Yearly salary, Yearly bonus, Retirement benefits, and Leave time|
|Pre-conditions|User must have their current job features to enter|
|Post-conditions|The user's current job is updated with the newly entered features|
|Scenarios_Normal|User enters current job features, one after another|
|Scenarios_Alternate|1. User enters a portion of current job features. 2. User save the data. 3. User updates the rest of the current job feature in the end.|
|Scenarios_Exception|1. User does not enter all the current job features. 2. User enters incorrect data types, e.g. including a character in the yearly salary feature|

### Enter job offers

|Use Case|Enter job offers|
|---:|:---:|
|Requirements|This use case allows the user to enter job offers with the following features: Title, Company, Location, Cost of living, Possible work remotely, Yearly salary, Yearly bonus, Retirement benefits, and Leave time|
|Pre-conditions|User must have the relevant job offer features to enter|
|Post-conditions|Job feature data is appended to the persistent list of job offers|
|Scenarios_Normal|User has one job offer and enters one job offer feature one after another|
|Scenarios_Alternate|User has at least two job offers. User enters the job offer features one after another for consecutive job offers.|
|Scenarios_Alternate|User has a current job. After entering a job offer, they can compare it to the current job.|
|Scenarios_Exception|1. User does not enter all the job features. 2. User enters incorrect data types, e.g. including a character in the yearly salary feature|

### Set comparison weight

|Use Case|Set comparison weights|
|---:|:---:|
|Requirements|This use case allows user to assign integer weights to: Possibility to work remotely, Yearly salary, Yearly bonus, Retirement benefits, and Leave time|
|Pre-conditions|The user must know what weights to assign|
|Post-conditions|The comparison weights settings object is updated with the new values|
|Scenarios_Normal|User assigns integer values to each weight|
|Scenarios_Alternate|If no weights are assigned, all factors are considered equal. Assign 1 to each category|
|Scenarios_Exception|1. User does not assign all the weight to each category. 2. User enters unexpected data types (e.g. a character)|

### Compare job offers

|Use Case|Compare job offers|
|---:|:---:|
|Requirements|This use case allows user to compare either: the current job versus a job offer; or compare two different job offers|
|Pre-conditions|There must either be: a current job and at least one job offer; or if there is no current job, at least two different job offers|
|Post-conditions|The two chosen jobs to compare are displayed to the user|
|Scenarios_Normal|1. User chooses to compare job offers. 2. A ranked list of job offers - including the clearly marked current job (if it exists) - is displayed to the user. 3. The user selects two of the jobs to compare. 4. The features of two jobs are displayed side-by-side in a single screen. 5. The user can choose to either compare other jobs or exit to main menu|
|Scenarios_Alternate|None|
|Scenarios_Exception|None|

### Calucate job score

|Use Case|Calculate job score|
|---:|:---:|
|Requirements|This use case covers the system updating the job score(s)|
|Pre-conditions|User must be ready to enter a new job offer, or if job offers exist, they must be ready to change comparison settings weights|
|Post-conditions|The existing job offer(s) have updated scores|
|Scenarios_Normal|1. User adds a new job offer to the system. 2. The system will update the new job offer's score based on the current weights|
|Scenarios_Alternate|1. User updates the comparison weights settings. 2. The system will update each job offer's score based on the new weights|
|Scenarios_Exception|None|

### Sort job score

|Use Case|Sort job score|
|---:|:---:|
|Requirements|This use case covers the system updating the ranked list of job offers|
|Pre-conditions|More than one job offer stored and user is either updating their comparison settings weights, or is adding a new job offer|
|Post-conditions|The ranked list of job offers is re-ordered|
|Scenarios_Normal|1. Either scenario from "Calculate job score" above. 2. The system will updated the ranked list of job offers based on new scores|
|Scenarios_Alternate|None|
|Scenarios_Exception|None|
