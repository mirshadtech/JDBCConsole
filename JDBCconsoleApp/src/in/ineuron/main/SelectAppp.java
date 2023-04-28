package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class SelectAppp {

	
	public static void selectOperation() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlSelectQuery = "select id,name,age,address from jdbc where id =?";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null)
				System.out.println("Enter the Id ::");
			int id = sc.nextInt();
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			//System.out.println(resultSet);

			if (resultSet != null) {

				if (resultSet.next()) {
					System.out.println("ID"+"\t"+"NAME"+"\t"+"AGE"+"\t"+"Address"+"\t");
					System.out.println(resultSet.getInt(1) + "	" + resultSet.getString(2) + "	"
							+ resultSet.getString(3) + "	" + resultSet.getString(4));
					System.out.println();
				}
				else {
					System.out.println("Result not Available....");
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
				//System.out.println("closing the resources...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
