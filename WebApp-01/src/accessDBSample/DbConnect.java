package accessDBSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * データベース接続クラス
 * Run as -> Java Application
 */

public class DbConnect {
	public static void main(String[] args){
		Connection con = null;
		
		try{
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			
			//データベースと接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample",
					"root",
					"db4editor");
			
			//接続しているデータベースを表示
			System.out.println(con.getCatalog());
			
		}catch(ClassNotFoundException ce){
			
			//JDBCドライバが見つからなかった場合
			ce.printStackTrace();
			
		}catch(SQLException se){
			//データベースと接続に失敗した場合
			se.printStackTrace();
			
		}finally{
			try {
				//データベースとの接続を解除
				if(con != null){
					con.close();
				}
			}catch (SQLException se){
				//データベースとの接続解除に失敗した場合
				se.printStackTrace();
			}
		}
	}
}
