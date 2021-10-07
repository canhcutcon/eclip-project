package system;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;



import Support.Input;
import system.LinkedList.Node;

public class CustumerList {

	public CustumerList() {
		// TODO Auto-generated constructor stub
	}
	LinkedList<Custumer> lstCus = new LinkedList<Custumer>();
	
	public LinkedList<Custumer> getAll(){
		return lstCus;
	}
	public void displayList() {
		try {
			lstCus.displayLinkedList();			
		}catch(Exception e)
		{
			System.out.println("List is empty!!");
		}
	}
	
	public boolean containID(String id) {
		if(searchID(id) != null)
			return true;
		else
			return false;
	}
	public boolean add(Custumer a)
	{
		if(containID(a.getCcode())) {
			System.out.println("Add defeat!!");
			return false;
		}
		lstCus.addLast(a);
		return true;
	} 
	
	// === searchID
	public Custumer searchID(String ID) {
		Node<Custumer> i = lstCus.head;
		while(i != null)
		{
			if(i.value.getCcode().equalsIgnoreCase(ID))
				return i.value;
			i = i.next;
		}
		return null;
	}
	
	
	public String inputCusID() {
		String id;
		Pattern patternMa = Pattern.compile("C\\d{2}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer ID: ");
		id = sc.nextLine();
		if(Input.isString(id)) {
			System.out.println("ID include one C and 2 random number: ");
			return null;
		}
		if(!patternMa.matcher(id).matches()) {
			System.out.println("ID include one C and 2 random number: ");
			id = sc.nextLine();
			return null;
		}
		return id;
	}
	public String inputCusName() {
		String name;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Custumer Name: ");
			name = sc.next();
		}while(Input.isString(name));
		name = Input.chuanHoaDanhTuRieng(name);
		return name;
	}
	
	public String phone() {
		String phone;
		Pattern paMa = Pattern.compile("19\\d{2}$");
		Scanner sc = new Scanner(System.in);
		phone = sc.nextLine();
		if(!paMa.matcher(phone).matches()) {
			System.out.println("Enter your phone have must like (0123456789) ");
			return null;
		}
		return phone;
	}
	
	public void inputOnCus() {
		String id,name, phone;
		Scanner sc = new Scanner(System.in);
		id = inputCusID();
		while(id == null) {
			id = inputCusID();
			if (containID(id))
			{
				id = null;
			}
		}
		name = inputCusName();
		phone = phone();
		while(phone == null) {
			phone = phone();
		}
		this.add(new Custumer(id,name,phone));
		System.out.println("Add success!");
	}
	
	
	public int searchIndex(Custumer a) {
		int index = 0;
		Node<Custumer> i = lstCus.head;
		while(i != null)
		{
			if(i.value.getCcode().equalsIgnoreCase(a.getCcode()))
				return index;
			index++;
			i = i.next;
		}
		return -1;
	}
	// === delete
	public void delete(Custumer a) throws Exception {
			int index = this.searchIndex(a);
			if(index != -1) {
				lstCus.removeAtIndex(index);
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
					String phone = Input.chuanHoa(stk.nextToken());
					this.add(new Custumer(tcode, tName, phone));
				}
				bf.close();
				fileR.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error");
			}

		}

	public void saveListToFile(String filename) {
			if (lstCus.length == 0) {
				System.out.println("Empty list!!");
				return;
			}
			try {

				File fileOut = new File(filename);
				FileWriter fWriter = new FileWriter(fileOut);
				PrintWriter printW = new PrintWriter(fWriter);
				Node<Custumer> i = lstCus.head;
				while (i != null) {
					String Train = "";
					Train = " " + i.value.getCcode() + " " + "|" + " " + i.value.getCus_name() + " " + "|" + " "
							+ i.value.getPhone();
					printW.println(Train);
					printW.flush();
					i = i.next;
				}
				printW.close();
				fWriter.close();
				lstCus.removeAll();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error!!!");
			}
		}

		

}
