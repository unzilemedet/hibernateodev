package org.bilgeadam.repository;

import org.bilgeadam.entity.Film;
import org.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class FilmDao implements ICrud<Film>{
    private Session session = null;

    @Override
    public void save(Film film) {
        try (
                Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            System.out.println("Film kaydedildi");
            session.close();
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }





    @Override
    public void getAll() {
        List<Film> list = null;
        try {

            session.beginTransaction();
            list = session.createQuery("select film from Film film").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return list;
    }

    @Override
    public void getById(int id) {

    }

    public static void askAwardByName(String filmIsmi){
        List<Object> list = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            String qs = "select o.oyuncuIsmı  from film as f\n" +
                    "inner join film_oyuncu as fo\n" +
                    "on f.id = fo.Film_id\n" +
                    "inner join oyuncu as o\n" +
                    "on fo.oyuncular_id = o.id " +
                    "where f.filmIsmi = :Filmx";
            Query query = session.createNativeQuery(qs);
            query.setParameter("Filmx", filmIsmi);
            list = query.getResultList();
            if(list.isEmpty()){
                System.out.println("---");
            } else{
                for(Object item:list) {
                    System.out.println(
                            "odıl oyuncu ismi: " + item
                    );
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    public void deleteById(int id){
        try(
                Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Film film = session.load(Film.class,id);
            session.delete(film);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }

    public void update(Film film){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(film);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void delete(int id) {

    }


}
