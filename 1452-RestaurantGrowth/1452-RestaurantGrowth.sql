-- Last updated: 7/9/2026, 3:06:50 PM
SELECT
visited_on,
SUM(amount) OVER(
    ORDER BY visited_on
    ROWS BETWEEN 6 PRECEDING
    AND CURRENT ROW
) AS amount,
ROUND(
    AVG(amount) OVER(
        ORDER BY visited_on
        ROWS BETWEEN 6 PRECEDING
        AND CURRENT ROW
    ),2
) AS average_amount
FROM
(
    SELECT
    visited_on,
    SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
) t
LIMIT 100000 OFFSET 6;