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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Vehiculo.findByAno", query = "SELECT v FROM Vehiculo v WHERE v.ano = :ano")
    , @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculo.findByCilindraje", query = "SELECT v FROM Vehiculo v WHERE v.cilindraje = :cilindraje")
    , @NamedQuery(name = "Vehiculo.findByPaisFabricacion", query = "SELECT v FROM Vehiculo v WHERE v.paisFabricacion = :paisFabricacion")
    , @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVehiculo")
    private Integer idVehiculo;
    @Column(name = "Ano")
    private Integer ano;
    @Size(max = 45)
    @Column(name = "Modelo")
    private String modelo;
    @Size(max = 45)
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Cilindraje")
    private Integer cilindraje;
    @Size(max = 45)
    @Column(name = "PaisFabricacion")
    private String paisFabricacion;
    @Size(max = 10)
    @Column(name = "Placa")
    private String placa;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo, Integer ano, String modelo, String marca, Integer cilindraje, String paisFabricacion, String placa) {
        this.idVehiculo = idVehiculo;
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.paisFabricacion = paisFabricacion;
        this.placa = placa;
    }
    

    public Vehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
