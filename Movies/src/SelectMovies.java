import java.sql.*;

public class SelectMovies {

  public static void main( String args[] ) {

   Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:Movies.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM MOVIES;" );
      
      while ( rs.next() ) {
         String MovieID = rs.getString("MovieID");
         String  MovieTitle = rs.getString("MovieTitle");
         Date ReleaseDate = rs.getDate("ReleaseDate");
         String  Actor = rs.getString("Actor");
         String  Actress = rs.getString("Actress");
         String  Director = rs.getString("Director");
        
         
         System.out.println( "MovieID = " + MovieID );
         System.out.println( "MovieTitle = " + MovieTitle );
         System.out.println( "ReleaseDate = " + ReleaseDate );
         System.out.println( "Actor = " + Actor );
         System.out.println( "Actress = " + Actress );
         System.out.println( "Director = " + Director );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("Operation done successfully");
  }
}