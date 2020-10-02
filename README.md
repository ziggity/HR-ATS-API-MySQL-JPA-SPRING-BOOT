# HR-ATS-API-MySQL-JPA-SPRING-BOOT
## Final project for Promineo tech 
## How to use project:
-Navigate yourself to the working directory, and type "mvn spring-boot:run" in the cmd prompt / Terminal window. 
open another cmd prompt/ terminal and use Curl to the local address: http://localhost:8080/api/recruiters, or use Postman (much better option)
-Make a Post request to that URL with this payload in JSON format, raw body:
{"firstName" : "Sri", "lastName": "S", "title": "Recruiter", "level": "5", "salary": "185,000"}

-To Create a recruiter use this URL: make a Post request in Postman: http://localhost:8080/api/recruiters
and here's the payload JSON format raw: {"firstName" : "Tamm", "lastName": "Lee", "title": "Manager", "level": "6", "salary": "285,000"}

-To Read all the recruiters use this URL: create a GET request in Postman and send this: http://localhost:8080/api/recruiters

-To update a recruiter, create a Put request and use this URL: http://localhost:8080/api/recruiters/3 with this payload:
{"firstName" : "Sri", "lastName": "S", "title": "Recruiter", "level": "4", "salary": "85,000"}

-To Delete the recruiter you wish to, create a Delete request in postman with the ID of the recruiter at the end: http://localhost:8080/api/recruiters/2



### Basic outline of the schema: 

Users = recruiters / sourcers / HR assistants / HR coordinators
Admins = Managers / Sr Lead Recruiters / Directors / VPs

Entity: Tags, Candidates, Users, Admins, Jobs  (any other ones let me know I'll add them)

Tags have one to one relationship (candidate to a job)
candidates have one to many relationships to Jobs
Users can own many candidates so many to many
*Stretch goal* add Admins same as Users but higher privileges
Jobs have one to many candidates and Admins as well
- User can register and login
- User can create job listing
- User can delete a job
- User can update a job
-*stretch goal* can post job to Indeed website with API call
-User can input a candidate into the system (general applicant pool)
-User can tag a candidate to a job (candidates are one to many relationship to jobs)
- User can browse all jobs
- User can browse all candidates
- User can browse jobs by job family
- User can view all details about a specific job Or specific Candidate
- Users can leave feedback on a candidate (from interview - phone or onsite)
- User can tag a candidate to a one or more jobs at a time (creates a tag entity)
- When a job is created a timer is set for 8 weeks from creation date and will alert Admin if it goes past 6 weeks.
- User can return a candidate to the general pool from the job they were assigned (called dispositioning)
- When a candidate is hired a salary is assigned to the candidate's account if the candidate is marked hired. And is removed from candidate pool, and that job is now closed.





