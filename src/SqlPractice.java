/**
 * SQL practice (5-8 min each). Write your query in the matching constant, then ask for a review.
 *
 * Schema (MySQL / standard SQL):
 *   Employees(id, name, salary, department_id, manager_id)   -- manager_id is NULL for the CEO
 *   Departments(id, name)
 *   Orders(id, customer_id, order_date, amount)
 *   Customers(id, name, country)
 */
public class SqlPractice {

    /**
     * Q1 (easy): Customers who have never placed an order.
     * Return their names, sorted by name ascending.
     */
    static final String Q1 = """
            SELECT c.name FROM Customers c
            LEFT JOIN Orders o ON o.customer_id = c.id
            WHERE o.id IS NULL
            ORDER BY c.name;
            """;

    /**
     * Q2 (medium): Above-average earners.
     * For each department, list the employees whose salary is strictly higher than the
     * average salary of their own department.
     * Return: department name, employee name, salary.
     * Order by department name, then salary descending.
     */
    static final String Q2 = """
            SELECT d.name AS department, e.name AS employee, e.salary
            FROM Employees e
            JOIN Departments d ON d.id = e.department_id
            JOIN (
                SELECT department_id, AVG(salary) AS avg_salary
                FROM Employees
                GROUP BY department_id
            ) a ON a.department_id = e.department_id
            WHERE e.salary > a.avg_salary
            ORDER BY d.name, e.salary DESC;
            """;

    /**
     * Q3 (medium-hard): Top customer per country.
     * For each country, return the customer with the highest total order amount.
     * Return: country, customer name, total_amount.
     * If customers tie within a country, return all of them.
     * Ignore customers with no orders.
     */
    static final String Q3 = """
            WITH totals AS (
                SELECT c.id, c.name, c.country, SUM(o.amount) AS total_amount
                FROM Customers c
                JOIN Orders o ON o.customer_id = c.id
                GROUP BY c.id, c.name, c.country
            ),
            ranked AS (
                SELECT *, RANK() OVER (PARTITION BY country ORDER BY total_amount DESC) AS rnk
                FROM totals
            )
            SELECT country, name AS customer_name, total_amount
            FROM ranked
            WHERE rnk = 1;
            """;

    /**
     * Q4 (easy): Department headcount.
     * Return each department name with its number of employees.
     * Include departments with zero employees (count 0).
     * Order by count descending, then department name ascending.
     */
    static final String Q4 = """
            SELECT 
            """;

    /**
     * Q5 (medium): Employees who earn more than their manager.
     * Return: employee name, employee salary, manager name, manager salary.
     * The CEO (no manager) must not appear.
     */
    static final String Q5 = """
            -- your query here
            """;

    /**
     * Q6 (medium-hard): Second-highest order per customer.
     * For each customer, return the amount of their second-highest distinct order amount.
     * Return: customer name, second_highest_amount.
     * If a customer has fewer than two distinct amounts, second_highest_amount must be NULL,
     * and the customer must still appear. Customers with no orders also appear with NULL.
     */
    static final String Q6 = """
            -- your query here
            """;

    public static void main(String[] args) {
        System.out.println("Q1:\n" + Q1);
        System.out.println("Q2:\n" + Q2);
        System.out.println("Q3:\n" + Q3);
        System.out.println("Q4:\n" + Q4);
        System.out.println("Q5:\n" + Q5);
        System.out.println("Q6:\n" + Q6);
    }
}
