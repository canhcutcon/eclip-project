package system;
import java.util.Scanner;
import java.util.regex.Pattern;

import Support.Input;
import system.LinkedList.Node;
public class BookingList {
	LinkedList<Booking> lstBook;

	public BookingList() {
		super();
		// TODO Auto-generated constructor stub
		lstBook = new LinkedList<Booking>();
	}
	
	public LinkedList<Booking> getAll()
	{
		return lstBook;
	}
	
	
	public void displayList() {
		try {
			lstBook.displayLinkedList();			
		}catch(Exception e)
		{
			System.out.println("List empty");
		}
	}
	//===== looking for customID from Cutomer list
	public boolean searchIDCustome(String ID,CustumerList lstCu) {
		if(lstCu.searchID(ID) != null)
			return true;
		return false;
	}
	
	//======= looking for train ID form train list
	public boolean searchIDTrain(String ID,TrainList lstTrain) {
		if(lstTrain.searchID(ID) != null)
			return true;
		return false;
	}
	// looking for customer ID in Booking list
	public Booking searchIDCustomerBooked(String ID) {
		Node<Booking> i = lstBook.head;
		while (i != null) {
			if (i.value.getCcode().equalsIgnoreCase(ID))
				return i.value;
			i = i.next;
		}
		return null;
	}
	
	// looking for train ID in Booking list
	public Booking searchIDTrainBooked(String ID) {
		Node<Booking> i = lstBook.head;
		while (i != null) {
			if (i.value.getTcode().equalsIgnoreCase(ID))
				return i.value;
			i = i.next;
		}
		return null;
	}

	// kiem tra ve da duoc dat hay chua
	public boolean checkBooked(String tcode, String ccode) {
		if (searchIDCustomerBooked(ccode) != null && searchIDTrainBooked(tcode) != null)
			return true; // ve da ton tai
		return false;
	}
	
	// addBooking
	public boolean add(Booking a)
	{
		lstBook.addLast(a);
		return true;
	}
	
	public String inputTCode() {
		// kiem tra ID hop le
		String id;
		Pattern patternMa = Pattern.compile("B\\d{2}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Code: ");
		id = sc.nextLine();
		if (Input.isString(id)) {
			System.out.println("Code include one B and 2 random number: ");
			return null;
		}
		if (!patternMa.matcher(id).matches()) {
			System.out.println("Code include one B and 2 random number: ");
			id = sc.nextLine();
			return null;
		}
		return id;
	}
	
	public String inputCusID() {
		String id;
		Pattern patternMa = Pattern.compile("C\\d{2}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID: ");
		id = sc.nextLine();
		if (Input.isString(id)) {
			System.out.println("ID include one C and 2 random number: ");
			return null;
		}
		if (!patternMa.matcher(id).matches()) {
			System.out.println("ID include one C and 2 random number: ");
			id = sc.nextLine();
			return null;
		}
		return id;
	}
	
	public void inputBooking(TrainList lstTrain, CustumerList lstCus) {
		try {
			String tcode, ccode;
			int seat;
			System.out.println("Enter train code:");
			do {
				tcode = inputTCode();
			} while (tcode == null);
			System.out.println("Enter customer code:");
			do {
				ccode = inputCusID();
			} while (ccode == null);

			// tcode not found in the Train list or ccode not found in the customer list
			// then data is not accept
			if (!searchIDCustome(ccode, lstCus) || !searchIDTrain(tcode, lstTrain)) {
				System.out.println("No custome , no train");
				return;
			} else {
				// If both tcode and ccode are found in the booking list then data is not
				// accepted
				if (checkBooked(tcode, ccode)) {
					System.out.println("Tiket is exist");
					Booking a = searchIDCustomerBooked(ccode);
					System.out.println(a.toString());
					return;
				}
				System.out.println("Enter number of seats to be booked:");
				seat = Input.chechNumber();
				// If tcode and ccode found in Traines and customers lists but booked = seat is
				// not accept
				if (seat >= lstTrain.searchAvailableSeatOfTrain(tcode)) {
					System.out.println("The train is exhausted");
					return;
				}
				this.add(new Booking(tcode,ccode,seat));
				System.out.println("Add success!!");
			}
		} catch (Exception e) {
			 System.out.println("error");
			return;
		}
	
	}
	
	public void sortID()  {
		for (Node<Booking> i = lstBook.head; i != lstBook.tail; i = i.next) {
			for (Node<Booking> j = i.next; j != null; j = j.next) {
				String buffer1 = i.value.getTcode()+i.value.getCcode(); //B01C02
				String buffer2 = j.value.getTcode()+j.value.getCcode(); //B02C03
				if(buffer1.compareTo(buffer2) > 0)
					lstBook.swap(i, j);
			}
		}
	}
}
