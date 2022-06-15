/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JomianTC
 */
public class conexionJasper {

    private Connection conexion;

    public Connection obtenerConexion() throws SQLException {

        String usuario = "zfiqcmklzdgczr";
        String clave = "289ecded42b6283e4ff5692adab12b91c19a83b8b91e08fdf69784574fc88f77";
        String url = "jdbc:postgresql://ec2-54-157-16-196.compute-1.amazonaws.com/d6mrhnmu5dc0ah";
        String driverDB = "org.postgresql.Driver";

        try {

            Class.forName(driverDB);
            conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(conexionJasper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexion;
    }
}
