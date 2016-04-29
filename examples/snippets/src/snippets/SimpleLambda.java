package snippets;

public class SimpleLambda {

	public static void main(String[] args) {
		Runner runner = new Runner();
		int d = 9;
		runner.run((int w) ->{
		System.out.println("Hello there."+w+d);
		 return w;
		}
		);
	}

}

interface Executable {
	int ddd(int a);
}


interface Executable2 {
	int eee(String a);
}

class Runner {
	public void run(Executable e) {
		int x = e.ddd(7);
		System.out.println("Return value from lambda"+x);
	}
	
	public void run(Executable2 e) {
		int x = e.eee("d");
		System.out.println("Executable2 Return value from lambda"+x);
	}
}
//https://www.caveofprogramming.com/java/whats-new-in-java-8-lambda-expressions.html