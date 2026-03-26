package raffaele.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="concerti")
public class Concerto extends Evento {
    @Enumerated(EnumType.STRING)
    @Column(name="genere")
    private Genere genere;
    @Column(name="streaming")
    private boolean streaming;

//costruttori
    public Concerto() {}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, int nmaxpartecipanti, Genere genere, boolean streaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, nmaxpartecipanti);
        this.genere = genere;
        this.streaming = streaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", streaming=" + streaming +
                '}';
    }
}
