package snippets;

public class StaticInnerCarParts {
    public static int factoryId =10;
    public static class Wheel {
        public Wheel() {
            System.out.println("Wheel created!"+factoryId);
        }
    }

    public StaticInnerCarParts() {
        System.out.println("Car Parts object created!");
    }
}

 