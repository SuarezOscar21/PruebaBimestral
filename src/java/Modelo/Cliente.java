/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Cliente.findByCedula", query = "SELECT c FROM Cliente c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Cliente.findByEdad", query = "SELECT c FROM Cliente c WHERE c.edad = :edad")
    , @NamedQuery(name = "Cliente.findByProvinciaResi", query = "SELECT c FROM Cliente c WHERE c.provinciaResi = :provinciaResi")
    , @NamedQuery(name = "Cliente.findByVehiculoComprado", query = "SELECT c FROM Cliente c WHERE c.vehiculoComprado = :vehiculoComprado")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private Integer idCliente;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Cedula")
    private Integer cedula;
    @Size(max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Edad")
    private Integer edad;
    @Size(max = 45)
    @Column(name = "ProvinciaResi")
    private String provinciaResi;
    @Column(name = "VehiculoComprado")
    private Integer vehiculoComprado;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String apellido, Integer cedula, String direccion, Integer edad, String provinciaResi, Integer vehiculoComprado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.edad = edad;
        this.provinciaResi = provinciaResi;
        this.vehiculoComprado = vehiculoComprado;
    }

    
    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getProvinciaResi() {
        return provinciaResi;
    }

    public void setProvinciaResi(String provinciaResi) {
        this.provinciaResi = provinciaResi;
    }

    public Integer getVehiculoComprado() {
        return vehiculoComprado;
    }

    public void setVehiculoComprado(Integer vehiculoComprado) {
        this.vehiculoComprado = vehiculoComprado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
