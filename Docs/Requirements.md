# Requirements Document

**Author**: Chris Butler

## 1 Introduction

This document simply lists each requirement of the JobCompare app one-by-one. It is not a deliverable for the Group Project, but will assist across development and testing to ensure full coverage of scope is satisfied.

## 2 Table of Requirements

| ID | Grouping | Requirement | Satisfied? |
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
