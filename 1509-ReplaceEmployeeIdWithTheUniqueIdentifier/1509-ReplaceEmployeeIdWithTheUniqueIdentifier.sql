-- Last updated: 7/9/2026, 3:06:45 PM
SELECT
    eu.unique_id,
    e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu
ON e.id = eu.id;