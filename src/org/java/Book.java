package org.java;

public class Book {
	
	private String title;
	private int pages;
	private String author;
	private String editor;
	
	public Book(String title, int pages, String author, String editor) throws Exception {
		setTitle(title);
		setPages(pages);
		setAuthor(author);
		setEditor(editor);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws Exception {
		if (title == null || title.isEmpty() || title.length() < 1) {			
			throw new TitleException("Title field must not be empty.");
		}
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) throws Exception {
		if (pages < 1) {			
			throw new PagesException("Number of pages must be greater than 0.");
		}
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) throws Exception {
		if (author == null || author.isEmpty() || author.length() < 1) {
			throw new AuthorException("Author field must not be empty.");
		} 
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) throws Exception {
		if (editor == null || editor.isEmpty() || editor.length() < 1) {
			throw new EditorException("Editor field must not be empty.");
		}
		this.editor = editor;
	}
	
	@Override
	public String toString() {
		return "Title: " + getTitle() + '\n' +
				"Pages: " + getPages() + '\n' +
				"Author: " + getAuthor() + '\n' +
				"Editor: " + getEditor() + '\n';
	}
}
