package pl.csanecki.memento;

public class Coordinator {

  private final Memorizable memorizable;
  private final History<Memento> history;

  public Coordinator(Memorizable memorizable) {
    this.memorizable = memorizable;
    this.history = new History<>();
  }

  public void backup() {
    System.out.println("Making backup...");
    history.addSnapshot(memorizable.makeSnapshot());
  }

  public void undo() {
    if (history.isEmpty()) {
      System.out.println("Nothing to restore..");
      return;
    }
    memorizable.restore(history.pop());
  }

  public void showHistory() {
    if (history.isEmpty()) {
      System.out.println("List of mementos is empty...");
    } else {
      System.out.println("History of mementos:");
      System.out.println(history.print());
    }
  }
}
