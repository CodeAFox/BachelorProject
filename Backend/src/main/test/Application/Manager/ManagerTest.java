package Application.Manager;

import Application.Entities.Base.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
