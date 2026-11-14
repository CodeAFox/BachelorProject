package Application.RestAPI;

import Application.Entities.Base.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ProjectControllerTest
{
  private ProjectController projectController;
  private Project testProject;
  @BeforeEach
  public void setUp()
  {
    projectController = new ProjectController();
    testProject = new Project("Test", "This is a test project.");
  }

  @Test
  public void ManagerAddProjectCanBeCalled()
  {
    Assertions.assertDoesNotThrow(() ->
        projectController.addProject(testProject));
  }

  @Test
  public void ManagerGetProjectCanBeCalled()
  {
    // Arrange
    projectController.addProject(testProject);

    // Assert
    Assertions.assertDoesNotThrow(()->
        projectController.getProject(0));
  }

  @Test
  public void ManagerGetAllProjectsCanBeCalledWithoutFilter()
  {
    Assertions.assertDoesNotThrow(()->
        projectController.getAllProjects(null));
  }

  @Test
  public void managerGetProjectsCanBeCalledWithFilter()
  {
    Assertions.assertDoesNotThrow(()->
        projectController.getAllProjects("test"));
  }

  @Test
  public void managerDeleteProjectCanBeCalled()
  {
    // Arrange
    projectController.addProject(testProject);

    // Assertions
    Assertions.assertDoesNotThrow(()->
        projectController.deleteProject(0));
  }

  @Test
  public void managerEditProjectCanBeCalled()
  {
    // Arrange
    projectController.addProject(testProject);

    //Assert
    Assertions.assertDoesNotThrow(()->
        projectController.editProject(0, new Project("test", "under test")));
  }
}
