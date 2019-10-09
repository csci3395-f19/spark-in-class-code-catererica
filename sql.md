# Title

## Question 1

### How many tables are in this database?

16

## Question 2

### How many users are currently set up?

222

## Question 3

### Which table has the smallest number of entries? How many entries does it have?

There are two tables that tie for the smallest number of entries. 
Both lambda_assoc and lambda_questions have just a single entry.


## Question 4

### How many answers have been posted for multiple choice questions?

There can but up to 8 different answer options on a given mc question. 
The number of options varies by question. There are only 2 questions that have 
8 options. In total there are 108 rows(questions) in the 
multi_choice_questions tables,


## Question 5

###  How many quizzes were given to section 6 of CSCI 1320 in Fall 2015?

22


## Question 6

### Which course has the most quizzes? How many quizzes does it have?

Courseid = 12
course name = CSCI1320
Semester= F16
quizzes = 26

## Question 7 

### Which course has the most questions on quizzes? How many questions does it have?

The data is really weird here. I'm joing to report the values I got while using an inner join in order to be as accurate as possible however I will make a note that there are quizid's that only appear in some tables. For instance, courseid =12 had 26 quizes, however not all of those appear on the multi_choice_asso tale, only 17 do. A Right Join shows all 26, some having NULL values fo the number of quiestiions on thse quiz. Just though I would make a note of my methods here.

courseid = 11
coursecode = CSCI1321
semester = F16
questions = 60

## Question 8

### What fraction of students who submit an answer for a function question eventually get it right?

1551 / 2013 if 1 = true
or 
462/2013 if 0 = true













