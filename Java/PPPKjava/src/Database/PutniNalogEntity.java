package Database;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PutniNalog", schema = "dbo", catalog = "PPPK")
public class PutniNalogEntity {
    private int idPutniNalog;
    private Timestamp datumOdlaska;
    private Timestamp datumDolaska;
    private Integer brojSati;
    private Integer brojDnevnica;
    private Integer iznosDnevnice;
    private String opis;

    @Id
    @Column(name = "IDPutniNalog", nullable = false)
    public int getIdPutniNalog() {
        return idPutniNalog;
    }

    public void setIdPutniNalog(int idPutniNalog) {
        this.idPutniNalog = idPutniNalog;
    }

    @Basic
    @Column(name = "DatumOdlaska", nullable = true)
    public Timestamp getDatumOdlaska() {
        return datumOdlaska;
    }

    public void setDatumOdlaska(Timestamp datumOdlaska) {
        this.datumOdlaska = datumOdlaska;
    }

    @Basic
    @Column(name = "DatumDolaska", nullable = true)
    public Timestamp getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Timestamp datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    @Basic
    @Column(name = "BrojSati", nullable = true)
    public Integer getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(Integer brojSati) {
        this.brojSati = brojSati;
    }

    @Basic
    @Column(name = "BrojDnevnica", nullable = true)
    public Integer getBrojDnevnica() {
        return brojDnevnica;
    }

    public void setBrojDnevnica(Integer brojDnevnica) {
        this.brojDnevnica = brojDnevnica;
    }

    @Basic
    @Column(name = "IznosDnevnice", nullable = true)
    public Integer getIznosDnevnice() {
        return iznosDnevnice;
    }

    public void setIznosDnevnice(Integer iznosDnevnice) {
        this.iznosDnevnice = iznosDnevnice;
    }

    @Basic
    @Column(name = "Opis", nullable = true, length = 100)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PutniNalogEntity that = (PutniNalogEntity) o;
        return idPutniNalog == that.idPutniNalog &&
                Objects.equals(datumOdlaska, that.datumOdlaska) &&
                Objects.equals(datumDolaska, that.datumDolaska) &&
                Objects.equals(brojSati, that.brojSati) &&
                Objects.equals(brojDnevnica, that.brojDnevnica) &&
                Objects.equals(iznosDnevnice, that.iznosDnevnice) &&
                Objects.equals(opis, that.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPutniNalog, datumOdlaska, datumDolaska, brojSati, brojDnevnica, iznosDnevnice, opis);
    }
}
