package RestConsomation;

import java.util.List;

import entities.Documentt;


public interface DocumentConsomationLocal {
	public  List<Documentt> consomation();
	public void Create(Documentt p);
	public void Update(Documentt p , int id);

}
