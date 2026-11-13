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

  @Test
  public void cannotDeleteNonExistentProject()
  {
    Assertions.assertThrows(IndexOutOfBoundsException.class, ()->
        dbs.getProjectDAO().deleteProject(-1));
  }

  @Test
  public void deleteAddedProject()
  {
    // Arrange
    dbs.getProjectDAO().addProject(testProject);
    Assertions.assertEquals(1, dbs.getProjectDAO().getAllProjects().size());

    // Act
    dbs.getProjectDAO().deleteProject(0);

    // Assert
    Assertions.assertEquals(0, dbs.getProjectDAO().getAllProjects().size());
  }

  @Test
  public void canDeleteFromMultipleProjects()
  {
    // Arrange
    dbs.getProjectDAO().addProject(testProject);
    dbs.getProjectDAO().addProject(testProject);
    dbs.getProjectDAO().addProject(testProject);
    Assertions.assertEquals(3, dbs.getProjectDAO().getAllProjects().size());

    // Act
    dbs.getProjectDAO().deleteProject(1);

    // Assert
    Assertions.assertEquals(2, dbs.getProjectDAO().getAllProjects().size());
  }

  @Test
  public void cannotEditNonexistentProject()
  {
    Assertions.assertThrows(IndexOutOfBoundsException.class, ()->
        dbs.getProjectDAO().editProject(-1, testProject));
  }

  @Test
  public void editingProjectEditsIt()
  {
    // Arrange
    dbs.getProjectDAO().addProject(testProject);
    Assertions.assertEquals(testProject, dbs.getProjectDAO().getProject(0));

    // Act
    dbs.getProjectDAO().editProject(0, new Project("test2", "under test"));

    // Assert
    Assertions.assertNotEquals(testProject, dbs.getProjectDAO().getProject(0));
    Assertions.assertEquals(new Project("test2", "under test"), dbs.getProjectDAO().getProject(0));
  }
}
