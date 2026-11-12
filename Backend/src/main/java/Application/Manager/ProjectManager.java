package Application.Manager;

import Application.Database.DatabaseManager;
import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectManager implements IProjectManager
{
  private final DatabaseManager dbs;

  public ProjectManager()
  {
    dbs = new DatabaseManager();
  }
  public void addProject(Project project) throws NullSavedToDatabaseException
  {
    dbs.getProjectDAO().addProject(project);
  }

  public Project getProject(int id)
  {
    return dbs.getProjectDAO().getProject(id);
  }

  public List<Project> getAllProjects(Optional<String> projectNameFilter)
  {
    return applyFilters(dbs.getProjectDAO().getAllProjects(),
        projectNameFilter);
  }

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
