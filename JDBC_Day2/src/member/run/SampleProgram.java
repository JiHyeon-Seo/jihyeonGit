package member.run;

class SuperClass{
	void paint() {
		draw();
	}
	void draw() {
		System.out.println("Super Object");
	}
}

class SubClass extends SuperClass{
	void paint() {
		super.paint();
		super.draw();
	}
	void draw() {
		System.out.println("Sub Object");
	}
}

public class SampleProgram {
	public static void main(String[] args) {
		SuperClass ex = new SubClass();
		//SuperClass ex1 = new SuperClass();
		//((SubClass)ex).draw();
		//ex.draw();
		
		ex.paint();
		
		//ex1.paint();
		//ex1.draw();
	}

}
