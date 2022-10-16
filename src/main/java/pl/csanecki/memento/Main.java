package pl.csanecki.memento;

public class Main {

  public static void main(String[] args) {

    Person person = new Person("Jan", "Kowalski");
    Coordinator coordinator = new Coordinator(person);
    coordinator.backup();

    System.out.println("\n=====");
    person.changeFirstName("Tomasz");
    coordinator.backup();

    System.out.println("\n=====");
    person.changeLastName("Kołodziejczyk");
    coordinator.backup();

    System.out.println("\n=====");
    person.changeFirstName("Izabela");
    person.changeLastName("Polańczyk");
    coordinator.backup();

    System.out.println("\n=====");
    coordinator.showHistory();

    System.out.println("\n=====");
    coordinator.undo();
    person.print();

    System.out.println("\n=====");
    coordinator.undo();
    person.print();

    System.out.println("\n=====");
    coordinator.undo();
    person.print();

    System.out.println("\n=====");
    coordinator.undo();
    person.print();

    System.out.println("\n=====");
    coordinator.undo();
    person.print();

    System.out.println("\n=====");
    coordinator.showHistory();
  }
}
