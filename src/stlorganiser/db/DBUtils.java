/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stlorganiser.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import stlorganiser.controllers.PrintInformationsController;
import stlorganiser.models.PrintInformations;


/**
 *
 * @author Jean-Christophe Chatelain
 */
public class DBUtils {
    private final String JDBC_CONNECT = "jdbc:sqlite:PrintInformations.db";
    private final String JDBC_CLASS = "org.sqlite.JDBC";
    private final String DB_OPEN_SUCCESS = "opened successfully";
    private final String SQL_SELECT_ALL = "SELECT * FROM PrintInformations ORDER BY grade DESC;";
    private final int SQL_DATABASE_ERROR = 1;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public DBUtils()
    {
        try
        {
            connection = getConnection();
            statement = connection.createStatement();			
        }
        catch (SQLException e )
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );            
        }   
    }

    private Connection getConnection()
    {
        try
        {
            Class.forName(JDBC_CLASS);
            Connection c = DriverManager.getConnection(JDBC_CONNECT);
            System.out.println(DB_OPEN_SUCCESS);
            return c;
        }
        catch (ClassNotFoundException | SQLException e )
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
    }

    private void createTable()
    {
        try
        {
            String sql = "CREATE TABLE PrintInformations (checksum BIGINT (100)" +  
                    "UNIQUE ON CONFLICT FAIL PRIMARY KEY," +
                    "name TEXT, path TEXT, size BIGINT (100), " +
                    "description TEXT, grade INTEGER(6), support TINYINT(3), printTime TEXT)";

            // execute the statement string
            statement.executeUpdate(sql);                
        }
        catch ( SQLException e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );              
        }


    }
    
   

    public void addToDB(PrintInformations item)
    {
            try
            {
                statement.executeUpdate(item.getSQLInsert());
            }
            catch ( SQLException e)
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
    }

    public void updateDB(PrintInformations item)
    {
        try
        {
            statement.executeUpdate(item.getSQLUpdate());
        }
        catch ( SQLException e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void deleteFromDB(Long checksum)
    {
        try
        {
            statement.executeUpdate("DELETE from PrintInformations WHERE checksum =" + checksum + ";");
        }
        catch ( SQLException e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void close()
    {
        try
        {
            statement.close();
            connection.close();	
            System.out.println("Database successfully closed.");		
        }
        catch (SQLException e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }   
    }

    public ArrayList<PrintInformations> loadPrintInformationsFromDB() {
        try
        {
            System.out.println("Loading data from table...");
            ArrayList<PrintInformations> printInfoList = new ArrayList<>();

            resultSet = statement.executeQuery( SQL_SELECT_ALL );

            while (resultSet.next())
            {
                    printInfoList.add(new PrintInformations(resultSet));
            }
            System.out.println("Loaded " + printInfoList.size() + " records.");
            return printInfoList;			
        }
        catch ( SQLException e)
        {
            if (e.getErrorCode() == SQL_DATABASE_ERROR)
            {
                createTable();
                loadPrintInformationsFromDB();
            }
            else
            {
                System.err.println( e.getClass().getName() + ": " + e.getErrorCode() );
            }
        }
        return null;
    }
    
    public PrintInformations getPrintInformationFromDB(Long checksum) throws SQLException{
        PrintInformations printInfos=null;
        resultSet = statement.executeQuery("SELECT * FROM PrintInformations WHERE checksum = "+checksum+";" );
        while (resultSet.next())
        {
               printInfos =new PrintInformations(resultSet);
        }
        return printInfos;
    }

}
