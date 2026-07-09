-- Last updated: 7/9/2026, 3:08:05 PM
# Write your MySQL query statement below
SELECT c.Name AS Customers
FROM Customers c
LEFT JOIN Orders o
ON c.Id = o.CustomerId
WHERE o.Id IS NULL;