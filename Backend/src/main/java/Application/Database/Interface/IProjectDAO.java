package Application.Database.Interface;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

public interface IProjectDAO
{
  public void addProject(Project project) throws NullSavedToDatabaseException;
}
