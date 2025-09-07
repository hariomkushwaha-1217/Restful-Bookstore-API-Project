CREATE DATABASE college_admission;
USE college_admission;

CREATE TABLE Students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    marks INT NOT NULL
);

CREATE TABLE Courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cutoff INT NOT NULL
);

CREATE TABLE Applications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    status VARCHAR(20) DEFAULT 'PENDING',
    FOREIGN KEY(student_id) REFERENCES Students(id),
    FOREIGN KEY(course_id) REFERENCES Courses(id)
);
