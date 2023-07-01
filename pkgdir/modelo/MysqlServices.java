package pkgdir.modelo;

import com.mysql.cj.jdbc.Driver; 
import java.sql.*; 

public class MysqlServices{  
	public MysqlServices(){  
	}  

	public String getDataFromMysql(){
		String stmp = "";
		try{  
			System.out.println("Into MysqlServices class");
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mintic?useSSL=false","rafael","Mysqlpsql43*");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from reservation");  
			int tmp1 = 0;
			String tmp2 = "";
			String tmp3 = 	"";
			String tmp4 = 	"";
			int tmp5 = 	0;
			int tmp6 = 	0;	
			while(rs.next())  {
				tmp1 = rs.getInt(1);
				tmp2 = rs.getString(2);
				tmp3 = rs.getString(3);
				tmp4 = rs.getString(4);
				tmp5 = rs.getInt(5);
				tmp6 = rs.getInt(6);	
				System.out.println( tmp1+" "+tmp2+" "+tmp3+" "+tmp4+" "+tmp5+" "+tmp6 );  
				stmp += tmp1+" "+tmp2+" "+tmp3+" "+tmp4+" "+tmp5+" "+tmp6+"\n";
			}
			con.close();  
		}catch(Exception e){ 
			e.printStackTrace();
		}
		return stmp;
	}
	
	
}  
