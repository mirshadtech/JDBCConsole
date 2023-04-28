package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class DeleteApp {
	public static void UpdateStatement() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		try {
			connection = JdbcUtil.getJdbcConnection();
			String query = "DELETE from jdbc where id=?";
			if (connection != null) {
				pstmt = connection.prepareStatement(query);
			}
			if (pstmt != null) {
				System.out.println("Enter the ID::");
				int id = sc.nextInt();
				
				pstmt.setInt(1, id);
				
				int rowAffected = pstmt.executeUpdate();
				// System.out.println("Number of row affected:: " + rowAffected);
				if (rowAffected != 0) {
					System.out.println("Data Deleted Successully");
				} else {
					System.out.println("Deletion Failed");
				}
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
				// System.out.println("closing the resources...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
}
