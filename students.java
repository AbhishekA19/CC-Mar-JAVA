package sits;
import java.util.*;

public class students {
	student theStudents[]=new student[50];
	Scanner sc=new Scanner(System.in);
	
	public static int count=0;
	
	//add book
	public void addStudent(student s) {
		for(int i=0;i<count;i++) {
			if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)) {
				System.out.println("\nStudent of Registration Number "+ s.regNum+ " is Already Registered. ");
				return ;
			}
		}
		if(count<=50) {
			theStudents[count]=s;
			count++;
		}
	}
	
	//show All Students
	public void showAllStudents() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Student Name\t\tRegistration Number");
		for(int i=0;i<count;i++) {
			System.out.println(theStudents[i].studentName + "\t\t\t" + theStudents[i].regNum);
		}
		System.out.println("---------------------------------------------------------------------------------------");
		return;
	}
	
	//check the student
	public int isStudent() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.print("\nEnter Registration Number:- ");
		String regNum=sc.nextLine();
		for(int i=0;i<count;i++) {
			
			if(theStudents[i].regNum.equalsIgnoreCase(regNum)) {
				
				return i;
			}
		}
		System.out.println("\nStudent is Not Registered.");
		System.out.println("Register First.");
		return -1;
		
	}
	
	//remove the Book
	public void checkOutBook(books book) {
		int studentIndex=this.isStudent();
		
		if(studentIndex !=-1) {
			System.out.println("\n\t\t\tChecking Out.");
			
			book.showAllBooks();
			book b=book.checkOutBook();
			
			System.out.println("Checking Out.");
			if(b!=null) {
				if(theStudents[studentIndex].bookCount <=3) {
					System.out.println("Adding Book");
					theStudents[studentIndex].borrowedBook[theStudents[studentIndex].bookCount] =b;
				    theStudents[studentIndex].bookCount++;
				    return;
				}else {
					System.out.println("Student Can Not Borrow More Than 3 Books At A Time.");
					return;
				}
			}
			System.out.println("Book is not Available.");
		}
	}
	
	//to add the book
	public void checkInBook(books book) {
		int studentIndex = this.isStudent();
		if(studentIndex != -1) {
			System.out.println("S.No\t\tBook Name\t\tAuthor Name");
			
			student s=theStudents[studentIndex];
			
			for(int i=0;i<s.bookCount;i++) {
				System.out.println(
						s.borrowedBook[i].sNo + "\t\t\t"
				        + s.borrowedBook[i].bookName + "\t\t\t"
				        + s.borrowedBook[i].authorName);
			}
			System.out.print("\nEnter Serial Number of Book to be Checked In:- ");
			int sNo=sc.nextInt();
			
			for(int i=0;i<s.bookCount;i++) {
				if(sNo == s.borrowedBook[i].sNo) {
					book.checkInBook(s.borrowedBook[i]);
					s.borrowedBook[i]=null;
					return;
				}
			}
			System.out.println("Book of Serial No "+sNo+" not Found");
		}
	}
	
	public void exit() {
		System.exit(0);
	}
}