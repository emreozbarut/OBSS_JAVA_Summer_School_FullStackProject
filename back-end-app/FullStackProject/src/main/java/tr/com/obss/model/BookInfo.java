package tr.com.obss.model;

public class BookInfo {
	private int bookID;
	private String title;
	private String publishDate;
	private String updateDate;
	private String insertDate;
	private String insertedBy;

	public BookInfo() {

	}

	public BookInfo(int bookID, String title, String publishDate, String updateDate, String insertDate,
			String insertedBy) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
		this.insertDate = insertDate;
		this.insertedBy = insertedBy;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	@Override
	public String toString() {
		return "BookInfo [bookID=" + bookID + ", title=" + title + ", publishDate=" + publishDate + ", updateDate="
				+ updateDate + ", insertDate=" + insertDate + ", insertedBy=" + insertedBy + "]";
	}
	
}
