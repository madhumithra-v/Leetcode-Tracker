-- Last updated: 7/9/2026, 3:07:59 PM
# Write your MySQL query statement below
SELECT w1.id
FROM Weather w1
JOIN Weather w2
ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;