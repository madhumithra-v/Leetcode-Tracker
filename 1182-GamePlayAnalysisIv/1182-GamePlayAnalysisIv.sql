-- Last updated: 7/9/2026, 3:07:06 PM
WITH first_login AS (
    SELECT
        player_id,
        MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
)

SELECT
    ROUND(
        COUNT(a.player_id) /
        (SELECT COUNT(*) FROM first_login),
        2
    ) AS fraction
FROM first_login f
LEFT JOIN Activity a
ON f.player_id = a.player_id
AND a.event_date = DATE_ADD(f.first_date, INTERVAL 1 DAY);