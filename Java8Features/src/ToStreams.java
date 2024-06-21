import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Prd{
	int id;
	String name;
	float price;
	public Prd(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.id + " | " + this.name + " | " + this.price;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Prd) {
			Prd p = (Prd) obj;
			if (this.id == p.id) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}

	public class ToStreams {
		public static void main(String[] args) {
			List<Prd> productlist = new ArrayList<Prd>();
			for (int i=1;i<=3; i++) {
				productlist.add(new Prd(10,"Mouse",34567.67f));
			}
			productlist.add(new Prd(20,"Keyboard",46455.67f));
			System.out.println(productlist);

			Set<Prd> prdset = productlist.stream()
					.collect(Collectors.toSet());
			System.out.println(prdset);
			
			// Map
			
			Map<Integer, String> prodmap = prdset.stream()
											.collect(Collectors.toMap(p->p.id, p->p.name));
			Iterator<Entry<Integer,String>>map_itr = prodmap.entrySet().iterator();
			while(map_itr.hasNext()) {
				Entry<Integer, String> ent = map_itr.next();
				System.out.println(ent.getKey() + " | "+ ent.getValue());
			}
			
		}
	}
