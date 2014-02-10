package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author J-Tron
 */
public class DB_MySql implements DBAccessor{
    private Connection connection;
    
    public DB_MySql(){
        
    }
   
    @Override
    public void openConnection(String driverClassName, String url, String username, String password) throws IllegalArgumentException, ClassNotFoundException, SQLException {
                String msg = "Please enter a valid URL!";
		if( url == null || url.length() == 0 ) throw new IllegalArgumentException(msg);
		username = (username == null) ? "" : username;
		password = (password == null) ? "" : password;
		Class.forName (driverClassName);
		connection = DriverManager.getConnection(url, username, password);
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }

    @Override
    public List findRecords(String sqlQuery, boolean closeConnection) throws SQLException, Exception {
        
                Statement sqlStatement = null;
		ResultSet sqlResults = null;
		ResultSetMetaData metaData = null;
		final List listOfRecords = new ArrayList();
		Map record = null;
                
                try{
                    sqlStatement = connection.createStatement();
                    sqlResults = sqlStatement.executeQuery(sqlQuery);
                    metaData = sqlResults.getMetaData();
                    final int numFields = metaData.getColumnCount();
                    
                    while(sqlResults.next()){
                        record = new HashMap();
                        for(int i = 0; i <= numFields; i++){
                            try{
                                record.put(metaData.getColumnName(i), sqlResults.getObject(i));
                            }catch(NullPointerException nullValue){ 
                                //Since Null values are allowed for some fields nothing is done here, they will be handled 
                                //in the creation of the object.
                            }
                        }
                            listOfRecords.add(record);
                        }
                           
                    }catch(SQLException sqle){
                        throw sqle;
                            
                    }catch(Exception e){
                        throw e;
                    }
                finally{
                    try{
                        sqlStatement.close();
				if(closeConnection) connection.close();
                    }catch(SQLException e){
                        throw e;
                    }
                }
                
                return listOfRecords;
    }
    
    
    
}
