package dominio;


public class Usuario {
    /*Generando las variables*/
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

/*Constructo desde IdUsuario*/    

    /**
     *
     * @param idUsuario
     * @param nombre1
     * @param apellido1
     * @param email1
     * @param telefono1
     */
    
    public Usuario(int idUsuario, String nombre1, String apellido1, String email1, String telefono1) {
        this.idUsuario = idUsuario;
    }
    /*Constructor Vacio*/
    public Usuario(){
        
    }

    public Usuario(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    
    /*Métodos Getters & Setters*/

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /*Método to string con el fin de convertir los objetos en texto y poder visualizarlos*/

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + " }";
    }
      
}
