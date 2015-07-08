
public interface Node{
	public void add(Node node);
		
	public int search(String id, int level);
	
	public Node getLeft();

	public Node getRight();

	public String getId();

	public Node searchForNode(String id);
	
}