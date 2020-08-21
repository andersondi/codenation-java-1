package br.com.codenation.model;

import org.junit.Test;

import java.time.LocalDate;
import static org.junit.Assert.assertEquals;


public class TimeEsportivoModelTest {
    @Test()
    public void deveRetornarErroQuandoMotoristaNaoTemHabilitacao() {
        LocalDate date = LocalDate.of(1970,1,1);

        TimeEsportivoModel team = TimeEsportivoModel.builder(1L)
                .withNome( "Arizona Cardinals")
                .withDataCriacao( date )
                .withCorUniformePrincipal( "Preto" )
                .withCorUniformeSecundario( "Preto e Branco" )
                .build();
        assertEquals("Preto", team.getCorUniformePrincipal());
    }

}