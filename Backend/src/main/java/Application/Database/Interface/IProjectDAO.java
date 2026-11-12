package Application.Database.Interface;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.List;

public interface IProjectDAO
{
  public void addProject(Project project) throws NullSavedToDatabaseException;
  public Project getProject(int id);
  public List<Project> getAllProjects();
}
