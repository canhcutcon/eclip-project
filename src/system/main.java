package system;

import java.util.Scanner;

import Support.Input;

public class main {
	public static void titleTrainLoadList() {
		System.out.printf("|%-10s|%-20s|%-10s|%-10s|%-10s|%-10s|", "Train ID", "Train Name", "Seat", "Booked",
				"Depart Time", "Depart Place");
		System.out.println();
	}

	public static void titleTrainList() {
		System.out.printf("|%-10s|%-20s|%-10s|%-10s|%-10s|%-10s|%-10s|", "Train ID", "Train Name", "Seat", "Booked",
				"Depart Time", "Depart Place", "Available seat");
		System.out.println();
	}

	public static void titleCustomerList() {
		System.out.printf("|%-10s|%-10s|%-10s|", "Custumer ID", "Custumer Name", "Custmer Phone");
		System.out.println();
	}

	public static void titleBookingList() {
		System.out.printf("|%-10s|%-10s|%-10s|", "Train ID", "Custumer ID", "Seat");
		System.out.println();
	}

	public static void displayListBooking(BookingList lstBook) {
		titleBookingList();
		lstBook.displayList();
	}

	public static int menuYesNo() {
		while (true) {
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choose;

			do {
				System.out.println("Enter your choose:");
				choose = Input.chechNumber();
			} while (choose < 0 || choose > 2);
			switch (choose) {
			case 1:
				return 1; // yes
			case 2:
				return 0; // no
			default:
				System.out.println("Unknow choose!!");
				break;
			}

		}
	}

	// ===============Train================
	public static void inputTrain(TrainList lstTrain) {
		int number;
		do {
			System.out.println("Enter your number Train you wanna add: ");
			number = Input.chechNumber();
		} while (number < 0);
		for (int i = 0; i < number; i++) {
			System.out.println("Enter " + (i + 1) + "Train");
			Train a = lstTrain.inputOneTrain();
			lstTrain.add(a);
		}
		System.out.println("Add success!!");
	}

	public static void searchTrainID(TrainList lstTrain) {
		String trainID;
		do {
			trainID = lstTrain.inputTrainID();
		} while (trainID == null);
		Train train = lstTrain.searchID(trainID);
		if (train == null) {
			System.out.println("Train not found!!");
			return;
		}
		System.out.println(train.toString());
	}

	public static void addAfterPositionK(TrainList lstTrain) {
		String trainID;
		int index;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter train you wanna add:");
		Train a = lstTrain.inputOneTrain();

		do {
			System.out.println("Enter your position K : ");
			index = Input.chechNumber();
		} while (index < 0);

		lstTrain.addAfterPositionK(a, index);
		System.out.println("Add sucess!");
	}

	public static void deleteTrainId(TrainList lstTrain) throws Exception {
		String tcode;
		do {
			System.out.println("Enter tcode you want to delete:");
			tcode = lstTrain.inputTrainID();
		} while (tcode == null);
		Train train = lstTrain.searchID(tcode);
		if (train != null) {
			System.out.println("Do you want delete it?");
			int choose = menuYesNo();
			if (choose == 1) {
				lstTrain.delete(train);
				System.out.println("Delete success!");
			} else {
				System.out.println("Delete fail!");
			}
		}
	}

	public static void deleteTrainBefore(TrainList lstTrain) throws Exception {
		String tcode;
		do {
			System.out.println("Enter tcode you want to delete:");
			tcode = lstTrain.inputTrainID();
		} while (tcode == null);
		Train train = lstTrain.searchID(tcode);
		if (train != null) {
			System.out.println("Do you want delete it?");
			int choose = menuYesNo();
			if (choose == 1) {
				lstTrain.deleteNodeBefore(train);
				System.out.println("Delete success!");
			} else {
				System.out.println("Delete fail!");
			}
		}
	}

	// ===============Custumer================
	public static void inputCus(CustumerList lstCus) {
		int number;
		do {
			System.out.println("Enter your number Custumer you wanna add: ");
			number = Input.chechNumber();
		} while (number < 0);

		for (int i = 0; i < number; i++) {
			System.out.println("Enter" + (i + 1) + "Custumer");
			lstCus.inputOnCus();
		}
	}

	public static void searchCusID(CustumerList lstCus) {
		String cusID;
		cusID = lstCus.inputCusID();
		while (cusID == null) {
			cusID = lstCus.inputCusID();
		}
		Custumer cus = lstCus.searchID(cusID);
		if (cus == null) {
			System.out.println("Train not found!!");
			return;
		}
		System.out.println(cus.toString());
	}

	public static void deleteCustomerByTCode(CustumerList lstCus) throws Exception {
		String tcode;
		do {
			System.out.println("Enter tcode you want to delete:");
			tcode = lstCus.inputCusID();
		} while (tcode == null);
		Custumer customer = lstCus.searchID(tcode);
		if (customer != null) {
			System.out.println("Do you want delete it?");
			int choose = menuYesNo();
			if (choose == 1) {
				lstCus.delete(customer);
				System.out.println("Delete success!");
			} else {
				System.out.println("Delete fail!");
			}
		}
	}

	// =============== Booking=========================
	public static void inputBooking(BookingList lstBook, TrainList lstTrain, CustumerList lstCus) {

		int number;
		do {
			System.out.println("Enter your number Booking you wanna add: ");
			number = Input.chechNumber();
		} while (number < 0);
		for (int i = 0; i < number; i++) {
			System.out.println("Enter " + (i + 1) + "Train");
			lstBook.inputBooking(lstTrain, lstCus);
		}
	}

	public static void menuMain() {
		System.out.println("|=======================================|");
		System.out.println("|				1.Train					|");
		System.out.println("|				2.Custumner				|");
		System.out.println("|				3.Booking				|");
		System.out.println("|				0.Exit					|");
		System.out.println("|=======================================|");
	}

	public static void menuTrainList() {

		System.out.println("|====================================================================|");
		System.out.println("|===== 		 Trai List 											=====|");
		System.out.println("|===== 1.Load data from file 									=====|");
		System.out.println("|===== 2.Input & add to the head 								=====|");
		System.out.println("|===== 3.Display data				 							=====|");
		System.out.println("|===== 4.Save lstTrain to file  								=====|");
		System.out.println("|===== 5.Search by tcode  										=====|");
		System.out.println("|===== 6.Delete by tcode  										=====|");
		System.out.println("|===== 7.Sort by tcode  										=====|");
		System.out.println("|===== 8.Add after position k  									=====|");
		System.out.println("|===== 9.Delete the node before the node having tcode = xCode  	=====|");
		System.out.println("|===== 0.Exit  													=====|");
		System.out.println("|====================================================================|");
		System.out.println();

	}

	public static void menuCusList() {
		System.out.println("|====================================================|");
		System.out.println("|======= 		Customer list 					=====|");
		System.out.println("|======= 1. Load data from file 				=====|");
		System.out.println("|======= 2.Input & add to the end 				=====|");
		System.out.println("|======= 3.Display data 						=====|");
		System.out.println("|======= 4.Save customer list to file 			=====|");
		System.out.println("|======= 5.Search by ccode 						=====|");
		System.out.println("|======= 6.Delete by ccode 						=====|");
		System.out.println("|======= 0.Exit  								=====|");
		System.out.println("|====================================================|");

		System.out.println();
	}

	public static void menuBookList() {
		System.out.println();
		System.out.println("|====================================================|");
		System.out.println("|=======  			Booking list 				=====|");
		System.out.println("|======= 1.Input Data  							=====|");
		System.out.println("|======= 2.Display data with available seats 	=====|");
		System.out.println("|======= 3.Sort by tcode + ccode 				=====|");
		System.out.println("|======= 0.Exit					 				=====|");
		System.out.println("|====================================================|");

		System.out.println();

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TrainList lstTrain = new TrainList();
		CustumerList lstCus = new CustumerList();
		BookingList lstBook = new BookingList();
		// load data form file

		boolean flat = true;
		while (flat) {
			menuMain();
			System.out.println("Please enter your choose: ");
			int choo = Input.chechNumber();
			while (choo < 0) {
				System.out.println("Please enter your choose again: ");
				choo = Input.chechNumber();
			}
			switch (choo) {
			case 1: {
				boolean choose = true;
				while (choose) {
					menuTrainList();
					System.out.println("Please enter your choose: ");
					int cho = Input.chechNumber();
					while (cho < 0) {
						System.out.println("Please enter your choose again: ");
						cho = Input.chechNumber();
					}
					switch (cho) {
					case 1: {
						lstTrain.addFromFile("Train.txt");
						lstTrain.display();
						break;
					}
					case 2: {
						inputTrain(lstTrain);
						break;
					}
					case 3: {
						titleTrainList();
						lstTrain.display();
						break;
					}
					case 4: {
						System.out.println("Do you want to save?");
						int chooose = menuYesNo();
						if (chooose == 1) {
							lstTrain.saveListToFile("Train.txt");
							System.out.println("Save success!");
						} else {
							System.out.println("Save fail!");
						}
						break;
					}
					case 5: {
						searchTrainID(lstTrain);
						break;
					}
					case 6: {
						deleteTrainId(lstTrain);
						break;
					}
					case 7: {
						lstTrain.sortID();
						titleTrainList();
						lstTrain.display();
						break;
					}
					case 8: {
						addAfterPositionK(lstTrain);
						break;
					}
					case 9: {
						deleteTrainBefore(lstTrain);
						break;
					}
					case 0: {
						choose = false;
						break;
					}
					default: {
						System.out.println("Unknown!!!");
						break;
					}
					}

				}
				break;
			}
			case 2: {
				boolean chose = true;
				while (chose) {
					menuCusList();
					System.out.println("Please enter your choose: ");
					int chosose = Input.chechNumber();
					while (chosose < 0) {
						System.out.println("Please enter your choose again: ");
						chosose = Input.chechNumber();
					}
					switch (chosose) {
					case 1: {
						lstCus.addFromFile("Custumer.txt");
						lstCus.displayList();
						break;
					}
					case 2: {
						inputCus(lstCus);
						break;
					}
					case 3: {
						titleCustomerList();
						lstCus.displayList();
						break;
					}
					case 4: {
						System.out.println("Do you want to save?");
						int chooeose = menuYesNo();
						if (chooeose == 1) {
							lstTrain.saveListToFile("Custumer.txt");
							System.out.println("Save success!");
						} else {
							System.out.println("Save fail!");
						}
						break;
					}
					case 5: {
						searchCusID(lstCus);
						break;
					}
					case 6: {
						deleteCustomerByTCode(lstCus);
						break;
					}
					case 0: {
						chose = false;
						break;
					}
					default: {
						System.out.println("Unknown!!!");
						break;
					}
					}
				}
				break;
			}
			case 3: {
				boolean treck = true;
				while (treck) {
					menuBookList();
					System.out.println("Please Enter your choose: ");
					int bok = Input.chechNumber();
					while (bok < 0) {
						System.out.println("Please Enter your choose again: ");
						bok = Input.chechNumber();
					}
					switch (bok) {
					case 1: {
						inputBooking(lstBook, lstTrain, lstCus);
						break;
					}
					case 2: {
						displayListBooking(lstBook);
						break;
					}
					case 3: {
						lstBook.sortID();
						displayListBooking(lstBook);
						break;
					}
					case 0: {
						treck = false;
						break;
					}
					default: {
						System.out.println("Unknown!!!");
						break;
					}
					}
				}
				break;
			}
			case 0: {
				flat = false;
				break;
			}
			default: {
				System.out.println("Unknown!!!");
				break;
			}
			}
		}
	}
}
