# Employee Record Management Application

- We can hard code the employee records in any data structure of our choice.
- Columns of the table are: EmpName, Age, Designation, Department, ReportingTo

# Task 1: 
- Display all the Employee records in a table format.
# Task 2: 
- Search records based on user give criteria.(this task is divided into two sub-tasks)
  - a. display option according to the column type: 
    - 1.String – Equals, Notequals, Contains, Notcontains, startswith, endswith 2.Integer- <, >, =, !=, between.
  - b. apply the same for multiple conditions using ‘AND’ for each condition.  (similar to ‘where’ class in SQL using multiple columns).
      
# Task 3: 
- print reporting tree of the given employee.

# Task 4: 
- print the employees reporting to the given manager.- 

# Task 5: 
- print summary of Department, Designation, ReportingTo.(menu driven)
  "C:\Program Files\Java\jdk-17.0.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2\lib\idea_rt.jar=56987:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\thell\Documents\Machine coding\ZOHO\Employee management system\out\production\Employee management system" controller.Main

😃-----Welcome to employee management system-----😃
1. Display all Employee record
2. Search records
3. Print reporting tree of given employee
4. Employees reporting to the given manager
5. exit
   2
1. String
2. Integer
   1

Please choose the field to apply search condition
1. name
2. reportingTo
3. designation
4. department
   3

Choose any string operations from below list
1. Equals
2. Not Equals
3. Contains
4. Not contains
5. Starts with
6. Ends with
   3

Please enter the string value you want to search for
JUNIOR

Do you want to search more ?
1. Yes
2. No
   2
   ✅---Printing selected employees---✅
   Employee Id : 21
   Employee name : vijay
   Employee age :21
   Reporting manager : Catherine
   Designation : JUNIOR AUTOMATION TESTER
   Department : AUTOMATION TESTING
-----------------------------------------------------------------------
Employee Id : 23
Employee name : Priyanka arul mohan
Employee age :31
Reporting manager : Arivu
Designation : JUNIOR FIRMWARE DEVELOPER
Department : FRAMEWORK DEVELOPMENT
-----------------------------------------------------------------------
Employee Id : 27
Employee name : Henry
Employee age :37
Reporting manager : Dheva
Designation : JUNIOR FIRMWARE DEVELOPER
Department : FIRMWARE DEVELOPMENT
-----------------------------------------------------------------------

😃-----Welcome to employee management system-----😃
1. Display all Employee record
2. Search records
3. Print reporting tree of given employee
4. Employees reporting to the given manager
5. exit