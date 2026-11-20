package Application.Manager;

import Application.Database.DatabaseManager;
import lombok.Getter;

/**
 * The class that contains all the managers for the system.
 * Delegates methods through private manager variables.
 */
@Getter
public class Manager
{
  private final IProjectManager projectManager;
  private final DatabaseManager dbs;

  /**
   * Constructor.
   * Creates the database instance that is then passed on to the managers.
   */
  public Manager()
  {
    dbs = new DatabaseManager();

    projectManager = new ProjectManager(dbs);
  }
}
