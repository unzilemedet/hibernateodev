package org.bilgeadam.service;

import org.bilgeadam.entity.Film;
import org.bilgeadam.entity.Odul;
import org.bilgeadam.entity.Oyuncu;
import org.bilgeadam.entity.Yonetmen;
import org.bilgeadam.repository.OyuncuDao;

import java.util.Arrays;

public class OyuncuServices {
    static OyuncuDao oyuncuDao = new OyuncuDao();
    public static void main(String[] args) {

        save();
        //getAll();
        //getById(2);
        //delete(3);
        //update();



    }

    public static void save(){
        try{
            Film filmy = new Film("Film1");
            Odul oduly = new Odul("Odul3");
            Odul odulz= new Odul("Odul3");
            Oyuncu oyuncu1 = new Oyuncu("Beren", Arrays.asList(filmy),Arrays.asList(oduly,odulz));
            oyuncuDao.save(oyuncu1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getAll(){
        try{
            oyuncuDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try {
            oyuncuDao.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getById(int id) {
        try {
            oyuncuDao.getById(id);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void update(){
        try {
            Yonetmen yonetmen11 = new Yonetmen("Yonetmenx");
            Odul odulx = new Odul("oduly");
            Film filmx = new Film("x.FİLM");
            Oyuncu oyuncux = new Oyuncu(5,"Filmxyz",Arrays.asList(filmx),Arrays.asList(odulx));
            oyuncuDao.update(oyuncux);
            //   ActorDao.update(film3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
