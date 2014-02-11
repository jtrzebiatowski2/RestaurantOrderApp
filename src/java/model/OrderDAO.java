package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author J-Tron
 */
public class OrderDAO implements OrderDAOStrategy{
    private final DBAccessor databaseAccessor;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tiburon87";
    
    public OrderDAO(){
        databaseAccessor = new DB_MySql();
    }

    @Override
    public List<MenuItem> getMenuItems() {
        
        List<MenuItem> menuItems = new <MenuItem>ArrayList();
        
        try{
            databaseAccessor.openConnection(DRIVER, URL, USERNAME, PASSWORD);
            String tableName = "menu_items";
            List<Map> menu_list = databaseAccessor.findAllRecords(tableName, true);
            
            for(int i = 1; i < menu_list.size(); i++){
            MenuItem item = new MenuItem();
            item.setName((String)(menu_list.get(i).get("name")));
            item.setDescription((String)(menu_list.get(i).get("description")));
            item.setPrice((Double)(menu_list.get(i).get("price")));
            menuItems.add(item);
        }
            
        }catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch(Exception ex) {
             throw new RuntimeException(ex.getMessage(), ex);
        }
        
        return menuItems;
        
    }
  
}
