package com.simplilearn.Brief6;

import java.util.List;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		carDao CarDao = new carDaoImp();
		category Category = getCatgory();
		car Car = getCar();
		Scanner input = new Scanner(System.in);
		/**/
		//CarDao.createCar(Car);
		//CarDao.createCategory(Category);
		//getCarById(CarDao, "A31");
		//getCatgById(CarDao, 123);
		//getAllCatgInfo(CarDao);
		//getAllCarInfo(CarDao);
		//CarDao.deleteCarById("A34");
		//CarDao.deleteCatgById(123);
		//CarDao.updateCarPriceById(4.0, "A31");
		//CarDao.updateCatgNameById("DEKAPOTABLE", 123);
		System.out.println("choisir entre \n\t1- Categorie \n\t2- Car");
		int mode = input.nextInt();
		while (mode !=1 && mode !=2 ) {
			System.out.println("YOU HAVE ONE THESE CHOISE 1 OR 2!!!!!");
			System.out.println("choisir entre \n\t1- Categorie \n\t2- Car");
			int mode1 = input.nextInt();
			mode = mode1;
		}
		switch (mode) {
		case 1:
			System.out.println("choisir entre \n\t1- Create Categorie \n\t2- Show All Categorie \n\t3- Show One Categorie "
					+ "\n\t4- Update Name Of Categorie \n\t5- Delete Categorie \n\t0- Exit");
			int CRUD = input.nextInt();
			do {
				switch (CRUD) {
				case 1:
					CarDao.createCategory(Category);
					break;
				case 2:
					getAllCatgInfo(CarDao);
					break;
				case 3:
					System.out.println("Give Me ID Of Category");
					int IdOfCatg = input.nextInt();
					getCatgById(CarDao, IdOfCatg);
					break;
				case 4:
					System.out.println("Give Me ID Of Category");
					int CatgId = input.nextInt();
					System.out.println("Give Me Name Of Category");
					String CatgNameUpd = input.next();
					CarDao.updateCatgNameById(CatgNameUpd, CatgId);
					break;
				case 5:
					System.out.println("Give Me ID Of Category");
					int CatgIddel = input.nextInt();
					CarDao.deleteCatgById(CatgIddel);
					break;
				case 0:
					System.exit(0);
					break;
				}
				
			} while (CRUD == 0);
			
		case 2:

			System.out.println("choisir entre \n\t1- Create Car \n\t2- Show All Cars \n\t3- Show One Car "
					+ "\n\t4- Update Price Of Car \n\t5- Delete Car");
			int CRUD2 = input.nextInt();
			while (CRUD2 !=1 && CRUD2 !=2 && CRUD2 != 3 && CRUD2 != 4 && CRUD2 != 5 ) {
				System.out.println("choisir entre \n\t1- Create Car \n\t2- Show All Cars \n\t3- Show One Car "
						+ "\n\t4- Update Price Of Car \n\t5- Delete Car");
				int CRUD3 = input.nextInt();
				CRUD2 = CRUD3;
			}
			switch (CRUD2) {
			case 1:
				CarDao.createCategory(Category);
				break;
			case 2:
				getAllCarInfo(CarDao);
				break;
			case 3:
				System.out.println("Give Me ID Of Category");
				String IdOfCar = input.next ();
				getCarById(CarDao, IdOfCar);
				break;
			case 4:
				System.out.println("Give Me Matricule");
				String CatgId = input.next();
				System.out.println("Give Me The New Price");
				int CarPriceUpd = input.nextInt();
				CarDao.updateCarPriceById(CarPriceUpd, CatgId);
				break;
			case 5:
				System.out.println("Give Me Matricule");
				String CarIddel = input.next();
				CarDao.deleteCarById(CarIddel);
				break;
			case 0:
				System.out.println("BY BY");
				System.exit(0);
				break;
			}
		
			
		}
	}
	
	private static car getCar() {
		car Car = new car();
		Car.setMatricule("A31");
		Car.setCom_Name("FORD");
		Car.setKilometrage(40000.0);
		Car.setManiFacture("GERMANY");
		Car.setPrice(4000000.0);
		Car.setId_Catg(123);
		return Car;
	}
	
	private static category getCatgory() {
		category Category = new category();
		Category.setId_Catg(124);
		Category.setNom_Catg("ESCENCE");
		return Category;
	}
	
	
	
	private static void getCarById(carDao CarDao, String Matricule) {
		car car2 = CarDao.getCarById(Matricule);
		if(car2 != null){
			System.out.println(car2);
		}else{
			System.out.println("Car does not exist..");
		}
	}
	
	private static void getCatgById(carDao CarDao, int id_catg) {
		category catg2 = CarDao.getCatgById(id_catg);
		if(catg2 != null){
			System.out.println(catg2);
		}else{
			System.out.println("Category does not exist..");
		}
	}
	
	private static void getAllCatgInfo (carDao CarDao) {
		List<category> CatgList = CarDao.getAllCatgInfo();
		for (category Category : CatgList) {
			System.out.println(Category);
		}
	}
	
	private static void getAllCarInfo (carDao CarDao) {
		List<car> CarList = CarDao.getAllCarInfo();
		for (car Car : CarList) {
			System.out.println(Car);
		}
	}
	
	
}



