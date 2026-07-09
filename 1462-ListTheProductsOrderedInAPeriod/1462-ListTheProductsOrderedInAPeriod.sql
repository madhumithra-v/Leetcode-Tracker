-- Last updated: 7/9/2026, 3:06:49 PM
SELECT
    p.product_name,
    SUM(o.unit) AS unit
FROM Products p
JOIN Orders o
ON p.product_id = o.product_id
WHERE DATE_FORMAT(order_date,'%Y-%m') = '2020-02'
GROUP BY p.product_name
HAVING SUM(o.unit) >= 100;