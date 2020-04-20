package com.puleri.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Sponsor  {

    public Sponsor() {
        setSquadre(new ArrayList<>());
    }
    
    public Sponsor(Integer id, String nome, List<Squadra> squadre) {
    	super();
		this.setId(id);
		this.setNome(nome);
		this.setSquadre(squadre);
	}

	@Id @GeneratedValue
    private Integer id;

    private String nome;

    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "sponsors")
    private List<Squadra> squadre = new ArrayList<>();

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
		Sponsor other = (Sponsor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Sponsor [id=" + id + ", nome=" + nome + ", squadre=" + squadre + "]";
	}

}
