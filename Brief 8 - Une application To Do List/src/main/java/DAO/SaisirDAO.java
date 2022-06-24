package DAO;

import Model.Category;
import Model.Tache;

public interface SaisirDAO {

    public abstract void createTache(Tache tache);

    public abstract void updateTache(Integer id_tache, String newtitle, String newdescription, String newdeadline, String newstatue);

    public abstract void createCategory(Category category);
}
