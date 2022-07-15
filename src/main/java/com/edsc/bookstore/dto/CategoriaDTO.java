package com.edsc.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.edsc.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo nome é requerido")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 a 100 caracteres.")
    private String nome;
    @NotEmpty(message = "Campo descricao é requerido")
    @Length(min = 3, max = 200, message = "O campo descricao deve ter entre 3 a 200 caracteres.")
    private String descricao;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria cat) {
        super();
        this.id = cat.getId();
        this.nome = cat.getNome();
        this.descricao = cat.getDescricao();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
