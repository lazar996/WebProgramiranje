package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.User.Role;;

public class UserDAO {

	public static List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		Connection conn = ConnectionManager.getConnection();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT id,username, password, datumRegistracije,role,blokiran FROM users";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String username = rset.getString(index++);
				String password = rset.getString(index++);
				String datumRegistracije = rset.getString(index++);
				Role role = Role.valueOf(rset.getString(index++));
				Boolean blokiran = rset.getBoolean(index++);

				User user = new User(id, username, password, datumRegistracije, role, blokiran);
				users.add(user);

			}
		}

		catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		}

		return users;
	}

	public static List<User> getAsc() {

		List<User> users = new ArrayList<>();

		Connection conn = ConnectionManager.getConnection();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT id,username, password, datumRegistracije,role,blokiran FROM users ORDER BY username ASC";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String username = rset.getString(index++);
				String password = rset.getString(index++);
				String datumRegistracije = rset.getString(index++);
				Role role = Role.valueOf(rset.getString(index++));
				Boolean blokiran = rset.getBoolean(index++);

				User user = new User(id, username, password, datumRegistracije, role, blokiran);
				users.add(user);

			}
		}

		catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		}

		return users;
	}

	public static List<User> getDesc() {

		List<User> users = new ArrayList<>();

		Connection conn = ConnectionManager.getConnection();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT id,username, password, datumRegistracije,role,blokiran FROM users ORDER BY username DESC";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String username = rset.getString(index++);
				String password = rset.getString(index++);
				String datumRegistracije = rset.getString(index++);
				Role role = Role.valueOf(rset.getString(index++));
				Boolean blokiran = rset.getBoolean(index++);

				User user = new User(id, username, password, datumRegistracije, role, blokiran);
				users.add(user);

			}
		}

		catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		}

		return users;
	}

	public static User get(String username) {

		Connection conn = ConnectionManager.getConnection();
		

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {

			String query = "SELECT id,password,datumRegistracije,role,blokiran FROM users WHERE username = ?";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, username);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String password = rset.getString(index++);
				String datumRegistracije = rset.getString(index++);
				Role role = Role.valueOf(rset.getString(index++));
				Boolean blokiran = rset.getBoolean(index++);
				try {

				} catch (Exception ex) {
				}

				return new User(id, username, password, datumRegistracije, role, blokiran);

			}
		} catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
			try {
				rset.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
		return null;
	}

	public static boolean add(User user) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;

		try {

			String query = "INSERT INTO users (id, username, password, datumRegistracije,role, blokiran )"
					+ "VALUES (?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(query);

			int index = 1;
			pstmt.setInt(index++, user.getId());
			pstmt.setString(index++, user.getUsername());
			pstmt.setString(index++, user.getPassword());
			pstmt.setString(index++, user.getDatumRegistracije());
			pstmt.setString(index++, user.getRole().toString());
			pstmt.setBoolean(index++, user.isBlokiran());

			return pstmt.executeUpdate() == 1;

		} catch (Exception ex1) {
			// TODO: handle exception
			ex1.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex2) {
				// TODO: handle exception
				ex2.printStackTrace();
			}
		}

		return false;
	}

	public static User getByUserId(int id) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {

			String query = "SELECT id,username, password,datumRegistracije,role,blokiran FROM users WHERE id=?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				int index = 1;
				int id1 = rset.getInt(index++);
				String username = rset.getString(index++);
				String password = rset.getString(index++);
				String datumRegistracije = rset.getString(index++);
				Role role = Role.valueOf(rset.getString(index++));
				Boolean blokiran = rset.getBoolean(index++);

				return new User(id1, username, password, datumRegistracije, role, blokiran);

			}
		} catch (Exception ex1) {
			// TODO: handle exception

			ex1.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (Exception ex2) {
				// TODO: handle exception
				ex2.printStackTrace();
			}
		}
		return null;
	}

	public static boolean update(User user, int id) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {

			String query = " UPDATE web.users SET id =? , username=?, password=?, datumRegistracije=?, role= ?, blokiran=? WHERE id= ?";

			pstmt = conn.prepareStatement(query);

			System.out.println(query);
			pstmt.setInt(1, id);
			int index = 1;

			pstmt.setInt(index++, user.getId());
			pstmt.setString(index++, user.getUsername());
			pstmt.setString(index++, user.getPassword());
			pstmt.setString(index++, user.getDatumRegistracije());
			pstmt.setString(index++, user.getRole().toString());
			pstmt.setBoolean(index++, user.isBlokiran());
			pstmt.setInt(index++, user.getId());
			System.out.println(pstmt);
			return pstmt.executeUpdate() == 1;

		} catch (Exception ex1) {
			ex1.printStackTrace();
			// TODO: handle exception
		} finally {
			try {

				pstmt.close();
			} catch (Exception ex2) {
				// TODO: handle exception
				ex2.printStackTrace();
			}
		}
		return false;

	}

	public static boolean delete(int id) {

		Connection conn = ConnectionManager.getConnection();
	
		PreparedStatement pstmt = null;
		try {
			String query = "DELETE FROM users WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setInt(index++, id);

			return pstmt.executeUpdate() == 1;

		} catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		}
		return false;
	}
}
