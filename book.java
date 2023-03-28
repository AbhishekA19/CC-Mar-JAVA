package sits;

import java.util.*;

public class book {
	public int sNo;
	public String bookName;
	public String authorName;
	public int bookQty;
	public int bookQtyCopy;
	
	Scanner sc=new Scanner(System.in);
	
	public book(){
		System.out.print("\nEnter Serial No of Book:- ");
		this.sNo=sc.nextInt();
		sc.nextLine();
		
		System.out.print("\nEnter Book Name:- ");
		this.bookName=sc.nextLine();
		
		System.out.print("\nEnter Author Name:- ");
		this.authorName=sc.nextLine();
		
		System.out.print("\nEnter Quantity of Book:- ");
		this.bookQty=sc.nextInt();
		bookQtyCopy= this.bookQty;
		return;
	}
}