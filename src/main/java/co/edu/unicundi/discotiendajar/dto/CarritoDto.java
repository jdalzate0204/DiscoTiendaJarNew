/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendajar.dto;

/**
 *
 * @author ALEJANDRA
 */
public class CarritoDto {
    
    private Integer id;
    private Long numeroCanciones;
    private String  album;
    private Long total;

    public CarritoDto() {
    }

    public CarritoDto( Long numeroCanciones, String album, Long total) {
        this.numeroCanciones = numeroCanciones;
        this.album = album;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(Long numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public String getCancion() {
        return album;
    }

    public void setCancion(String album) {
        this.album = album;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    
}
