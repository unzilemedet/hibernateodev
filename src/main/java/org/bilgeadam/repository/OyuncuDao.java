package org.bilgeadam.repository;

import org.bilgeadam.entity.Oyuncu;
import org.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OyuncuDao implements ICrud<Oyuncu>{

    private
    Session session = null;
    public void save(Oyuncu oyuncu){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(oyuncu);
            session.getTransaction().commit();
            System.out.println("Oyuncu kaydedildi.");
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    public void getAll(){
        List<Object[]> ls = null;
        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select o.oyuncuIsmi, f.filmIsmi, od.odulIsmi  from oyuncular as o\n" +
                    "inner join oyuncu as a\n" +
                    "on o.oyuncu_id = o.id\n" +
                    "inner join odul as aw\n" +
                    "on od.odul_id = od.id\n" +
                    "inner join oyuncu_film of\n" +
                    "on o.Oyuncu_id = of.Oyuncu_id \n" +
                    "inner join film f\n" +
                    "on of.film_id = f.id";
            ls = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item:ls){
                System.out.println(
                                "Oyuncu Ismi: " + item[0] + ", " +
                                "Film Ismi: " + item[1] + ", " +
                                "Odul Ismi: " + item[2]
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    @Override
    public void getById(int id) {
        List<Object[]> directorList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String sql = "select o.OyuncuIsmi, f.filmName, od.odulIsmi from oyuncu as o\n" +
                    "inner join oyuncu_film of on of.Oyuncu_id = o.id\n" +
                    "inner join film as f on f.id = of.film_id\n" +
                    "inner join oyuncu_odul oo on oo.Oyuncu_id = o.id\n" +
                    "inner join o as a on od.id = ood.odul_id where o.id = ?";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, id);
            directorList = query.getResultList();
            for(Object[] item : directorList){

                System.out.println("Yonetmen Ismi: " + item[0] + " --"
                        + " Film İsmi: " + item[1] + " --"
                        + " Odul İsmi: " + item[2]
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try(
                Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Oyuncu oyuncu = session.load(Oyuncu.class,id);
            session.delete(oyuncu);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void update(Oyuncu oyuncu){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(oyuncu);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
