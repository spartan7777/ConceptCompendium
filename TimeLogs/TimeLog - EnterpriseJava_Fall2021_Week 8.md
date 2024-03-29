### Tosan Ogedengbe
#### Enterprise Java Fall 2021: Weekly Reflection

#### Week 8
#### 10/18/2021 - 10/24/2021 - *26 Hours*


#### RELEVANT ITEMS:
1. Reviewed all Week 4 Videos
2. Worked on all the Hibernate Demos to get the materials covered in the Week 4 Videos into the Concept Compendium
3. Reviewed all Week 5 Videos
4. Worked on all the Hibernate Demos to get the annotations covered in the Week 5 Videos into the Concept Compendium
5. Completed adding data updates to the test database for the Concept Compendium
6. Updated the Java classes that comprise the test Persistence layer for the Concept Compendium
7. Worked back towards getting all DAOs fixed by coding model-sensitive DAOs in order to better understand the transition to the Generic DAO. 
8. Continued work on the test User DAO for the Concept Compendium
9. Continued work on the test Concept DAO for the Concept Compendium
10. Continued work on all necessary unit tests for the test layer for the Concept Compendium
11. Made changes to the database and removed several unnecessary columns to improve the ease of data entry
12. Added a test database class and added the necessary test database cleandb.sql files to facilitate unit testing
13. Worked towards completion of all required materials for the submission for Checkpoint 2


**ACCOMPLISHMENTS:** Went over all of the Week 4 and Week 5 videos once again to complete all of the DAO and classes in the test part of the project. Was able to get the cleandb.sql file added
into the project, and got the sql in that file to work after troubleshooting assistance during the class period. Changed the data in the test database and made that more 
conducive to testing and using the cleandb.sql files. Cleaned up a lot of the code and worked out a lot of the errors and warnings that hibernate was noticing. Removed two 
columns (the keyword columns) from the databases and the code as I found that these were counterproductive to the concept creation process when adding in sample data. It
seemed too difficult to know what keywords to use to reference linked ideas with when starting to create the ideas. I decided that in order to be able to better reference 
and link ideas after the fact, it would be best if people could just search for any keyword they need in the concept descriptions, and then update them as needed after the
fact to keep linked ideas together.


Was able to get some of the tests to run on the User entity, meaning I was able to clear up the code in the project using a UserDao just enough that the code would run. Got
a lot of test failures for various reasons that required little fixes and code refactoring throughout the project. Worked on this in order to get the unit tests to pass.
Debugged this in class and realized that making the jump to the Generic DAO without having anything working through entity specific DAOs was not a good idea and was the main
reason for my test failures. Went back to basics and re-worked all the DAOs in the project to get the unit tests to pass. Completed all work and got passing tests for the
User DAO. 


**SETBACKS:** I found myself needing to do a lot of additional research and study to make sure I could get the DAOs to work. I needed to go back and take a real deep look at the code and
the process of that the DAOs do, and how they transition to a Generic one. This was the major setback this week as I failed to see the connections to how the generic DAO
works because I ignored the steps before trying to implement it. I am still not in an optimal place in terms of progress, as I continue to make up time that life takes away
from me, and I have compounded that with trying to basically jump over vital steps. I still need to complete Checkpoint 2 so I can move on to Checkpoint 3. In order to get
to that final Checkpoint, I see I might need to set aside a weekend or two where I will not be able to spend as much time with my son as I would like. It is times like this
that I realize they never really mention all of the sacrifices that someone needs to make when trying to better themselves and pursue a degree. I hope I can come through in
the end.



