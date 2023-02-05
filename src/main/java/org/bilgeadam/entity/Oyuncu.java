package org.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

    @Entity
    @Data
    @NoArgsConstructor
    public class Oyuncu {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Integer id;


        private String oyuncuIsmi;

        @ManyToMany (cascade = CascadeType.ALL)
        private List<Film> filmler;

        @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private List<Odul> oduller;

        public Oyuncu(String oyuncuIsmi, List<Film> filmler, List<Odul> oduller) {
            this.oyuncuIsmi =oyuncuIsmi;
            this.filmler = filmler;
            this.oduller = oduller;
        }

        public Oyuncu(Integer id, String oyuncuIsmi, List<Film> filmler, List<Odul> oduller) {
            this.id = id;
            this.oyuncuIsmi= oyuncuIsmi;
            this.filmler = filmler;
            this.oduller = oduller;
        }
        public Oyuncu(Integer id) {
            this.id = id;
        }

        public Oyuncu(String oyuncuIsmi) {
            this.oyuncuIsmi= oyuncuIsmi;
        }




    }

