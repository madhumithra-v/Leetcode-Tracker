-- Last updated: 7/9/2026, 3:07:14 PM
SELECT
    p.project_id,
    ROUND(AVG(e.experience_years),2) AS average_years
FROM Project p
JOIN Employee e
ON p.employee_id = e.employee_id
GROUP BY p.project_id;