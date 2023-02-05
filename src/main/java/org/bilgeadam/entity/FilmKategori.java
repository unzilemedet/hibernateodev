package org.bilgeadam.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
    public class FilmKategori {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String filmKategoriIsmi;


        public FilmKategori(String filmKategoriIsmi) {
            this.filmKategoriIsmi = filmKategoriIsmi;
        }
    public FilmKategori(Integer id) {this.id = id;}

}
