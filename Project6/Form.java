import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Form implements Node
{
	String lastname;
	String firstname;
	Date date;
	String phoneNumber;

	Node left;
	Node right;

	public Form()
	{
		super();
		/*lastname = "";
		firstname = "";
		date = new Date();
		phoneNumber = "none";*/
	}

	public Form(String firstname, String lastname, Date date, String phoneNumber)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
		this.phoneNumber = phoneNumber;
	}
	
	

	@Override
	public void add(Node node)
	{
		if(getId().compareTo(node.getId()) > 0)
		{
			if(left == null)
			{
				left = node;
			}
			else
			{
				left.add(node);
			}
		}
		else if(getId().compareTo(node.getId()) <= 0)
		{
			if(right == null)
			{
				right = node;
			}
			else
			{
				right.add(node);
			}
		}
	}
		
	@Override
	public int search(String id, int level)
	{
		if(lastname.compareTo(id) == 0)
		{
			return level;
		}
		else if(left != null && getId().compareTo(id) > 0)
		{
			return left.search(id, level+1);
		}
		else if(right != null && getId().compareTo(id) < 0)
		{
			return right.search(id, level+1);
		}
		else
		{
			return -1;
		}
	}
	
	@Override
	public Node getLeft()
	{
		return left;
	}	

	@Override
	public Node getRight()
	{
		return right;
	}

	@Override
	public String getId()
	{
		return lastname + "," + firstname;
	}

	@Override
	public Node searchForNode(String id)
	{
		if(getId().contains(id))
		{
			return this;
		}
		Node ret = null;
		if(right != null && (ret = right.searchForNode(id)) != null)
		{
			return ret;
		}
		if(left != null && (ret = left.searchForNode(id)) != null)
		{
			return ret;
		}
		return null;
	}
	public String getFirstName(){
		return firstname;
	}
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	public String getLastName(){
		return lastname;
	}
	public void setLastName(String lastname){
		this.lastname = lastname;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber; 
	}
	public String toString(){
		return getFirstName() + " " + getLastName();
	}
	
}