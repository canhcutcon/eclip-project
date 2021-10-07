package Support;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

	public Input() {
		// TODO Auto-generated constructor stub
	}
	public static boolean isString(String str) {  
		  try {  
		    Double.parseDouble(str);   
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  		
		  }catch (IllegalArgumentException e) { 
				// TODO: handle exception
				System.out.println( "không hợp lệ!");
				return false;
			}catch (NullPointerException e) { 
				// TODO: handle exception
				System.out.println( "không  được trống!");
				return false;
			}  
	}
	
	 public static int chechNumber(){
		 Scanner sc= new Scanner(System.in);
		 boolean check= false;
		 int n=0;
		 while(!check){
			 System.out.print(" ");
			 try{
			       n= sc.nextInt();
			       check= true;
			 }
			 catch(Exception e){
			       System.out.println("Just Interger!!");
			       sc.nextLine();
			 }
		}
		return (n);
	}
	 
	 public static String chuanHoa(String str) {
	        str = str.trim();
	        str = str.replaceAll("\\s+", " ");
	        return str;
	    }
	 
	 public static String chuanHoaDanhTuRieng(String str) {
	        str = chuanHoa(str);
	        String temp[] = str.split(" ");
	        str = ""; // ? ^-^
	        for (int i = 0; i < temp.length; i++) {
	            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
	            if (i < temp.length - 1)
	                str += " ";
	        }
	        return str;
	    }
		
	public static String phone()
	{
			String phone;
			Pattern patternMa = Pattern.compile("(19\\d{2}$)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your phone(1923): ");
			phone = sc.nextLine();
			if(!patternMa.matcher(phone).matches())
			{
				System.out.println("Enter your phone have must like (1912)");
				return null;
			}
			return phone;
	}

}
