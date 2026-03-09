package model;

public class Livro {
    private int paginas;
    private double preço;
    private String nome;
    private int  ano;
    private String autor;
    private int id;
    private boolean isEmprestado;
    private Usuario usuarioEmprestado;

    public Usuario getUsuarioEmprestado() {
        return usuarioEmprestado;
    }

    public void setUsuarioEmprestado(Usuario usuarioEmprestado) {
        this.usuarioEmprestado = usuarioEmprestado;
    }

    public boolean isEmprestado() {
        return isEmprestado;
    }

    public boolean setEmprestado(boolean emprestado) {
        isEmprestado = emprestado;
        return emprestado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String toString() {
        return "Nome: " + getNome() + "\n" +
                "Autor: " + getAutor() + "\n" +
                "Ano: " + getAno() + "\n" +
                "Paginas: " + getPaginas() + "\n" +
                "Preço: " + getPreço();
    }



}

