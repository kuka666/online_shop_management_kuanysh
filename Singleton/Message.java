package Singleton;

import java.sql.*;
import java.util.Scanner;

public class Message {
    private static Message jdbc;

    //JDBCSingleton prevents the instantiation from any other class.
    private Message() {  }

    //Now we are providing gloabal point of access.
    public static Message getInstance() {
        if (jdbc == null) {
            jdbc = new Message();
        }
        return jdbc;
    }

    private static Connection getConnection()throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        return con;
    }

    public  void view(String email, String password) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con=this.getConnection();
            ps=con.prepareStatement("select * from customer where email=? and password=?");
            ((PreparedStatement) ps).setString(1, email);
            ((PreparedStatement) ps).setString(2, password);
            rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println("You have entered successfully, "+rs.getString("email"));
            }
        } catch (Exception e) { System.out.println(e);}
        finally{
            if(rs!=null){
                rs.close();
            }if (ps!=null){
                ps.close();
            }if(con!=null){
                con.close();
            }
        }
    }
}