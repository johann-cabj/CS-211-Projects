/**
 * Abstract class Form
 * 
 * @author
 *
 */
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Form {

    // instance members
    private String firstName;
    private String lastName;
    private Date date;
    private String phoneNumber;

    public final String patternString = "([A-Z][a-zA-Z0-9]*\\s)([A-Z][a-zA-Z0-9]*\\s)(\\d{3}[-\\.]\\d{3}[-\\.]\\d{4})";
    private Pattern pattern;

    /**
     * Default Constructor
     */
    public Form() {
	super();
    }

    /**
     * Parameter Constructor
     * 
     * @param firstName
     * @param lastName
     * @param date
     * @param phoneNumber
     */
    public Form(String firstName, String lastName, Date date, String phoneNumber) {
	super();
	this.firstName = firstName.trim();
	this.lastName = lastName.trim();
	this.date = date;
	this.phoneNumber = phoneNumber.trim();
    }

    /**
     * function to get the first name
     * 
     * @return firstName
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * Function to set the first name.
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName.trim();
    }

    /**
     * Function to get the last name.
     * 
     * @return last name
     */
    public String getLastName() {
	return lastName.trim();
    }

    /**
     * Function to set the last name.
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
	this.lastName = lastName.trim();
    }

    /**
     * Function to get the date
     * 
     * @return date
     */
    public Date getDate() {
	return date;
    }

    /**
     * Function to set the date
     * 
     * @param date
     */
    public void setDate(Date date) {
	this.date = date;
    }

    /**
     * Function to get the phone number
     * 
     * @return phoneNumber
     */
    public String getPhoneNumber() {
	return phoneNumber;
    }

    /**
     * Function to set the phone number
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    @Override
    /**
     * String representation 
     * 
     * @return string representation
     */
    public String toString() {
	return firstName + " " + lastName;
    }

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

	return found;
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
