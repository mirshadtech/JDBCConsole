package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class UpdateApp {

	public static void updateOperation() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		try {
			connection = JdbcUtil.getJdbcConnection();
			String query = "select id,name,age,address from jdbc where id =?";
			String query2 = "UPDATE  jdbc set name=?,age=?,address=? where id=?";
			if (connection != null) {
				pstmt = connection.prepareStatement(query);
				pstmt2 = connection.prepareStatement(query2);
			}
			if (pstmt != null) {
				System.out.println("Enter the ID::");
				int id = sc.nextInt();
				pstmt.setInt(1, id);
				resultSet = pstmt.executeQuery();
				if (resultSet != null) {

					if (resultSet.next()) {
						System.out.println("ID" + "\t" + "NAME" + "\t" + "AGE" + "\t" + "Address" + "\t");
						System.out.println(resultSet.getInt(1) + "	" + resultSet.getString(2) + "	"
								+ resultSet.getString(3) + "	" + resultSet.getString(4));
						System.out.println();
						if (pstmt2 != null) {
							System.out.println("Enter the New Name::");
							String name = sc.next();
							System.out.println("Enter the New Age::");
							String age = sc.next();
							System.out.println("Enter the New Address::");
							String address = sc.next();
							pstmt2.setString(1, name);
							pstmt2.setString(2, age);
							pstmt2.setString(3, address);
							pstmt2.setInt(4, id);
							int rowAffected = pstmt2.executeUpdate();
							// System.out.println("Number of row affected:: " + rowAffected);
							if (rowAffected != 0) {
								System.out.println("Data Updated Successully");
							} else {
								System.out.println("Insertion Failed");
							}

						}
					} else {
						System.out.println("Result not Found....");
					}
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
