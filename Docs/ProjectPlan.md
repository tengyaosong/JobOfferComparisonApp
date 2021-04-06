# Project Plan

**Author**: Chris Butler

## 1 Introduction

The Job Comparison Android application allows a user to update their current job, upload job offers, and compare job offers via a simple user interface.

## 2 Process Description

### UML Class Diagram Refinements

Since the team may find improvements throughout the project - or generally change the course of the implementation for whatever purpose - a continuous process of updating the UML Class diagram is required.

**Entrance criteria:**

- UML Class diagram created

**Exit criteria:**

- Finalized UML Class diagram

### Develop Back-end Classes

To develop the Classes, the team will translate the associated UML Class diagram into Java code. Throughout this process, the team need not remain true to the original design if enhancements are discovered, but the original UML Class diagram should be updated to reflect those enhancements.

**Entrance criteria:**

- UML Class diagram created
- Design document created
- Use-case model created
- Supplemental requirements created

**Exit criteria:**

- Classes implemented:
  - MainMenu
  - ComparisonSettings
  - Job
  - JobOffer
  - Location

### Create GUI

In the GUI creating process, a simple wireframe will be designed, discussed between the team members, and a final GUI will be implemented in Android Studio based on the final design. This implementation will utilize both XML screens as well as Java developed Activity Classes.

**Entrance criteria:**

- UML Class diagram graded
- Design document created
- Use-case model created
- Supplemental requirements created

**Exit criteria:**

- Fully-functional GUI implemented

### Implement Glue Code

To ensure that the GUI and underlying classes are working with one-another, the associating functionality and algorithms have to be developed to translate user-input to the desired output.

**Entrance criteria:**

- Java Class(es) available
- GUI component(s) related to available Java Class(es) built out
- Test plan created

**Exit criteria:**

- GUI satisfies:
  - Design document created
  - Use-case model created
  - Supplemental requirements created

### Build Persistence Solution

When restarting the app, it is expected that data previously entered by the user will persist and be readily available in a new app session. Throughout the project lifecycle, the team will explore various options such as local file storage, SQLite, Room Database, etc. The most efficient solution will be chosen.

**Entrance criteria:**

- Partial Glue Code implemented

**Exit criteria:**

- User data persists between app sessions

### Testing

The testing process covers both the continuous JUnit testing performed throughout development and UI testing once GUI prototypes start being delivered. JUnit testing will be performed regularly to ensure that code is meeting requirements and running as expected. Once a working prototype is established, UI testing with Espresso (and ad hoc manual interactions) will begin to check that the requirements are satisfied.

**Entrance criteria:**

- UML Class diagram graded
- Design document created
- Use-case model created
- Supplemental requirements created
- Test plan created

**Exit criteria:**

- Ready for deployment

## 3 Team

### Team Members

- Andre Thompson
- Chris Butler
- Steven Woollaston
- Tengyao Song

### Role Definitions

Each member of the team is assigned to the generic 'Developer' role which covers:

- App Development
  - Developing Java Classes and glue code
  - JUnit testing
- UI Development
  - Developing the GUI
  - UI testing

Each member of the team will also take on one of the following project lead roles. These roles were designed to assign an individual team member the 'final say' and accountability for different aspects of the project if team consensus cannot be met (e.g. project documentation, implementation of difficult methods, specific unit tests, etc.).

- Development Lead
  - Owner of design document development sections
  - Provides direction on Java development
- GUI Lead
  - Owner of design document UI sections
  - Provides direction on GUI development
- Product Lead
  - Owner of extra requirements, use-case model, & UML Class documents
  - Provides direction on requirements
- QA Lead
  - Owner of test plan
  - Provides direction on JUnit & UI testing

### Table of Roles

|Role|Andre|Chris|Steven|Tengyao|
|---:|:---:|:---:|:---:|:---:|
|Development Lead|||X||
|GUI Lead|X||||
|Product Lead||X|||
|QA Lead||||X|
|Developer|X|X|X|X|
