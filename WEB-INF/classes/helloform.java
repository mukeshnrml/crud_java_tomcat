import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class helloform extends
 HttpServlet{
  public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{ response.setContentType("text/html");
  PrintWriter pw = response.getWriter();
  String connectionURL = "jdbc:mysql://localhost/ddn";
  Connection connection;
  try{
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  pw.println(username);
  pw.println(password);
  Class.forName("com.mysql.cj.jdbc.Driver");
  connection = DriverManager.getConnection (connectionURL, "root", "");
  PreparedStatement pst = connection.prepareStatement
  ("insert into rebel values(?,?)");
  pst.setString(1,username);
  pst.setString(2,password);
  int i = pst.executeUpdate();
  if(i!=0){
  pw.println("<br>Record has been inserted");
  }
  else{
  pw.println("failed to insert the data");
  }
  }
  catch (Exception e){
  pw.println(e);
  }
  }
}