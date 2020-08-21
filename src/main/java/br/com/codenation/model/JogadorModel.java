package br.com.codenation.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class JogadorModel {

    private final Long id;
    private final Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;

    private JogadorModel( JogadorBuilder jogadorBuilder ) {
        this.id = jogadorBuilder.id;
        this.idTime = jogadorBuilder.idTime;
        this.nome = jogadorBuilder.nome;
        this.dataNascimento = jogadorBuilder.dataNascimento;
        this.nivelHabilidade = jogadorBuilder.nivelHabilidade;
        this.salario = jogadorBuilder.salario;
    }

    public Long getId() {
        return id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        JogadorModel jogadorModel = ( JogadorModel ) o;
        return Objects.equals( id, jogadorModel.id );
    }


    @Override
    public int hashCode() {
        return Objects.hashCode( id );
    }

    public static JogadorModel.JogadorBuilder builder( Long id, Long idTime ) {
        return new JogadorBuilder( id, idTime );
    }

    public static class JogadorBuilder {
        private final Long id;
        private final Long idTime;
        private String nome;
        private LocalDate dataNascimento;
        private Integer nivelHabilidade;
        private BigDecimal salario;

        private JogadorBuilder( Long id, Long idTime ) {
            this.id = id;
            this.idTime = idTime;
        }

        public JogadorBuilder withNome( String nome ) {
            this.nome = nome;
            return this;
        }

        public JogadorBuilder withDataNascimento( LocalDate dataNascimento ) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public JogadorBuilder withNivelHabilidade( Integer nivelHabilidade ) {
            this.nivelHabilidade = nivelHabilidade;
            return this;
        }

        public JogadorBuilder withSalario( BigDecimal salario ) {
            this.salario = salario;
            return this;
        }

        public JogadorModel build() {
            JogadorModel jogadorModel = new JogadorModel( this );
            validateUserObject( jogadorModel );
            return jogadorModel;
        }

        private void validateUserObject( JogadorModel timeEsportivoModel ) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }

}
