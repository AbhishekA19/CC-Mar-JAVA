package sits;
import java.util.*;

public class student {
	String studentName;
	String regNum;
	
	book borrowedBook[]=new book[3];
	public int bookCount=0;
	
	Scanner sc=new Scanner(System.in);
	
	public student() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.print("\nEnter Student Name:- " );
		this.studentName=sc.nextLine();
		
		System.out.print("\nEnter Registration Number:- ");
		this.regNum=sc.nextLine();
		System.out.println("---------------------------------------------------------------------------------------");
	}

}
