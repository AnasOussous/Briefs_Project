import java.util.Scanner;

public class FirstStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Entrer Votre Nom : ");
		String nom = input.next();
		System.out.print("Bonjour " + nom);
		
		System.out.println("\n\tchoisir entre mode de \n\t\t1- payement mensuel \n\t\t2- hebdomadaire");
		
		int mode = input.nextInt();
		switch (mode) {
		case 1:
			System.out.print("Nombre D'heure Travaillee par Semaine : ");
			int HeureTrM = input.nextInt();
			if (HeureTrM > 50) {
				do {
					System.out.println("Vous avez depasser 50 heures par semaine");
					System.out.print("Nombre D'heure Travaillee par Semaine : ");
					int HeureTr2 = input.nextInt();
					HeureTrM = HeureTr2;
				} while (HeureTrM >= 50);
			}
			System.out.print("Votre Tarif Par Heure : ");
			int TarifM = input.nextInt();
			if (TarifM < 25) {
				
				do {
					System.out.print("Le tarif par heure ne doit pas être inferieur a 25 DH par heure");
					System.out.print("\nVotre Tarif Par Heure : ");
					int Tarif2 = input.nextInt();
					TarifM = Tarif2;
				} while (TarifM < 25);
			}
		
			if (40 < HeureTrM && HeureTrM <= 50) {
				int tarifAugmente = TarifM * 50/100;
				int HeureTr1 = HeureTrM - 40 ;
				
				int Ajoute = HeureTr1 * tarifAugmente;
					
				int Ajoute1 = Ajoute + HeureTrM * TarifM;
				System.out.print("\n" + Ajoute1);
				
			}
			
			
			break;
		case 2:
			System.out.print("Nombre D'heure Travaillee par Mois : ");
			int HeureTrH = input.nextInt();
			if (HeureTrH > 200) {
				do {
					System.out.println("Vous avez depasser 200 heures par MOIS");
					System.out.print("Nombre D'heure Travaillee par MOIS : ");
					int HeureTr2 = input.nextInt();
					HeureTrH = HeureTr2;
				} while (HeureTrH >= 200);
			}
			System.out.print("Votre Tarif Par Heure : ");
			int Tarif = input.nextInt();
			if (Tarif < 20) {
				
				do {
					System.out.print("Le tarif par heure ne doit pas être inferieur a 20 DH par heure");
					System.out.print("\nVotre Tarif Par Heure : ");
					int Tarif2 = input.nextInt();
					Tarif = Tarif2;
				} while (Tarif < 20);
			}
		
			if (180 < HeureTrH && HeureTrH <= 200) {
				int tarifAugmente = Tarif * 50/100;
				int HeureTr1 = HeureTrH - 180 ;
				
				int Ajoute = HeureTr1 * tarifAugmente;
					
				int Ajoute1 = Ajoute + HeureTrH * Tarif;
				System.out.print("\n" + Ajoute1);
				
			}
			break;
		}
	}

}
