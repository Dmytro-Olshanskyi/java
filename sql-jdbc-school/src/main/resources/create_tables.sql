DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS groups ;
DROP TABLE IF EXISTS courses;

CREATE TABLE groups(
   group_id INT PRIMARY KEY     NOT NULL,
   group_name           TEXT    NOT NULL
);

CREATE TABLE students(
   student_id INT PRIMARY KEY     NOT NULL,
   group_id INT,
   first_name TEXT NOT NULL,
   last_name TEXT NOT NULL,
   CONSTRAINT fk_group
   FOREIGN KEY(group_id)
   REFERENCES groups(group_id)
);

CREATE TABLE courses(
course_id INT PRIMARY KEY NOT NULL,
course_name TEXT NOT NULL,
course_description TEXT
);



