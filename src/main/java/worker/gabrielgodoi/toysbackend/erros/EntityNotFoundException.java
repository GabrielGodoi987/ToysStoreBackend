package worker.gabrielgodoi.toysbackend.erros;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
