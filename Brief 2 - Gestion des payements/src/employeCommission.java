public class employeCommission  extends employe{
	 private int quantite_Vendeur=300;
	 private double commission_Vendeur=0.3;
	
	
	public employeCommission(String firstname, String lastname, double salaire, String strDate) {
		super(firstname, lastname, salaire, strDate);
		this.quantite_Vendeur=quantite_Vendeur;
	}
	


	@Override
	public double calculerSalaire() {	
		
	return super.getSalaire()+(quantite_Vendeur*commission_Vendeur);
		  
	}
	public String toString() {
		return "L'Employes Commission:"+"\n\t First Name :" + getFirstname() + "\n\t Last Name:" + getLastname() +
				"\n\t Datebirth:" + strDate+ "\n\t Salaire:" + calculerSalaire()+ "";
	}
	
	
	

}
