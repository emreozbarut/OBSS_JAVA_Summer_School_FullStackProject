package tr.com.obss.model;

public class Book {
	private int bookID;
	private int authorID;
	
	public Book(){
		
	}
	public Book(int bookID, int authorID) {
		super();
		this.bookID = bookID;
		this.authorID = authorID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", authorID=" + authorID + "]";
	}
	
}
