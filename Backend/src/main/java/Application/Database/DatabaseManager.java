package Application.Database;

import Application.Database.InMemory.InMemoryProjectDAO;
import Application.Database.Interface.IProjectDAO;
import lombok.Getter;

/**
 * The class that manages and delegates database related entities.
 */
@Getter
public class DatabaseManager
{
  private final IProjectDAO projectDAO;

  public DatabaseManager()
  {
    projectDAO = new InMemoryProjectDAO();
  }
}
