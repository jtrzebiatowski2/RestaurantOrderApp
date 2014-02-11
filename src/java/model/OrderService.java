package model;

import java.util.List;

/**
 *
 * @author J-Tron
 */
public class OrderService {
    private final OrderDAOStrategy order;
    private List<MenuItem> menuItems;
    
    public OrderService(){
        order = new OrderDAO();
    }
    
    public List<MenuItem> getMenuItems() {
        menuItems = order.getMenuItems();
        return menuItems;
    }
    
}
