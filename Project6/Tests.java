import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;


public class Tests {
	
	
	@Test
	public void test3() {;
		TestForm curr = new TestForm("John","Doe");
		
		assertEquals(null,curr.getLeft());
		assertEquals(null,curr.getRight());
		TestForm left = new TestForm("Bob", "Bill");
		curr = new TestForm("John","Doe");
		
		curr.add(left);
		assertEquals(left,curr.getLeft());
		assertEquals(null,curr.getRight());		
	}	
	
	
	@Test
	public void test5() {
		TestForm newF = new TestForm("Bob", "Doe");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(newF);
		assertEquals(newF,curr.getLeft());
		assertEquals(null,curr.getRight());
	}	
	
	@Test
	public void test6() {
		TestForm newF = new TestForm("Johnny", "Doe");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(newF);
		assertEquals(null,curr.getLeft());
		assertEquals(newF,curr.getRight());
	}	
	
	@Test
	public void test7() {
		TestForm newF = new TestForm("John","Doe",new Date(), "555-555-5555");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(newF);
		assertEquals(null,curr.getLeft());
		assertEquals("555-555-5555",((TestForm)curr.getRight()).getPhoneNumber());
	}	
	
	@Test
	public void test8() {
		TestForm kid = new TestForm("Bob", "Smith");
		TestForm right = new TestForm("Bob", "Jones");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(kid);
		assertEquals(null,curr.getLeft());		
		assertEquals(null,curr.getRight().getLeft());		
		assertEquals(kid,curr.getRight().getRight());
	}	
	
	@Test
	public void test9() {
		TestForm kid = new TestForm("Bob", "Earl");
		TestForm right = new TestForm("Bob", "Jones");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(kid);
		assertEquals(null,curr.getLeft());		
		assertEquals(kid,curr.getRight().getLeft());		
		assertEquals(null,curr.getRight().getRight());
	}	
	
	@Test
	public void test10() {
		TestForm kid = new TestForm("Bob", "Doe");
		TestForm right = new TestForm("Bob", "Cat");
		TestForm curr = new TestForm("John","Earl");
		
		curr.add(right);
		curr.add(kid);
		assertEquals(null,curr.getRight());		
		assertEquals(null,curr.getLeft().getLeft());		
		assertEquals(kid,curr.getLeft().getRight());
	}	
	
	@Test
	public void test11() {
		TestForm kid = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Cat");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(kid);
		assertEquals(null,curr.getRight());		
		assertEquals(kid,curr.getLeft().getLeft());		
		assertEquals(null,curr.getLeft().getRight());
	}	
	
	@Test
	public void test12() {
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		assertEquals(right,curr.getRight());		
		assertEquals(left,curr.getLeft());		
	}	
	
	@Test
	public void test13() {
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(left);
		curr.add(right);
		assertEquals(right,curr.getRight());		
		assertEquals(left,curr.getLeft());		
	}
	
	@Test
	public void test14() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);		
		assertEquals(kid1,curr.getLeft().getLeft());		
		assertEquals(kid2,curr.getLeft().getRight().getLeft());		
		assertEquals(kid4,curr.getLeft().getRight().getRight());		
		assertEquals(kid5,curr.getRight().getRight());			
	}		

	@Test
	public void test15() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(1,curr.search("Doe",1));			
	}	
	
	@Test
	public void test16() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(2,curr.search("Dog",1));			
	}	
	
	@Test
	public void test17() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(2,curr.search("Apple",1));			
	}	
	
	@Test
	public void test18() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(3,curr.search("E",1));			
	}	
	
	@Test
	public void test19() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(3,curr.search("C",1));			
	}
	
	@Test
	public void test20() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(4,curr.search("D",1));			
	}	
	
	@Test
	public void test21() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(-1,curr.search("X",1));			
	}	
	
	@Test
	public void test22() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(-1,curr.search("Do",1));			
	}	
	
	/***********************************/		

	@Test
	public void test23() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(curr,curr.searchForNode("John"));			
	}	
	
	@Test
	public void test24() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Sam", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(right,curr.searchForNode("Bob"));			
	}	
	
	@Test
	public void test25() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Chris", "Apple");
		TestForm right = new TestForm("Bob", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(left,curr.searchForNode("Chris"));			
	}	
	
	@Test
	public void test26() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bob", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bob", "E");		
		TestForm left = new TestForm("Bob", "Apple");
		TestForm right = new TestForm("David", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(kid5,curr.searchForNode("Bo"));			
	}	
	
	@Test
	public void test27() {
		TestForm kid1 = new TestForm("Bob", "A");
		TestForm kid2 = new TestForm("Bob", "B");
		TestForm kid3 = new TestForm("Bo", "C");	
		TestForm kid4 = new TestForm("Bob", "D");	
		TestForm kid5 = new TestForm("Bo", "E");		
		TestForm left = new TestForm("Bo", "Apple");
		TestForm right = new TestForm("Bo", "Dog");
		TestForm curr = new TestForm("John","Doe");
		
		curr.add(right);
		curr.add(left);
		curr.add(kid3);
		curr.add(kid2);
		curr.add(kid4);
		curr.add(kid5);
		curr.add(kid1);				
		assertEquals(kid4,curr.searchForNode("Bob"));			
	}
		

}