package jdbc.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/JDBC";
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "postgres", "postgres");
			stmt = conn.createStatement();
			stmt.executeUpdate("DROP TABLE if exists book CASCADE");
			stmt.executeUpdate("DROP TABLE if exists client CASCADE");
			stmt.executeUpdate("DROP TABLE if exists achat CASCADE");
			stmt.executeUpdate("CREATE TABLE book(id serial PRIMARY KEY, " + "title varchar(200) not null, "
					+ "author varchar(100))");

			stmt.executeUpdate("CREATE TABLE client(id serial PRIMARY KEY, " + "lastname varchar(100) not null, "
					+ "firstname varchar(100), " + "gender varchar(1), " + "id_book integer, "
					+ "constraint fk_id_client FOREIGN KEY (id_book) references book(id))");

			stmt.executeUpdate(
					"CREATE TABLE achat(id_client Integer, id_book Integer, constraint fk_id_achat FOREIGN KEY (id_book) references book(id), constraint fk_id_achat2 FOREIGN KEY (id_client) references client(id))");

//Creation d'un book
			Book bk1 = new Book("Dragon Ball", "Akira Toriyama");
			Book bk2 = new Book("Dôme", "Stephen King");
			Book bk3 = new Book("Star Wars", "Georgio");

//Appel méthode	addBook
			Service.addBook(conn, bk1);
			Service.addBook(conn, bk2);
			Service.addBook(conn, bk3);

//Creation d'un client
			Client c1 = new Client("Montet", "Benjamin", "M", 1);
			Client c2 = new Client("Maurice", "Mauricette", "F", 2);
			Client c3 = new Client("René", "Coty", "M", 3);

//Appel méthode addClient
			Service.addClient(conn, c1);
			Service.addClient(conn, c2);
			Service.addClient(conn, c3);

//Achat Client_Book
			Service.addAchat(conn, c1, bk1);
			Service.addAchat(conn, c2, bk2);
			Service.addAchat(conn, c3, bk3);

//Livres achetés par un certain client
			Service.achatClients(conn, c1);
			Service.achatClients(conn, c2);
			Service.achatClients(conn, c3);

//Quel client ont acheté un certain livre
			Service.acheteur(conn, c1);
			Service.acheteur(conn, c2);
			Service.acheteur(conn, c3);

		} catch (Exception e) {
			logger.error("an exception has been thrown" + e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}

}
