package pl.csanecki.memento;

public interface Memorizable {

  Memento makeSnapshot();

  void restore(Memento snapshot);
}
