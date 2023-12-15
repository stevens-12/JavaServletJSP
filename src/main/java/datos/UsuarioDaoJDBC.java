/*DAO= Data access object objeto de acceso a los datos*/
package datos;

import datos.Conexion;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC {
    private static final String SQL_SELECT = "SELECT idUsuario,nombre,apellido,email,telefono FROM Usuario";
    private static final String SQL_SELECT_BY_ID= "SELECT idUsuario,nombre,apellido,email,telefono FROM Usuario WHERE id_Usuario = 2";
    private static final String SQL_INSERT="INSERT INTO Usuario(nombre,apellido,email,telefono) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE= "UPDATE Usuario SET nombre=?, apellido=?, email=?, telefono=? WHERE id_Usuario=?";
    private static final String SQL_DELETE="DELETE FROM Usuario WHERE id_Usuario=?";
    
    /*Método para listar objetos (Usuarios) */
    public List<Usuario> listar(){
        Connection conn= null;
        PreparedStatement stmt  = null;
        ResultSet rs= null;
        List<Usuario> Usuarios = new ArrayList<Usuario>();
        
        /*Manejo de las excepciones al conectar con una base de datos*/
        try {
            conn= Conexion.getConnection();
            stmt= conn.prepareStatement(SQL_SELECT);
            rs= stmt.executeQuery();
            while (rs.next()){
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
            
                
                System.out.println(nombre+" "+apellido+" "+email);
                
                Usuarios.add(new Usuario(idUsuario,nombre,apellido,email,telefono));
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return Usuarios;
        
    }
    
    /*Método para buscar un Usuario*/
    public Usuario  buscar(Usuario Usuario){
        Connection conn= null;
        PreparedStatement stmt  = null;
        ResultSet rs= null;
        
        /*Manejo de las excepciones al conectar con una base de datos*/
        try {
            conn= Conexion.getConnection();
            stmt= conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, Usuario.getIdUsuario());
            
            rs= stmt.executeQuery();
                rs.next();
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                          
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        }finally{
            
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
            
        }
        return Usuario;
        
    }
    
     /*Método para insertar un Usuario*/
    public int  insertar (Usuario Usuario){
        Connection conn= null;
        PreparedStatement stmt  = null;
        int rows=0;
        
        /*Manejo de las excepciones al conectar con una base de datos*/
        try {
            conn= Conexion.getConnection();
            stmt= conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, Usuario.getNombre());
            stmt.setString(2, Usuario.getApellido());
            stmt.setString(3, Usuario.getEmail());
            stmt.setString(4, Usuario.getTelefono());
            
            rows = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        
        return rows;
        
    }
    
    /*Método para actualizar un Usuario*/
    public int actualizar (Usuario Usuario){
             Connection conn= null;
        PreparedStatement stmt  = null;
        int rows=0;
        
        /*Manejo de las excepciones al conectar con una base de datos*/
        try {
            conn= Conexion.getConnection();
            stmt= conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, Usuario.getNombre());
            stmt.setString(2, Usuario.getApellido());
            stmt.setString(3, Usuario.getEmail());
            stmt.setString(4, Usuario.getTelefono());
            stmt.setInt(6,Usuario.getIdUsuario());
            
            rows = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        
        return rows;
    }
    
    /*Método para eliminar un Usuario*/
    public int eliminar(Usuario Usuario){
        Connection conn= null;
        PreparedStatement stmt  = null;
        int rows=0;
        
        /*Manejo de las excepciones al conectar con una base de datos*/
        try {
            conn= Conexion.getConnection();
            stmt= conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1,Usuario.getIdUsuario());
            
            rows = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        
        return rows;
    }
    
    /*PRUEBA*/
    public static void main(String[] args) {
        UsuarioDaoJDBC Usuario= new UsuarioDaoJDBC();
        Usuario.listar(); 
    }
    
}
