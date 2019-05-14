package Lab11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Superlative{
	private float a;
	private float b;
	public Superlative(float a, float b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public Superlative() {
		super();
	}

	public float getA() {
		return a;
	}
	public void setA(float a) {
		this.a = a;
	}
	public float getB() {
		return b;
	}
	public void setB(float b) {
		this.b = b;
	}
	
}
class Quadratic {
	private float a;
	private float b;
	private float c;
	public Quadratic(float a, float b, float c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Quadratic() {
		super();
	}

	public float getA() {
		return a;
	}
	public void setA(float a) {
		this.a = a;
	}
	public float getB() {
		return b;
	}
	public void setB(float b) {
		this.b = b;
	}
	public float getC() {
		return c;
	}
	public void setC(float c) {
		this.c = c;
	}
	
}
public class RunEquationProgram {

	private static Scanner input=new Scanner(System.in);
	private static int choose=0;
	public static void main(String[] args) {
		while(true) {
			try {
				System.out.println("============ Equation Program ===============");
				System.out.println("1.Calculate superlative equation");
				System.out.println("2.Calculate quadratic equation");
				System.out.println("3.Exit");
				choose = Integer.parseInt(input.nextLine());

			} catch (Exception e) {
				System.out.println("Please enter number @@!");
			}

			switch (choose) {
			case 1:
				calculateSuperlative();
				break;
			case 2:
				calculateQuadraticEquation();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				break;
			}

		}

	}
	private static void calculateQuadraticEquation() {
		System.out.println("Please enter coefficient for Quadratic Equation!");
		
		
	}
	private static void calculateSuperlative() {
		ArrayList<Float> listFloat=new ArrayList<Float>();
		Float a=0f,b=0f;
		//input
		while(true) {
			try {
				System.out.println("Please enter coefficient for Superlative Equation!");
				System.out.println("Enter a coefficient:");
				a=input.nextFloat();
				System.out.println("Enter b coefficient:");
				b=input.nextFloat();
				break;
			} catch (Exception e) {
				System.out.println("Enter number please!");
			}
		}
		listFloat.add(a);listFloat.add(b);
		System.out.print("The odd number:");
		for(float x: listFloat) {
			if(isOdd(x)) {
				System.out.println(x+" ");
			}
		}
		System.out.print("The even number:");
		for(float x: listFloat) {
			if(!isOdd(x)) {
				System.out.println(x+" ");
			}
		}
		System.out.print("The perfect square number:");
		for(Float x: listFloat) {
			if(!isPerfectSquare(x)) {
				System.out.println(x+" ");
			}
		}
		//calculate
		System.out.println("The solution:"+calculateEquation(a, b));

		
	}
	private static boolean isPerfectSquare(float a) {
		
		float temp=(float) Math.sqrt(a);
		if (temp*temp==a) {
		    return true;
		} else return false;
		
	}
	private static boolean isOdd(float a) {
		if(a%2 != 0)return true;
		else return false;
		
	}
	private static List<Float> calculateEquation(float a, float b) {
		List<Float> result=new LinkedList<Float>();
		if(a==0){
			if(b==0) {
				return null;
			}else {
				return null;
			}
		}else {
			result.add((-b/a));
		}
		return result;
	}

}
