/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByIdMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idMantenimiento = :idMantenimiento")
    , @NamedQuery(name = "Mantenimiento.findByMantenimientocol", query = "SELECT m FROM Mantenimiento m WHERE m.mantenimientocol = :mantenimientocol")
    , @NamedQuery(name = "Mantenimiento.findByIdVehiculo", query = "SELECT m FROM Mantenimiento m WHERE m.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Mantenimiento.findByIdCliente", query = "SELECT m FROM Mantenimiento m WHERE m.idCliente = :idCliente")
    , @NamedQuery(name = "Mantenimiento.findByFecha", query = "SELECT m FROM Mantenimiento m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mantenimiento.findByDescripcion", query = "SELECT m FROM Mantenimiento m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Mantenimiento.findByKilometraje", query = "SELECT m FROM Mantenimiento m WHERE m.kilometraje = :kilometraje")})
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMantenimiento")
    private Integer idMantenimiento;
    @Size(max = 45)
    @Column(name = "Mantenimientocol")
    private String mantenimientocol;
    @Column(name = "IdVehiculo")
    private Integer idVehiculo;
    @Column(name = "IdCliente")
    private Integer idCliente;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Kilometraje")
    private Integer kilometraje;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idMantenimiento, String mantenimientocol, Integer idVehiculo, Integer idCliente, Date fecha, String descripcion, Integer kilometraje) {
        this.idMantenimiento = idMantenimiento;
        this.mantenimientocol = mantenimientocol;
        this.idVehiculo = idVehiculo;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.kilometraje = kilometraje;
    }
    

    public Mantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getMantenimientocol() {
        return mantenimientocol;
    }

    public void setMantenimientocol(String mantenimientocol) {
        this.mantenimientocol = mantenimientocol;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimiento != null ? idMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idMantenimiento == null && other.idMantenimiento != null) || (this.idMantenimiento != null && !this.idMantenimiento.equals(other.idMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Mantenimiento[ idMantenimiento=" + idMantenimiento + " ]";
    }
    
}
