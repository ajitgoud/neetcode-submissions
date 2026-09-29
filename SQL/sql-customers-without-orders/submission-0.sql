-- Write your query below
SELECT c.name
FROM customers AS c
LEFT JOIN orders AS o
ON c.id=o.customer_id
WHERE o.customer_id is NULL;
