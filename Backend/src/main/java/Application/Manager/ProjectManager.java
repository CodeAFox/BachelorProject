package Application.Manager;

import Application.Database.DatabaseManager;
import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The class responsible for managing the {@link Project} related methods
 */
public class ProjectManager implements IProjectManager
{
  private final DatabaseManager dbs;

  /**
   * Constructor.
   * @param dbs the database to be used
   */
  public ProjectManager(DatabaseManager dbs)
  {
    this.dbs = dbs;
  }

  /**
   * Adds project to database.
   * @param project The project to be added.
   * @throws NullSavedToDatabaseException Thrown if the method is called using a null {@link Project}
   */
  public void addProject(Project project) throws NullSavedToDatabaseException
  {
    dbs.getProjectDAO().addProject(project);
  }

  /**
   * Getting a {@link Project} from the database
   * @param id The ID of the project to be retrieved.
   * @return The {@link Project} to be returned.
   */
  public Project getProject(int id)
  {
    return dbs.getProjectDAO().getProject(id);
  }

  /**
   * Getting a list of {@link Project} entities
   * @param projectNameFilter The {@link Optional} containing a {@link String} filter for project names.
   * @return The list of {@link Project} entities with potential filters applied.
   */
  public List<Project> getAllProjects(Optional<String> projectNameFilter)
  {
    return applyFilters(dbs.getProjectDAO().getAllProjects(),
        projectNameFilter);
  }

  /**
   * Method for deleting a {@link Project}
   * @param id The ID of the {@link Project} that needs to be deleted
   */
  public void deleteProject(int id)
  {
    dbs.getProjectDAO().deleteProject(id);
  }

  /**
   * Method for editing a {@link Project}
   * @param id The ID of the {@link Project} to be edited
   * @param edited The {@link Project} with the updated information
   * @return The edited {@link Project}
   */
  public Project editProject(int id, Project edited)
  {
    return dbs.getProjectDAO().editProject(id, edited);
  }

  /**
   * Method that applies provided filters to a provided list of {@link Project} entities.
   * @param projects The list of {@link Project} entities that need to be filtered
   * @param projectNameFilter An {@link Optional} filter containing a {@link String} for project names
   * @return Returns the filtered list.
   */
  private List<Project> applyFilters(List<Project> projects, Optional<String> projectNameFilter)
  {
    List<Project> filteredProjects = projects;
    
    if(projectNameFilter.isPresent())
    {
      filteredProjects = projects.stream().filter(project -> project.getProjectName().toLowerCase()
          .contains(projectNameFilter.get().toLowerCase()))
          .toList();
    }

    return filteredProjects;
  }
}
