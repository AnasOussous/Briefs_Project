package dao;

public interface DAO <T> {

	public void Add(T t);
	
	public void Delete(T t);
	
	public void Update(T t);
	
	public void SelectAll(T t);
	
	public void SelectById(T t);
}
