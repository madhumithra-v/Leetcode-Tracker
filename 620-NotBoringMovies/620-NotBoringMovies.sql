-- Last updated: 7/9/2026, 3:07:24 PM
SELECT *
FROM Cinema
WHERE id % 2 = 1
AND description <> 'boring'
ORDER BY rating DESC;