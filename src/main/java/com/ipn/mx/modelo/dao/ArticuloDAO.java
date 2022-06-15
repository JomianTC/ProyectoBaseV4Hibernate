/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.entidades.Articulo;
import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.utilerias.HibernateUtil;
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
public class ArticuloDAO {
    
    public void create(Articulo dto) {
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        
        try {
            
            t.begin();
            s.persist(dto);
            t.commit();
            
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }
    
    public void update(Articulo dto) {
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        
        try {
            
            t.begin();
            s.merge(dto);
            t.commit();
            
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }
    
    public void delete(Articulo dto) {
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        
        try {
            
            t.begin();
            s.remove(dto);
            t.commit();
            
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }
    
    public Articulo read(Articulo dto) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        
        try {
            transaction.begin();
            dto = session.find(Articulo.class, dto.getIdArticulo());
            
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        
        return dto;
    }
    
    public List readAll() {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        List resultados = new ArrayList();
        
        try {
            transaction.begin();
            Query q = session.createQuery("from Articulo", Articulo.class);
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
        
        ArticuloDAO dao = new ArticuloDAO();
        Articulo dto = new Articulo();
        
        Categoria cato = new Categoria();
        CategoriaDAO cat = new CategoriaDAO();
        
        cato.setIdCategoria(3);

        //dto.setIdArticulo(1);
        dto.setNombreArticulo("Potenciometro");
        dto.setDescripcionArticulo("10k ohm");
        dto.setExistencias(200);
        dto.setStockMinimo(10);
        dto.setStockMaximo(1000);
        dto.setPrecio(30.50);
        dto.setCategoria(cat.read(cato));
        
        try {
            dao.create(dto);
            //dao.update(dto);
            //to = dao.read(dto);
            //dao.delete(dto);
            //System.out.println(dto);
            //System.out.println(dao.readAll());
        } catch (Exception ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
