package com.Session;
// Generated 23 mars 2022, 15:21:43 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Proprietes generated by hbm2java
 */
@Entity
@Table(name = "proprietes", catalog = "agence_immobiliere")
public class Proprietes implements java.io.Serializable {

	private Integer idPropriete;
	private Adresse adresse;
	private Proprietaire proprietaire;
	private int surface;
	private int prix;
	private boolean disponibilite;
	private Date dateDispo;
	private Set<Achat> achats = new HashSet<Achat>(0);
	private Set<Visiter> visiters = new HashSet<Visiter>(0);

	public Proprietes() {
	}

	public Proprietes(Adresse adresse, Proprietaire proprietaire, int surface, int prix, boolean disponibilite,
			Date dateDispo) {
		this.adresse = adresse;
		this.proprietaire = proprietaire;
		this.surface = surface;
		this.prix = prix;
		this.disponibilite = disponibilite;
		this.dateDispo = dateDispo;
	}

	public Proprietes(Adresse adresse, Proprietaire proprietaire, int surface, int prix, boolean disponibilite,
			Date dateDispo, Set<Achat> achats, Set<Visiter> visiters) {
		this.adresse = adresse;
		this.proprietaire = proprietaire;
		this.surface = surface;
		this.prix = prix;
		this.disponibilite = disponibilite;
		this.dateDispo = dateDispo;
		this.achats = achats;
		this.visiters = visiters;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_propriete", unique = true, nullable = false)
	public Integer getIdPropriete() {
		return this.idPropriete;
	}

	public void setIdPropriete(Integer idPropriete) {
		this.idPropriete = idPropriete;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "num_adresse", nullable = false)
	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proprietaire", nullable = false)
	public Proprietaire getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Column(name = "surface", nullable = false)
	public int getSurface() {
		return this.surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	@Column(name = "prix", nullable = false)
	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@Column(name = "disponibilite", nullable = false)
	public boolean isDisponibilite() {
		return this.disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_dispo", nullable = false, length = 10)
	public Date getDateDispo() {
		return this.dateDispo;
	}

	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proprietes")
	public Set<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(Set<Achat> achats) {
		this.achats = achats;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proprietes")
	public Set<Visiter> getVisiters() {
		return this.visiters;
	}

	public void setVisiters(Set<Visiter> visiters) {
		this.visiters = visiters;
	}

}