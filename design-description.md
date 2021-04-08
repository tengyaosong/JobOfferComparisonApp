# Design Description Document

## Team 133

A fellow classmate, George P. Burdell, is looking for a new job in the US after graduation. As it can be complicated to compare job offers with benefits, in different locations, and other aspects beyond salary, he would like an app to help with this process and has asked for your assistance in creating a simple, single-user job offer comparison app.  As a first step, he would like you to create an initial design for the app, expressed in UML, based on a set of requirements he provided.

# Design Description:

### Requirements:

> 1.	When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).
- To realize this requirment, we created a MainMenu class to handle the entry point of this system. This system will provide the elements of a main menu that are expressed in the write up.
    -- The current job of the user which is expressed as an instance of the Job class
    -- The default settings for comparison as an instance of our ComparisonSettings class
    -- A list of job offers realized by a list of JobOffer objects
- To realize the user operations part of this requirement we created methods for the MainMenu class.
    -- Enter or edit current job details: createJob and editJob methods
    -- Enter job offers: createJob method
    -- Adjust the comparison settings: assignCompWeights method
    -- compare job offers: compareJobs method
&nbsp;
> 2.	When choosing to enter current job details, a user will:
a.	Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of:
i.	Title
ii.	Company
iii.	Location (entered as city and state)
iv.	Cost of living in the location (expressed as an index)
v.	Yearly salary
vi.	Yearly bonus
vii.	Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5)
viii.	Retirement benefits (as percentage matched)
ix.	Leave time (vacation days and holiday and/or sick leave, as a single overall number of days)
b.	Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.
- To realize this requirement, we created a superclass called the job class which contains all the variables that make up a job. An instance of this class will contain our current job.

&nbsp;
> 3.	When choosing to enter job offers, a user will:
a.	Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
b.	Be able to either save the job offer details or cancel.
c.	Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).
- To realize this requirement, we created a JobOffer class which is a subclass of the Job class this JobOffer class inherits the variables relating to a job due to generalization. These include all that is listed from requirement 2. The JobOffer class contains a variable known as the ranking.

&nbsp;
> 4.	When adjusting the comparison settings, the user can assign integer weights to:
a.	Yearly salary
b.	Yearly bonus
c.	Allowed weekly telework days
d.	Retirement benefits
e.	Leave time
If no weights are assigned, all factors are considered equal.
- To realize this requirement, we created a ComparisonSettings class which is a class that tracks the user's comparison parameters they want to set for use in the comparing feature within the app. This class holds integer variables that in correlate to the variables above. We also set a default of 1 for weights to satisfy the case where if the weights aren't explicitly defined by the user all the factors are equal.

&nbsp;
> 5.	When choosing to compare job offers, a user will:
a.	Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
b.	Select two jobs to compare and trigger the comparison.
c.	Be shown a table comparing the two jobs, displaying, for each job:
i.	Title
ii.	Company
iii.	Location
iv.	Yearly salary adjusted for cost of living
v.	Yearly bonus adjusted for cost of living
vi.	Allowed weekly telework days
vii.	Retirement benefits (as percentage matched)
viii.	Leave time
d.	Be offered to perform another comparison or go back to the main menu.
- To realize this requirement, associations between the MainMenu, ComparisonSettings, and JobOffer classes were made. This association defined that the user would be comparing job classes. We also created 2 methods underneath the MainMenu class to define this ability, AssignCompWeights and CompareJobs.
&nbsp;
> 6.	When ranking jobs, a job’s score is computed as the weighted sum of: (Formula removed for brevity)
- To realize this requirement, we created a subclass of our jobs class that holds the ranking for a particular job. We also added a displayRankings method under our Main Menu class to initiate the ranking system and place in order for viewing by the user.
&nbsp;
> 7.	The user interface must be intuitive and responsive.
- This requirement does not have any effect on our design due to the fact this is an implementation requirement and how the system handles during runtime.


&nbsp;
> 8.	For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
- This requirement does not have any effect on my design due to the fact this is an implementation requirment and how the system handles during runtime.




&nbsp;
### Further Development of the Class Diagram:

To further define the system being requested with our assumptions we can take a look deeper into our diagram. One key note to take away is that we did not model any GUI interfaces or tasks. This made our design simple enough to follow along with.
- This system is only being used by one user at a time for every running instance of the app.
- We made Job a superclass to better specialize the 2 job components the system cares about which are
    - The users current job if they have one (which innately is a job: job class)
    - Job offers the user has received from companies (jobOffer class)
- We created a location utility class to embody further split up the segments that make a job's location. An example of this would be city and state. This class also allows us to further expand our location to street/country/zipcode if needed in the next design phase.
- We did not define the getters and setters for each class within my diagram


&nbsp;
License
----

MIT

# MD Software Used to create this file:
https://github.com/joemccann/dillinger
