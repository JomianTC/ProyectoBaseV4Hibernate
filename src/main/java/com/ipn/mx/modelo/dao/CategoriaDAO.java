/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.utilerias.HibernateUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author JomianTC
 */
public class CategoriaDAO {

    public List readAll() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        List resultados = new ArrayList();

        try {
            transaction.begin();
            Query q = session.createQuery("from Categoria", Categoria.class);
            resultados = q.list();

            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        return resultados;
    }


    
    //Herramienta de DEBUGG

    public static void main(String[] args) {

        CategoriaDAO dao = new CategoriaDAO();
        //CategoriaDTO dto = new CategoriaDTO();

        //dto.getEntidad().setIdCategoria(5);
        //dto.getEntidad().setNombreCategoria("Redes");
        //dto.getEntidad().setDescripcionCategoria("Articulos De Redes");

        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (Exception ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
