package co.id.javan.berbageekprasimsha;

import javax.persistence.*;
import java.util.List;

@Entity
public class Petani {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "no_tlp")
    private String noTlp;

    @OneToMany(mappedBy = "petani")
    private List<Kolam> kolams;

    public Petani(){}

    public Petani(String namaLengkap, String noTlp){
        this.namaLengkap = namaLengkap;
        this.noTlp = noTlp;
    }

    public List<Kolam> getKolams(){return kolams;}

    public void setKolams(List<Kolam> kolams) {this.kolams = kolams;}

    public Long getId() {return id;}

    public void setId(Long id){this.id = id;}

    public String getNamaLengkap() {return namaLengkap;}

    public void setNamaLengkap(String namaLengkap){this.namaLengkap = namaLengkap;}

    public String getNoTlp() {return noTlp;}

    public void setNoTlp(String noTlp) {this.noTlp = noTlp;}
}
