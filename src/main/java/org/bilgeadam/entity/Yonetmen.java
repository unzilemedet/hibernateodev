package org.bilgeadam.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Yonetmen {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String yonetmenIsmi;
    @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Film> filmler;
    @OneToOne (cascade = CascadeType.ALL)
    private Odul odul;

    public Yonetmen(String yonetmenIsmi) {
        this.yonetmenIsmi = yonetmenIsmi;
    }
    public Yonetmen(Integer id) {this.id = id;}
    public Yonetmen(String yonetmenIsmi, List<Film> filmler, Odul odul) {
        this.yonetmenIsmi = yonetmenIsmi;
        this.filmler = filmler;
        this.odul= odul;
    }

    public Yonetmen(Integer id, String yonetmenIsmi, List<Film> filmler, Odul odul) {
        this.id = id;
        this.yonetmenIsmi = yonetmenIsmi;
        this.filmler = filmler;
        this.odul = odul;
    }
}


