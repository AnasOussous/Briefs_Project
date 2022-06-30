package model;

public class User {
	
	private int id_User;
    private String name_User;
    private String prenom_User;
    private String username;
    private String psw;

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getName_User() {
        return name_User;
    }

    public void setName_User(String name_User) {
        this.name_User = name_User;
    }

    public String getPrenom_User() {
        return prenom_User;
    }

    public void setPrenom_User(String prenom_User) {
        this.prenom_User = prenom_User;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_User=" + id_User +
                ", name_User='" + name_User + '\'' +
                ", prenom_User='" + prenom_User + '\'' +
                ", username='" + username + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
