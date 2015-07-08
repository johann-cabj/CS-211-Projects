public class Item {
    private String name;
    private double price;
    private int quantity;
    private static int count = -1;

    public Item() {
	if (count == -1)
	    count = 1;
	else
	    count++;
    }

    public Item(String name, double price, int quantity) {
	this.setName(name);
	this.setPrice(price);
	this.setQuantity(quantity);

	if (count == -1)
	    count = 1;
	else
	    count++;
    }

    public static int getCount() {
	return count;
    }

    public static void resetCount() {
	count = -1;
    }

    public boolean isValid() {
	if (this.price >= 0) {
	    if (this.name != null && this.name.length() >= 1) {
		if (this.quantity > 0) {
		    return true;
		}
	    }
	}
	return false;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }
}
