package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author J-Tron
 */
public class ConsoleOutputTest {
    
    
    public static void main(String[] args) throws Exception{
        DB_MySql database = new DB_MySql();
        
        List<MenuItem> menu_items = new <MenuItem>ArrayList();
        
        database.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mydb", "root", "tiburon87");
        
        String tableName = "menu_items";
        
        List<Map> menu_list = database.findAllRecords(tableName, true);
        
        for(int i = 1; i < menu_list.size(); i++){
            MenuItem item = new MenuItem();
            item.setName((String)(menu_list.get(i).get("name")));
            item.setDescription((String)(menu_list.get(i).get("description")));
            item.setPrice((Double)(menu_list.get(i).get("price")));
            menu_items.add(item);
        }
        
        for(int x = 0; x < menu_items.size(); x++){
            System.out.print(menu_items.get(x).toString() + "\n");
        }
        
        
       
    }
}
