package com.puleri.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Citta  {

    public Citta() {
        setSquadre(new ArrayList<>());
    }
    
    public Citta(Integer id, String nome, String provincia, String stato, List<Squadra> squadre) {
    	super();
		this.setId(id);
		this.setNome(nome);
		this.setProvincia(provincia);
		this.setStato(stato);
		this.setSquadre(squadre);
	}


	@Id @GeneratedValue
    private Integer id;

    private String nome, provincia, stato;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "citta", orphanRemoval = true)
    private List<Squadra> squadre;

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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public List<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(List<Squadra> squadre) {
		this.squadre = squadre;
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
		Citta other = (Citta) obj;
		return Objects.equals(id, other.id);
	}

	
}
