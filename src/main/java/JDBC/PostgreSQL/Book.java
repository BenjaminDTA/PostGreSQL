package JDBC.PostgreSQL;

public class Book {
	private Integer id;
	private String Title;
	private String Author;
	
	

	public Book(String title, String author) {
		super();
		Title = title;
		Author = author;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	
	
}
