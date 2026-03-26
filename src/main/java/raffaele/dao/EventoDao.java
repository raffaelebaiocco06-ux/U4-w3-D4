package raffaele.dao;
import jakarta.persistence.*;
import raffaele.entities.Evento;
import raffaele.entities.Genere;
import raffaele.entities.PartitaDiCalcio;
import raffaele.exeption.NotFoundException;
import jakarta.persistence.TypedQuery;
import raffaele.entities.Concerto;

import java.util.List;

public class EventoDao {
    private final EntityManager entityManager;
    public EventoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    public void save(Evento newEvento){
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvento);
        transaction.commit();
        System.out.println(" L' Evento " + newEvento.getTitolo() + " è stato salvato con successo!");
    }
    public Evento findById(int Id) {
        Evento found = entityManager.find(Evento.class, Id);
        if (found == null) throw new NotFoundException(Id);
        return found;
    }

    public void delete(int Id){
        Evento found= findById(Id);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println(" L' Evento " + found.getTitolo() + " è stato rimosso con successo!");
    }
   public List<Concerto> getConcertiInStreaming(boolean inStreaming){
        TypedQuery<Concerto> query= entityManager.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming =: inStreaming", Concerto.class);
       query.setParameter("streaming", inStreaming);
       return query.getResultList();
   }
   public List<Concerto> getConcertiPerGenere(Genere genere){
       TypedQuery<Concerto> query= entityManager.createQuery("SELECT c FROM Concerto c WHERE c.genere =: genere",Concerto.class);
       query.setParameter("streaming", genere);
       return query.getResultList();
   }
   public List<PartitaDiCalcio> getPartiteVinteInCasa(){
        TypedQuery<PartitaDiCalcio> query= entityManager.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadravincente = p.squadradicasa", PartitaDiCalcio.class);
       return query.getResultList();
   }
    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(){
        TypedQuery<PartitaDiCalcio> query= entityManager.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadravincente = p.squadraospite", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
