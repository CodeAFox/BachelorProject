package Application.Database.InMemory;

import Application.Database.Interface.IProjectDAO;
import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProjectDAO implements IProjectDAO
{
  private ArrayList<Project> projects = new ArrayList<>();
  public void addProject(Project project) throws NullSavedToDatabaseException
  {
    //Verification before adding
    if(project == null)
    {
      throw new NullSavedToDatabaseException("Project");
    }
    projects.add(project);
  }

  public Project getProject(int id)
  {
    return new Project(projects.get(id));
  }

  public List<Project> getAllProjects()
  {
    return new ArrayList<>(projects);
  }

  public void deleteProject(int id)
  {
    projects.remove(id);
  }

  public Project editProject(int id, Project edited)
  {
    projects.set(id, edited);

    return projects.get(id);
  }
}
