package br.com.codenation.model;

import java.util.HashMap;
import java.util.Map;

public class LigaEsportivaModel {

    Map< Long, TimeEsportivoModel > timesDaLigaEsportiva = new HashMap<>();

    public LigaEsportivaModel() {
    }

    public Map< Long, TimeEsportivoModel > getTimesDaLigaEsportiva() {
        return timesDaLigaEsportiva;
    }

    public void setLigaEsportiva( Map< Long, TimeEsportivoModel > timesDaLigaEsportiva ) {
        this.timesDaLigaEsportiva = timesDaLigaEsportiva;
    }

    public void addTimeEsportivo( TimeEsportivoModel timeEsportivo ) {
        getTimesDaLigaEsportiva().put( timeEsportivo.getId(), timeEsportivo );
    }

    public TimeEsportivoModel findTimeEsportivo( Long id ) {
        TimeEsportivoModel timeProcurado = timesDaLigaEsportiva.get( id );

        return timeProcurado;
    }
}
