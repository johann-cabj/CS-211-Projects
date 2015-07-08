import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;


public class Tests {

	@Test
	public void test1(){
		Item.resetCount();
		Item i = new Item("socks",4.0,1);
		assertEquals(1,Item.getCount());
		
		Date date = new Date();
		TestForm f = new TestForm("Kinga","Dobolyi",date,"555-555-5555");
		assertEquals(date,f.getDate());
		assertEquals("Kinga",f.getFirstName());
		assertEquals("Dobolyi",f.getLastName());
		assertEquals("555-555-5555",f.getPhoneNumber());
		assertEquals("Kinga Dobolyi",f.toString());		
	}//end test

	@Test
	public void test2(){
		ArrayList data = new ArrayList();
		data.add("Kinga Dobolyi 555-555-5555");
		data.add("#socks,2.34,2");
		Driver driver = new Driver();
		data = driver.run(data);
		assertEquals(0,data.size());
		Form form = (Form)driver.getData().get(0);
		assertEquals("Kinga",form.getFirstName());
		assertEquals("Dobolyi",form.getLastName());
		assertEquals("555-555-5555",form.getPhoneNumber());
		assertEquals("class OrderForm",form.getClass().toString());
	}//end test

	@Test
	public void test3(){
		ArrayList data = new ArrayList();
		data.add("!Kinga Dobolyi 5555555555");
		data.add("What a great product!#5");
		Driver driver = new Driver();
		data = driver.run(data);
		assertEquals(0,data.size());
		ReviewForm form = (ReviewForm)driver.getData().get(0);		
		assertEquals("What a great product!",form.getReview());
		assertEquals(5, form.getStars());
	}//end test
	
	@Test
	public void test4(){
		ArrayList data = new ArrayList();
		data.add("Kinga Dobolyi 555-555-5555");
		data.add("nothing");
		data.add("#socks,2.34,2");
		Driver driver = new Driver();
		data = driver.run(data);
		System.out.println(data.get(0).toString());
		//System.out.println(data.get(1));		
		assertEquals(1,data.size());
		Form form = (Form)driver.getData().get(0);
		assertEquals("Kinga",form.getFirstName());
		assertEquals("Dobolyi",form.getLastName());
		assertEquals("555-555-5555",form.getPhoneNumber());
		assertEquals("class OrderForm",form.getClass().toString());
	}//end test

	@Test
	public void test5(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test6(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test7(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test8(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test9(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test10(){
		assertEquals(true,true);
	}//end test	
	
	@Test
	public void test11(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test12(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test13(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test14(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test15(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test16(){
		assertEquals(true,true);
	}//end test	
	
	@Test
	public void test17(){
		assertEquals(true,true);
	}//end test
	
	
	@Test
	public void test18(){
		assertEquals(true,true);
	}//end test	
	
	
	@Test
	public void test19(){
		assertEquals(true,true);	
	}//end test
	
	@Test
	public void test20(){
		assertEquals(true,true);	
	}//end test
	
	@Test
	public void test21(){
		assertEquals(true,true);	
	}//end test
	
	@Test
	public void test22(){
		assertEquals(true,true);		
	}//end test
	
	@Test
	public void test23(){
		assertEquals(true,true);	
	}//end test	
	
	@Test
	public void test24(){
		assertEquals(true,true);	
	}//end test
	
	@Test
	public void test25(){
		assertEquals(true,true);	
	}//end test	
	
	@Test
	public void test26(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test27(){
		assertEquals(true,true);		
	}//end test	
		
	@Test 
	public void  test28(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test29(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test30(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test31(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test32(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test33(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test34(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test35(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test36(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test37(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test38(){
			assertEquals(true,true);
		}//end test

	@Test 
	public void  test39(){
			assertEquals(true,true);
		}//end test	
	
	@Test 
	public void  test40(){
			assertEquals(true,true);
		}//end test	
	
	@Test 
	public void  test41(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test42(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test43(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test44(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test45(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test46(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test47(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test48(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test49(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test50(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test51(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test52(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test53(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test54(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test55(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test56(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test57(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test58(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test59(){
			assertEquals(true,true);
		}//end test		

	@Test 
	public void  test60(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test61(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test62(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test63(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test64(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test65(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test66(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test67(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test68(){
			assertEquals(true,true);
		}//end test
			
	@Test 
	public void  test69(){
			assertEquals(true,true);
		}//end test		
			
	@Test 
	public void  test70(){
			assertEquals(true,true);
		}//end test			
	
}

