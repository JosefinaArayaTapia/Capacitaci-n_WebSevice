package com.josefina.controller;

import com.josefina.dao.PeliculaDao;
import com.josefina.model.Pelicula;

import java.util.List;

/**
 * Creado por Josefina on 26-06-18.
 */
public class ServicioWs {

    public List<Pelicula> ListarPeliculas() {

        PeliculaDao p = new PeliculaDao();
        Pelicula Pelicula = new Pelicula();
        List<Pelicula> pelis = null;
        try {

            pelis = p.ListarPeliculas();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return pelis;
    }

    public int InsertarPeliculaWS(String NombrePelicula, String AnioPelicula, Integer RankingPelicula) {

        Pelicula pm = new Pelicula();
        PeliculaDao pd = new PeliculaDao();
        try {
            pm.setNombrePelicula(NombrePelicula);
            pm.setAnioPelicula(AnioPelicula);
            pm.setRankingPelicula(RankingPelicula);
        } catch (Exception e) {
            e.printStackTrace();
        }

        pd.InsertarPelicula(pm);
        return 1;
    }
}
