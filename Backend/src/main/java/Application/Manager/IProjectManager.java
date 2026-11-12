package Application.Manager;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.ArrayList;
import java.util.List;

public interface IProjectManager
{
  public void addProject(Project project) throws NullSavedToDatabaseException;
  public Project getProject(int id);
  public List<Project> getAllProjects();
}
