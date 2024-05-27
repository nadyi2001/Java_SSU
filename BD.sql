--1. TABLE employeesAge

DROP TABLE IF EXISTS employeesAge;

CREATE TABLE employeesAge (
  id SERIAL PRIMARY KEY,
  employeeName VARCHAR(50),
  age INTEGER
);

DELETE FROM public.employeesAge;

INSERT INTO employeesAge (id, employeeName, age) VALUES
(0, 'Кирилл', 18),
(1, 'Саша', 20),
(2, 'Катя', 25);

--2. TABLE departmentSalary

DROP TABLE IF EXISTS departmentSalary;

CREATE TABLE departmentSalary (
  id SERIAL PRIMARY KEY,
  employeeName VARCHAR(50),
  departmentName VARCHAR(50),
  salary BIGINT
);

DELETE FROM public.departmentSalary;

INSERT INTO departmentSalary (id, employeeName, departmentName, salary) VALUES
(0, 'Кирилл', 'IT', 30000),
(1, 'Иван', 'IT', 20000),
(2, 'Маша', 'HR', 40000);

--3. TABLES departmentLocation & departmentEmployee

DROP TABLE IF EXISTS departmentLocation;

CREATE TABLE departmentLocation (
  id SERIAL PRIMARY KEY,
  departmentName VARCHAR(50),
  location VARCHAR(100)
);

DELETE FROM public.departmentLocation;

INSERT INTO departmentLocation (id, departmentName, location) VALUES
(1, 'IT', 'Floor 1'),
(2, 'HR', 'Floor 2');

DROP TABLE IF EXISTS departmentEmployee;

CREATE TABLE departmentEmployee (
  id SERIAL PRIMARY KEY,
  employeeName VARCHAR(50),
  departmentId INTEGER REFERENCES departmentLocation(id)
);

DELETE FROM public.departmentEmployee;

INSERT INTO departmentEmployee (id, employeeName, departmentId) VALUES
(0, 'Кирилл', 1),
(1, 'Иван', 1),
(2, 'Маша', 2);
