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

        String usuario = "freapdpovpelbm";
        String clave = "3ac64a8b5f78689a6b7e19d303729ce86adb50c5142165f2c7a1d24cbe0fbd1c";
        String url = "jdbc:postgresql://ec2-34-231-221-151.compute-1.amazonaws.com/darl8lqfr16bt1";
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
