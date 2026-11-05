package Application.Database;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseManagerTest
{
  private DatabaseManager dbs;
  private Project testProject;
  @BeforeEach
  public void setUp()
  {
    dbs = new DatabaseManager();
    testProject = new Project("Test", "This is a test project");
  }

  @Test
  public void databaseManagerIsNotNull()
  {
    Assertions.assertNotNull(dbs);
  }
  @Test
  public void projectDAOIsNotNull()
  {
    Assertions.assertNotNull(dbs.getProjectDAO());
  }

  @Test
  public void addingNullAsProjectThrowsError()
  {
    Assertions.assertThrows(NullSavedToDatabaseException.class, ()->
        dbs.getProjectDAO().addProject(null));
  }

  @Test
  public void addingOneProjectIsPossible()
  {
    Assertions.assertDoesNotThrow(() ->
        dbs.getProjectDAO().addProject(testProject)
        );
  }
}
