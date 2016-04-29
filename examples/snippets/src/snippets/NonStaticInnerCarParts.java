package snippets;

public class NonStaticInnerCarParts {
	private int id;

	public static int factoryId = 22;

	public class Wheel {
		public Wheel() {
			
			System.out.println("Wheel created!" + factoryId+Wheel.class.getClassLoader());
		}
	}

	public NonStaticInnerCarParts(int id) {
		this.id = id;
		System.out.println("Car Parts object created! non static");
	}
}
