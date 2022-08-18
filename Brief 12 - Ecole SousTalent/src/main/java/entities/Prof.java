package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "prof")
public class Prof implements Serializable{
	private static final long serialVersionUID = 1L;


		@Id
	    @Column(name = "idprof", columnDefinition = "serial")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idprof;
		
		@Column(name = "fullnameProf")
		private String fullname;
		
		@Column(name = "sexeProf")
		private String sexe;
		
		@Column(name = "phone")
		private String phone;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="Prof_ID")
		private Set<Cour> cour;

		public Prof(long idprof, String fullname, String sexe, String phone, Set<Cour> cour) {
			super();
			this.idprof = idprof;
			this.fullname = fullname;
			this.sexe = sexe;
			this.phone = phone;
			this.cour = cour;
		}

		public Prof() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getIdprof() {
			return idprof;
		}

		public void setIdprof(long idprof) {
			this.idprof = idprof;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getSexe() {
			return sexe;
		}

		public void setSexe(String sexe) {
			this.sexe = sexe;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Set<Cour> getCour() {
			return cour;
		}

		public void setCour(Set<Cour> cour) {
			this.cour = cour;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Prof [idprof=" + idprof + ", fullname=" + fullname + ", sexe=" + sexe + ", phone=" + phone
					+ ", cour=" + cour + "]";
		}
	
		
}
