

import java.text.DateFormat;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  

public class main {
	
	public static void main(String[] args) {
		//EmployCommission empl1 = new EmployCommission("nawan","hhhh",4000.00,"01/01/2000");
		employeFixe emp1 = new employeFixe("nawan","hhhh", 4000.00,"01/01/2000");
		employeCommission emp2 = new employeCommission("anas","oussous",	5000.00,"02/01/2000");
		employeHoraire emp3 = new employeHoraire("latifa","al",	5000.00,"02/07/2000");
		System.out.println("**********************************");
		System.out.println(emp1.toString());
		System.out.println("**********************************");
		System.out.println(emp2.toString());
		System.out.println("**********************************");
		System.out.println(emp3.toString());
		System.out.println("**********************************");
		
		
	
		
	    
	  
	   
		

		
		
		
		
	  
	  
	}

}
