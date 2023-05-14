
package Modulo;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
        /*crear variables de los datos de la base, sera mas facil de manejar*/
    private final String base = "fight_or_die";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection conectar = null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            /*para ahorrar escritura se usan las variables con el "this."*/
            conectar =(Connection) DriverManager.getConnection(this.url,this.user,this.password);
            System.out.println("Conección exitosa juan");
        }
        catch(SQLException e){
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conectar;
    }
}
