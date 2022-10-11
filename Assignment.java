package numbers;
import java.util.*;
import java.io.*;
public class Assignment {
	static String staff = "";
	static int jungle[] = new int[10];
    static int sea[] = new int[10];
	public static void print() {
		System.out.print("1. Sign Up\n2. Log In\n3. Log Out\n4. Book Room\n5. Manage\n6. Recipt\n7. Exit\nEnter your choice : ");
	}
	
	public static void signup() throws IOException {
		Scanner sc = new Scanner(System.in);
		String name,password,email;
		System.out.print("Enter name : ");
		name=sc.next();
		System.out.print("Enter email : ");
		email=sc.next();
		System.out.print("Enter password : ");
		password=sc.next();
		String content = name+","+password+","+email+"\n";
		BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Java\\Programms\\numbers\\users.txt", true));
		out.write(content);
		out.close();
        System.out.println("Registred!");
	}
	
	public static void login() throws IOException {
		if(staff.compareTo("") != 0) {System.out.println("Already logged In!");}
		else {
			Scanner sc = new Scanner(System.in);
			int flag=0;
			System.out.print("Enter email : ");
			String email=sc.next();
			System.out.print("Enter password : ");
			String password=sc.next();
			File file = new File("D:\\Java\\Programms\\numbers\\users.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = br.readLine()) != null) {
	        	if(line.contains(password) && line.contains(email)) {
	        		flag=1;
	        		System.out.println("Logged In!");
	        		for(int i=0;i<line.length();i++) {
	        			if(line.charAt(i)!=',') {staff+=line.charAt(i);}
	        			else {break;}
	        		}
	        	}
	        }
	        if(flag==0) {System.out.print("No such account found!\n");}
		}
	}
	
	public static void logout() {
		if(staff.compareTo("") != 0) {
			staff = new String("");
			System.out.print("Logged Out!\n");
		}
		else {System.out.print("No account logged in!\n");}
	}
	
	public static void book_room() throws IOException {
		if(staff.compareTo("") != 0) {
			
			File file = new File("D:\\Java\\Programms\\numbers\\room.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	        int flag=0,flag1=0;
	        for(int i=0;i<10;i++) {jungle[i]=0;sea[i]=0;}
	        String room = "",view = "";
	        while ((line = br.readLine()) != null) {
	        	for(int i=0;i<line.length();i++) {
	        		if(line.charAt(i)==',') {flag++;}
	        		else if(flag==0) {room+=line.charAt(i);}
	        		else if(flag==1) {view+=line.charAt(i);}
	        	}
	        	int temp = Integer.parseInt(room);
	        	if(view.equalsIgnoreCase("jungle")) {jungle[temp-1]++;}
	        	else {sea[temp-1]++;}
	        	flag=0;room = new String("");view = new String("");
	        }
			System.out.println("Available rooms : ");
			System.out.print("Jungle : ");
			for(int i=0;i<10;i++) {if(jungle[i]==0) {System.out.print(i+1+" ");flag1=1;}}
			if(flag1==0) {System.out.print("No rooms available!");}
			flag1=0;
			System.out.print("\nSea    : ");
			for(int i=0;i<10;i++) {if(sea[i]==0) {System.out.print(i+1+" ");flag1=1;}}
			if(flag1==0) {System.out.print("No rooms available!");}
			
			Scanner sc = new Scanner(System.in);
			System.out.print("\nName : ");
			String name = sc.next();
			System.out.print("Age : ");
			String age = sc.next();
			System.out.print("Passport : ");
			String passport = sc.next();
			System.out.print("Contact Number : ");
			String contact_number = sc.next();
			System.out.print("Email : ");
			String email = sc.next();
			System.out.print("Room Number : ");
			String roomID = sc.next();
			System.out.print("View : ");
			String view1 = sc.next();
			System.out.print("No. of Days stay : ");
			String no_of_days = sc.next();
			int amount = Integer.parseInt(no_of_days);
			amount = (amount*350)+(amount*10);
			amount +=amount/10;
			String content = roomID+","+view1+","+name+","+age+","+passport+","+contact_number+","+email+","+no_of_days+","+amount+","+staff+"\n";
			BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Java\\Programms\\numbers\\room.txt", true));
			out.write(content);
			out.close();
			
	        System.out.println("Room Booked!");
		}
		else {System.out.println("Sign-in to book a room!");}
	}
	
	public static void modify() throws IOException {
		if(staff.compareTo("") != 0) {
			
			Scanner sc1 = new Scanner(System.in);
			System.out.print("Room : ");
			String room = sc1.next();
			System.out.print("View : ");
			String view = sc1.next();
			
			File file = new File("D:\\Java\\Programms\\numbers\\room.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line,room1="",view1="";
	       
	        int flag1=0;
	        while ((line = br.readLine()) != null) {
	        	int flag=0;
	        	room1=new String("");
	        	view1=new String("");
	        	for(int i=0;i<line.length();i++) {
	        		if(line.charAt(i)==',') {flag++;}
	        		else if(flag==0) {room1+=line.charAt(i);}
	        		else if(flag==1) {view1+=line.charAt(i);}
	        		else {break;}
	        	}
	        	
	        	if(room.compareTo(room1)==0 && view.equalsIgnoreCase(view1)) {
	        		
	        		flag1=1;
	        		String filePath = "D:\\Java\\Programms\\numbers\\room.txt";
	        	    Scanner sc = new Scanner(new File(filePath));
	        	    StringBuffer buffer = new StringBuffer();
	        	    while (sc.hasNextLine()) {
	        	    	buffer.append(sc.nextLine()+System.lineSeparator());
	        	    }
	        	    String fileContents = buffer.toString();
	        	    sc.close();
//	        	    System.out.println(fileContents);
	        	    
	        	    System.out.print("1. Change Room\n2. Change Stay days\nEnter Your Choice : ");
	        	    int temp = sc1.nextInt();
	        	    int loc = -1,loc1 = -1;
	        	    flag=0;
	        	    room1 = new String("");
	        	    view1 = new String("");
	        	    if(temp==1) {
	        	    	System.out.print("Enter room number : ");
	        	    	int temp_room = sc1.nextInt();
	        	    	for(int i=0;i<fileContents.length();i++) {
	        	    		if(line.charAt(i)==',') {flag++;}
	    	        		else if(flag==0) {room1+=line.charAt(i);loc=i;}
	    	        		else if(flag==1) {view1+=line.charAt(i);}
	    	        		else if(line.charAt(i)=='\n'){room1=new String("");view1=new String("");flag=0;}
	    	        		else if(room.compareTo(room1)==0 && view.equalsIgnoreCase(view1)) {
	    	        			fileContents=fileContents.substring(0, loc) +temp_room+ fileContents.substring(loc+1);
	    	        			FileWriter writer = new FileWriter(filePath);
	    	        			writer.append(fileContents);
	    	        			writer.flush();
	    	        			System.out.print("Updated!\n");
	    	        		    break;
	    	        		}
	        	    	}
	        	    	
	        	    }
	        	    else if(temp==2) {
	        	    	int b=0;
	        	    	System.out.println("Enter Stays Days : ");
	        	    	int temp_stay = sc1.nextInt();
	        	    	int amount = (temp_stay*350)+(temp_stay*10);
	        			amount +=amount/10;
	        			for(int i=0;i<fileContents.length();i++) {
	        	    		if(line.charAt(i)==',') {flag++;}
	    	        		else if(flag==0) {room1+=line.charAt(i);}
	    	        		else if(flag==1) {view1+=line.charAt(i);}
	    	        		else if(line.charAt(i)=='\n'){room1=new String("");view1=new String("");flag=0;}
	    	        		else if(room.compareTo(room1)==0 && view.equalsIgnoreCase(view1)) {
	    	        			for(int j=i;j<fileContents.length();j++) {
	    	        				if(line.charAt(j)==',') {flag++;if(flag==9) {loc1=j;}else if(flag==7) {loc=j+1;}}
	    	        				else if(loc!=-1 && loc1!=-1) {
	    	        					fileContents=fileContents.substring(0, loc) +temp_stay+","+amount+ fileContents.substring(loc1);
			    	        			FileWriter writer = new FileWriter(filePath);
			    	        			writer.append(fileContents);
			    	        			writer.flush();
			    	        			System.out.print("Updated!\n");
			    	        			b=1;
		    	        				break;
	    	        				}
	    	        			}
	    	        		}
	        	    		if(b==1) {break;}
	        	    	}
	        	    }
	        	    
	        	    else {System.out.println("Wrong Input!");}
	        	    
	        		break;
	        	}
	        	
	        }
	        if(flag1==0) {System.out.println("No such record found!");}
	        
		}
		
		else {System.out.println("Sign-in to delete");}
		
	}
	
	public static void delete() throws IOException {
		if(staff.compareTo("") != 0) {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Room : ");
			String room = sc.next();
			System.out.print("View : ");
			String view = sc.next();
			
			File file = new File("D:\\Java\\Programms\\numbers\\room.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line,room1="",view1="",temp="";
	        int flag1=0;
	        while ((line = br.readLine()) != null) {
	        	int flag=0;
	        	room1=new String("");
	        	view1=new String("");
	        	for(int i=0;i<line.length();i++) {
	        		if(line.charAt(i)==',') {flag++;}
	        		else if(flag==0) {room1+=line.charAt(i);}
	        		else if(flag==1) {view1+=line.charAt(i);}
	        		else {break;}
	        	}
	        	if(room.compareTo(room1)!=0 || view.equalsIgnoreCase(view1)==false) {
	        		temp+=line;
	        	}
	        	else {flag1=1;}
	        	
	        }
	        if(flag1==0) {System.out.println("No such record found!");}
	        else {
	        	String fileContents=temp;
    			FileWriter writer = new FileWriter("D:\\Java\\Programms\\numbers\\room.txt");
    			writer.append(fileContents);
    			writer.flush();
    			System.out.print("Updated!\n");
	        }
		}
		
		else {System.out.println("Sign-in to delete");}
		
	}
	
	public static void search() throws IOException {
			if(staff.compareTo("") != 0) {
				
				Scanner sc = new Scanner(System.in);
				System.out.print("Room : ");
				String room = sc.next();
				System.out.print("View : ");
				String view = sc.next();
				
				File file = new File("D:\\Java\\Programms\\numbers\\room.txt");
		        BufferedReader br = new BufferedReader(new FileReader(file));
		        String line;
		        
		        int flag=0,flag1=0;
		        while ((line = br.readLine()) != null) {
		        	if(line.contains(view) && line.contains(room)) {
		        		flag1=1;
		        		String temp="";
		        		for(int i=0;i<line.length();i++) {
		        			if(line.charAt(i)==',') {
		        				if(flag==0) {System.out.print("Room ID :");}
		        				else if(flag==1) {System.out.print("View : ");}
		        				else if(flag==2) {System.out.print("Name : ");}
		        				else if(flag==3) {System.out.print("Age : ");}
		        				else if(flag==4) {System.out.print("Passport : ");}
		        				else if(flag==5) {System.out.print("Contact Number : ");}
		        				else if(flag==6) {System.out.print("Email : ");}
		        				else if(flag==7) {System.out.print("Number of days stay : ");}
		        				else if(flag==8) {System.out.print("Amount : ");}
		        				if(flag<=8) {System.out.println(temp);}
		        				temp = new String("");
		        				flag++;
		        			}
		        			else {temp+=line.charAt(i);}
		        		}
		        	}
		        }
		        if(flag1==0) {System.out.print("Room is not booked yet!\n");}
			}
			else {System.out.println("Sign-in to get required information!");}
		
	}
			
	
	public static void view() throws IOException {
		if(staff.compareTo("") != 0) {
			for(int i=0;i<10;i++) {jungle[i]=0;sea[i]=0;}
			File file = new File("D:\\Java\\Programms\\numbers\\room.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	        int flag=0,flag1=0;
	        String room = "",view = "";
	        while ((line = br.readLine()) != null) {
	        	for(int i=0;i<line.length();i++) {
	        		if(line.charAt(i)==',') {flag++;}
	        		else if(flag==0) {room+=line.charAt(i);}
	        		else if(flag==1) {view+=line.charAt(i);}
	        	}
	        	int temp = Integer.parseInt(room);
	        	if(view.equalsIgnoreCase("jungle")) {jungle[temp-1]++;}
	        	else {sea[temp-1]++;}
	        	flag=0;room = new String("");view = new String("");
	        }
			System.out.println("Booked rooms : ");
			System.out.print("Jungle : ");
			for(int i=0;i<10;i++) {if(jungle[i]!=0) {System.out.print(i+1+" ");flag1=1;}}
			if(flag1==0) {System.out.print("All rooms available!");}
			flag1=0;
			System.out.print("\nSea    : ");
			for(int i=0;i<10;i++) {if(sea[i]!=0) {System.out.print(i+1+" ");flag1=1;}}
			if(flag1==0) {System.out.print("All rooms available!");}
			System.out.println();
		}
		
		else {System.out.println("Sign-in to delete");}
		
	}
	
	public static void manage() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Modify\n2. Delete\n3. Search\n4. View\nEnter your choice:");
		int choice = sc.nextInt();
		if(choice==1) {modify();}
		else if(choice==2) {delete();}
		else if(choice==3) {search();}
		else if(choice==4) {view();}
		else {System.out.println("Worng output!");}
	}
	
	public static void recipt() throws IOException {
		if(staff.compareTo("") != 0) {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Room : ");
			String room = sc.next();
			System.out.print("View : ");
			String view = sc.next();
			
			File file = new File("D:\\Java\\Programms\\numbers\\room.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	        
	        int flag=0,flag1=0;
	        while ((line = br.readLine()) != null) {
	        	if(line.contains(view) && line.contains(room)) {
	        		flag1=1;
	        		String temp="";
	        		for(int i=0;i<line.length();i++) {
	        			if(line.charAt(i)==',') {
	        				if(flag==0) {System.out.print("Room ID :");}
	        				else if(flag==1) {System.out.print("View : ");}
	        				else if(flag==2) {System.out.print("Name : ");}
	        				else if(flag==3) {System.out.print("Age : ");}
	        				else if(flag==4) {System.out.print("Passport : ");}
	        				else if(flag==5) {System.out.print("Contact Number : ");}
	        				else if(flag==6) {System.out.print("Email : ");}
	        				else if(flag==7) {System.out.print("Number of days stay : ");}
	        				else if(flag==8) {System.out.print("Amount : ");}
	        				if(flag<=8) {System.out.println(temp);}
	        				temp = new String("");
	        				flag++;
	        			}
	        			else {temp+=line.charAt(i);}
	        		}
	        	}
	        }
	        if(flag1==0) {System.out.print("Room is not booked yet!\n");}
		}
		else {System.out.println("Sign-in to get required information!");}
		
	}
	
	public static void main(String args[]) throws IOException {
		Scanner ip = new Scanner(System.in);
		String choice = "1";
		while(true){
			print();
			choice = ip.next();
			if(choice.compareTo("1") == 0) {signup();}
			else if(choice.compareTo("2") == 0) {login();}
			else if(choice.compareTo("3") == 0) {logout();}
			else if(choice.compareTo("4") == 0) {book_room();}
			else if(choice.compareTo("5") == 0) {manage();}
			else if(choice.compareTo("6") == 0) {recipt();}
			else if(choice.compareTo("7") == 0) {break;}
			else {System.out.println("Wrong Out Put!");}
		}
		ip.close();
	}
}
