-- Last updated: 7/9/2026, 3:06:44 PM
SELECT
    stock_name,
    SUM(
        CASE
            WHEN operation='Sell'
            THEN price
            ELSE -price
        END
    ) AS capital_gain_loss
FROM Stocks
GROUP BY stock_name;