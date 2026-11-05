package Application.Entities.Base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Project
{
  private String projectName;
  private String description;
}
