package Application.Database;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

  // Tests for Project
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

  @Test
  public void cannotGetNonexistentProject()
  {
    Assertions.assertThrows(IndexOutOfBoundsException.class, ()->
        dbs.getProjectDAO().getProject(-1)
        );
  }

  @Test
  public void gettingExistingProjectReturnsSame()
  {
    // Arrange
    dbs.getProjectDAO().addProject(new Project(testProject));

    // Assert
    Assertions.assertEquals(dbs.getProjectDAO().getProject(0), testProject);
  }

  @Test
  public void canGetEmptyListOfProjects()
  {
    Assertions.assertEquals(dbs.getProjectDAO().getAllProjects(), new ArrayList<Project>());
  }

  @Test
  public void addingProjectReturnsNonEmptyList()
  {
    // Arrange
    dbs.getProjectDAO().addProject(testProject);

    // Assert
    Assertions.assertEquals(1, dbs.getProjectDAO().getAllProjects().size());
  }
}
