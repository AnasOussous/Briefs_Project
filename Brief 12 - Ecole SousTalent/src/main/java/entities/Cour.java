package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cour")
public class Cour implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
    @Column(name = "idcour", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcour;
	
	@Column(name = "nameCour")
	private String name;
	
	
	@ManyToMany
	@JoinTable(name = "cours_etudiant", 
			  joinColumns = @JoinColumn(name = "Etudiant_id"), 
			  inverseJoinColumns = @JoinColumn(name = "Cours_id"))
    private List<Etudiant> etudiant;


	public Cour(Integer idcour, String name, List<Etudiant> etudiant) {
		super();
		this.idcour = idcour;
		this.name = name;
		this.etudiant = etudiant;
	}


	public Cour() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getIdcour() {
		return idcour;
	}


	public void setIdcour(Integer idcour) {
		this.idcour = idcour;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Etudiant> getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Cour [idcour=" + idcour + ", name=" + name + ", etudiant=" + etudiant + "]";
	}
	
	
	
	
}
