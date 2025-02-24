package com.entity;

import java.text.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BookDAO dao = new BookDAO();
		Book b;
		
		while(true) {
			System.out.println("\n---------Book Management---------");
			System.out.print("\n1.Add Book\n2.Retrieve books\n3.Retrieve book by name\n4.Update Book by Id\n5.Delete book by Id\n6.Exit\nYour choice:");
			int ch = sc.nextInt(); sc.nextLine();
			List<Book> list;
			
			switch(ch) {
				case 1:
					b = new Book();
					System.out.print("\nEnter name: ");
					b.setBname(sc.nextLine());
					System.out.print("Enter publisher name: ");
					b.setPublisher_name(sc.next());
					String dateFormat = "yyyy-MM-dd";
			        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			        System.out.print("Enter published date (" + dateFormat + "): ");
			        String inputDate = sc.next();
			        try {
			            b.setPublished_date(sdf.parse(inputDate));;
			        } catch (ParseException e) {
			            System.out.println("Invalid date format. Please use the format: " + dateFormat);
			        }
			        System.out.print("Enter author: ");
			        b.setAuthor(sc.next());
			        System.out.print("Enter price: ");
			        b.setPrice(sc.nextFloat());
			        System.out.print("Enter edition: ");
			        b.setEdition(sc.nextInt());
			        dao.addBook(b);
			        break;
				case 2:
					list = dao.retrieveBook();
					if(!list.isEmpty())
						for(Book bb: list)
							System.out.println(bb.toString());
					else
						System.out.println("No books available");
					break;
				case 3:
					System.out.print("Enter book name to be retrived: ");
					list = dao.retrieveBook(sc.next());
					if(!list.isEmpty())
						for(Book bb: list)
							System.out.println(bb.toString());
					else
						System.out.println("No such book available");
					break;
				case 4:
					b = new Book();
                    System.out.print("Enter book ID to update: ");
                    b.setBid(sc.nextInt()); sc.nextLine();
                    System.out.print("Enter new name: ");
                    b.setBname(sc.nextLine());
                    System.out.print("Enter new publisher name: ");
                    b.setPublisher_name(sc.nextLine());
                    System.out.print("Enter new author: ");
                    b.setAuthor(sc.nextLine());
                    System.out.print("Enter new price: ");
                    b.setPrice(sc.nextFloat());
                    System.out.print("Enter new edition: ");
                    b.setEdition(sc.nextInt());
                    String newDateFormat = "yyyy-MM-dd";
                    SimpleDateFormat newSdf = new SimpleDateFormat(newDateFormat);
                    System.out.print("Enter new published date (" + newDateFormat + "): ");
                    String newInputDate = sc.next();
                    try {
                        b.setPublished_date(newSdf.parse(newInputDate));
                        dao.updateBook(b);
                        System.out.println("\nBook updated successfully!");
                    } catch (ParseException e) {
                        System.out.println("\nInvalid date format. Please use the format: " + newDateFormat);
                    }
                    break;

                case 5:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = sc.nextInt(); sc.nextLine();
                    dao.deleteBook(deleteId);
                    System.out.println("Book deleted successfully!");
                    break;
				case 6:
					System.out.println("\nExiting.......");
					sc.close();
					break;
				default:
					System.out.println("Enter a valid choice..\n");
			}
		}
	}

}
