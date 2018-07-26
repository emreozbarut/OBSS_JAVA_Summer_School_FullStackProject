package tr.com.obss.model;

public class Favorite {
	private int userID;
	private int bookID;
	
	public Favorite(){
		
	}
	public Favorite(int userID, int bookID) {
		super();
		this.userID = userID;
		this.bookID = bookID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	@Override
	public String toString() {
		return "Favorite [userID=" + userID + ", bookID=" + bookID + "]";
	}
	
}
