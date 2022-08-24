package DAO;

import Model.Category;
import Model.Tache;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public interface TodoListDAO {

    //public abstract ArrayList<String> getSsns();

    //public abstract void createTache(Tache tache);

    //public abstract void createCategory(Category category);

    public abstract void deleteTache(Integer id_tache);

    public abstract void AffTache(Tache tache, ObservableList<Tache> tacheList);

    //public abstract void updateTache(Integer id_tache, String newtitle, String newdescription, String newdeadline, String newstatue);
}
