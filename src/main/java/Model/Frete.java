package Model;

import javax.persistence.*;

@Entity
public class Frete {

    @Id @GeneratedValue
    private Integer codigo_frete;

    @Column(length = 30)
    private String descricao;

    @Column(scale = 4)
    private Float peso;

    @Column(scale = 4)
    private Float valor;

    // relacionamentos
    @ManyToOne
    @JoinColumn(name = "cli_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    @Lob
    private Cidade cidade;

    public Frete(){}

    public Frete(String descricao, Float peso, Float valor, Cliente cliente, Cidade cidade) {
        this.descricao = descricao;
        this.peso = peso;
        this.valor = valor;
        this.cliente = cliente;
        this.cidade = cidade;
    }

    public Integer getCodigo_frete() {
        return codigo_frete;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
