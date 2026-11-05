package Application.Manager;

import Application.Database.DatabaseManager;
import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

public class ProjectManager implements IProjectManager
{
  private DatabaseManager dbs;

  public ProjectManager()
  {
    dbs = new DatabaseManager();
  }
  public void addProject(Project project) throws NullSavedToDatabaseException
  {
    dbs.getProjectDAO().addProject(project);
  }
}
