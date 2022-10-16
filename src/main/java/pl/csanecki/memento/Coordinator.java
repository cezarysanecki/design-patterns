package pl.csanecki.memento;

public class Coordinator {

  private final Memorizable memorizable;
  private final History<Memento> history;

  public Coordinator(Memorizable memorizable) {
    this.memorizable = memorizable;
    this.history = new History<>();
  }

  public void backup() {
    history.addSnapshot(memorizable.makeSnapshot());
  }

  public void undo() {
    if (history.isEmpty()) {
      return;
    }
    memorizable.restore(history.pop());
  }

  public String printHistory() {
    if (history.isEmpty()) {
      return "List of mementos is empty...";
    } else {
      return "History of mementos:\n" + history.print();
    }
  }
}
