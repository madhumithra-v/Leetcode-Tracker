-- Last updated: 7/9/2026, 3:06:56 PM
SELECT
query_name,
ROUND(AVG(rating/position),2) AS quality,
ROUND(AVG(rating<3)*100,2) AS poor_query_percentage
FROM Queries
GROUP BY query_name;