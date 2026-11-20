package Application.Database.InMemory;

import Application.Database.Interface.IProjectDAO;
import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for saving Projects at runtime only using lists
 */
public class InMemoryProjectDAO implements IProjectDAO
{
  private ArrayList<Project> projects = new ArrayList<>();

  /**
   * Method for saving a {@link Project} into a list.
   * @param project The {@link Project} that needs to be saved. Cannot be null.
   * @throws NullSavedToDatabaseException Thrown if the {@link Project} to be saved is null.
   */
  public void addProject(Project project) throws NullSavedToDatabaseException
  {
    //Verification before adding
    if(project == null)
    {
      throw new NullSavedToDatabaseException("Project");
    }
    projects.add(project);
  }

  /**
   * Method for retrieving a {@link Project} from the list
   * @param id The index of the {@link Project} saved.
   * @return The {@link Project} retrieved from the list.
   */
  public Project getProject(int id)
  {
    return new Project(projects.get(id));
  }

  /**
   * Method for retrieving the list of {@link Project} entities.
   * @return The list of {@link Project} entities.
   */
  public List<Project> getAllProjects()
  {
    return new ArrayList<>(projects);
  }

  /**
   * Method for deleting a {@link Project}
   * @param id The index of the {@link Project} to be deleted.
   */
  public void deleteProject(int id)
  {
    projects.remove(id);
  }

  /**
   * Method for editing a {@link Project}
   * @param id The index of the {@link Project} to be edited.
   * @param edited The {@link Project} with the updated information.
   * @return The edited {@link Project}.
   */
  public Project editProject(int id, Project edited)
  {
    projects.set(id, edited);

    return projects.get(id);
  }
}
