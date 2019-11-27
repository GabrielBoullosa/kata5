package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) {
        String URL_BD = new String("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\kata5\\kata5.db");
        Connection connection = connect(URL_BD);
        createNewTable();
    }

    private static Connection connect(String URL_BD) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL_BD);
            System.out.println("Se ha conectado a la base de datos con exito.");
            ShowTableData(connection);
            
        }catch(SQLException ex){
            System.out.println("ERROR kata5 " + ex.getMessage());
        }
        finally{
            try{
                if(connection != null) connection.close();
            }catch(SQLException ex){
                System.out.println("ERROR kata5 " + ex.getMessage());   
            }
        }
        return connection;
        }

    private static void ShowTableData(Connection connection) {
        String SQL_Sentence = "SELECT * FROM PEOPLE";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL_Sentence);
            System.out.println("Id \t Name \t Apellidos \t Departamento");
            while(resultset.next()){
                System.out.println(resultset.getInt("Id") + " \t " +
                        resultset.getString("Name") + " \t " +
                        resultset.getString("Apellidos") + " \t " +
                        resultset.getString("Departamento"));
            }
        }catch(SQLException ex){
            System.out.print("ERROR kata5 " + ex.getMessage());
        }
    }

    private static void createNewTable() {
        String url = "jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\kata5\\kata5.db";
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n" +
                "id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "direccion text NOT NULL);";
        try (Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Se ha creado la tabla EMAIL.");
        }catch(SQLException ex){
            System.out.print("ERROR kata5 " + ex.getMessage());
        }
    }
}
