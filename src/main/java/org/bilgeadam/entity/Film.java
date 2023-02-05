package org.bilgeadam.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


    @Entity
    @Data
    @NoArgsConstructor
    public class Film {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String filmIsmi;

        @ManyToOne(cascade = CascadeType.ALL)
        private Yonetmen yonetmen;

        @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)

        private List<Oyuncu> oyuncular;
        @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private List<Odul> oduller;
        @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private List<FilmKategori> filmKategoriler;



        public Film(String filmIsmi, Yonetmen yonetmen, List<Oyuncu> oyuncular, List<FilmKategori> filmKategoriler, List<Odul> oduller) {
            this.filmIsmi = filmIsmi;
            this.yonetmen = yonetmen;
            this.oyuncular = oyuncular;
            this.filmKategoriler= filmKategoriler;
            this.oduller = oduller;
        }

        public Film(Integer id, String filmIsmi, Yonetmen yonetmen, List<Oyuncu> oyuncular, List<FilmKategori> filmKategoriler, List<Odul> oduller) {
            this.id = id;
            this.filmIsmi = filmIsmi;
            this.yonetmen = yonetmen;
            this.oyuncular = oyuncular;
            this.filmKategoriler = filmKategoriler;
            this.oduller = oduller;
        }

        public Film(String filmIsmi) {
            this.filmIsmi = filmIsmi;
        }
        public Film(Integer id) {this.id = id;}
}
