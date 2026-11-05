package Application.RestAPI;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;
import Application.Manager.Manager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController
{
  private Manager manager;

  public ProjectController()
  {
    manager = new Manager();
  }
  @PostMapping("/projects")
  public void addProject(@RequestBody Project project)
  {
    manager.getProjectManager().addProject(project);
  }
}
