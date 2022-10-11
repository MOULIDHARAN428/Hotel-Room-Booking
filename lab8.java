package numbers;
import java.util.*;

class oddeven{
	public int a;
	public oddeven() {}
	public oddeven(int a) {
		this.a=a;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public void oddoreven(){
		if(a%2 == 0) {
			System.out.println("A is even number");
		}
		else {
			System.out.println("A is odd number");
		}
	}
}
class palindrome{
	public int a;
	public palindrome() {}
	public palindrome(int a) {
		this.a=a;
	}
	public int geta() {
		return a;
	}
	public void seta(int a) {
		this.a = a;
	}
	public void pali() {
		int temp=a,rem,ans=0;
		while(temp>0) {
			rem=temp%10;
			ans=(ans*10)+rem;
			temp/=10;
		}
		if(ans==a) {
			System.out.println("A is a palindrome number");
			}
		else {
			System.out.println("A is not a palindrome number");
		}
	}
}

public class lab8 {
	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		
		System.out.print("Enter A : ");
		int a=ip.nextInt();
		oddeven a1=new oddeven(a);
		a1.oddoreven();
		palindrome a2=new palindrome(a);
		a2.pali();
		
		ip.close();
		
	}
}
