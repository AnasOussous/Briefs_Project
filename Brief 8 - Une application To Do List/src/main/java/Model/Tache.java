package Model;

public class Tache {
    private Integer id_tache;
    private String title;
    private String description;
    private String deadline;
    private String statue;
    private int id_Category;

    public Tache(Integer id_tache, String title, String description, String deadline, String statue, int id_Category) {
        this.id_tache = id_tache;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.statue = statue;
        this.id_Category = id_Category;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public int getId_Category() {
        return id_Category;
    }

    public void setId_Category(int id_Category) {
        this.id_Category = id_Category;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "statue='" + statue + '\'' +
                '}';
    }
}
