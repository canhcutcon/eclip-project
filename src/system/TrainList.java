package system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import Support.Input;
import system.LinkedList.Node;

public class TrainList {

	public TrainList() {
		// TODO Auto-generated constructor stub
	}

	LinkedList<Train> lstTrain = new LinkedList<Train>();

	public LinkedList<Train> getAll() {
		return lstTrain;
	}

	public void display() {
		try {
			lstTrain.displayLinkedList();
		} catch (Exception e) {
			System.out.println("List is empty");
		}
	}

	// ======= add=========
	public boolean containID(String id) {
		if (searchID(id) != null)
			return true; // trung max
		else
			return false;
	}

	public boolean add(Train a) {

		if (containID(a.gettCode())) {
			System.out.println("Add defeat!!");
			return false;
		}
		lstTrain.addhead(a);
		return true;
	}

	// ===== search ID =====
	public Train searchID(String ID) {
		Node<Train> i = lstTrain.head;
		while (i != null) {
			if (i.value.gettCode().equalsIgnoreCase(ID))
				return i.value;
			i = i.next;
		}
		return null;
	}
	// ===== check ID ======

	public String inputTrainID() {
		String id;
		Pattern patternMa = Pattern.compile("B\\d{2}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Train ID: ");
		id = sc.nextLine();
		if (Input.isString(id)) {
			System.out.println("ID include one B and 2 random number: ");
			return null;
		}
		if (!patternMa.matcher(id).matches()) {
			System.out.println("ID include one B and 2 random number: ");
			id = sc.nextLine();
			return null;
		}

		return id;
	}

	public String inputTrainName() {
		String name;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Train Name: ");
			name = sc.nextLine();
		} while (Input.isString(name));
		name = Input.chuanHoaDanhTuRieng(name);
		return name;
	}

	public int inputSeat() {
		int seat;
		do {
			System.out.println("Enter Seat Train: ");
			seat = Input.chechNumber();
		} while (seat <= 0);
		while (seat > 50) {
			System.out.println("Seat Train is very height, please Enter again!!!");
			System.out.println("Enter Seat Train: ");
			seat = Input.chechNumber();
		}
		return seat;
	}

	public int inputBooked(int seat) {
		int booked;
		do {
			System.out.println("Enter Booked Train: ");
			booked = Input.chechNumber();
		} while (booked < 0);

		while (booked > seat) {
			System.out.println("Booked Train is very more than Seat, please Enter again!!!!");
			System.out.println("Enter Booked Train: ");
			booked = Input.chechNumber();
		}
		return booked;
	}

	public double depart_Time() {
		double time = 0;
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		while (!check) {
			System.out.print(" ");
			try {
				time = sc.nextDouble();
				check = true;
			} catch (Exception e) {
				System.out.println("Just Number!!");
				sc.nextLine();
			}
		}
		return time;
	}

	public String depart_place() {
		boolean check = true;
		System.out.println("Choose depart place");
		while (check) {
			System.out.println("|====== 	Place 		======|");
			System.out.println("|====== 	1.PA 		======|");
			System.out.println("|====== 	2.PB 		======|");
			System.out.println("|====== 	3.PC		======|");
			System.out.println("|====== 	4.PD 		======|");
			System.out.println("|====== 	5.PE 		======|");
			System.out.println("|====== 	6.PF 		======|");

			int choose = 0;
			choose = Input.chechNumber();
			while (choose < 0) {
				System.out.println("More than 0");
				choose = Input.chechNumber();
			}

			switch (choose) {
			case 1: {
				return "PA";
			}
			case 2: {
				return "PB";

			}
			case 3: {
				return "PC";

			}
			case 4: {
				return "PD";

			}
			case 5: {
				return "PE";

			}
			case 6: {
				return "PF";

			}
			default: {
				System.out.println("Unknown!!");
				break;
			}
			}
		}
		return "";
	}

	public Train inputOneTrain() {
		Train train;
		String id, name, place;
		int seat, booked;
		double time;
		do {
			id = inputTrainID();
			if (containID(id))
			{
				id = null;
			}
		} while (id == null);

		name = inputTrainName();
		seat = inputSeat();
		booked = inputBooked(seat);
		System.out.println("Enter depart time: ");
		time = depart_Time();
		place = depart_place();
		return new Train(id, name, seat, booked, time, place);
	}

	// === Search Index
	public int searchIndex(Train a) {
		int index = 0;
		Node<Train> i = lstTrain.head;
		while (i != null) {
			if (i.value.gettCode().equalsIgnoreCase(a.gettCode())) {
				return index;
			}
			index++;
			i = i.next;
		}
		return -1;

	}

	// === add with index K
	public boolean addAfterPositionK(Train a, int index) {
		if (containID(a.gettCode())) {
			System.out.println("Add defeat!!");
			return false;
		}
		lstTrain.insert(index, a);
		return true;
	}

	// ========== delete ===========
	public void delete(Train a) throws Exception {
		int index = this.searchIndex(a);
		if (index != 1) {
			lstTrain.removeAtIndex(index);
		}
	}

	// ========= Delete Node Before K ============
	public int indexBefore(int index) {
		int indexBefore;
		if (index == 0) {
			return indexBefore = lstTrain.length - 1;
		} else
			return indexBefore = index - 1;
	}

	public void deleteNodeBefore(Train a) throws Exception {
		int index = this.searchIndex(a);
		if (index != -1) {
			int indexBefore = indexBefore(index);
			lstTrain.removeAtIndex(indexBefore);
		}
	}

	// ======= return value avaiable of Train
	public int searchAvailableSeatOfTrain(String Id) {
		Train a = searchID(Id);
		return a.avaiable_seat();
	}

	// ======== sort ======
	public void sortID() {
		for (Node<Train> i = lstTrain.head; i != lstTrain.tail; i = i.next) {
			for (Node<Train> j = i.next; j != null; j = j.next) {
				if ((i.value.gettCode()).compareTo(j.value.gettCode()) > 0) {
					lstTrain.swap(i, j);
				}
			}
		}
	}

	public void addFromFile(String fileName) {
		try {
			File filenIn = new File(fileName);
			if (!filenIn.exists()) {
				System.out.println("File not exists!!");
				return;
			}
			FileReader fileR = new FileReader(fileName);
			BufferedReader bf = new BufferedReader(fileR);
			String train;
			while ((train = bf.readLine()) != null) {
				StringTokenizer stk = new StringTokenizer(train, "|");
				String tcode = Input.chuanHoa(stk.nextToken());
				String tName = Input.chuanHoa(stk.nextToken());
				int seat = Integer.parseInt(Input.chuanHoa(stk.nextToken()));
				int book = Integer.parseInt(Input.chuanHoa(stk.nextToken()));
				double departTime = Double.parseDouble(Input.chuanHoa(stk.nextToken()));
				String departPlace = Input.chuanHoa(stk.nextToken());
				this.add(new Train(tcode, tName, seat, book, departTime, departPlace));
			}
			bf.close();
			fileR.close();

		} catch (Exception e) {

			System.out.println("Error");
		}
	}

	public void saveListToFile(String fileName) {
		if (lstTrain.length == 0) {
			System.out.println("Empty list !!");
			return;
		}

		try {

			File fileOut = new File(fileName);
			FileWriter fWriter = new FileWriter(fileOut);
			PrintWriter printW = new PrintWriter(fWriter);
			Node<Train> i = lstTrain.head;
			while (i != null) {
				String Train = "";
				Train = " " + i.value.gettCode() + " " + "|" + " " + i.value.getTrainName() + " " + "|" + " "
						+ i.value.getSeat() + " " + "|" + " " + i.value.getBooked() + " " + "|" + " "
						+ i.value.getDepartTime() + " " + "|" + " " + i.value.getDepartPlace();
				printW.println(Train);
				printW.flush();
				i = i.next;
			}
			printW.close();
			fWriter.close();
			lstTrain.removeAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error!!!");
		}
	}

}