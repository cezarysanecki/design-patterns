package pl.csanecki.memento;

import java.util.Stack;
import java.util.stream.Collectors;

public class History<T extends Memento> {

  private final Stack<T> history = new Stack<>();

  public T pop() {
    if (history.isEmpty()) {
      throw new IllegalStateException("history is empty");
    }
    return history.pop();
  }

  public boolean isEmpty() {
    return history.isEmpty();
  }

  public void addSnapshot(T snapshot) {
    history.add(snapshot);
  }

  public String print() {
    return history.stream()
        .map(Memento::getName)
        .collect(Collectors.joining("\n"));
  }

}
