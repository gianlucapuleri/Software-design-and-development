package com.puleri.models;

import javax.persistence.*;

import java.util.*;

@Entity
public class Squadra  {

    public Squadra() {
        setSponsors(new ArrayList<>());
        setCalciatori(new ArrayList<>());
        setDirigenti(new ArrayList<>());
    }

    public Squadra(Integer id, String nome, String lega, String colori, Integer fatturato, List<Sponsor> sponsors,
			Citta citta, List<Calciatore> calciatori, List<Dirigente> dirigenti) {
    	super();
		this.setId(id);
		this.setNome(nome);
		this.setLega(lega);
		this.setColori(colori);
		this.setFatturato(fatturato);
		this.setSponsors(sponsors);
		this.setCitta(citta);
		this.setCalciatori(calciatori);
		this.setDirigenti(dirigenti);
	}

	@Id @GeneratedValue
    private Integer id;

    private String nome, lega, colori;
    
    private Integer fatturato;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Finanzia",
            joinColumns = @JoinColumn(name = "squadra_id"),
            inverseJoinColumns = @JoinColumn(name = "sponsor_id")
    )
    private List<Sponsor> sponsors = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "citta_id", nullable = false)
    private Citta citta;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "squadra", orphanRemoval = true)
    private List<Calciatore> calciatori;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "squadra", orphanRemoval = true)
    private List<Dirigente> dirigenti;

    public void addSponsor(Sponsor other) {
        sponsors.add(other);
        other.getSquadre().add(this);
    }

	public void removeSponsor(Sponsor other) {
        sponsors.remove(other);
        other.getSquadre().remove(this);
    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLega() {
		return lega;
	}

	public void setLega(String lega) {
		this.lega = lega;
	}

	public String getColori() {
		return colori;
	}

	public void setColori(String colori) {
		this.colori = colori;
	}

	public Integer getFatturato() {
		return fatturato;
	}

	public void setFatturato(Integer fatturato) {
		this.fatturato = fatturato;
	}

	public List<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	public List<Calciatore> getCalciatori() {
		return calciatori;
	}

	public void setCalciatori(List<Calciatore> calciatori) {
		this.calciatori = calciatori;
	}

	public List<Dirigente> getDirigenti() {
		return dirigenti;
	}

	public void setDirigenti(List<Dirigente> dirigenti) {
		this.dirigenti = dirigenti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Squadra other = (Squadra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Squadra [id=" + id + ", nome=" + nome + ", lega=" + lega + ", colori=" + colori + ", fatturato="
				+ fatturato + ", sponsors=" + sponsors + ", citta=" + citta + ", calciatori=" + calciatori
				+ ", dirigenti=" + dirigenti + "]";
	}
	
}
