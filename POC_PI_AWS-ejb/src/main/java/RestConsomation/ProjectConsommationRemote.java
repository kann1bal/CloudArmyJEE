package RestConsomation;

import java.util.List;

import entities.Project;



public interface ProjectConsommationRemote {
	List<Project> Consomation();
	void Update(Project p, int id);

	void Add(Project p);

	void Delete(Project p);

}
