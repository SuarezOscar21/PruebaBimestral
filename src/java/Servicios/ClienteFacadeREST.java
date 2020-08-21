/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "ExamenBimestralPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
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
    public Cliente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @POST
    @Path("{Crear Cliente")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String CrearCliente(
            @FormParam("idCliente") Integer idCliente,
            @FormParam("Nombre") String Nombre,
            @FormParam("Apellido") String Apellido, 
            @FormParam("Cedula") Integer Cedula,
            @FormParam("Diereccion") String Direccion,
            @FormParam("Edad") Integer Edad,
            @FormParam("ProvinciaResi") String ProvinciaResi,
            @FormParam("VehiculoComprado")Integer VehiculoComprado) {

        Cliente cliente = new Cliente(idCliente,
                Nombre,
                Apellido,
                Cedula,
                Direccion,
                Edad,
                ProvinciaResi,
                VehiculoComprado);
        super.create(cliente);
        return "el cliente ha sido creado";
    }

    @POST
    @Path("{Editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Editar(
            @FormParam("idCliente") Integer idCliente,
            @FormParam("Nombre") String Nombre,
            @FormParam("Apellido") String Apellido, 
            @FormParam("Cedula") Integer Cedula,
            @FormParam("Diereccion") String Direccion,
            @FormParam("Edad") Integer Edad,
            @FormParam("ProvinciaResi") String ProvinciaResi,
            @FormParam("VehiculoComprado")Integer VehiculoComprado) {
        
        Cliente cliente=super.find(idCliente);
        
        cliente.setNombre(Nombre);
        cliente.setDireccion(Apellido);
        cliente.setCedula(Cedula);
        cliente.setDireccion(Direccion);
        cliente.setEdad(Edad);
        cliente.setProvinciaResi(ProvinciaResi);
        cliente.setVehiculoComprado(VehiculoComprado);
        
        super.edit(cliente);
        return "datos editados ";
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
