import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class OrderForm {

    private String firstName;
    private String lastName;
    private String[] items;
    private Date date;
    private String phoneNumber;

    public final int NUMITEM = 5;
    public final String patternString = "([A-Z][a-zA-Z0-9]*\\s)([A-Z][a-zA-Z0-9]*\\s)(\\d{3}[-\\.]\\d{3}[-\\.]\\d{4})";
    private Pattern pattern;

    public OrderForm() {

        items = new String[NUMITEM];
    }

    public OrderForm(String firstName, String lastName, Date date, String phoneNumber){

        setFirstName(firstName);
        setLastName(lastName);
        this.date = date;
        setPhoneNumber(phoneNumber);
        items = new String[NUMITEM];
    }

    /*** set methods ***/
    public void setFirstName(String firstName){

        //trim the leading & traling spaces
        this.firstName = firstName==null?null:firstName.trim();
    }

    public void setLastName(String lastName){

        //trim the leading & traling spaces
        this.lastName = lastName==null?null:lastName.trim();
    }

    public void setDate(Date date){

        this.date = date;
    }

    public void setPhoneNumber(String phoneNumber){

        //trim the leading & traling spaces
        this.phoneNumber = phoneNumber==null?null:phoneNumber.trim();
    }

    public void setItems(String[] items){

        //if items == null, don't set it
        if(items == null) return;
        this.items = items;
    }

    /*** get methods ***/
    public String getFirstName(){

        return firstName;
    }

    public String getLastName(){

        return lastName;
    }

    public String getPhoneNumber(){

        return phoneNumber;
    }

    public String[] getItems(){

        //since the requirement doesn't require the security issue,
        //i.e can modify the items, we can just return the items array,
        //don't need to clone over
        return this.items;
    }

    public Date getDate(){

        return date;
    }

    public boolean process(String input){

        //if the input is null, return false
        if(input == null) return false;

        //lazy initialization
        if(pattern == null){
            pattern = Pattern.compile(patternString);
        }

        Matcher m = pattern.matcher(input);
        boolean found = false;

        //using while here, we can choose whether to break or not
        //to get the last match
        while(m.find()){
            found = true;

            //the requirement only require to store matched field, 
            //doesn't require to store the current date
            setFirstName(m.group(1));
            setLastName(m.group(2));
            setPhoneNumber(m.group(3));
            break; //optional
        }
       
        return found;
    }

    public boolean addItem(String item){

        //if the items array is null or empty, cannot add
        if(items == null || items.length == 0)
            return false;

        //if the item is null, return true but won't add item
        if(item == null) return true; 

        for(int i = 0; i < items.length; i++){
            if(items[i] == null){
                items[i] = item.trim();
                return true;
            }
        }

        return false;
    }
}
