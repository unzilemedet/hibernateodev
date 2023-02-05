package org.bilgeadam.service;
import org.bilgeadam.entity.*;
import org.bilgeadam.repository.FilmDao;
import org.bilgeadam.util.HibernateUtil;

import java.util.*;
public class FilmServices {
   private static FilmDao filmDao = new FilmDao();
    public static void main(String[] args) {
        //HibernateUtil.getSessionFactory();
        save();
       // getAll();
        //odulIsmi("Film1");
        //delete(1);
        //update();

    }

    public static void save(){
        try {
            Yonetmen yonetmen1 = new Yonetmen("Yonetmen1");
            Oyuncu oyuncu1 = new Oyuncu("Oyuncu1");
            FilmKategori filmKategori1 = new FilmKategori("FilmKategori1");
            Odul odul1 = new Odul("Odul1");
            Film film1 = new Film("Film1", yonetmen1, Arrays.asList(oyuncu1), Arrays.asList(filmKategori1), Arrays.asList(odul1));
            filmDao.save(film1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getAll(){
        try {
            filmDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

  /*  public static void odulIsmiby(String filmIsmi){
        try{
            FilmDao.odulIsmiby(filmIsmi);

        }catch (Exception e){
            e.printStackTrace();

        }
    }*/

    public static void delete(int id){
        try {
            filmDao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(){
        try {
            Yonetmen yonetmen1 = new Yonetmen("Yonetmen1");
            Oyuncu oyuncu2 = new Oyuncu("Oyuncu2");
            FilmKategori filmKategori3 = new FilmKategori("FilmKategori3");
            Odul odul4 = new Odul("Odul4");
            Film film3 = new Film(1,"Film2", yonetmen1, Arrays.asList(oyuncu2), Arrays.asList(filmKategori3), Arrays.asList(odul4));
            filmDao.update(film3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
