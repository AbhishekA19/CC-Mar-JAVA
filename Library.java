package sits;

import java.util.*;

public class Library {

	public static void main(String[] args) {
		int choice;
		int searchChoice;
		try (Scanner sc = new Scanner(System.in)) {
			//menu
			System.out.println();
			System.out.println("********************Welcome to the SITS Library********************");
			
			books ob =new books();
			
			students obStudent=new students();
			
			//choose menu
			do {
				ob.dispMenu();
				System.out.print("\nChoose Operation:- ");
				choice=sc.nextInt();
				
				switch(choice) {
				case 1:{
					book b=new book();
					ob.addBook(b);
					break;
				}
				
				case 2:{
					System.out.println("---------------------------------------------------------------------------------------");
					System.out.println("\n1:Search with Book Serial Number.");
					System.out.println("\n2:Search with Book's Author Name.");
					System.out.print("\nChoose one of above Option:- ");
					
					searchChoice=sc.nextInt();
					
					switch(searchChoice) {
					case 1:{
						ob.searchBySno();
						break;
					}
					
					case 2:{
						ob.searchByAuthorName();
						break;
					}
					
					}
					break;
				}
				
				case 3:{
					ob.showAllBooks();
					break;
				}
				
				case 4:{
					student s=new student();
					obStudent.addStudent(s);
					break;
				}
				
				case 5:{
					obStudent.showAllStudents();
					break;
				}
				
				case 6:{
					obStudent.checkOutBook(ob);
					break;
				}
				
				case 7:{
					obStudent.checkInBook(ob);
					break;
				}
				
				case 0:{
					obStudent.exit();
					break;
				}
				
				default:{
					System.out.println("Invalid Choice");
					break;
				}
				
				}
			}while(true);
		}
		
	}

}