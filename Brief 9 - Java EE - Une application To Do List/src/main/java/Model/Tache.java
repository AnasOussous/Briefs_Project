package Model;

import java.time.LocalDate;

public class Tache {
	private Integer id_tache;
    private String title;
    private String description;
    private LocalDate deadline;
    private String statue;

    public Tache(Integer id_tache, String title, String description, LocalDate deadline, String statue) {
        this.id_tache = id_tache;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.statue = statue;
    }
    
    public Tache(String title, String description, LocalDate deadline, String statue) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.statue = statue;
    }


    public Tache(){}

    public Integer getId_tache() {
        return id_tache;
    }

    public void setId_tache(Integer id_tache) {
        this.id_tache = id_tache;
    }

    public void setId_tache(int id_tache) {
        this.id_tache = id_tache;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }


    @Override
    public String toString() {
        return "Tache{" +
                "statue='" + statue + '\'' +
                '}';
    }
}
