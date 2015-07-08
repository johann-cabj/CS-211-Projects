import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Random;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class NodeTest {
	
	static Random r = new Random(123456789);
	
	public static void main(String args[])
	{
		
		Result result = JUnitCore.runClasses(NodeTest.class);
		for(Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}
	}
	
	
	@Test
	public void testSearch()
	{
		LLNode node = new LLNode(new Person("15", 3));
		for(int i=0; i < 15; i++)
			node.add(new LLNode(new Person(r.nextInt() + "", 0)));
		LLNode first = (LLNode) node.add(new LLNode(new Person(r.nextInt() + "", 0)));
		Assert.assertEquals("Search:", node, first.search(node.getData()));
	}
	
	@Test
	public void testBeforeFirst()
	{
		LLNode node = new LLNode(new Person("3", 3));
		LLNode first = new LLNode(new Person("2", 2));
		node.add(first);
		assertEquals("Adding before first:", first, node.search(first.getData()));
	}
	
	@Test
	public void testAfterLast()
	{
		LLNode node = new LLNode(new Person("3", 3));
		LLNode last = new LLNode(new Person("55", 2));
		node.add(last);
		assertEquals("Adding after last:", last, node.search(last.getData()));
	}
	@Test
	public void test1(){
		
		String[] ids = {"0","1","2","3","4","5","6","7","8","9"};
		Person per0 = new Person(ids[0],10);
		Person per1 = new Person(ids[0],10);
		Person per2 = new Person(ids[2],10);
		Person per3 = new Person(ids[3],10);
		Person per4 = new Person(ids[3],10);
		Node start = new LLNode(per0);
		Node node1 = new LLNode(per1);
		Node node2 = new LLNode(per2);
		Node node3 = new LLNode(per3);
		start.add(node1);
		start.add(node2);
		start.add(node3);
		assertEquals(start.search(per0),start);
		
		
	}
	
	@Test
	public void test2() {
		String[] ids = {"0","1","2","3","4","5","6","7","8","9"};
		Person per0 = new Person(ids[0],10);
		Person per1 = new Person(ids[1],10);
		Node node1 = new LLNode(per0);
		Node node2 = new LLNode(per1);
		Node start=node1;
		start = start.add(node2);
		Node ans = start.search(per0);
		assertEquals(ans,node1);
		ans = start.search(per1);
		assertEquals(ans,node2);
	}
	
	@Test
	public void test3() {
		
		String[] ids = {"0","1","2","3","4","5","6","7","8","9"};
		Person per0 = new Person(ids[0],10);
		Person per1 = new Person(ids[1],10);
		Person per2 = new Person(ids[2],10);
		Node start = new LLNode(per0);
		Node node1 = new LLNode(per1);
		
		start.setNext(node1);
		assertEquals(start.getNext(),node1);
		node1.setPrev(start);
		assertEquals(node1.getPrev(),start);
		
		
	}
	
	@Test
	public void test4() {
		String[] ids = {"0","1","2","3","4","5","6","7","8","9"};
		Node start = new LLNode(new Person(ids[0],10));
		Person per1 = new Person(ids[1],10);
		Person per2 = new Person(ids[2],10);
		Person per3 = new Person(ids[3],10);
		Person per4 = new Person(ids[4],10);
		Person per5 = new Person(ids[5],10);
		Person per6 = new Person(ids[6],10);
		Person per7 = new Person(ids[7],10);
		Person per8 = new Person(ids[8],10);
		Person per9 = new Person(ids[9],10);
		Node n1 = new LLNode(per1);
		Node n2 = new LLNode(per2);
		Node n3 = new LLNode(per3);
		Node n4 = new LLNode(per4);
		Node n5 = new LLNode(per5);
		Node n6 = new LLNode(per6);
		Node n7 = new LLNode(per7);
		Node n8 = new LLNode(per8);
		Node n9 = new LLNode(per9);
		
		start.add(n3);
		start.add(n2);
		start.add(n5);
		start.add(n1);
		start.add(n4);
		start.add(n6);
		start.add(n7);
		start.add(n8);
		start.add(n9);
		System.out.println(per1.compareTo(per3));
		System.out.println(n3.getPrev().getData());
		assertEquals(n1.getNext().getData(),"2");
		assertEquals(n3.getPrev().getData(),"2");
		assertEquals(n4.getNext(),n5);
		assertEquals(n2.getNext(),n3);
		assertEquals(n9.getPrev(),n8);
		assertEquals(n9.getPrev(),n8);
		assertEquals(n9.getPrev(),n8);
		assertEquals(n9.getPrev(),n8);
		assertEquals(n7.getPrev(),n6);
	}
	
	@Test
	public void test5() {
		String[] ids = {"0","1","2","3","4","5","6","7","8","9"};
		Person per0 = new Person(ids[0],10);
		Person per1 = new Person(ids[1],10);
		Person per2 = new Person(ids[2],10);
		Node start = new LLNode(per0);
		Node node1 = new LLNode(per1);
		Node node2 = new LLNode(per2);
		start.add(node1);
		start.add(node2);
		assertEquals(start.search(per1),node1);
		assertEquals(start.search(per2),node2);
		assertEquals(start.search(per1),node1);
	}
	
	@Test
	public void test6() {
		
		String[] ids = {"1","6","2","3","0","7","8","4","5","9"};

		Node start = new LLNode(new Person(ids[0],10));
		for(int i=1; i<ids.length;i++) {
		start=start.add(new LLNode(new Person(ids[i],10)));
		}
		assertEquals(start.getData(),new Person("0",10));
		assertEquals(start.getNext().getData(),new Person("1",10));
	}
	
	@Test
	public void test7() {
		String[] ids = {"0","1","2","3","4","5","6","7","8","9"};
		Person per0 = new Person(ids[0],10);
		Person per1 = new Person(ids[1],10);
		Person per2 = new Person(ids[2],10);
		Person per3 = new Person(ids[3],10);
		Node start = new LLNode(per0);
		Node node1 = new LLNode(per1);
		Node node2 = new LLNode(per2);
		start.add(node1);
		start.add(node2);
		assertEquals(start.search(per3),null);
		assertEquals(start.search(per0),start);
	}
	
	@Test
	public void test8() {
		String[] ids = {"w","x","y","z","4","5","6","7","8","9"};
		Person per0 = new Person(ids[0],10);
		Person per1 = new Person("y",5);
		Person per2 = new Person(ids[1],10);
		Person per3 = new Person("z",8);
		LLNode node1 = new LLNode(per0);
		Node start=node1;
		LLNode node2 = new LLNode(per1);
		start=start.add(node2);
		LLNode node3 = new LLNode(per2);
		start = start.add(node3);
		assertEquals(node1.getData(),per0);
		assertEquals(node2.getData(),per1);	
		assertEquals(node3.getData(),per2);
	}
}
