package Application.Manager;

import Application.Database.DatabaseManager;
import lombok.Getter;

@Getter
public class Manager
{
  private final IProjectManager projectManager;
  private final DatabaseManager dbs;

  public Manager()
  {
    dbs = new DatabaseManager();

    projectManager = new ProjectManager(dbs);
  }
}
