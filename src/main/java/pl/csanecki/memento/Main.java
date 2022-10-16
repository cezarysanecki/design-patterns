package pl.csanecki.memento;

public class Main {

  public static void main(String[] args) {

    Person person = new Person("Jan", "Kowalski");
    Coordinator coordinator = new Coordinator(person);

    coordinator.backup();
    System.out.println(person.print());

    System.out.println("\n=====");
    person.changeFirstName("Tomasz");
    coordinator.backup();
    System.out.println(person.print());

    System.out.println("\n=====");
    person.changeLastName("Kołodziejczyk");
    coordinator.backup();
    System.out.println(person.print());

    System.out.println("\n=====");
    person.changeFirstName("Izabela");
    person.changeLastName("Polańczyk");
    coordinator.backup();
    System.out.println(person.print());

    System.out.println("\n=====");
    person.changeFirstName("Kamil");
    person.changeLastName("Prebl");
    System.out.println(person.print());

    System.out.println("\n=====");
    System.out.println(coordinator.printHistory());

    System.out.println("\n=====");
    coordinator.undo();
    System.out.println(person.print());

    System.out.println("\n=====");
    coordinator.undo();
    System.out.println(person.print());

    System.out.println("\n=====");
    coordinator.undo();
    System.out.println(person.print());

    System.out.println("\n=====");
    coordinator.undo();
    System.out.println(person.print());

    System.out.println("\n=====");
    coordinator.undo();
    System.out.println(person.print());

    System.out.println("\n=====");
    System.out.println(coordinator.printHistory());
  }
}
