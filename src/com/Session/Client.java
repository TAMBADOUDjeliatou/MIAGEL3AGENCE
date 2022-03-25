package com.Session;
// Generated 23 mars 2022, 15:21:43 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(name = "client", catalog = "agence_immobiliere")
public class Client implements java.io.Serializable {

	private Integer idClient;
	private String nom;
	private String prenom;
	private String email;
	private Set<Visiter> visiters = new HashSet<Visiter>(0);
	private Set<Achat> achats = new HashSet<Achat>(0);

	public Client() {
	}

	public Client(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Client(String nom, String prenom, String email, Set<Visiter> visiters, Set<Achat> achats) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.visiters = visiters;
		this.achats = achats;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_client", unique = true, nullable = false)
	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	@Column(name = "nom", nullable = false, length = 20)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 20)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "email", nullable = false, length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Visiter> getVisiters() {
		return this.visiters;
	}

	public void setVisiters(Set<Visiter> visiters) {
		this.visiters = visiters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(Set<Achat> achats) {
		this.achats = achats;
	}

}
