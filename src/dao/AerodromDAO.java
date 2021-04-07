package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Aerodrom;

public class AerodromDAO {

	public static List<Aerodrom> getAllAeordrom() {

		List<Aerodrom> aerodroms = new ArrayList<>();

		Connection conn = ConnectionManager.getConnection();

		Statement stmt = null;
		ResultSet rset = null;

		try {

			String query = "SELECT id, naziv FROM aerodromi";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {

				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);

				Aerodrom aerodrom = new Aerodrom(id, naziv);
				aerodroms.add(aerodrom);

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
		return aerodroms;
	}

	public static Aerodrom getAerodromById(int id) {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {

			String query = "SELECT id, naziv FROM aerodromi WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				int index = 1;
				int id1 = rset.getInt(index++);
				String naziv = rset.getString(index++);

				return new Aerodrom(id1, naziv);

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
