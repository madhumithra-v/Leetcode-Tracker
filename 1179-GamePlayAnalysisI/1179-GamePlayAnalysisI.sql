-- Last updated: 7/9/2026, 3:07:10 PM
SELECT
    player_id,
    MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;