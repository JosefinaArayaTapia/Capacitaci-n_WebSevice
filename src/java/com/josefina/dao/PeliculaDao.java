package com.josefina.dao;
import com.josefina.model.Pelicula;
import com.josefina.utils.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Creado por Josefina on 19-06-18.
 */
public class PeliculaDao {

    private Connection connection;
    public PeliculaDao() {
        connection = DBConn.getConnection();
    }

    public void InsertarPelicula(Pelicula P){

        try {
            PreparedStatement st = connection.prepareStatement("insert into peliculas (nombre,anio,ranking) values (?,?,?)");

            st.setString(1,P.getNombrePelicula());
            st.setString(2,P.getAnioPelicula());
            st.setInt(3,P.getRankingPelicula());
            st.executeUpdate();

        }catch (SQLException e){

            e.printStackTrace();
        }

    }
    public List<Pelicula> ListarPeliculas(){

        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from peliculas");
            while (rs.next()) {
                Pelicula p = new Pelicula();
                p.setId(rs.getInt("id"));
                p.setNombrePelicula(rs.getString("nombre"));
                p.setAnioPelicula(rs.getString("anio"));
                p.setRankingPelicula(rs.getInt("ranking"));
                peliculas.add(p);
            }
        }catch (SQLException e){

            e.printStackTrace();;
        }
        return peliculas;

    }



}
