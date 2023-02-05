package org.bilgeadam.service;

import org.bilgeadam.entity.Film;
import org.bilgeadam.entity.Odul;
import org.bilgeadam.entity.Yonetmen;
import org.bilgeadam.repository.FilmDao;
import org.bilgeadam.repository.YonetmenDao;

import java.util.Arrays;
import java.util.List;

public class YonetmenServices {
    static YonetmenDao yonetmenDao = new YonetmenDao();
    public static void main(String[] args) {
        //save();
        getAll();
        //delete(4);
        //update();
    }



    public static void save(){
        try {
            Odul odul1 = new Odul("Aodul");
            Film film1 = new Film("Filma");
            Yonetmen yonetmen1 = new Yonetmen("Yonetmena", Arrays.asList(film1),odul1);
            yonetmenDao.save(yonetmen1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getAll(){
        try {
            yonetmenDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try {
            yonetmenDao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(){
        try {
            Odul odul1 = new Odul("Aodul");
            Film film1 = new Film("filmb");
            Yonetmen yonetmen1 = new Yonetmen(3,"yonetmenb",Arrays.asList(film1),odul1);
            yonetmenDao.update(yonetmen1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
