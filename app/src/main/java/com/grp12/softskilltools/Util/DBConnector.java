package com.grp12.softskilltools.Util;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Calendar;


    public class DBConnector {

        private final String HOST     = "Localhost";
        private final int    PORT     = 3307;
        private final String DATABASE = "test";
        private final String USERNAME = "root";
        private final String PASSWORD = "usbw";
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
        String createDB = "CREATE DATABASE " + timeStamp;
        public Connection connection;
        public boolean broke;

        /****************************************************************
         * This method is used to create a connection to the specific	*
         * database that we are using.									*
         ***************************************************************/
        public DBConnector() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
                connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        public Connection getConnection() {
            return connection;
        }

        /****************************************************************************
         * Method to use making SQL queries for our later use of SQL scripts.		*
         * @param query The SQL command we want to complete is defined by the query	*
         * @return Returns the results we want.										*
         ***************************************************************************/
        public ResultSet doQuery(String query) throws SQLException{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            stmt.close();
            rs.close();
            return rs;
        }

        /****************************************************************************
         * Method to use when we want to send the query we just created to the 		*
         * database.																*
         * @param query The SQL command we want to complete is defined by the query	*
         ***************************************************************************/
        public void doUpdate(String query) throws SQLException{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();

        }

        /****************************************************************************
         * Method that will create a string from the query we created so it can be	*
         * read in the database.													*
         * @param query The SQL command we want to complete is defined by the query	*
         ***************************************************************************/
        public String[] doQueryToString(String query) throws SQLException {
            ArrayList<String> list= new ArrayList<String>();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(rs.getString(1));


            }

            String[] result = new String[list.size()];
            result = list.toArray(result);

            stmt.close();
            rs.close();
            return result;
        }
}
