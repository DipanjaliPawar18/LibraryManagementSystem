package com.demo;

import java.util.List;
import java.util.Scanner;

import com.DAOClasses.BookDAO;
import com.DAOClasses.LoanDAO;
import com.DAOClasses.MemberDAO;
import com.entityClasses.Book;
import com.entityClasses.Loan;
import com.entityClasses.Member;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			// Give options for the operations
			System.out.println();
			System.out.println("Library Management System :");
			System.out.println("1 -> Add New Book");
			System.out.println("2 -> Register New Member");
			System.out.println("3 -> Issue Book");
			System.out.println("4 -> Return an issued Book");
			System.out.println("5 -> List of Books");
			System.out.println("6 -> List of Members");
			System.out.println("7 -> List of Loans");
			System.out.println("8 -> Exit");

			// Enter the operation to perform
			System.out.print("Choose an option : ");
			int choice = sc.nextInt(); // Enter operation
			sc.nextLine(); // Consume newline

			// Switch will help to choose the operation

			switch (choice) {

			case 1:
				// input the title of the book
				System.out.print("Enter the book title : ");
				String title = sc.nextLine();
				// input the author of the book
				System.out.print("Enter the name of book author : ");
				String author = sc.nextLine();
				// create a new book
				Book newBook = new Book();
				newBook.setTitle(title);
				newBook.setAuthor(author);
				// Call the addBook function
				BookDAO.addBook(newBook);
				System.out.println("New Book added successfully!!!");
				break;

			case 2:
				// input the name of the member you want to add
				System.out.print("Enter name of the member : ");
				String name = sc.nextLine();
				// input the email of the member you want to add
				System.out.print("Enter email of the member : ");
				String email = sc.nextLine();

				// create a new member
				Member newMember = new Member();
				newMember.setName(name);
				newMember.setEmail(email);
				// call the function to register the new member
				MemberDAO.registerMember(newMember);
				System.out.println("Member registered successfully!!!");
				break;

			case 3:
				// input the book id you want to borrow
				System.out.print("Enter book ID to issue : ");
				int bookId = sc.nextInt();
				// input the member id who want to borrow the book
				System.out.print("Enter member ID : ");
				int memberId = sc.nextInt();

				// call the function to borrow the book
				LoanDAO.issueBook(bookId, memberId);
				break;

			case 4:
				// input the id of borrow
				System.out.print("Enter loan ID to return: ");
				int loanId = sc.nextInt();
				// call the function to return the book
				LoanDAO.returnBook(loanId);
				break;

			case 5:
				// Get the list of all the books
				List<Book> books = BookDAO.listBooks();
				System.out.println();
				books.forEach(System.out::println);
				break;

			case 6:
				// Get the list of all the members
				List<Member> members = MemberDAO.listMembers();
				System.out.println();
				members.forEach(System.out::println);
				break;

			case 7:
				// Get the list of all the borrowing statement
				List<Loan> loans = LoanDAO.listLoans();
				System.out.println();
				loans.forEach(System.out::println);
				break;

			case 8:
				// if User chose to be exited from the system
				System.out.println("Exited from the system...");
				sc.close();
				return;

			// In case of any other option taken rather than the above
			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}