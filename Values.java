import java.util.Scanner;

//Public interface to be used to obtain values used in program
public interface Values {
	int getElement();
	double getValue();
}

//Class that implements the interface.
class Value implements Values {
	int elements;
	double data;
	//This method would be used to get user input for the number of employees.
	public int getElement() {
		Scanner scan = new Scanner(System.in);
		elements = scan.nextInt();
		return elements;
	}
	//This method is used to obtain hours and hourly wage of employees.
	public double getValue() {
		Scanner scan = new Scanner(System.in);
		data = scan.nextDouble();
		return data;
	}
}
//This class would be used to obtain commands from the user to search or print out payroll info
class Input {
	String input;

	public String getCommand() {
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		return input;
	}
}
	
class payrollCalc {
	public static void main(String args[]) 
		throws java.io.IOException {
			Value arr = new Value();
			Input names = new Input();
			
			System.out.print("Enter the number of people on the payroll: ");

			int arrayElem = arr.getElement();
			
			String[] name = new String[arrayElem];			//An array containing the names with elements specified by user
			double[][] hoursWages = new double [arrayElem][2];	//2-d array containing user hours and wages

			//For loop used to obtain all the names of employees
			for(int i = 0; i < arrayElem; i++) {
				System.out.print("\nEnter the name of the employee " + (i+1) + ": ");

				name[i] = names.getCommand();			
			}

			for(int i = 0; i < arrayElem; i++) {
				System.out.print("\nEnter the hours of the employee " + (i+1) + ": ");
				//nested for loop to ensure that the hourly wages would be put in the second array element it belongs in
				for(int p = 0; p < 2; p++) {
					if(p == 1)System.out.print("\nEnter the hourly wage of employee " + (i+1) + ": ");
					
					hoursWages[i][p] = arr.getValue();
				}		
			}
		
			Input in = new Input();
			Input se = new Input();
			Boolean Exit = false;	//initialization of exit to ensure the program will continue to run
			
			while(Exit == false) {

				System.out.print("\nEnter search to lookup a specific employee payrol or print to print out the full payroll report and exit the program: ");
			
				switch(in.getCommand()) {
					case "search":
						System.out.print("\nEnter the full name of the employee you wish to search for: ");
						//User to input who to search for
						String searResult = se.getCommand();					
						System.out.println("Employee Name\t\t\tHours Worked\tHourly Wages\tGross Pay");
						//For loop to run and compare the input with what is stored in the array to display payroll specific data
						for(int i = 0; i < arrayElem; i++) 
							//Compare string entered to string in array to find apropriate employee
							if(name[i].equals(searResult)) System.out.println(name[i] + "\t\t\t" + hoursWages[i][0] + "\t\t" + hoursWages[i][1] + "\t\t" + hoursWages[i][0]*hoursWages[i][1] + "\t");
						break;
				
					case "print":
						System.out.println("Employee Name\t\t\tHours Worked\tHourly Wages\tGross Pay");
						for(int i = 0; i < arrayElem; i++) 
							System.out.println(name[i] + "\t\t\t" + hoursWages[i][0] + "\t\t" + hoursWages[i][1] + "\t\t" + hoursWages[i][0]*hoursWages[i][1] + "\t");
						//To make the logic statement in while loop to become false and exit the loop
						Exit = true;
						break;

					default:
						System.out.println("Invalid Response, please try again.");		
				}
			}
		}
}	