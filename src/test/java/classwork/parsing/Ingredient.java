package classwork.parsing;


import java.util.Objects;

public class Ingredient {

    private String itemdescription;
    private int quantity;

    public Ingredient() {
    }

    public Ingredient(String itemdescription, int quantity) {
        this.quantity = quantity;
        this.itemdescription = itemdescription;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return quantity == that.quantity && Objects.equals(itemdescription, that.itemdescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemdescription, quantity);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "itemdescription='" + itemdescription + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
