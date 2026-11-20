package Application.Exception;

/**
 * Exception raised for when an entity that is null is called to be saved to the database.
 */
public class NullSavedToDatabaseException extends RuntimeException
{
  public NullSavedToDatabaseException(String entity)
  {
    super(entity + " entity is null and thus cannot be saved to the database.");
  }
}
