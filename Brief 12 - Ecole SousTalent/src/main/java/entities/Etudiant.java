package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
    @Column(name = "idetudiant", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idetudiant;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "Age")
	private String Age;
	
	@Column(name = "SexeEtud")
	private String SexeEtud;
	
	@ManyToMany
	@JoinTable(name = "cours_etudiant", 
			  joinColumns = @JoinColumn(name = "Etudiant_id"), 
			  inverseJoinColumns = @JoinColumn(name = "Cours_id"))
    private List<Cour> cour;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String fullname, String dateNaissance, String sexeEtud) {
		super();
		this.fullname = fullname;
		this.Age = dateNaissance;
		SexeEtud = sexeEtud;
	}

	public Integer getIdetudiant() {
		return idetudiant;
	}

	public void setIdetudiant(Integer idetudiant) {
		this.idetudiant = idetudiant;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String Age) {
		this.Age = Age;
	}

	public String getSexeEtud() {
		return SexeEtud;
	}

	public void setSexeEtud(String sexeEtud) {
		SexeEtud = sexeEtud;
	}

	@Override
	public String toString() {
		return "Etudiant [idetudiant=" + idetudiant + ", fullname=" + fullname + ", dateNaissance=" + Age
				+ ", SexeEtud=" + SexeEtud + "]";
	}

	
	
}