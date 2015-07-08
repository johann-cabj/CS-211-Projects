import java.util.ArrayList;
import java.util.Date;

public class OrderForm extends Form {

    private ArrayList<Item> items;

    /**
     * Default Constructor
     */
    public OrderForm() {
	super();
	this.items = new ArrayList<Item>();
    }

    public boolean addItem(Item item) {
	if (!item.isValid()) {
	    return false;
	}
	items.add(item);
	return true;
    }

    public ArrayList<Item> getItems() {
	return items;
    }

    public void setItems(ArrayList<Item> items) {

	if (items != null)
	    this.items = items;
    }

    /**
     * Parameter Constructor
     * 
     * @param firstName
     * @param lastName
     * @param date
     * @param phoneNumber
     */
    public OrderForm(String firstName, String lastName, Date date,
	    String phoneNumber) {
	super(firstName, lastName, date, phoneNumber);
	this.items = new ArrayList<Item>();
    }

    @Override
    /**
     * String representation 
     * 
     * @return string representation
     */
    public String toString() {
	String output = super.toString() + ", ";

	for (int i = 0; i < items.size() - 1; i++) {
	    Item it = items.get(i);
	    output += it.getName() + ",";
	}

	output += items.get(items.size() - 1).getName();

	return output;

    }
}
