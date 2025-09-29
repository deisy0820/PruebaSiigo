package org.models;

public class Tercero {
    private String tipo;
    private String tipoIdentificacion;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String direccion;
    private String comercial;

    // Constructor
    public Tercero(String tipo, String tipoident, String identificacion, String nombres, String apellidos,
                   String ciudad, String direccion, String comercial) {
        this.tipoIdentificacion = tipoident;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.comercial = comercial;
        this.tipo=tipo;
    }

    // Getters
    public String gettipo() { return tipo; }
    public String getTipoIdentificacion() { return tipoIdentificacion; }
    public String getIdentificacion() { return identificacion; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getCiudad() { return ciudad; }
    public String getDireccion() { return direccion; }
    public String getComercial() { return comercial; }

}
