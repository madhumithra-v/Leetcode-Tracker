-- Last updated: 7/9/2026, 3:07:17 PM
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = 
(
    SELECT COUNT(*)
    FROM Product
);