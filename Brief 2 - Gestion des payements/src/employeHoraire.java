

public class employeHoraire  extends employe {
	private int  nombreHeure=24;
	private double tauxHoraire=50;

	public employeHoraire(String firstname, String lastname, double salaire, String strDate) {
		super(firstname, lastname, salaire, strDate);
		
	}

	@Override
	public double calculerSalaire() {
		
		return (nombreHeure*tauxHoraire);
	}
	public String toString() {
		 return "L'Employes D'Horaire:"+"\n\t First Name :" + getFirstname() + "\n\t Last Name:" + getLastname() + "\n\t Datebirth:"
					+ strDate + "\n\t Salaire:" + calculerSalaire()+ "";
	}
	

}
