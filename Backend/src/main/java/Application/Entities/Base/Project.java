package Application.Entities.Base;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity for containing projects.
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Project
{
  private String projectName;
  private String description;

  public Project(Project copy)
  {
    projectName = copy.getProjectName();
    description = copy.getDescription();
  }
}
