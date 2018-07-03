package com.josefina.ws;

import com.josefina.controller.ServicioWs;
import com.josefina.dao.PeliculaDao;
import com.josefina.model.Pelicula;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 *  Creado por Josefina on 26-06-18.
 */
@Path("/ServicioPeliculas")
public class Service {
    @GET
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    @Path("ListarPeliculas")
    public List<Pelicula> ListarPeliculas() {


        List<Pelicula> pelis=new ArrayList<Pelicula>();
        PeliculaDao P =new PeliculaDao();
        pelis=P.ListarPeliculas();
        System.out.print("Objeto: "+pelis);
        return pelis;
    }
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    @Path("InsertarPelicula")
    public void InsertarPelicula(Pelicula pelicula){

        String NombrePelicula=pelicula.getNombrePelicula();
        String AnioPelicula=pelicula.getAnioPelicula();
        Integer RankingPelicula=pelicula.getRankingPelicula();

        ServicioWs Servicio = new ServicioWs();
        try {
            Servicio.InsertarPeliculaWS(NombrePelicula, AnioPelicula, RankingPelicula);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
