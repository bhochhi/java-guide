package snippets;

import java.util.ArrayList;
/**
 * playing with final and static
 * @author bhochhi
 *
 */
public class StaticFinal {

	private final  ArrayList list;// = new ArrayList<>();;
//	private static final  ArrayList list;
	
	public StaticFinal(){
		list = new ArrayList<>();
		list.add("hello");
	}
	
	public static void main(String[] args) {
		StaticFinal cls = new StaticFinal();
//		cls.list = new ArrayList<>();
		StaticFinal cl = new StaticFinal();
		cl.list.add("hiii");
		cls.list.add("Worlds");
		System.out.println("print "+cls.list+cl.list);
	}
}
