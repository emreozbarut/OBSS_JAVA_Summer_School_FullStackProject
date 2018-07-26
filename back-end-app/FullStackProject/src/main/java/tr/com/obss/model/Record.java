package tr.com.obss.model;

public class Record {
	private int userID;
	private int bookID;
	
	public Record(){
		
	}
	public Record(int userID, int bookID) {
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
		return "Record [userID=" + userID + ", bookID=" + bookID + "]";
	}
}
