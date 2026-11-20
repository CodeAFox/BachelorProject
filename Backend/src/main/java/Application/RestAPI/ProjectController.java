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

  /**
   * Constructor of Project Controller REST API endpoint collection
   */
  public ProjectController()
  {
    manager = new Manager();
  }

  /**
   * REST API endpoint for adding a new {@link Project} to the database
   * @param project the project that needs to be added
   */
  @PostMapping("/projects")
  public void addProject(@RequestBody Project project)
  {
    manager.getProjectManager().addProject(project);
  }

  /**
   * REST API endpoint for retrieving an existing {@link Project} from the database
   * @param id The ID of the {@link Project} that needs to be retrieved
   * @return The {@link Project} that was retrieved
   */
  @GetMapping("/projects/{id}")
  public Project getProject(@PathVariable int id)
  {
    return manager.getProjectManager().getProject(id);
  }

  /**
   * REST API endpoint for retrieving all the {@link Project} entities from the database.
   * May or may not include a filter.
   * @param projectNameFilter An optional filter used for filtering the project names.
   *                         The filter doesn't have to be an exact match; as long as the string in the filter is
   *                         contained by any of the project names those will be returned.
   * @return The list of {@link Project} entities that fulfills the filters
   */
  @GetMapping("/projects")
  public List<Project> getAllProjects(
      @PathVariable(required = false) String projectNameFilter
  )
  {
    return manager.getProjectManager().getAllProjects(Optional.ofNullable(projectNameFilter));
  }

  /**
   * REST API endpoint for deleting a {@link Project} from the database
   * @param id The ID of the {@link Project} that needs to be deleted
   */
  @DeleteMapping("/projects/{id}")
  public void deleteProject(@PathVariable int id)
  {
    manager.getProjectManager().deleteProject(id);
  }

  /**
   * REST API endpoint for editing a {@link Project} in the database
   * @param id The ID of the {@link Project} that needs to be edited
   * @param edited The {@link Project} that contains the information that needs to be edited
   * @return The edited version of the {@link Project} from the database
   */
  @PutMapping("/projects/{id}")
  public Project editProject(@PathVariable int id, @RequestBody Project edited)
  {
    return manager.getProjectManager().editProject(id, edited);
  }
}
