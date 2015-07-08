
import java.util.Date;


public class TestForm extends Form{
	
	
	
	public TestForm(){
		super();

	}
	
	public TestForm(String first,String last){
		super(first,last,new Date(),"none");

	}	
	
	public TestForm(String firstName, String lastName, Date date,
			String phoneNumber) {
		super(firstName,lastName,date,phoneNumber);

	}	
}
