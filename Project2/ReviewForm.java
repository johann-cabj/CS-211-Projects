
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Date;

public class ReviewForm {
    
    private String firstName;
    private String lastName;
    private Date date;
    private String phoneNumber;
    private String reviewText;
    private int numericRating;

    public final String patternString = "([A-Z][a-zA-Z0-9]*\\s)([A-Z][a-zA-Z0-9]*\\s)(\\d{3}[-\\.]\\d{3}[-\\.]\\d{4})";
    private Pattern pattern;

    public ReviewForm(){

        reviewText = null;
        numericRating = -1;
    }

    public ReviewForm(String firstName, String lastName, Date date, String phoneNumber, String reviewText, int rating){

        setFirstName(firstName);
        setLastName(lastName);
        setDate(date);
        setPhoneNumber(phoneNumber);
        setReviewText(reviewText);
        setNumericRating(rating);
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

    public void setReviewText(String reviewText){

        this.reviewText = reviewText; // no need to trim here
    }

    public void setNumericRating(int rating){

        //only set numeric rating when it is -1 or from 1 to 5
        if(rating == -1 || (1 <= rating && rating <= 5))
            this.numericRating = rating;
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

    public Date getDate(){

        return date;
    }

    public String getReviewText(){

        return reviewText;
    }

    public int getNumericRating(){

        return numericRating;
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
}