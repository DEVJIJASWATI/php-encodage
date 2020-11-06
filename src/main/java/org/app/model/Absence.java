package org.app.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "absence")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_absence;

    private String motif;

    private Date date_entrer;

    private Time heure_entrer;

    private int cumul;

    private boolean autorisation;

    public long getId_absence() {
        return id_absence;
    }

    public void setId_absence(long id_absence) {
        this.id_absence = id_absence;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDate_entrer() {
        return date_entrer;
    }

    public void setDate_entrer(Date date_entrer) {
        this.date_entrer = date_entrer;
    }

    public Time getHeure_entrer() {
        return heure_entrer;
    }

    public void setHeure_entrer(Time heure_entrer) {
        this.heure_entrer = heure_entrer;
    }

    public int getCumul() {
        return cumul;
    }

    public void setCumul(int cumul) {
        this.cumul = cumul;
    }

    public boolean isAutorisation() {
        return autorisation;
    }

    public void setAutorisation(boolean autorisation) {
        this.autorisation = autorisation;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "id_absence=" + id_absence +
                ", motif='" + motif + '\'' +
                ", date_entrer=" + date_entrer +
                ", heure_entrer=" + heure_entrer +
                ", cumul=" + cumul +
                ", autorisation=" + autorisation +
                '}';
    }

}
