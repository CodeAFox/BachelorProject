package Application.RestAPI;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;
import Application.Manager.Manager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

  @GetMapping("/projects/{id}")
  public Project getProject(@PathVariable int id)
  {
    return manager.getProjectManager().getProject(id);
  }

  @GetMapping("/projects")
  public List<Project> getAllProjects(
      @PathVariable(required = false) String projectNameFilter
  )
  {
    return manager.getProjectManager().getAllProjects(Optional.ofNullable(projectNameFilter));
  }
}
