package worker.Inklings.toysbackend.erros;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource Not found: id: " + id);
    }
}
