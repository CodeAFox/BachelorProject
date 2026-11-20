package Application.Manager;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Interface for implementations of classes that manage {@link Project} related methods
 */
public interface IProjectManager
{
  /**
   * Method for adding new {@link Project}.
   * @param project The {@link Project} to be added.
   * @throws NullSavedToDatabaseException thrown if null is saved to the database.
   */
  void addProject(Project project) throws NullSavedToDatabaseException;
  /**
   * Method for retrieving a {@link Project}.
   * @param id The ID of the {@link Project} to be retrieved.
   * @return The {@link Project}
   */
  Project getProject(int id);
  /**
   * Method for retrieving a list of {@link Project} entities.
   * @param projectNameFilter An {@link Optional} filter for project names.
   * @return The list of {@link Project} entities with filters applied.
   */
  List<Project> getAllProjects(Optional<String> projectNameFilter);
  /**
   * Method for deleting a {@link Project}.
   * @param id The ID of the {@link Project} to be deleted.
   */
  void deleteProject(int id);
  /**
   * Method for editing a {@link Project}
   * @param id The ID of the {@link Project} to be edited.
   * @param edited The {@link Project} with updated information.
   * @return The {@link Project} that has been edited.
   */
  Project editProject(int id, Project edited);
}
