package model;

/**
 *
 * @author J-Tron
 */
public class MenuItem {
    private String name;
    private String description;
    private double price;
    
    MenuItem(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    MenuItem(){
        
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item:" + name + "\nDescription:" + description + "\nPrice:" + price + "\n ============================================================================";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
