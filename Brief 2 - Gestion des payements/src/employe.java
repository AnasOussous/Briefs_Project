
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public   abstract class employe {
	private String Firstname;
	private String Lastname;
    private double salaire;
	Date Datebirth = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
    String strDate = formatter.format(Datebirth);
	
	public employe(String firstname, String lastname,double salaire ,String strDate) {
		super();
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.salaire= salaire;
		this.strDate = strDate;
		
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Date getDatebirth() {
		return Datebirth;
	}

	public void setstrDate(String strDate) {
		this.strDate = strDate;
	}
	
	



	@Override
	public String toString() {
		return "Employes [First Name :" + Firstname + ", Last Name:" + Lastname + ", Salaire:" + salaire + ", Datebirth:"
				+ strDate + "]";
	}

	public  abstract double calculerSalaire();
	
	
	
	
	



}
