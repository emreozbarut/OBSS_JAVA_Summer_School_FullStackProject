package tr.com.obss.model;

public class Author {
	private int authorID;
	private String name;
	private String surname;

	public Author() {

	}

	public Author(int authorID, String name, String surname) {
		super();
		this.authorID = authorID;
		this.name = name;
		this.surname = surname;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", name=" + name + ", surname=" + surname + "]";
	}

}
