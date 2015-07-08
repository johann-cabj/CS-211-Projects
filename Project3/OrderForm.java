import java.util.ArrayList;
import java.util.List;

public class OrderForm {

    private ArrayList<Item> items;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public OrderForm() {
        items = new ArrayList<Item>();
    }

    public boolean addItem(Item item) {
        if (!item.isValid()) {
            return false;
        }
        items.add(item);
        return true;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
	
	public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    public void clean(String content) {
        content = cleanPhoneNumber(content);
        content = cleanName(content, true);
        cleanName(content, false);
    }

    private String cleanName(String content, boolean isBuildLastName) {
        if (content == null || "".equals(content)) {
            if (isBuildLastName) {
                this.lastName = null;
            } else {
                this.firstName = null;
            }
            return content;
        }
        int index = 0;
        for (int i = content.length() - 1; i > 0; i--) {
            if (Character.isUpperCase(content.charAt(i))) {
                index = i;
                break;
            }
        }
        String subContent = content.substring(index, content.length());
        String subContent1 = null;
        for (int i = 0; i < subContent.length(); i++) {
            if (subContent.charAt(i) == ' ') {
                index = i;
                subContent1 = subContent.substring(index, subContent.length());
                break;
            }
        }
        if (isBuildLastName) {
            if (subContent1 != null) {
                this.lastName = subContent.replace(subContent1, "").trim();
            } else {
                this.lastName = subContent.trim();
            }
        } else {
            if (subContent1 != null) {
                this.firstName = subContent.replace(subContent1, "").trim();
            } else {
                this.firstName = subContent.trim();
            }

        }
        return content.replace(subContent, "");
    }

    private String cleanPhoneNumber(String content) {
        int phoneNumberCount = 0;
        int index = 0;
        for (int i = content.length() - 1; i > 0; i--) {
            if (Character.isDigit(content.charAt(i))) {
                phoneNumberCount++;
                if (phoneNumberCount == 10) {
                    index = i;
                    break;
                }
            }
        }
        String subContent = content.substring(index, content.length());
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        phoneNumberCount = 0;
        for (int i = 0; i < subContent.length(); i++) {
            if (Character.isDigit(subContent.charAt(i))) {
                phoneNumberCount++;
                builder.append(subContent.charAt(i));
                if (phoneNumberCount == 3) {
                    builder.append(") ");
                }
                if (phoneNumberCount == 6) {
                    builder.append("-");
                }
            }
        }
        String newContent = content.replace(subContent, "");
        if (newContent == null || "".equals(newContent)) {
            this.phoneNumber = null;
        } else {
            this.phoneNumber = builder.toString();
        }
        return newContent;
    }
}
