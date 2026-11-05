package Application.Manager;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

public interface IProjectManager
{
  public void addProject(Project project) throws NullSavedToDatabaseException;
}
