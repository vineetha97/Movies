import java.sql.*;

public class InsertMovies {

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Movies.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                        "VALUES ('M01', 'Taare Zameen Par', '2007-12-21','Darsheel Safary',NULL,'Aamir Khan' );"; 
         stmt.executeUpdate(sql);
         
         sql = "INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M02', 'Deadpool', '2016-02-12',	'Ryan Reynolds',NULL,'Tim Miller' );"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M03', 'Furious 7', '2015-04-03', 'Vin Diesel','Jordana Brewster','James Wan');"; 
         stmt.executeUpdate(sql);

         sql ="INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M04', 'PK', '2014-12-19', 'Rajkumar Hirani', 'Amir Khan', 'Anushka Sharma' );"; 
         stmt.executeUpdate(sql);
         sql ="INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M05', 'Gladiator', '2000-05-05','Russell Crowe','Connie Nielsen', 'Ridley Scott');"; 
         stmt.executeUpdate(sql);
         sql ="INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M06', 'The Hangover', '2009-06-05','Bradley Cooper',' Heather Graham','Todd Phillips');"; 
         stmt.executeUpdate(sql);
         sql ="INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M07', '3 Idiots', '2009-12-25','Amir Khan', 'Kareena Kapoor', 'Rajkumar Hirani');"; 
         stmt.executeUpdate(sql);
         sql ="INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M08', 'Spectre', '2015-11-06','Daniel Craig', 'Léa Seydoux','Sam Mendes');"; 
         stmt.executeUpdate(sql);
         sql ="INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M09', 'Batman Begins', '2005-06-15','Christian Bale', 'Katie Holmes',  'Christopher Nolan');"; 
         stmt.executeUpdate(sql);
         sql ="INSERT INTO MOVIES (MovieID,MovieTitle,ReleaseDate,Actor,Actress,Director) " +
                 "VALUES ('M10', 'The Dark Knight', '2008-07-18', 'Christian Bale', 'Maggie Gyllenhaal', 'Christopher Nolan' );"; 
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}