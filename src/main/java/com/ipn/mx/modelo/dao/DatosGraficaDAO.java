/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;
import com.ipn.mx.modelo.entidades.DatosGrafica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JomianTC
 */
public class DatosGraficaDAO {

    private static final String SQL_GRAFICAR = "select categoria.nombrecategoria, count(articulo.idarticulo) as existencias from categoria inner join articulo on categoria.idcategoria = articulo.idcategoria group by categoria.idcategoria;";

    private Connection conexion;

    public Connection obtenerConexion() {

        String usuario = "freapdpovpelbm";
        String clave = "3ac64a8b5f78689a6b7e19d303729ce86adb50c5142165f2c7a1d24cbe0fbd1c";
        String url = "jdbc:postgresql://ec2-34-231-221-151.compute-1.amazonaws.com/darl8lqfr16bt1";
        String driverDB = "org.postgresql.Driver";

        try {

            Class.forName(driverDB);
            conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexion;
    }

    public List graficar() throws SQLException {

        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;

        try {

            cs = conexion.prepareCall(SQL_GRAFICAR);
            rs = cs.executeQuery();

            List resultados = obtenerResultados(rs);

            if (!resultados.isEmpty()) {
                return resultados;

            } else {
                return null;
            }

        } finally {

            if (cs != null) {
                cs.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {

            DatosGrafica dto = new DatosGrafica();
            dto.setNombre(rs.getString(1));
            dto.setCantidad(rs.getInt(2));
            resultados.add(dto);
        }

        return resultados;
    }

    public static void main(String[] args) throws SQLException {
        DatosGrafica dto = new DatosGrafica();
        DatosGraficaDAO dao = new DatosGraficaDAO();
        List lista;
        lista = dao.graficar();
        for (Object dtoE : lista) {
            DatosGrafica elemento = (DatosGrafica) dtoE;
            System.out.println(elemento.getNombre());
            System.out.println(elemento.getCantidad());
        }
    }
}
