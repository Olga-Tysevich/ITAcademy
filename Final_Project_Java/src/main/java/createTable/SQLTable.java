package createTable;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQLTable {
    public static void main(String[] args) {
        SQLTable sqltable = new SQLTable();
    }

    public SQLTable() {
        createTables(createConnect());
    }

    private void createTables(Connection connection) {
        try {
            Statement statement = createStatement(connection);
            Properties queries = new Properties();
            queries.load(Files.newInputStream(Paths.get("src/main/resources/com/example/final_project_java/createDBQueries.properties")));
            createDBQuery(queries.getProperty("CreateMaterialsTable"), "Created materials table", "Creating materials table failed");
            createDBQuery(queries.getProperty("CreateCustomersTable"), "Created customers table", "Creating customers table failed");
            createDBQuery(queries.getProperty("CreateRecyclableTypeTable"), "Created recyclable type table", "Creating recyclable type table failed");
            createDBQuery(queries.getProperty("CreateRecyclableUnitsTable"), "Created recyclableUnits table", "Creating recyclableUnits table failed");
            createDBQuery(queries.getProperty("CreateRecyclableUnitsDataTable"), "Created recyclableUnitsData table", "Creating recyclableUnitsData table failed");
            createDBQuery(queries.getProperty("CreateRequisitesTable"), "Created requisites table", "Creating requisites table failed");
            createDBQuery(queries.getProperty("CreateBankAccountsTable"), "Created bankAccounts table", "Creating bankAccounts table failed");
            createDBQuery(queries.getProperty("CreateContractsTable"), "Created contracts table", "Creating contracts table failed");
            createDBQuery(queries.getProperty("CreatePricesTable"), "Created price table", "Creating price table failed");
            createDBQuery(queries.getProperty("CreateWayBillsTable"), "Created wayBills table", "Creating wayBills table failed");
            createDBQuery(queries.getProperty("CreateWayBillsDataTable"), "Created wayBillsData table", "Creating wayBillsData table failed");
            createDBQuery(queries.getProperty("CreateBillsTable"), "Created bills table", "Creating bills table failed");
            createDBQuery(queries.getProperty("CreateBillsDataTable"), "Created billsData table", "Creating billsData table failed");
            createDBQuery(queries.getProperty("CreatePaymentsTable"), "Created payments table", "Creating payments table failed");
            createDBQuery(queries.getProperty("CreatePaymentsDataTable"), "Created paymentsData table", "Creating paymentsData table failed");
            createDBQuery(queries.getProperty("AddRecyclableType"), "added RT", "not added RT");
            createDBQuery(queries.getProperty("AddMaterials"), "added M", "not added M");
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void createDBQuery(String query, String posMessage, String negMessage) {
        Connection conn = createConnect();
        Statement statement = conn != null ? createStatement(conn) : null;
        boolean checkQuery = checkQuery(statement, query);
        if (checkQuery) {
            System.out.println(posMessage);
        } else {
            System.out.println(negMessage);
        }
        try {
            if (conn != null) {
                conn.close();
            } else {
                System.out.println("Connection is null!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean checkQuery(Statement statement, String query) {
        if (statement != null) {
            try {
                statement.execute(query);
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

    private Statement createStatement(Connection conn) {
        if (conn != null) {
            try {
                return conn.createStatement();
            } catch (SQLException e) {
                System.out.println("Creation of statement failed...");
                return null;
            }
        }
        return null;
    }

    public Connection createConnect() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/final_project_java/databasefile/company.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
