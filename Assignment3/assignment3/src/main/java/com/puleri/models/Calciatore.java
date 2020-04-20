package com.puleri.models;

import javax.persistence.*;

import java.util.*;

@Entity
public class Calciatore {

    public Calciatore() {}
    
    public Calciatore(Integer id, String nome, String cognome, String ruolo, String nazionalita, Squadra squadra,
			Calciatore padre, List<Calciatore> figlicalciatore) {
		this.setId(id);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setRuolo(ruolo);
		this.setNazionalita(nazionalita);
		this.setSquadre(squadra);
		this.setPadre(padre);
		this.setFiglicalciatore(figlicalciatore);
	}

	@Id @GeneratedValue
    private Integer id;

    private String nome, cognome, ruolo, nazionalita;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "squadra_id")
    private Squadra squadra;
	
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "calciatore_id")
    private Calciatore padre;
    
	@OneToMany(mappedBy="padre")
	private List<Calciatore> figlicalciatore = new ArrayList<>();

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Squadra getSquadre() {
		return squadra;
	}

	public void setSquadre(Squadra squadra) {
		this.squadra = squadra;
	}

	public Calciatore getPadre() {
		return padre;
	}

	public void setPadre(Calciatore padre) {
		this.padre = padre;
	}

	public List<Calciatore> getFiglicalciatore() {
		return figlicalciatore;
	}

	public void setFiglicalciatore(List<Calciatore> figlicalciatore) {
		this.figlicalciatore = figlicalciatore;
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
		Calciatore other = (Calciatore) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Calciatore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", ruolo=" + ruolo
				+ ", nazionalita=" + nazionalita + ", squadra=" + squadra + ", padre=" + padre
				+ ", figlicalciatore=" + figlicalciatore + "]";
	}

}
