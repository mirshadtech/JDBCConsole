package in.ineuron.main;

import java.util.Scanner;

public class ConsoleApplication {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("*****************************");
		System.out.println("     WELCOME TO CONSOLE");
		System.out.println("*****************************");
		System.out.println("Press 1 for Insert operation");
		System.out.println("Press 2 for Select operation");
		System.out.println("Press 3 for Update operation");
		System.out.println("Press 4 for Delete operation");
		System.out.println("Press 5 for Exit");
		System.out.println("******************************");
		//Note: anything above 5 tell invalid operation
		int n=sc.nextInt();
		switch(n) {
		
		case 1 :
			System.out.println("In case 1");
			InsertApp obj=new InsertApp();
			obj.UpdateStatement();
			
			break;
		case 2 :
			System.out.println("In case 2");
			SelectAppp obj1=new SelectAppp();
			obj1.selectOperation();
			break;
		case 3:
			System.out.println("In case 3");
			UpdateApp obj2=new UpdateApp();
			obj2.updateOperation();
			break;
		case 4:
			System.out.println("In case 4");
			DeleteApp obj3=new DeleteApp();
			obj3.UpdateStatement();
			break;
		case 5:
			System.out.println("In case 5");
			System.out.println("Thank You");
			break;
		default :
			System.out.println("Invalid Operation");
			
		}

	}
}
