package Application.RestAPI;

import Application.Entities.Base.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
