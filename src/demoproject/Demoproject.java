
package demo;
import java.sql.*;  
import javax.swing.JOptionPane;

 public class demoproject

    
    public static void main(String[] args) {
        System.out.print("hello\n");
        
        try
	{ 
 		//step1 load the driver class   
//		Class.forName("com.mysql.jdbc.Driver");    
                Class.forName("com.mysql.cj.jdbc.Driver"); 
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jam","root","passwordmahitnahi");  
  
		//step3 create the statement object  
		Statement stmt=con.createStatement();   

 		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from user"); 
                while(rs.next())   
		System.out.println(rs.getInt(1)+"  "+rs.getString(2));
                stmt.executeUpdate("INSERT INTO user(SrNO,name) "+"VALUES ('1','NADED')");
                 System.out.print("\n Affter\n");
                rs=stmt.executeQuery("select * from user");
 		while(rs.next())   
		System.out.println(rs.getInt(1)+"  "+rs.getString(2));    
                JOptionPane.showMessageDialog(null, "successfully inserted new Customer");
		//step5 close the connection object   
		con.close();    
	}
	catch(Exception e)
	{ 
		System.out.println(e);
	}    
    }
    
}
