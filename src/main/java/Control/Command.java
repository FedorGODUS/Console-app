package Control;

public interface Command<T> {
    void execute(T data);
}
