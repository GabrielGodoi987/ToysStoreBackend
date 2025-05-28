package worker.Inklings.toysbackend.erros;

public class EntityCouldNotBeDeleted extends RuntimeException {
    public EntityCouldNotBeDeleted(String message) {
        super(message);
    }
}
