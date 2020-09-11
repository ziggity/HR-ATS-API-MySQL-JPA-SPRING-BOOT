# HR-ATS-API-MySQL-JPA-SPRING-BOOT
## Final project for Promineo tech 

### Basic outline of the schema: 

Users = recruiters / sourcers / HR assistants / HR coordinators
Admins = Managers / Sr Lead Recruiters / Directors / VPs

Entity: Tags, Candidates, Users, Admins, Jobs  (any other ones let me know I'll add them)

Tags have one to one relationship (candidate to a job)
candidates have one to many relationships to Jobs
Users can own many candidates so many to many
Admins same as Users but higher priveldges
Jobs have one to many candidates and Admins as well
- User can register and login
- Admin can create job listing
- Admin can delete a job
- Admin can update a job
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





