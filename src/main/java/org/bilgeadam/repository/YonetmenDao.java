package org.bilgeadam.repository;
import org.bilgeadam.entity.Yonetmen;
import org.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import java.util.List;

public class YonetmenDao implements  ICrud<Yonetmen> {

    private Session session = null;
    public void save(Yonetmen yonetmen){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(yonetmen);
            session.getTransaction().commit();
            System.out.println("Yonetmen başarılı bir şekilde kaydedildi.");
         }
        catch (Exception e){
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public void getAll(){
        List<Object[]> list = null;

        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select y.yonetmenIsmi, od.odulIsmi, f.filmIsmi  from director as y\n" +
                    "inner join odul as od\n" +
                    "on y.odul_id = od.id\n" +
                    "inner join yonetmen_film as yf\n" +
                    "on y.id = yf.Yonetmen_id\n" +
                    "inner join film as f\n" +
                    "on yf.films_id = f.id\n" +
                    "where odul_id is not null";
            list = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item:list){
                System.out.println(
                        "Yonetmen Ismi: " + item[0] + ", " +
                                "Odul Ismi: " + item[1] + ", " +
                                "Film Ismi: " + item[2]
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    @Override
    public void getById(int id) {

    }

    public void deleteById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Yonetmen yonetmen = session.load(Yonetmen.class,id);
            session.delete(yonetmen);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }

    public void update(Yonetmen director) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(director);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void delete(int id) {

    }
}
