import java.sql.*;

public class createMovies {

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Movies.db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE MOVIES " +
          "(MovieID varchar(10) NOT NULL PRIMARY KEY," +
         "MovieTitle varchar (30) NOT NULL,"+
        " ReleaseDate DATE NOT NULL,"+
        " Actor varchar(30) ,"+
        " Actress varchar(30)," +
         "Director varchar(30) )";
         
         
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
}