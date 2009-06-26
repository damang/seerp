package it.seerp.storage.db;
 

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
/**
 * This class simula un db connection pool
 *
 * @author Luisa
 * @version 1.0
 */
public class ConnectionPool {

    /*
     * il metodo crea la connessione col db e carica le realtive properties.
     */
    static {
        freeDbConnections = new ArrayList<Connection>();
        try {

            ConnectionPool.loadDbProperties();
            ConnectionPool.loadDbDriver();
        } catch (ClassNotFoundException e) {
            System.out.println("DB DRIVER NOT FOUND!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("DB CONNECTION POOL ERROR!");
            System.exit(2);
        }
    }
    /**
     *  properties del database
     */
    private static Properties dbProperties;
    /**
     * lista delle connessioni
     */
    private static List<Connection> freeDbConnections;

    /**
     * metodo che ritorna una conessione dalla lista delle conessioni
     * se non c'è ne sono di siponibili le crea
     *
     * @return conessione al db
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws SQLException {
        Connection connection;
        if (!freeDbConnections.isEmpty()) {
            connection = freeDbConnections.get(0);
            ConnectionPool.freeDbConnections.remove(0);

            try {
                if (connection.isClosed()) {
                    connection = ConnectionPool.getConnection();
                }
            } catch (SQLException e) {
                connection = ConnectionPool.getConnection();
            }
        } else {
            connection = ConnectionPool.createDBConnection();
        }

        return connection;
    }

    /**
     * metodo che rilascia la connessione e l'aggiunge alle connessioni libere
     * @param ReleasedCon conessione da rilasciare
     *     
     */
    public static synchronized void releaseConnection(Connection ReleasedCon) {

        ConnectionPool.freeDbConnections.add(ReleasedCon);
    }

    /**
     * crea una nuova connessione al bd basandosi sui parametri del file properrties
     *
     * @return una conessione al db
     * @throws SQLException
     */
    private static Connection createDBConnection() throws SQLException {
        Connection newConnection = null;

        newConnection = DriverManager.getConnection(
                ConnectionPool.dbProperties.getProperty("url"),
                ConnectionPool.dbProperties.getProperty("username"),
                ConnectionPool.dbProperties.getProperty("password"));

        return newConnection;
    }

    private static void loadDbDriver() throws ClassNotFoundException {
        Class.forName(ConnectionPool.dbProperties.getProperty("driver"));
    }

    /**
     * caricameno delle properties dal file database.properties
     *
     * @throws IOException
     */
    private static void loadDbProperties() throws IOException {
        InputStream fileProperties = new FileInputStream(".\\file_config\\database.properties");
        ConnectionPool.dbProperties = new Properties();
        ConnectionPool.dbProperties.load(fileProperties);

    }
}
