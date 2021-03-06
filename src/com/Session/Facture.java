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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Facture generated by hbm2java
 */
@Entity
@Table(name = "facture", catalog = "agence_immobiliere")
public class Facture implements java.io.Serializable {

	private Integer idFacture;
	private Date dateFacture;
	private Date montant;
	private Set<Achat> achats = new HashSet<Achat>(0);

	public Facture() {
	}

	public Facture(Date dateFacture, Date montant) {
		this.dateFacture = dateFacture;
		this.montant = montant;
	}

	public Facture(Date dateFacture, Date montant, Set<Achat> achats) {
		this.dateFacture = dateFacture;
		this.montant = montant;
		this.achats = achats;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_facture", unique = true, nullable = false)
	public Integer getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(Integer idFacture) {
		this.idFacture = idFacture;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_facture", nullable = false, length = 10)
	public Date getDateFacture() {
		return this.dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "montant", nullable = false, length = 10)
	public Date getMontant() {
		return this.montant;
	}

	public void setMontant(Date montant) {
		this.montant = montant;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facture")
	public Set<Achat> getAchats() {
		return this.achats;
	}

	public void setAchats(Set<Achat> achats) {
		this.achats = achats;
	}

}
