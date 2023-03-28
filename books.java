package sits;

import java.util.*;

public class books {
	book theBooks[]=new book[50];
	public static int count;
	Scanner sc=new Scanner(System.in);
	
	//menu
	public void dispMenu() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Choose What yo want to do.\n");
		System.out.println("\t\n1:Add New Book.");
		System.out.println("\t\n2:Search a Book.");
		System.out.println("\t\n3:Show All Books.");
		System.out.println("\t\n4:Register Student.");
		System.out.println("\t\n5:Show All Registered Student.");
		System.out.println("\t\n6:Check Out Book.");
		System.out.println("\t\n7:Check in Book.");
		System.out.println("\t\n0:Exit.");
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	//functions
	//Compare two books
	public int compareBookObjects(book b1, book b2) {
		
		if(b1.bookName.equalsIgnoreCase(b2.bookName)) {
			System.out.println("Book is Already Exists.");
			return 0;
		}
		
		if(b1.sNo==b2.sNo) {
			System.out.println("Book of this Serial number is Already Exists.");
			return 0;
		}
		return 1;
	}
	
	//Add Book
	public void addBook(book b) {
		for(int i=0;i<count;i++) {
			if(this.compareBookObjects(b, this.theBooks[i])== 0) {
				return;
			}
		}
		
		if(count<50) {
			theBooks[count]=b;
			count++;
		}else {
			System.out.println("\nLibrary is Full!");
		}
		return;
	}
	
	//search book by serial no
	public void searchBySno() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("\t\t\tSearch By Serial Number.\n");
		
		int sNo;
		System.out.print("Enter Serial Number of Book:- ");
		sNo=sc.nextInt();
		
		int flag=0;
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Quantity\t\tTotal Quantity");
		
		for(int i=0;i<=count;i++) {
			if(sNo == theBooks[i].sNo) {
				System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName +"\t\t"
						+ theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy +"\t\t" + theBooks[i].bookQty);
				flag++;
				return;
			}
		}
		if(flag==0) {
			System.out.println("No Book for Serial Number "+ sNo +" Found.");
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	public void searchByAuthorName() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("\t\t\tSearch By Author's Name.");
		//sc.nextLine();
		System.out.print("\nEnter Author Name:- ");
		String authorName=sc.nextLine();
		
		int flag=0;
		
		System.out.println("\nS.No\t\tName\t\tAuthor\t\t\tAvailable Quantity\t\tTotal Quantity");
		
		for(int i=0;i<count;i++) {
			if(authorName.equalsIgnoreCase(theBooks[i].authorName)) {
				System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName +"\t\t"
						+ theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy +"\t\t\t" + theBooks[i].bookQty);
				flag++;
			}
		}
		if(flag==0) {
			System.out.println("No Books of "+ authorName +" Found. ");
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	//display all books
	public void showAllBooks() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("\t\t\t Showing All Books\n");
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		
		for(int i=0;i<count;i++) {
			System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName +"\t\t"
					+ theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy +"\t\t\t" + theBooks[i].bookQty);
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	//Search the library
	public int isAvailable(int sNo) {
		for(int i=0;i<count;i++) {
			if(sNo == theBooks[i].sNo) {
				if(theBooks[i].bookQtyCopy>0) {
					System.out.println("Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable.");
				return -1;
			}
		}
		System.out.println("No Book of Serial Number "+ " Available in Library. ");
		return -1;
	}
	
	//to remove book
	public book checkOutBook() 
	{
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.print("\nEnter Serial number of book to be checked Out:- ");
		int sNo=sc.nextInt();
		
		int bookIndex = isAvailable(sNo);
		
		if(bookIndex != -1) {
			theBooks[bookIndex].bookQtyCopy--;
			return theBooks[bookIndex];
		}
		System.out.println("---------------------------------------------------------------------------------------");
		return null;
	}
	
	//to add the book to the library
	public void checkInBook(book b) {
		for(int i=0;i<count;i++) {
			if(b.equals(theBooks[i])) {
				theBooks[i].bookQtyCopy++;
				return;
			}
		}
	}
}
