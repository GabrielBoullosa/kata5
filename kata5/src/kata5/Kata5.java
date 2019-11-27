package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Kata5 {

    public static void main(String[] args) {
        String URL_BD = new String("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\kata5");
        Connection connection = connect(URL_BD);
    }

    private static Connection connect(String URL_BD) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL_BD);
            System.out.println("Se ha conectado a la base de datos con exito.");
            
        }catch(SQLException ex){
            System.out.print("ERROR kata5 " + ex.getMessage());
        }
        finally{
            try{
                if(connection != null) connection.close();
            }catch(SQLException ex){
                System.out.print("ERROR kata5 " + ex.getMessage());   
            }
        }
        return connection;
        }
        
    
    
}
