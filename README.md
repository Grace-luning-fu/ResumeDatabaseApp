
ResumeDatabaseApp (Week two challenge for Java Boot camp at MC) 
@author Grace, Aug 6, 2017


This Web App allows user to:
1. Add resume (with validation for name, email, startdate and enddate) to a database hosted on Mysql;
2. Calucate employed days (for both current jobs and past jobs);
3. Display added entries/results with calculated employed days;
4. Display a list of all resumes in the database (also display calculated employed days)


*Future work:
@Past validate "LocalDate" date type(since Hibernate does not support LocalDate type).
But basic format validation for LocalDate startDate and endDate has been done.
Next, pretty up the HTML

reference: 
Display dates in the validated format in HTML using thymeleaf:
http://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#double-bracket-syntax (10.1 Double-bracket syntax)




