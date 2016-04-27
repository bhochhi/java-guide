package snippets;

public class NonStaticInnerCarParts {
	private int id;

	public static int factoryId = 22;

	public class Wheel {
		public Wheel() {
			System.out.println("Wheel created!" + factoryId);
		}
	}

	public NonStaticInnerCarParts(int id) {
		this.id = id;
		System.out.println("Car Parts object created! non static");
	}
}
