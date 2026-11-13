package Application.Manager;

import Application.Entities.Base.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ManagerTest
{
  private Manager manager;
  private Project testProject;
  @BeforeEach
  public void setUp()
  {
    manager = new Manager();
    testProject = new Project("Test", "This is a test project.");
  }

  @Test
  public void addProjectMethodCanBeCalled()
  {
    Assertions.assertDoesNotThrow(() ->
        manager.getProjectManager().addProject(testProject));
  }

  @Test
  public void getProjectMethodCanBeCalled()
  {
    // Arrange
    manager.getProjectManager().addProject(testProject);

    // Assert
    Assertions.assertDoesNotThrow(() ->
        manager.getProjectManager().getProject(0));
  }

  @Test
  public void getAllProjectsMethodCanBeCalled()
  {
    Assertions.assertDoesNotThrow(()->
        manager.getProjectManager().getAllProjects(Optional.empty()));
  }

  @Test
  public void moreThanOneProjectCanBeAdded()
  {
    // Arrange
    manager.getProjectManager().addProject(testProject);
    manager.getProjectManager().addProject(testProject);
    manager.getProjectManager().addProject(testProject);

    // Assert
    Assertions.assertEquals(3, manager.getProjectManager().getAllProjects(Optional.empty()).size());
  }

  @Test
  public void filteringProjectNameReturnsCorrectProjects()
  {
    //Arrange
    manager.getProjectManager().addProject(new Project("Test", "This is a test"));
    manager.getProjectManager().addProject(new Project("Holidays", "This is a test"));
    manager.getProjectManager().addProject(new Project("Tessa", "This is a test"));

    //Assert
    Assertions.assertEquals(2, manager.getProjectManager().getAllProjects(Optional.of("Tes")).size());
    Assertions.assertEquals(1, manager.getProjectManager().getAllProjects(Optional.of("Holidays")).size());
    Assertions.assertEquals(3, manager.getProjectManager().getAllProjects(Optional.of("s")).size());
    Assertions.assertEquals(0, manager.getProjectManager().getAllProjects(Optional.of("hello there")).size());
  }

  @Test
  public void filteringProjectNamesDisregardsCapitalization()
  {
    // Arrange
    manager.getProjectManager().addProject(new Project("Test", "This is a test"));
    manager.getProjectManager().addProject(new Project("Holidays", "This is a test"));
    manager.getProjectManager().addProject(new Project("tessa", "This is a test"));

    // Assert
    Assertions.assertEquals(2, manager.getProjectManager().getAllProjects(Optional.of("tes")).size());
    Assertions.assertEquals(1, manager.getProjectManager().getAllProjects(Optional.of("holidays")).size());
    Assertions.assertEquals(3, manager.getProjectManager().getAllProjects(Optional.of("S")).size());
  }

  @Test
  public void deleteProjectCanBeCalled()
  {
    // Arrange
    manager.getProjectManager().addProject(testProject);

    Assertions.assertDoesNotThrow(()->
        manager.getProjectManager().deleteProject(0));
  }

}
