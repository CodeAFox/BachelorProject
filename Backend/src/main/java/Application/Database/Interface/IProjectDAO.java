package Application.Database.Interface;

import Application.Entities.Base.Project;
import Application.Exception.NullSavedToDatabaseException;

import java.util.List;

public interface IProjectDAO
{
  void addProject(Project project) throws NullSavedToDatabaseException;
  Project getProject(int id);
  List<Project> getAllProjects();
  void deleteProject(int id);
}
