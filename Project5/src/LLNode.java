class LLNode implements Node{
	Node next;
	Node prev;
	Comparable data;

	public LLNode(Comparable arg)
	{
		next = null;
		prev = null;
		data = arg;
	}

	public Comparable getData()
	{
		return data;
	}
	
	public Node add(Node thing)
	{
		Node curr = this;
		while(curr.getPrev() != null && curr.getData().compareTo(thing.getData()) > 0)
		{
			curr = curr.getPrev();
		}
		while(curr.getNext() != null && curr.getData().compareTo(thing.getData()) < 0)
		{
			curr = curr.getNext();
		}
		if(curr.getPrev() == null && curr.getData().compareTo(thing.getData()) > 0)
		{
			curr.setPrev(thing);
			thing.setNext(curr);
		}
		else if(curr.getNext() == null && curr.getData().compareTo(thing.getData()) < 0)
		{
			curr.setNext(thing);
			thing.setPrev(curr);
		}
		else
		{
			thing.setPrev(curr.getPrev());
			Node prev = curr.getPrev();
			if(prev != null)
				prev.setNext(thing);
			thing.setNext(curr);
			curr.setPrev(thing);
		}
		while(curr.getPrev() != null)
			curr = curr.getPrev();
		return curr;
	}
		
	public Node search(Comparable item)
	{
		Node curr = this;

		while(curr != null && curr.getData().compareTo(item) > 0)
		{
			curr = curr.getPrev();
		}
		while(curr != null && curr.getData().compareTo(item) < 0)
		{
			curr = curr.getNext();
		}
		if(curr != null && curr.getData().compareTo(item) == 0)
			return curr;
		return null;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public void setPrev(Node prev)
	{
		this.prev = prev;
	}

	public Node getNext()
	{
		return next;
	}

	public Node getPrev()
	{
		return prev;
	}
}
/* 
 * My partner for this project was James Choi from your class CS211-001
 * 
 * 
 * Q1. Why is the sorted ArrayList slower to add to than the Linked List?
 * 
	Sorted ArrayList has to move all the unsorted elements, where in LinkedList you don't have to move anything.

 * Q2. I thought we said that arrays are slow. Why is add so quick for the unsorted array? 
 * What kind of search is the sorted array using? Is it the same as the others?
 * 
	Unsorted array simply adds to the end so it's fast. Sorted array uses mergesort.

 * Q3. Are your numbers identical to mine? (Hint: even my numbers are not identical). 
 * Why is this? What is being measured in terms of time?
 * 
	No, the numbers aren't the same. They depend on a lot of things, like Java version, computer hardware, ... 
	The time elapsed from the first add to the last add or the time needed to search for the element.

 * Q4. Is the Person object always being added into the same place for all the lists? 
 * Does this matter for the timing?
 * 
	No, the Persons are random so they go in different parts of the lists. It does matter for the timing.

 * Q5. How could you improve the search time for the linked list, based on what you know about how the sorted array is searched? 
 * (You don't have to implement this, just discuss what you could do)
 * 
	We could add shortcuts, that is additional pointers that skip some elements.

 * */
