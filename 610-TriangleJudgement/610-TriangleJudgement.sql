-- Last updated: 7/9/2026, 3:07:27 PM
SELECT
    x,
    y,
    z,
    CASE
        WHEN x+y>z
         AND x+z>y
         AND y+z>x
        THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM Triangle;
        