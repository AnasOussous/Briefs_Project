package com.simplilearn.Brief5;

public class Candidat {
	private int id_candidat;
	private String nom;
	private String prénom;
	private String mail;
	private String adresse;
	private String ville;
	private String pays;
	
	public int getId_candidat() {
		return id_candidat;
	}
	public void setId_candidat(int id_candidat) {
		this.id_candidat = id_candidat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrénom() {
		return prénom;
	}
	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Candidat [id_candidat=" + id_candidat + ", nom=" + nom + ", prénom=" + prénom + ", mail=" + mail
				+ ", adresse=" + adresse + ", ville=" + ville + ", pays=" + pays + "]";
	}
	
	
	
}
