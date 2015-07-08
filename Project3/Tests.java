import static org.junit.Assert.*;

import org.junit.Test;


public class Tests {

	@Test
	public void test2(){
		OrderForm o = new OrderForm();		
		o.clean("KingaDobolyi123-456-7890");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());	
	}
	
	@Test
	public void test12(){
		OrderForm o = new OrderForm();		
		o.clean("Kinga Dobolyi 123 456 78901");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(234) 567-8901",o.getPhoneNumber());
		
		 o = new OrderForm();		
		o.clean(" Kinga  Dobolyi  123 456 7890 ");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}	
	
	@Test
	public void test13(){
		OrderForm o = new OrderForm();		
		o.clean("Kinga Dobolyi 1 2345 67890");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());
		
		 o = new OrderForm();		
		o.clean("xKinga xDobolyi x123x456x7890x");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}	
	
	@Test
	public void test14(){
		OrderForm o = new OrderForm();		
		o.clean("Kinga Dobolyi 123.456.7890");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());
		
		 o = new OrderForm();		
		o.clean("Kinga Laura Dobolyi 123-456-7890");
		assertEquals("Laura",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}	
	
	@Test
	public void test15(){
		OrderForm o = new OrderForm();		
		o.clean("Kinga Dobolyi (123) 456-7890");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());
		
		 o = new OrderForm();		
		o.clean("Kinga Laura David Dobolyi 123-456-7890");
		assertEquals("David",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}	
	
	@Test
	public void test16(){
		OrderForm o = new OrderForm();		
		o.clean("123 456 7890 Kinga Dobolyi");
		assertEquals(null,o.getFirstName());
		assertEquals(null,o.getLastName());
		assertEquals(null,o.getPhoneNumber());
		
		 o = new OrderForm();		
		o.clean("kinga Laura david Dobolyi david 123-456-7890");
		assertEquals("Laura",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}	
	
	
	@Test
	public void test17(){
		OrderForm o = new OrderForm();		
		o.clean("Kinga Dobolyi 1a2b3c45d6e7f8g9h0");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());
		
		 o = new OrderForm();		
		o.clean("Kinga DD Dobolyi 123-456-7890");
		assertEquals("D",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}		
	
	
	@Test
	public void test3a(){
		OrderForm o = new OrderForm();
		assertEquals(0,o.getItems().size());	
		
		 o = new OrderForm();		
		o.clean("QY Kinga Dobolyi XF 123-456-7890");
		assertEquals("X",o.getFirstName());
		assertEquals("F",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}	
	
	@Test
	public void test4a(){
		OrderForm o = new OrderForm();
		Item shirt = new Item(null, 25.56, 2);	
		assertEquals(false,o.addItem(shirt));
		assertEquals(0,o.getItems().size());		

		 o = new OrderForm();		
		o.clean("Kinga Dobolyi 1234567890");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}
	
	@Test
	public void test5a(){
		OrderForm o = new OrderForm();
		Item shirt = new Item(null, 25.56, 2);	
		assertEquals(false,o.addItem(shirt));
		assertEquals(0,o.getItems().size());	
		
		 o = new OrderForm();		
		o.clean("Kinga Dobolyi 123 456 7890");
		assertEquals("Kinga",o.getFirstName());
		assertEquals("Dobolyi",o.getLastName());
		assertEquals("(123) 456-7890",o.getPhoneNumber());		
	}	
	
	@Test
	public void test6a(){
		OrderForm o = new OrderForm();
		Item shirt = new Item("shirt", 25.56, 2);
		o.addItem(shirt);
		assertEquals(1,o.getItems().size());		
	}	
	
	@Test
	public void test7a(){
		Item shirt = new Item("shirt", 25.56, 2);
		assertEquals(true,shirt.isValid());		
	}		
	
	@Test
	public void test8a(){
		Item shirt = new Item("", 25.56, 2);
		assertEquals(false,shirt.isValid());		
	}		
	
	@Test
	public void test9a(){
		Item shirt = new Item("shirt", -1, 2);
		assertEquals(false,shirt.isValid());		
	}		
	
	@Test
	public void test10a(){
		Item shirt = new Item("shirt", 0, 2);
		assertEquals(true,shirt.isValid());		
	}	
	
	@Test
	public void test11a(){
		Item shirt = new Item("shirt", 25.56, 0);
		assertEquals(false,shirt.isValid());		
	}		
		

}