package br.com.sucos;

public class Suco {
    private String nome;
    private String foto;
    private String descricao;
    private String preco;
    private String sabor;

    public static Suco create(String nome, String foto, String descricao, String preco, String sabor){
        Suco s = new Suco();
        s.setNome(nome);
        s.setDescricao(descricao);
        s.setFoto(foto);
        s.setPreco(preco);
        s.setSabor(sabor);
        return s;
    }


    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}
