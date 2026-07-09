-- Last updated: 7/9/2026, 3:06:57 PM
WITH cte AS (
    SELECT
        person_name,
        turn,
        SUM(weight) OVER(
            ORDER BY turn
        ) AS total_weight
    FROM Queue
)

SELECT person_name
FROM cte
WHERE total_weight <= 1000
ORDER BY total_weight DESC
LIMIT 1;