package org.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static final File MY_FILE = new File("./bookList.txt");

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many books you want to add?\n");
		int booksNumber = Integer.valueOf(in.nextLine());
		
		Book[] books = new Book[booksNumber];
		
		for (int i = 0; i < booksNumber; i++) {
			System.out.println("\nBOOK " + (i + 1));
			
			System.out.println("Title: ");
			String title = in.nextLine();
			
			System.out.println("Number of pages: ");
			int pages = Integer.valueOf(in.nextLine());
			
			System.out.println("Author: ");
			String author = in.nextLine();
			
			System.out.println("Editor: ");
			String editor = in.nextLine();
						
			try {
				books[i] = new Book(title, pages, author, editor);
				// System.out.println(books[i]);
				// System.out.println("\n----------------\n");
			} catch (TitleException e) {
				System.out.println("Title Error: " + e.getMessage());
			} catch (PagesException e) {
				System.out.println("Pages Error: " + e.getMessage());
			} catch (AuthorException e) {
				System.out.println("Author Error: " + e.getMessage());
			} catch (EditorException e) {
				System.out.println("Editor Error: " + e.getMessage());
			}
		}
		
		
		// Scrivo libri sul file
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(MY_FILE);
			
			for (int i = 0; i < books.length; i++) {
				String strBook = books[i].toString();
				myWriter.write(strBook + '\n');
			}
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		} finally {
			if (myWriter != null)
				try {
					myWriter.close();
				} catch (IOException e) { }
		}
		
		
		// Leggo libri dal file
		Scanner myReader = null;
		try {
			myReader = new Scanner(MY_FILE);
			
			while (myReader.hasNextLine()) {
				System.out.println(myReader.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file: " + e.getMessage());
		} finally {
			if (myReader != null)
				myReader.close();
		}
		
		in.close();
	}
}
