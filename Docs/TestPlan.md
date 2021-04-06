# Test Plan

**Author**: Steven Woollaston

## 1 Testing Strategy

### 1.1 Overall strategy

To save time and avoid human error, we will automate as many tests as  possible. Some tests may have to be done manually, such as those testing GUI functionality. Our Test Lead (see ProjectPlan.md) will be responsible for creating, maintaining, and executing testing.

### 1.2 Test Selection

#### Unit Testing

- Unit testing will be utilised to test each classes private methods
- Inputs should be checked for validity. Unit tests will test the correct exceptions are being thrown (e.g. bound checking, null references)
- This will be white box testing

#### Integration Testing

- Class relationships will be tested with JUnit
- Test public classes of each class
- When new components are delivered to the app, integration testing will be used to ensure these new components work well with the current functionality
- This will be white box testing

#### System Testing

- Espresso will be used to simulate user interaction with the Android app and test the system as a whole
  - UI interaction such as page navigation, error handling, user feedback, and crash reports
  - Performance will be tested by adding and displaying hundreds of jobs in quick succession
- This will be black box testing

#### Regression Testing

- Both manual and automated testing will be utilised. The majority will be automated and we will re-run the entire test suite for each new build to ensure previous functionality has not been broken by new code. Manual testing will used for any functional and non-functional aspects which we know is not covered by the test suite.
- This will be both white box and black box testing

### 1.3 Adequacy Criterion

To ensure the quality of our final software product, we will use Android Studio code coverage to guide our test coverage. We will also add relevant test cases throughout development. Success with regard to code coverage will be 80% of code with testable logic. System level testing will be completed with Espresso and manual testing. We will discuss as a group what tests need to be completed to ensure robust coverage. These tests will be included in the testing table.

### 1.4 Bug Tracking

Bug reports and new feature requests can easily be tracked through the Github Issues page. As we are all working remotely on this project, it will be useful to open, close, and comment on bugs / feature requests as they arise. TODO comments will be embedded inline with a short description and a link to the Github Issues page.

### 1.5 Technology

We plan to use JUnit for testing, as well as Espresso for GUI testing where practicable.

## 2 Test Cases

### Deliverable 3 (Alpha) Testing

| Purpose | Steps | Expected | Actual | Pass / Fail | Notes
| ------- | :---- | :------- | :----- | :---------- | :----
| Main menu presented on initial startup | Initialize app | Main menu screen is displayed | As expected | Pass |
| Enter / Edit Job Details is clickable and opens a new activity | Click Enter / Edit Job Details | A new screen is presented | As expected | Pass |
| The Enter / Edit Job Details activity displays the correct data fields | Click Enter / Edit Job Details | A new screen is presented with all necessary fields for job details | As expected - but see notes | Pass | Fields are not discernable from background
| The Cancel button in the Enter / Edit Job Details activity returns to the main menu | Click Enter / Edit Job Details, click on the Cancel button | The user returns to the main menu | As expected | Pass |
| Enter Job Offers is clickable and opens a new activity | Click Job Offers | A new screen is presented | As expected | Pass |
| The Enter Job Offers activity displays the correct data fields | Click Job Offers | A new screen is presented with all necessary fields for job details | As expected | Pass |
| The Cancel button in the Enter Job Offers activity returns to the main menu | Click Job Offers, click on the Cancel button | The user returns to the main menu | As expected | Pass |
| Adjust Comparison Settings is clickable and opens a new activity | Click Adjust Comparison Settings | A new screen is presented | As expected | Pass |
| The Adjust Comparison Settings activity displays the correct data fields | Click Adjust Comparison Settings | A new screen is presented with all necessary fields for the comparison settings weights | As expected | Pass |
| The Cancel button in the Adjust Comparison Settings activity returns to the main menu | Click Adjust Comparison Settings, click on the Cancel button | The user returns to the main menu | As expected - but see notes | Pass | Cannot scroll down to see full cancel button on smaller device
| Compare Job Offers is clickable and opens a new activity | Click Compare Job Offers | A new screen is presented | As expected | Pass |
| The Compare Jobs activity displays the correct data fields | Click Compare Job Offers | A new screen is presented with a list layout | As expected | Pass |
| The Cancel button in the Compare Jobs activity returns to the main menu | Click Compare Jobs, click on the Cancel button | The user returns to the main menu | As expected - but see notes | Pass | Cannot scroll down to see full cancel button on smaller device

### Deliverable 4 (Final Product) Testing

| Purpose | Steps | Expected | Actual | Pass / Fail | Notes
| ------- | :---- | :------- | :----- | :---------- | :----
| Test adding job | Click Add job, enter details, click Save | Job saved in list of jobs to compare | As expected | Pass |
| Test edit job | Click Edit job, amend details, click Save | Job details updated to reflected new details | As expected | Pass |
| Test adding job without saving | Click Add job, enter details, click Cancel | Job details are discarded | As expected | Pass |
| Test add / edit validation | Click add / edit job, enter invalid data (e.g. empty input) | Disallows save | As expected | Pass |
| Test job blank details | Click add / edit job, enter null data (e.g. no title) | Disallows save | As expected | Pass |
| Test default job comparison weights | Compare job without entering weights | Job score computed with 1 for all weights | As expected | Pass |
| Test invalid job comparison weights - decimal | Enter decimal weight | Warns user - must be integer, reverts to previous weights | Unnecessary test - GUI forces input type | Pass
| Test invalid job comparison weights - negative | Enter negative weight | Warns user - must be positive integer, reverts to previous weights | Unnecessary test - GUI forces input type | Pass
| Test job score calculated correctly | Enter weights for job score | Compare calculated score with known correct job score | As expected | Pass
| Test job rankings | Click compare job offers | Program displays list of job offers in order from best to worst | As expected | Pass
 Test job rankings - current job | Click compare job offers | Program displays list of job offers in order from best to worst with current job clearly indicated | As expected | Pass
| Test program flow - save job returns to main menu | Enter / edit job | Program returns to main menu | As expected | Pass
| Test program flow - compare job | Click compare job offers | Program displays list of job offers | As expected | Pass
| Test program flow - compare job - details | Click compare job offers, select two jobs, click compare | Be shown a table comparing the two jobs with all details | As expected | Pass

### Deliverable 4.5 (Requirements Coverage) Testing

For the final product testing, the team also utilized the Requirements.md document's list of requirements, since each requirement was clearly spiked out and could be easily verified using the methods mentioned in this document. This allowed the team to ensure full requirements coverage when executing tests.

| ID | App Area | Test Case | Pass? |
|---|---|---|:---:|
| 1.0 | App Startup | When the app starts, the user is presented with the main menu. | Yes |
| 2.0 | Main menu | In the main menu, the user can enter or edit current job details. | Yes |
| 2.1 | Main menu | In the main menu, the user can enter multiple job offers. | Yes |
| 2.2 | Main menu | In the main menu, the user can adjust the comparison settings. | Yes |
| 2.3 | Main menu | In the main menu, the user can compare job offers. | Yes |
| 2.4 | Main menu | In the main menu, the job comparison option is disabled unless either: 1. There are at least 2 job offers; or 2. There is at least one job offer **and** there is a current job. | Yes |
| 2.0.0 | Enter Current Job Details | When entering current job details, a UI is displayed to the user to enter **or** edit all of the details of their current job. | Yes |
| 2.0.1 | Enter Current Job Details | When entering current job details, the title and company should be entered as strings. | Yes |
| 2.0.2 | Enter Current Job Details | When entering current job details, the yearly salary, yearly bonus, and retirement benefits should be entered as doubles. | Yes |
| 2.0.3 | Enter Current Job Details | When entering current job details, the location should be entered as city and state. | Yes |
| 2.0.4 | Enter Current Job Details | When entering current job details, the cost of living in the location should be expressed as an [index](https://www.expatistan.com/cost-of-living/index/north-america). | Yes |
| 2.0.5 | Enter Current Job Details | When entering current job details, the allowed weekly telework days should be expressed as number of days per week allowed for remote work, inclusively between 0 and 5. | Yes |
| 2.0.6 | Enter Current Job Details | When entering current job details, the leave time should be expressed as a single integer representing the overall days of leave. | Yes |
| 2.0.7 | Enter Current Job Details | When entering current job details, the user can save the job details if all fields are complete. This returns the user to the main menu. | Yes |
| 2.0.8 | Enter Current Job Details | When entering current job details, the user can cancel and exit without saving. This returns the user to the main menu. | Yes |
| 2.1.0 | Enter Job Offer Details | When entering job offer details, a UI is displayed to the user to enter **or** edit all of the details of their current job. | Yes |
| 2.1.1 | Enter Job Offer Details | When entering job offer details, the title and company should be entered as strings. | Yes |
| 2.1.2 | Enter Job Offer Details | When entering job offer details, the yearly salary, yearly bonus, and retirement benefits should be entered as doubles. | Yes |
| 2.1.3 | Enter Job Offer Details | When entering job offer details, the location should be entered as city and state. | Yes |
| 2.1.4 | Enter Job Offer Details | When entering job offer details, the cost of living in the location should be expressed as an [index](https://www.expatistan.com/cost-of-living/index/north-america). | Yes |
| 2.1.5 | Enter Job Offer Details | When entering job offer details, the allowed weekly telework days should be expressed as number of days per week allowed for remote work, inclusively between 0 and 5. | Yes |
| 2.1.6 | Enter Job Offer Details | When entering job offer details, the leave time should be expressed as a single integer representing the overall days of leave. | Yes |
| 2.1.7 | Enter Job Offer Details | When entering job offer details, the user can save the job details if all fields are complete. The user **is not** returned to the main menu. | Yes |
| 2.1.8 | Enter Job Offer Details | When entering job offer details, the user can cancel and exit without saving. The user **is** returned to the main menu. | Yes |
| 2.1.9 | Enter Job Offer Details | When entering job offer details, the user can enter another offer. | Yes |
| 2.1.10 | Enter Job Offer Details | When entering job offer details, the user can return to the main menu. | Yes |
| 2.1.10 | Enter Job Offer Details | When entering job offer details, the user can compare the offer (if it is saved) with the current job details (if present). | Yes |
| 2.2.0 | Adjust Comparison Settings | When adjusting comparison settings, a UI is displayed to the user to edit the comparison settings. | Yes |
| 2.2.1 | Adjust Comparison Settings | When adjusting comparison settings, the user can enter integer values for yearly salary, yearly bonus, allowed weekly telework days, retirement benefits, and leave time. If no weights are assigned, these settings should be 1. | Yes |
| 2.3.0 | Compare Job Offers | When comparing job offers, a UI is displayed to the user listing all available job offers, displayed as Title and Company. | Yes |
| 2.3.0.1 | Compare Job Offers | The list of job offers should be ranked from best to worst | Yes |
| 2.3.0.2 | Compare Job Offers | The list of job offers should include the current job (if present) and be clearly indicated as the current job | Yes |
| 2.3.1 | Compare Job Offers | When comparing job offers, the user must select two jobs to compare and trigger the comparison | Yes |
| 2.3.1.0 | Compare Job Offers | When two job offers are compared, a table should be displayed for the two jobs showing: title, company, location, yearly salary adjusted for cost of living, yearly bonus adjusted for cost of living, allowed weekly telework days, retirement benefits (as percentage matched), and leave time. | Yes |
| 2.3.1.1 | Compare Job Offers | When two job offers are compared, the user should have the option to perform another comparison | Yes |
| 2.3.1.2 | Compare Job Offers | When two job offers are compared, the user should have the option to go back to the main menu | Yes |
| 2.3.2 | Compare Job Offers | When ranking jobs, a job's score is computed as the **weighted** sum of: AYS + AYB + (RBP \* AYS) + (LT \* AYS / 260) - ((260 - 52 \* RWT) \* (AYS / 260) / 8). Where AYS = yearly salary adjusted for cost of living; AYB = yearly bonus adjusted for cost of living; RBP = retirement benefits percentage; LT = leave time; RWT = telework days per week. | Yes |
