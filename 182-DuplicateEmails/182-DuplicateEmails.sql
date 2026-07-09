-- Last updated: 7/9/2026, 3:08:06 PM
# Write your MySQL query statement below
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(*) > 1;