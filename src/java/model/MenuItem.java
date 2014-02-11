package model;

/**
 *
 * @author J-Tron
 */
public class MenuItem {
    private int itemID;
    private String name;
    private String description;
    private double price;
    
    public MenuItem(int itemID, String name, String description, double price){
        this.itemID= itemID;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public MenuItem(){
        
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
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
    
       @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.itemID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.itemID != other.itemID) {
            return false;
        }
        return true;
    }
    
    
}
