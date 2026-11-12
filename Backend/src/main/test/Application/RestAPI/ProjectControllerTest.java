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
  public void ManagerGetAllProjects()
  {
    Assertions.assertDoesNotThrow(()->
        projectController.getAllProjects(null));
  }
}
