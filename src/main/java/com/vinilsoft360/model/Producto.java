package com.vinilsoft360.model;

/**
 * Clase que representa un producto de la empresa Vinilsoft360.
 * Contiene la información de los pisos vinílicos disponibles para la venta.
 *
 * @author Dayson Mazo Villa
 */
public class Producto {

    // Atributos de la clase
    private int id;
    private String nombre;
    private String tipoPiso;
    private String color;
    private double precio;
    private int stock;

    /**
     * Constructor vacío.
     */
    public Producto() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id Identificador del producto.
     * @param nombre Nombre del producto.
     * @param tipoPiso Tipo de piso vinílico.
     * @param color Color del producto.
     * @param precio Precio del producto.
     * @param stock Cantidad disponible.
     */
    public Producto(int id, String nombre, String tipoPiso,
                    String color, double precio, int stock) {

        this.id = id;
        this.nombre = nombre;
        this.tipoPiso = tipoPiso;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el identificador del producto.
     * @return id del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna el identificador del producto.
     * @param id Identificador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del producto.
     * @param nombre Nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de piso.
     * @return tipo de piso.
     */
    public String getTipoPiso() {
        return tipoPiso;
    }

    /**
     * Asigna el tipo de piso.
     * @param tipoPiso Tipo de piso.
     */
    public void setTipoPiso(String tipoPiso) {
        this.tipoPiso = tipoPiso;
    }

    /**
     * Obtiene el color del producto.
     * @return color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Asigna el color del producto.
     * @param color Color del producto.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el precio del producto.
     * @return precio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Asigna el precio del producto.
     * @param precio Precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible.
     * @return stock disponible.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Asigna la cantidad disponible.
     * @param stock Cantidad en inventario.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

}