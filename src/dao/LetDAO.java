package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Aerodrom;
import model.Let;

public class LetDAO {

	public static SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static List<Let> getAllLet() {

		Connection conn = ConnectionManager.getConnection();

		Statement stmt = null;
		ResultSet rset = null;

		List<Let> lets = new ArrayList<>();

		try {

			String query = "SELECT id , broj, datumPolaska, datumDolaska, polazniAerodrom, dolazniAerodrom, brojSedista, cenaKarte, izbrisan FROM let  WHERE izbrisan = 0";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				int broj = rset.getInt(index++);
				Timestamp datumPolaska = rset.getTimestamp(index++);
				Timestamp datumDolaska = rset.getTimestamp(index++);
				int polazniAerodrom = rset.getInt(index++);
				int dolazniAerodrom = rset.getInt(index++);
				int brojSedista = rset.getInt(index++);
				int cenaKarte = rset.getInt(index++);
				Boolean izbrisan = rset.getBoolean(index++);

				Aerodrom z = AerodromDAO.getAerodromById(polazniAerodrom);
				Aerodrom z1 = AerodromDAO.getAerodromById(dolazniAerodrom);

				Let let = new Let(id, broj, datumPolaska, datumDolaska, z, z1, brojSedista, cenaKarte, izbrisan);
				lets.add(let);
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
		return lets;
	}

	public static List<Let> getSortAsc() {

		Connection conn = ConnectionManager.getConnection();

		Statement stmt = null;
		ResultSet rset = null;

		List<Let> lets = new ArrayList<>();

		try {

			String query = "SELECT id , broj, datumPolaska, datumDolaska, polazniAerodrom, dolazniAerodrom, brojSedista, cenaKarte, izbrisan FROM let WHERE izbrisan = 0 ORDER BY broj ASC";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				int broj = rset.getInt(index++);
				Timestamp datumPolaska = rset.getTimestamp(index++);
				Timestamp datumDolaska = rset.getTimestamp(index++);
				int polazniAerodrom = rset.getInt(index++);
				int dolazniAerodrom = rset.getInt(index++);
				int brojSedista = rset.getInt(index++);
				int cenaKarte = rset.getInt(index++);
				Boolean izbrisan = rset.getBoolean(index++);

				Aerodrom z = AerodromDAO.getAerodromById(polazniAerodrom);
				Aerodrom z1 = AerodromDAO.getAerodromById(dolazniAerodrom);

				Let let = new Let(id, broj, datumPolaska, datumDolaska, z, z1, brojSedista, cenaKarte, izbrisan);
				lets.add(let);
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
		return lets;
	}

	public static List<Let> getSortDesc() {

		Connection conn = ConnectionManager.getConnection();

		Statement stmt = null;
		ResultSet rset = null;

		List<Let> lets = new ArrayList<>();

		try {

			String query = "SELECT id , broj, datumPolaska, datumDolaska, polazniAerodrom, dolazniAerodrom, brojSedista, cenaKarte , izbrisan FROM let WHERE izbrisan = 0  ORDER BY broj DESC";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				int broj = rset.getInt(index++);
				Timestamp datumPolaska = rset.getTimestamp(index++);
				Timestamp datumDolaska = rset.getTimestamp(index++);
				int polazniAerodrom = rset.getInt(index++);
				int dolazniAerodrom = rset.getInt(index++);
				int brojSedista = rset.getInt(index++);
				int cenaKarte = rset.getInt(index++);
				Boolean izbrisan = rset.getBoolean(index++);

				Aerodrom z = AerodromDAO.getAerodromById(polazniAerodrom);
				Aerodrom z1 = AerodromDAO.getAerodromById(dolazniAerodrom);

				Let let = new Let(id, broj, datumPolaska, datumDolaska, z, z1, brojSedista, cenaKarte, izbrisan);
				lets.add(let);
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
		return lets;
	}

	public static Let getLetById(int id) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {

			String query = "SELECT id , broj, datumPolaska, datumDolaska, polazniAerodrom, dolazniAerodrom, brojSedista, cenaKarte, izbrisan FROM let WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				int index = 1;
				int id1 = rset.getInt(index++);
				int broj = rset.getInt(index++);
				Timestamp datumPolaska = rset.getTimestamp(index++);
				Timestamp datumDolaska = rset.getTimestamp(index++);
				int polazniAerodrom = rset.getInt(index++);
				int dolazniAerodrom = rset.getInt(index++);
				int brojSedista = rset.getInt(index++);
				int cenaKarte = rset.getInt(index++);
				Boolean izbrisan = rset.getBoolean(index++);

				Aerodrom z = AerodromDAO.getAerodromById(polazniAerodrom);
				Aerodrom z1 = AerodromDAO.getAerodromById(dolazniAerodrom);
				return new Let(id1, broj, datumPolaska, datumDolaska, z, z1, brojSedista, cenaKarte, izbrisan);
			}

		} catch (Exception ex1) {
			// TODO: handle exception
			ex1.printStackTrace();
		}

		finally {
			// TODO: handle finally clause
			try {
				rset.close();
			} catch (Exception ex2) {
				// TODO: handle exception
				ex2.printStackTrace();
			}
		}
		return null;
	}

	public static Let getId(String id) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {

			String query = "SELECT id , broj, datumPolaska, datumDolaska, polazniAerodrom, dolazniAerodrom, brojSedista, cenaKarte,izbrisan FROM let WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				int index = 1;
				int id1 = rset.getInt(index++);
				int broj = rset.getInt(index++);
				Timestamp datumPolaska = rset.getTimestamp(index++);
				Timestamp datumDolaska = rset.getTimestamp(index++);
				int polazniAerodrom = rset.getInt(index++);
				int dolazniAerodrom = rset.getInt(index++);
				int brojSedista = rset.getInt(index++);
				int cenaKarte = rset.getInt(index++);
				Boolean izbrisan = rset.getBoolean(index++);

				Aerodrom z = AerodromDAO.getAerodromById(polazniAerodrom);
				Aerodrom z1 = AerodromDAO.getAerodromById(dolazniAerodrom);
				return new Let(id1, broj, datumPolaska, datumDolaska, z, z1, brojSedista, cenaKarte, izbrisan);
			}

		} catch (Exception ex1) {
			// TODO: handle exception
			ex1.printStackTrace();
		}

		finally {
			// TODO: handle finally clause
			try {
				rset.close();
			} catch (Exception ex2) {
				// TODO: handle exception
				ex2.printStackTrace();
			}
		}
		return null;
	}

	public static boolean update(Let let, int id) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {

			String query = "UPDATE let SET id=?, broj=?, datumPolaska=?, datumDolaska=?, polazniAerodrom=?, dolazniAerodrom=?, brojSedista=?, cenaKarte=? , izbrisan=? WHERE id=?";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, id);
			int index = 1;
			pstmt.setInt(index++, let.getId());
			pstmt.setInt(index++, let.getBroj());

			java.sql.Timestamp datumPolaska = new java.sql.Timestamp(let.getDatumPolaska().getTime());
			pstmt.setTimestamp(index++, datumPolaska);

			java.sql.Timestamp datumDolaska = new java.sql.Timestamp(let.getDatumDolaska().getTime());
			pstmt.setTimestamp(index++, datumDolaska);

			pstmt.setInt(index++, let.getPolazniAerodrom().getId());
			pstmt.setInt(index++, let.getDolazniAerodrom().getId());
			pstmt.setInt(index++, let.getBrojSedista());
			pstmt.setInt(index++, let.getCenaKarte());

			pstmt.setBoolean(index++, let.isIzbrisan());

			pstmt.setInt(index++, let.getId());
			System.out.println(pstmt);

			return pstmt.executeUpdate() == 1;
		} catch (Exception ex1) {
			// TODO: handle exception
			ex1.printStackTrace();
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

	public static boolean add(Let let) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;

		try {

			String query = "INSERT INTO let (id, broj,datumPolaska, datumDolaska,polazniAerodrom,dolazniAerodrom,brojSedista, cenaKarte,izbrisan) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(query);

			int index = 1;
			pstmt.setInt(index++, let.getId());
			pstmt.setInt(index++, let.getBroj());

			java.sql.Timestamp datumPolaska = new java.sql.Timestamp(let.getDatumPolaska().getTime());
			pstmt.setTimestamp(index++, datumPolaska);

			java.sql.Timestamp datumDolaska = new java.sql.Timestamp(let.getDatumDolaska().getTime());
			pstmt.setTimestamp(index++, datumDolaska);

			pstmt.setInt(index++, let.getPolazniAerodrom().getId());
			pstmt.setInt(index++, let.getDolazniAerodrom().getId());
			pstmt.setInt(index++, let.getBrojSedista());
			pstmt.setInt(index++, let.getCenaKarte());
			pstmt.setBoolean(index, let.isIzbrisan());
			return pstmt.executeUpdate() == 1;

		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return false;
	}

}
