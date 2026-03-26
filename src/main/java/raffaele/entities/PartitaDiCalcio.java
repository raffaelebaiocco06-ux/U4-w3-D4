package raffaele.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="partita_di_calcio")
public class PartitaDiCalcio extends  Evento {
  @Column(name = "squadradicasa" ,nullable = false)
    private String squadradicasa;
    @Column(name = "squadraospite" ,nullable = false)
    private String squadraospite;
    @Column(name = "squadravincente" ,nullable = false)
    private String squadravincente;
    @Column(name = "ngolcasa" ,nullable = false)
    private int ngolcasa;
    @Column(name = "ngolospite" ,nullable = false)
    private int ngolospite;

    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, int nmaxpartecipanti, String squadradicasa, String squadraospite, String squadravincente, int ngolcasa, int ngolospite) {
        super(titolo, dataEvento, descrizione, tipoEvento, nmaxpartecipanti);
        this.squadradicasa = squadradicasa;
        this.squadraospite = squadraospite;
        this.squadravincente = squadravincente;
        this.ngolcasa = ngolcasa;
        this.ngolospite = ngolospite;
    }

    public String getSquadradicasa() {
        return squadradicasa;
    }

    public String getSquadraospite() {
        return squadraospite;
    }

    public String getSquadravincente() {
        return squadravincente;
    }

    public int getNgolcasa() {
        return ngolcasa;
    }

    public int getNgolospite() {
        return ngolospite;
    }

    public void setSquadradicasa(String squadradicasa) {
        this.squadradicasa = squadradicasa;
    }

    public void setSquadraospite(String squadraospite) {
        this.squadraospite = squadraospite;
    }

    public void setSquadravincente(String squadravincente) {
        this.squadravincente = squadravincente;
    }

    public void setNgolcasa(int ngolcasa) {
        this.ngolcasa = ngolcasa;
    }

    public void setNgolospite(int ngolospite) {
        this.ngolospite = ngolospite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadradicasa='" + squadradicasa + '\'' +
                ", squadraospite='" + squadraospite + '\'' +
                ", squadravincente='" + squadravincente + '\'' +
                ", ngolcasa=" + ngolcasa +
                ", ngolospite=" + ngolospite +
                '}';
    }
}

