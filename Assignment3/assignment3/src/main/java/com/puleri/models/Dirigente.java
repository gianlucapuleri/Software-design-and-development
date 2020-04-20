package com.puleri.models;

import javax.persistence.*;

import java.util.*;

@Entity
public class Dirigente  {

    public Dirigente() {}
    
    public Dirigente(Integer id, String nome, String cognome, String ruolo, Squadra squadra) {
		this.setId(id);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setRuolo(ruolo);
		this.setSquadre(squadra);
	}

	@Id @GeneratedValue
    private Integer id;

    private String nome, cognome, ruolo;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "squadra_id")
    private Squadra squadra;

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

	public Squadra getSquadre() {
		return squadra;
	}

	public void setSquadre(Squadra squadra) {
		this.squadra = squadra;
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
		Dirigente other = (Dirigente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Dirigente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", ruolo=" + ruolo + ", squadra="
				+ squadra + "]";
	}

}
