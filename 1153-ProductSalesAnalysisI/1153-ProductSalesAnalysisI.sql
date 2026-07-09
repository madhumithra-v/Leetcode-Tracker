-- Last updated: 7/9/2026, 3:07:16 PM
SELECT
    p.product_name,
    s.year,
    s.price
FROM Sales s
JOIN Product p
ON s.product_id = p.product_id;