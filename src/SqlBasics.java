/**
 * SQL basics: one table, six warm-ups (2-3 min each).
 * Write your query in each constant, then check it against the expected result.
 * No database is needed. Trace the query by hand on the sample data.
 *
 * Employees
 *   id | name | department | salary | hire_year
 *    1 | Ana  | Sales      | 48000  | 2019
 *    2 | Ben  | Sales      | 52000  | 2020
 *    3 | Cara | IT         | 70000  | 2018
 *    4 | Dan  | IT         | 65000  | 2021
 *    5 | Eve  | IT         | 58000  | 2022
 *    6 | Finn | HR         | 45000  | 2020
 *    7 | Gia  | HR         | 51000  | 2017
 *
 * Cheat sheet
 *   Write order:  SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY, LIMIT
 *   Runs in this order: FROM, WHERE, GROUP BY, HAVING, SELECT, ORDER BY, LIMIT
 *   WHERE filters rows. HAVING filters groups (use it with aggregates like COUNT).
 *   Text is in 'single quotes'. Equality is =, not ==.
 *   Aggregates: COUNT(*), SUM(x), AVG(x), MIN(x), MAX(x).
 *   Every column in SELECT that is not inside an aggregate must be in GROUP BY.
 *   NULL: use IS NULL / IS NOT NULL, never = NULL.
 */
public class SqlBasics {

    /**
     * B1: Return the name and salary of every employee.
     * Expected: 7 rows (Ana 48000, Ben 52000, ... Gia 51000).
     */
    static final String B1 = """
            -- your query here
            """;

    /**
     * B2: Return the names of employees who earn more than 50000,
     * highest salary first.
     * Expected: Cara, Dan, Eve, Ben, Gia
     */
    static final String B2 = """
            -- your query here
            """;

    /**
     * B3: Return the names of employees in the Sales or HR departments,
     * sorted by name. Try it with IN.
     * Expected: Ana, Ben, Finn, Gia
     */
    static final String B3 = """
            -- your query here
            """;

    /**
     * B4: Return how many employees there are.
     * Expected: 7
     */
    static final String B4 = """
            -- your query here
            """;

    /**
     * B5: Return each department with its average salary, sorted by department.
     * Expected: HR 48000, IT 64333.33, Sales 50000
     */
    static final String B5 = """
            -- your query here
            """;

    /**
     * B6: Return the departments that have more than 2 employees.
     * Expected: IT
     */
    static final String B6 = """
            -- your query here
            """;

    public static void main(String[] args) {
        System.out.println("B1:\n" + B1);
        System.out.println("B2:\n" + B2);
        System.out.println("B3:\n" + B3);
        System.out.println("B4:\n" + B4);
        System.out.println("B5:\n" + B5);
        System.out.println("B6:\n" + B6);
    }
}
