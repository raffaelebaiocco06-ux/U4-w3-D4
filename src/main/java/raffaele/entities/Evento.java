package raffaele.entities;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "titolo", nullable = false, length = 30)
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(name = "descrizione", nullable = false, length = 30)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false)
    private EventType tipoEvento;

    @Column(name = "nmaxpartecipanti", nullable = false)
    private int nmaxpartecipanti;

    public Evento() {
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione,
                  EventType tipoEvento, int nmaxpartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.nmaxpartecipanti = nmaxpartecipanti;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public EventType getTipoEvento() {
        return tipoEvento;
    }

    public int getNmaxpartecipanti() {
        return nmaxpartecipanti;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipoEvento(EventType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setNmaxpartecipanti(int nmaxpartecipanti) {
        this.nmaxpartecipanti = nmaxpartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", nmaxpartecipanti=" + nmaxpartecipanti +
                '}';
    }
}


