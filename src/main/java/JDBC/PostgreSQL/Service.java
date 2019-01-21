package jdbc.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {
	private Service() {

	}

	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	public static void addBook(Connection conn, Book bk) throws SQLException {

		PreparedStatement insert1;
		try {
			insert1 = conn.prepareStatement("INSERT INTO book(title, author) VALUES(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			insert1.setString(1, bk.getTitle());
			insert1.setString(2, bk.getAuthor());
			insert1.executeUpdate();
			ResultSet generatedKeys = insert1.getGeneratedKeys();
			generatedKeys.next();
			bk.setId(generatedKeys.getInt("id"));
			insert1.close();

		} catch (SQLException e) {
			logger.error("an exception has been thrown" + e);
		}

	}

	public static void addClient(Connection conn, Client c) throws SQLException {
		PreparedStatement insert2;
		try {
			insert2 = conn.prepareStatement(
					"INSERT INTO client(lastname, firstname, gender, id_book) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			insert2.setString(1, c.getLastname());
			insert2.setString(2, c.getFirstname());
			insert2.setString(3, c.getGender());
			insert2.setInt(4, c.getidLivrePref());
			insert2.executeUpdate();
			ResultSet generatedKeys = insert2.getGeneratedKeys();
			generatedKeys.next();
			c.setId(generatedKeys.getInt("id"));
			insert2.close();

		} catch (SQLException e) {
			logger.error("an exception has been thrown" + e);
		}

	}

	public static void addAchat(Connection conn, Client c, Book bk) {
		PreparedStatement insert3;
		try {
			insert3 = conn.prepareStatement("INSERT INTO achat(id_client, id_book) VALUES (?, ?)");
			insert3.setInt(1, c.getId());
			insert3.setInt(2, bk.getId());
			insert3.executeUpdate();

		} catch (SQLException e) {
			logger.error("an exception has been thrown" + e);
		}

	}

	public static void achatClients(Connection conn, Client c) {
		PreparedStatement insert4;

		try {
			insert4 = conn.prepareStatement(
					"Select title, author from book join achat on book.id = achat.id_book join client on achat.id_client = client.id where client.id ="
							+ c.getId());
			ResultSet resultSet = insert4.executeQuery();
			logger.info(c.getFirstname());
			while (resultSet.next()) {
			logger.info(resultSet.getString("title") + " " + resultSet.getString("author"));

			}

			insert4.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void acheteur(Connection conn, Client c) {
		PreparedStatement insert5;

		try {
			insert5 = conn.prepareStatement(
					"Select distinct firstname, lastname from client join achat on client.id = achat.id_book");
			ResultSet resultSet = insert5.executeQuery();
			logger.info(c.getFirstname());
			while (resultSet.next()) {
				System.out.println(resultSet.getString("firstname") + " " + resultSet.getString("lastname"));

			}
			insert5.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
