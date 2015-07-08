import java.util.ArrayList;

public class Driver {

    private ArrayList data;

    public Driver() {
	this.data = new ArrayList();
    }

    public ArrayList getData() {
	return data;
    }

    public void setData(ArrayList data) {
	this.data = data;
    }

    public ArrayList run(ArrayList data) {
	ArrayList un = new ArrayList();

	OrderForm frm = new OrderForm();
	int i = 0;
	frm = new OrderForm();

	ReviewForm f = null;
	String s = (String) data.get(0);
	i = 0;
	while (i < data.size()) {

	    if (!s.startsWith("!") && frm.process(s)) {

		this.data.add(frm);
		// process items
		while (true) {
		    i++;
		    if (i == data.size())
			break;
		    String ss = (String) data.get(i);

		    if (ss.startsWith("#")) // item
		    {
			String[] vals = ss.split(",");
			if (vals.length == 3) {
			    Item item = new Item(vals[0].substring(1),
				    Double.parseDouble(vals[1]),
				    Integer.parseInt(vals[2]));
			    frm.addItem(item);
			} else {
			    // invalid
			    un.add(ss);
			}
		    } else if (ss.startsWith("!")) // review
		    {
			String sss = ss.substring(1);
			f = new ReviewForm();
			if (f.process(sss)) {
			    this.data.add(f);
			} else
			    un.add(ss);
		    } else {
			OrderForm ff = new OrderForm();
			if (ff.process(ss)) {
			    frm = new OrderForm();
			    frm.process(ss);
			    this.data.add(frm);
			    s = ss;
			} else {
			    if (ss.contains(",#")) //
			    {
				String vals[] = ss.split(",");

				if (f != null) {
				    f.setReview(vals[0] + ",");
				    f.setStars(Integer.parseInt(vals[1]
					    .substring(1)));
				}
			    } else
				un.add(ss); // invalid
			}
		    }
		}
	    }

	    else if (s.startsWith("!")) // review
	    {
		String sss = s.substring(1);
		f = new ReviewForm();
		if (f.process(sss)) {
		    this.data.add(f);
		    while (true && i < data.size()) {
			i++;
			if (i >= data.size())
			    break;
			sss = (String) data.get(i);
			if (sss.contains("#")) {
			    String vals[] = sss.split("#");
			    if (f != null) {
				f.setReview(vals[0]);
				f.setStars(Integer.parseInt(vals[1]));
			    }
			}
		    }
		} else
		    un.add(s);
	    } else if (s.contains("#")) //
	    {
		String vals[] = s.split("#");
		if (f != null) {
		    f.setReview(vals[0]);
		    f.setStars(Integer.parseInt(vals[1]));
		}
	    } else // invalid entry
	    {
		un.add(s);
	    }
	}

	return un;
    }

}
