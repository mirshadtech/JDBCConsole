package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class InsertApp {

	public static void UpdateStatement() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		try {
			connection = JdbcUtil.getJdbcConnection();
			String query = "INSERT into jdbc (`id`,`name`,`age`,`address`) VALUE(?,?,?,?)";
			if (connection != null) {
				pstmt = connection.prepareStatement(query);
			}
			if (pstmt != null) {
				System.out.println("Enter the ID::");
				int id = sc.nextInt();
				System.out.println("Enter the Name::");
				String name = sc.next();
				System.out.println("Enter the Age::");
				String age = sc.next();
				System.out.println("Enter the Address::");
				String address = sc.next();
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, age);
				pstmt.setString(4, address);
				int rowAffected = pstmt.executeUpdate();
				// System.out.println("Number of row affected:: " + rowAffected);
				if (rowAffected != 0) {
					System.out.println("Data Inserted Successully");
				} else {
					System.out.println("Insertion Failed");
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
