package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Let;

import model.Rezervacije;
import model.User;

public class RezervacijeDAO {

	public static List<Rezervacije> getAllRezervacije() {

		Connection conn = ConnectionManager.getConnection();

		Statement stmt = null;
		ResultSet rset = null;

		List<Rezervacije> rezervacijes = new ArrayList<>();
		try {
			String query = "SELECT id, polazniLet,povratniLet,sedistePolazni,sedisteDolazni,datumRezervacije,datumProdajeKarte,user, imePutnika, prezimePutnika FROM Rezervacije1";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {

				int index = 1;
				int id = rset.getInt(index++);
				int polazniLet = rset.getInt(index++);
				int povratniLet = rset.getInt(index++);
				int sedistePolazni = rset.getInt(index++);
				int sedisteDolazni = rset.getInt(index++);
				String datumRezervacije = rset.getString(index++);
				String datumProdajeKarte = rset.getString(index++);
				int user = rset.getInt(index++);
				String imePutnika = rset.getString(index++);
				String prezimePutnika = rset.getString(index++);

				User u = UserDAO.getByUserId(user);
				Let letPolazni = LetDAO.getLetById(polazniLet);
				Let letPovratni = LetDAO.getLetById(povratniLet);

				Rezervacije rezervacije = new Rezervacije(id, letPolazni, letPovratni, sedistePolazni, sedisteDolazni,
						datumRezervacije, datumProdajeKarte, u, imePutnika, prezimePutnika);
				rezervacijes.add(rezervacije);
			}
		} catch (Exception ex1) {
			// TODO: handle exception

			ex1.printStackTrace();
		}

		finally {

			try {
				rset.close();
			} catch (Exception ex2) {
				// TODO: handle exception

				ex2.printStackTrace();
			}
		}
		return rezervacijes;
	}

	public static boolean Rezervacije(Rezervacije rezervacije) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;

		try {

			String query = "INSERT INTO rezervacije1(id, polazniLet, povratniLet,SedistePolazni,SedisteDolazni,datumRezervacije,datumProdajeKarte,user,imePutnika,prezimePutnika) VALUES(?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(query);

			int index = 1;
			pstmt.setInt(index++, rezervacije.getId());
			pstmt.setInt(index++, rezervacije.getPolazniLet().getId());
			pstmt.setInt(index++, rezervacije.getPovratniLet().getId());
			pstmt.setInt(index++, rezervacije.getSedistePolazni());
			pstmt.setInt(index++, rezervacije.getSedisteDolazni());
			pstmt.setString(index++, rezervacije.getDatumRezervacije());
			pstmt.setString(index++, rezervacije.getDatumProdajeKarte());
			pstmt.setInt(index++, rezervacije.getUser().getId());
			pstmt.setString(index++, rezervacije.getImePutnika());
			pstmt.setString(index++, rezervacije.getPrezimePutnika());

			return pstmt.executeUpdate() == 1;
		} catch (Exception ex1) {
			// TODO: handle exception
			ex1.printStackTrace();
		} finally {
			try {

			} catch (Exception ex2) {
				// TODO: handle exception
				ex2.printStackTrace();
			}
		}

		return false;

	}

	public static boolean Rezervacije1(Rezervacije rezervacije) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;

		try {

			String query = "INSERT INTO rezervacije1(id, polazniLet, povratniLet,SedistePolazni,SedisteDolazni,datumRezervacije,datumProdajeKarte,user,imePutnika,prezimePutnika) VALUES(?,?,null,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(query);

			int index = 1;
			pstmt.setInt(index++, rezervacije.getId());
			pstmt.setInt(index++, rezervacije.getPolazniLet().getId());
			pstmt.setInt(index++, rezervacije.getSedistePolazni());
			pstmt.setInt(index++, rezervacije.getSedisteDolazni());
			pstmt.setString(index++, rezervacije.getDatumRezervacije());
			pstmt.setString(index++, rezervacije.getDatumProdajeKarte());
			pstmt.setInt(index++, rezervacije.getUser().getId());
			pstmt.setString(index++, rezervacije.getImePutnika());
			pstmt.setString(index++, rezervacije.getPrezimePutnika());

			return pstmt.executeUpdate() == 1;
		} catch (Exception ex1) {
			// TODO: handle exception
			ex1.printStackTrace();
		} finally {
			try {

			} catch (Exception ex2) {
				// TODO: handle exception
				ex2.printStackTrace();
			}
		}

		return false;

	}

	public static boolean delete(int letInt) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			String query = "DELETE FROM let WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, letInt);

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

	public static List<Rezervacije> getByRezervacijeId(int id) {

		List<Rezervacije> rezervacijeById = new ArrayList<>();

		System.out.println("provera broj 1");
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {

			String query = "SELECT id, polazniLet,povratniLet,sedistePolazni,sedisteDolazni,datumRezervacije,datumProdajeKarte,user, imePutnika, prezimePutnika FROM rezervacije1 WHERE user =?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				int index = 1;
				int id1 = rset.getInt(index++);
				int polazniLet = rset.getInt(index++);
				int povratniLet = rset.getInt(index++);
				int sedistePolazni = rset.getInt(index++);
				int sedisteDolazni = rset.getInt(index++);
				String datumRezervacije = rset.getString(index++);
				String datumProdajeKarte = rset.getString(index++);
				int user = rset.getInt(index++);
				String imePutnika = rset.getString(index++);
				String prezimePutnika = rset.getString(index++);

				User u = UserDAO.getByUserId(user);
				Let letPolazni = LetDAO.getLetById(polazniLet);
				Let letPovratni = LetDAO.getLetById(povratniLet);

				Rezervacije rezervacijeId = new Rezervacije(id1, letPolazni, letPovratni, sedistePolazni,
						sedisteDolazni, datumRezervacije, datumProdajeKarte, u, imePutnika, prezimePutnika);
				rezervacijeById.add(rezervacijeId);

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

		return rezervacijeById;
	}

	public static Rezervacije getByRezervacijeRacunId(int id) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {

			String query = "SELECT id, polazniLet,povratniLet,sedistePolazni,sedisteDolazni,datumRezervacije,datumProdajeKarte,user, imePutnika, prezimePutnika FROM rezervacije1 WHERE id =?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				int index = 1;
				int id1 = rset.getInt(index++);
				int polazniLet = rset.getInt(index++);
				int povratniLet = rset.getInt(index++);
				int sedistePolazni = rset.getInt(index++);
				int sedisteDolazni = rset.getInt(index++);
				String datumRezervacije = rset.getString(index++);
				String datumProdajeKarte = rset.getString(index++);
				int user = rset.getInt(index++);
				String imePutnika = rset.getString(index++);
				String prezimePutnika = rset.getString(index++);

				User u = UserDAO.getByUserId(user);
				Let letPolazni = LetDAO.getLetById(polazniLet);
				Let letPovratni = LetDAO.getLetById(povratniLet);

				return new Rezervacije(id1, letPolazni, letPovratni, sedistePolazni, sedisteDolazni, datumRezervacije,
						datumProdajeKarte, u, imePutnika, prezimePutnika);

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

}
