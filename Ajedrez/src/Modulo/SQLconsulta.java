
package Modulo;

import com.mysql.jdbc.PreparedStatement;
import java.sql.*;

public class SQLconsulta extends Conexion{
    
    public boolean registrar (Datos_Usuario dat){
    PreparedStatement ps = null;
    Connection conectar = getConexion();
    
    String sql= "INSERT INTO usuarios (nombre,apellido,edad,nick_User,correo,contrasena) VALUES (?,?,?,?,?,?)";
    
    try{
        ps=(PreparedStatement) conectar.prepareStatement(sql);
        ps.setString(1, dat.getNombre());
        ps.setString(2, dat.getApellido());
        ps.setInt(3, dat.getEdad());
        ps.setString(4, dat.getNick());
        ps.setString(5, dat.getCorreo());
        ps.setString(6, dat.getContrasena());
        ps.execute();
        return true;
    }
    catch(SQLException e){
        System.err.print(e);
        return false;
    }
    finally{
        try{
            conectar.close();
        }
        catch (SQLException ex){
            System.err.print(ex);
        }
    }
    }
    
    /*metodo de actualización de datos de usuario*/
    public boolean modificar (Datos_Usuario dat){
        PreparedStatement ps = null;
        Connection conectar = getConexion();
        
        String sql = "Update usuarios set nombre=?,apellido=?,edad=?,nick_User=?,correo=?,contrasena=? WHERE id_User = ?";
        
        try {
            ps=(PreparedStatement) conectar.prepareStatement(sql);
            ps.setString(1, dat.getNombre());
            ps.setString(2, dat.getApellido());
            ps.setInt(3, dat.getEdad());
            ps.setString(4, dat.getNick());
            ps.setString(5, dat.getCorreo());
            ps.setString(6, dat.getContrasena());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                conectar.close();
            }
            catch(SQLException ex){
                System.err.println(ex);
            }
        }
    }
    
    /*faltan los meodos de eliminar datos de usuario y buscar usuario*/
}
