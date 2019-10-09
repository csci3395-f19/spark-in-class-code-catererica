//Question 1

show tables;

//Question 2

SELECT * FROM users;

//Question 3

SELECT COUNT(*) FROM tableName;

I did this for every single table sadly.

//Question 4
SELECT COUNT(*) FROM multi_choice_questions;
SELECT COUNT(option8) FROM 	multi_choice_questions;

//Question 5

SELECT COUNT(*) 
FROM courses 
INNER JOIN quiz_course_close_assoc 
ON courses.courseid = quiz_course_close_assoc.courseid 
WHERE code = "CSCI1320" AND section = 6 AND semester = "F15";

// Question 6

SELECT * 
FROM courses 
INNER JOIN quiz_course_close_assoc 
ON courses.courseid = quiz_course_close_assoc.courseid 
WHERE courses.courseid = X;

// Where X is the course ids. I did this for all 18 courses.


// Question 7
// Step 1 how many questions on each quiz?
SELECT quizid, COUNT(*) FROM multiple_choice_assoc GROUP BY quizid;
//Step 2 what quizzes wirh each course?
SELECT * FROM (SELECT quizid, COUNT(*) AS "questions" FROM multiple_choice_assoc GROUP BY quizid) AS mc INNER JOIN quiz_course_close_assoc ON quiz_course_close_assoc.quizid = mc.quizid
 
FULL answer:
SELECT SUM(questions) FROM (SELECT quizid, COUNT(*) AS "questions" FROM multiple_choice_assoc GROUP BY quizid) AS mc INNER JOIN quiz_course_close_assoc ON quiz_course_close_assoc.quizid = mc.quizid WHERE courseid = X;
where X is a numer.


// Question 8
SELECT userid, mc.quizid, mc_question_id, correct FROM (SELECT * FROM mc_answers) AS mc INNER JOIN function_assoc ON mc.mc_question_id  = function_assoc.func_question_id WHERE correct = X;
Where X is a number and then the same code again without a specification at the end.








