package snippets;

public class Main {

	public static void main(String[] args) {
		StaticInnerCarParts cp = new StaticInnerCarParts();
		StaticInnerCarParts.Wheel wh = new StaticInnerCarParts.Wheel();

		NonStaticInnerCarParts ncp = new NonStaticInnerCarParts(200);
		NonStaticInnerCarParts.Wheel wncp = ncp.new Wheel();
	}
}