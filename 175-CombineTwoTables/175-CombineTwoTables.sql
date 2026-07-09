-- Last updated: 7/9/2026, 3:08:18 PM
# Write your MySQL query statement below
SELECT
    p.FirstName,
    p.LastName,
    a.City,
    a.State
FROM Person p
LEFT JOIN Address a
ON p.PersonId = a.PersonId;