# School_Project_BE

# FakerDataAccessService
To create somme dummy data and add them to the database, you can call the insertDummyData() on [FakerDataAccess](src/main/java/com/crystal/school/service/FakerDataAccessService.java)
- The default password for all users is 1234

# Type of rooms

- Classrooms: These are the rooms where students attend classes and receive instruction from teachers.
- Offices: These are typically private rooms where administrators, teachers, and other staff members can conduct meetings, work on paperwork, and perform other tasks.
- Labs: These are specialized rooms that are equipped with the necessary equipment and materials for hands-on science experiments, computer programming, and other technical subjects.
- Libraries: These are rooms that contain a collection of books, periodicals, and other resources that students and staff can use for research and study.
- Auditoriums: These are large rooms with a stage and seating for assemblies, concerts, plays, and other events.
- Cafeterias: These are rooms where students can purchase and eat meals during the school day.
- Gymnasiums: These are large rooms with sports equipment and facilities for physical education classes and sports practices and games.
- Art studios: These are rooms equipped with materials and tools for art and design projects.


# Employee roles
- Administrator
- Teacher
- Organizer
- None (others)

# Session_rating_Trigger

I have
1. session_rating table with those entities (user_id, session_id, rating)
2. session table with those entities (session_id,... rating_sum, rating_count)
   I want to create a trigger which will add the rating from session_rating to rating_sum of session and increment the rating_count by one each time a new session_rating row is inserted
[TRIGGER](src/main/resources/sql/session_rating_trigger.sql)