package Application.Manager;

import lombok.Getter;

@Getter
public class Manager
{
  private final IProjectManager projectManager;

  public Manager()
  {
    projectManager = new ProjectManager();
  }
}
