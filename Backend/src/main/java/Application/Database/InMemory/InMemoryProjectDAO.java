package Application.Database.InMemory;

import Application.Database.Interface.IProjectDAO;
import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.ArrayList;

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
}
