package Application.Exception;

public class NullSavedToDatabaseException extends RuntimeException
{
  public NullSavedToDatabaseException(String entity)
  {
    super(entity + " entity is null and thus cannot be saved to the database.");
  }
}
