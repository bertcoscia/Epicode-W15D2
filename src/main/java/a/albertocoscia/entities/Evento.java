package a.albertocoscia.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")

public class Evento {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "titolo", nullable = false)
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "descrizione", nullable = false)
    private String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventoTipo tipoEvento;
    @Column(name = "max_pax")
    private int maxPax;

    public Evento() {
    }

    ;

    public Evento(String titolo, LocalDate data, String desc, EventoTipo tipo, int maxPax) {
        this.titolo = titolo;
        this.dataEvento = data;
        this.descrizione = desc;
        this.tipoEvento = tipo;
        this.maxPax = maxPax;
    }

    public Long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventoTipo getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventoTipo tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getMaxPax() {
        return maxPax;
    }

    public void setMaxPax(int maxPax) {
        this.maxPax = maxPax;
    }
}
