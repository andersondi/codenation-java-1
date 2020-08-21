package br.com.codenation.model;

import br.com.codenation.exceptions.JogadorNaoEncontradoException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TimeEsportivoModel {
    private final Long id;
    private final String nome;
    private final LocalDate dataCriacao;
    private final String corUniformePrincipal;
    private final String corUniformeSecundario;
    private Long idCapitaoDoTime;
    private Map< Long, JogadorModel > mapDeJogadores;

    private TimeEsportivoModel( TimeEsportivoBuilder timeEsportivoBuilder ) {
        this.id = timeEsportivoBuilder.id;
        this.nome = timeEsportivoBuilder.nome;
        this.dataCriacao = timeEsportivoBuilder.dataCriacao;
        this.corUniformePrincipal = timeEsportivoBuilder.corUniformePrincipal;
        this.corUniformeSecundario = timeEsportivoBuilder.corUniformeSecundario;
        this.idCapitaoDoTime = timeEsportivoBuilder.idCapitaoDoTime;
        this.mapDeJogadores = timeEsportivoBuilder.mapDeJogadores;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public Map< Long, JogadorModel > getJogadores() {
        return mapDeJogadores;
    }

    public void setIdCapitaoDoTime( Long idCapitaoDoTime ) {
        if ( getJogadores().size()>0 ) {
            this.idCapitaoDoTime = idCapitaoDoTime;
        }else{
            throw new JogadorNaoEncontradoException();
        }
    }

    public void addJogador( JogadorModel jogador ) {
        this.getJogadores().put( jogador.getId(), jogador );
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        TimeEsportivoModel timeEsportivoModel = ( TimeEsportivoModel ) o;
        return Objects.equals( id, timeEsportivoModel.id );
    }


    @Override
    public int hashCode() {
        return Objects.hashCode( id );
    }

    public static TimeEsportivoBuilder builder( Long id ) {
        return new TimeEsportivoBuilder( id );
    }

    public static class TimeEsportivoBuilder {
        private final Long id;
        private String nome;
        private LocalDate dataCriacao;
        private String corUniformePrincipal;
        private String corUniformeSecundario;
        private Long idCapitaoDoTime;
        private Map< Long, JogadorModel > mapDeJogadores = new HashMap<>();

        private TimeEsportivoBuilder( Long id ) {
            this.id = id;
        }

        public TimeEsportivoBuilder withNome( String nome ) {
            this.nome = nome;
            return this;
        }

        public TimeEsportivoBuilder withDataCriacao( LocalDate dataCriacao ) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public TimeEsportivoBuilder withCorUniformePrincipal( String corUniformePrincipal ) {
            this.corUniformePrincipal = corUniformePrincipal;
            return this;
        }

        public TimeEsportivoBuilder withCorUniformeSecundario( String corUniformeSecundario ) {
            this.corUniformeSecundario = corUniformeSecundario;
            return this;
        }

        public TimeEsportivoModel build() {
            TimeEsportivoModel timeEsportivoModel = new TimeEsportivoModel( this );
            validateUserObject( timeEsportivoModel );
            return timeEsportivoModel;
        }

        private void validateUserObject( TimeEsportivoModel timeEsportivoModel ) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
