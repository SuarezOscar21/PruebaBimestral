/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DELL
 */
@Stateless
@Path("modelo.vehiculo")
public class VehiculoFacadeREST extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "ExamenBimestralPU")
    private EntityManager em;

    public VehiculoFacadeREST() {
        super(Vehiculo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vehiculo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vehiculo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Vehiculo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @POST
    @Path("{RegistrarVehiculo")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String CrearVehiculo(
            @FormParam("idVehiculo") Integer idVehiculo,
            @FormParam("Ano") Integer ano,
            @FormParam("Modelo") String Modelo,
            @FormParam("Marca") String Marca,
            @FormParam("Cilindraje") Integer Cilindraje,
            @FormParam("PaisFabricacion") String PaisFabricacion,
            @FormParam("Placa") String Placa) {

        Vehiculo vehiculo = new Vehiculo(idVehiculo,
                ano,
                Modelo,
                Marca,
                Cilindraje,
                PaisFabricacion,
                Placa);
        super.create(vehiculo);
        return "el vehiculo ha sido registrado";
    }

    @POST
    @Path("{EditarVehiculo")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String EditarVehiculo(
            @FormParam("idVehiculo") Integer idVehiculo,
            @FormParam("Ano") Integer ano,
            @FormParam("Modelo") String Modelo,
            @FormParam("Marca") String Marca,
            @FormParam("Cilindraje") Integer Cilindraje,
            @FormParam("PaisFabricacion") String PaisFabricacion,
            @FormParam("Placa") String Placa) {

        Vehiculo vehiculo = super.find(idVehiculo);
        vehiculo.setIdVehiculo(idVehiculo);
        vehiculo.setAno(ano);
        vehiculo.setModelo(Modelo);
        vehiculo.setCilindraje(Cilindraje);
        vehiculo.setPaisFabricacion(PaisFabricacion);
        vehiculo.setPlaca(Placa);
        
        super.find(vehiculo);
        return "el vehiculo ha sido registrado";
    }
    @POST
    @Path("Marca")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Vehiculo>marca(@FormParam("Marca")String Marca){
        TypedQuery consulta=getEntityManager().createQuery
                ("SELECT v FROM Vehiculo v WHERE v.marca = :marca",Vehiculo.class);
        consulta.setParameter("Marca",Marca);
        return consulta.getResultList();
    }
        @GET
        @Path("count")
        @Produces(MediaType.TEXT_PLAIN)
        public String countREST
        
            () {
        return String.valueOf(super.count());
        }

        @Override
        protected EntityManager getEntityManager
        
            () {
        return em;
        }

    }
