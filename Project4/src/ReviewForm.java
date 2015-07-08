import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewForm extends Form {

    private String reviewText;
    private int numericRating;

    public final String patternString = "([A-Z][a-zA-Z0-9]*\\s)([A-Z][a-zA-Z0-9]*\\s)(\\d{3}[-\\.]\\d{3}[-\\.]\\d{4})";
    private Pattern pattern;

    public ReviewForm() {
	super();
	reviewText = "None";
	numericRating = -1;
    }

    public ReviewForm(String firstName, String lastName, Date date,
	    String phoneNumber, String reviewText, int rating) {
	super(firstName, lastName, date, phoneNumber);
	setReview(reviewText);
	setStars(rating);
    }

    /*** set methods ***/

    public void setReview(String reviewText) {

	if (reviewText == null)
	    this.reviewText = "None";
	else
	    this.reviewText = reviewText; // no need to trim here
    }

    public void setStars(int rating) {

	// only set numeric rating when it is -1 or from 1 to 5
	if (rating == -1 || (1 <= rating && rating <= 5))
	    this.numericRating = rating;
    }

    public String getReview() {

	return reviewText;
    }

    public int getStars() {

	return numericRating;
    }

    @Override
    /**
     * String representation 
     * 
     * @return string representation
     */
    public String toString() {
	String output = super.toString() + ", " + this.reviewText;
	return output;

    }

    @Override
    public boolean process(String input) {

	// if the input is null, return false
	if (input == null)
	    return false;

	// lazy initialization
	if (pattern == null) {
	    pattern = Pattern.compile(patternString);
	}

	Matcher m = pattern.matcher(input);
	boolean found = false;

	// using while here, we can choose whether to break or not
	// to get the last match
	while (m.find()) {
	    found = true;

	    // the requirement only require to store matched field,
	    // doesn't require to store the current date
	    setFirstName(m.group(1));
	    setLastName(m.group(2));
	    setPhoneNumber(m.group(3));
	    break; // optional
	}

	return true;
    }
}