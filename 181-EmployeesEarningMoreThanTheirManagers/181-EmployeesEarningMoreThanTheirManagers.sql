-- Last updated: 7/9/2026, 3:08:08 PM
# Write your MySQL query statement below
SELECT e.Name AS Employee
FROM Employee e
JOIN Employee m
ON e.ManagerId = m.Id
WHERE e.Salary > m.Salary;