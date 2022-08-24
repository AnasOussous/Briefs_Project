public class employeFixe  extends employe{
	
	public employeFixe(String firstname, String lastname, double salaire,  String strDate) {
		super(firstname, lastname, salaire, strDate);
		
	}


	@Override
	public double calculerSalaire() {
		 return super.getSalaire();
		
		
	}
	public String toString() {
		 return "L'Employes Fixe:"+"\n\t First Name :" + getFirstname() + "\n\t Last Name:" + getLastname() +"\n\t Datebirth:"
					+ strDate+ "\n\t Salaire:" +getSalaire() + "";
	}

	

}
