-- Last updated: 7/9/2026, 3:07:30 PM
SELECT id, COUNT(*) AS num
FROM(
    SELECT requester_id AS id
    FROM RequestAccepted

    UNION ALL

    SELECT accepter_id
    FROM RequestAccepted

) t
GROUP BY id
ORDER BY num DESC
LIMIT 1;