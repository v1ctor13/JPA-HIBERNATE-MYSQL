package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cidade  {

    @Id @GeneratedValue
    private Integer id;

    @Column(length = 30)
    @Lob
    private String nome;

    @Column(length = 30)
    private String UF;

    @Column(scale = 4)
    private Float taxa;

    public Cidade(){}

    public Cidade(String nome, String UF, Float taxa) {
        this.nome = nome;
        this.UF = UF;
        this.taxa = taxa;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Float getTaxa() {
        return taxa;
    }

    public void setTaxa(Float taxa) {
        this.taxa = taxa;
    }
}
