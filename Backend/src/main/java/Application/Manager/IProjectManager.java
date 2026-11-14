package Application.Manager;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IProjectManager
{
  void addProject(Project project) throws NullSavedToDatabaseException;
  Project getProject(int id);
  List<Project> getAllProjects(Optional<String> projectNameFilter);
  void deleteProject(int id);
  Project editProject(int id, Project edited);
}
