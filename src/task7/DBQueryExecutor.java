import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBQueryExecutor {

    private final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASS = "123";

    private Connection makeConnection() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("You successfully connected to database now");
        return connection;
    }

    public static void printData(ResultSet data) {
        try {
            ResultSetMetaData metaData = data.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<Integer> columnWidths = new ArrayList<>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                columnWidths.add(metaData.getColumnName(i).length());
            }

            List<String[]> rows = new ArrayList<>();
            while (data.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = data.getString(i);
                    if (row[i - 1] != null) {
                        columnWidths.set(i - 1, Math.max(columnWidths.get(i - 1), row[i - 1].length()));
                    }
                }
                rows.add(row);
            }

            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-" + columnWidths.get(i - 1) + "s\t", metaData.getColumnName(i));
            }
            System.out.println();

            for (String[] row : rows) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.printf("%-" + columnWidths.get(i) + "s\t", row[i]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error while printing data");
            e.printStackTrace();
        }
    }

    static void executeQuery(Connection con, String query) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        printData(rs);
        stmt.close();
    }

    public void run() throws SQLException {

        DBQueryExecutor baseWorker = new DBQueryExecutor();
        Connection connection = baseWorker.makeConnection();

        connection.setAutoCommit(true);

        final String firstQuery = """
                SELECT * FROM
                    public.employeesAge
                WHERE
                    employeesAge.age > 20
                LIMIT 10;
                    """;

        final String secondQuery = """
                SELECT departmentname, round(AVG(salary), 2)::real as "Average salary" FROM
                    public.departmentsalary
                GROUP BY departmentname;
                """;

        final String thirdQuery = """
                SELECT public.departmentemployee.employeename,
                        public.departmentlocation.departmentname,
                        public.departmentlocation.location
                FROM
                    public.departmentemployee
                INNER JOIN
                    public.departmentlocation
                ON
                    public.departmentemployee.departmentid = public.departmentlocation.id
                LIMIT 100;
                    """;

        DBQueryExecutor.executeQuery(connection, firstQuery);
        DBQueryExecutor.executeQuery(connection, secondQuery);
        DBQueryExecutor.executeQuery(connection, thirdQuery);
        connection.close();

    }

    public static void main(String[] argv) throws SQLException {
        new DBQueryExecutor().run();
    }
}
