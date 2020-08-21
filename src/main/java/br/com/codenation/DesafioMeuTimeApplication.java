package br.com.codenation;

import br.com.codenation.model.JogadorModel;
import br.com.codenation.model.LigaEsportivaModel;
import br.com.codenation.model.TimeEsportivoModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private LigaEsportivaModel ligaEsportivaModel = new LigaEsportivaModel();

    public void incluirTime( Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario ) {
        TimeEsportivoModel timeEsportivo = TimeEsportivoModel.builder( id )
                .withNome( nome )
                .withDataCriacao( dataCriacao )
                .withCorUniformePrincipal( corUniformePrincipal )
                .withCorUniformeSecundario( corUniformeSecundario )
                .build();
        ligaEsportivaModel.addTimeEsportivo( timeEsportivo );
    }

    public void incluirJogador( Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario ) {
        JogadorModel jogador = JogadorModel.builder( id, idTime )
                .withNome( nome )
                .withDataNascimento( dataNascimento )
                .withNivelHabilidade( nivelHabilidade )
                .withSalario( salario )
                .build();
        ligaEsportivaModel.getTimesDaLigaEsportiva().get( idTime ).addJogador( jogador );
    }

    public void definirCapitao( Long idJogador ) {
        throw new UnsupportedOperationException();
    }

    public Long buscarCapitaoDoTime( Long idTime ) {
        throw new UnsupportedOperationException();
    }

    public String buscarNomeJogador( Long idJogador ) {
        throw new UnsupportedOperationException();
    }

    public String buscarNomeTime( Long idTime ) {
        throw new UnsupportedOperationException();
    }

    public List< Long > buscarJogadoresDoTime( Long idTime ) {
        List< Long > listaIdsJogadores = new ArrayList<>();

        ligaEsportivaModel.getTimesDaLigaEsportiva()
                .get( idTime )
                .getJogadores()
                .keySet()
                .forEach( id -> listaIdsJogadores.add( id ) );

        return listaIdsJogadores;
    }

    public Long buscarMelhorJogadorDoTime( Long idTime ) {
        throw new UnsupportedOperationException();
    }

    public Long buscarJogadorMaisVelho( Long idTime ) {
        throw new UnsupportedOperationException();
    }

    public List< Long > buscarTimes() {
        List< Long > listaIdsLigaEsportiva = new ArrayList<>();

        ligaEsportivaModel.getTimesDaLigaEsportiva()
                .keySet()
                .forEach( id -> listaIdsLigaEsportiva.add( id ) );

        return listaIdsLigaEsportiva;
    }

    public Long buscarJogadorMaiorSalario( Long idTime ) {
        throw new UnsupportedOperationException();
    }

    public BigDecimal buscarSalarioDoJogador( Long idJogador ) {
        throw new UnsupportedOperationException();
    }

    public List< Long > buscarTopJogadores( Integer top ) {
        throw new UnsupportedOperationException();
    }

}
