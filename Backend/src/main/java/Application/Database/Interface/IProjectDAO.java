package Application.Database.Interface;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.List;

/**
 * Interface for the database implementation for {@link Project} related queries
 */
public interface IProjectDAO
{
  /**
   * Method for adding a {@link Project} to the database.
   * @param project The {@link Project} that needs to be saved.
   * @throws NullSavedToDatabaseException Thrown before a null entity is saved to the database.
   */
  void addProject(Project project) throws NullSavedToDatabaseException;
  /**
   * Method for retrieving a {@link Project} from the database.
   * @param id The ID of the {@link Project} to be retrieved.
   * @return The {@link Project} saved in the database.
   */
  Project getProject(int id);
  /**
   * Method for retrieving all {@link Project} entities from the database.
   * @return The list of {@link Project} entities.
   */
  List<Project> getAllProjects();
  /**
   * Method for deleting a {@link Project} from the database.
   * @param id The ID of the {@link Project} to be deleted.
   */
  void deleteProject(int id);
  /**
   * Method for editing a {@link Project} in the database
   * @param id The ID of the {@link Project} to be edited.
   * @param edited The {@link Project} that contains the edited entity.
   * @return The edited {@link Project} from the database.
   */
  Project editProject(int id, Project edited);
}
