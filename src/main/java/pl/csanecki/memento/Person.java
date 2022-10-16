package pl.csanecki.memento;

import java.time.Instant;

public class Person implements Memorizable {

  private String firstName;
  private String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;

    System.out.println("Created person: " + this);
  }

  public void changeFirstName(String firstName) {
    this.firstName = firstName;
    System.out.println("Change first name to: " + firstName);
  }

  public void changeLastName(String lastName) {
    this.lastName = lastName;
    System.out.println("Change last name to: " + lastName);
  }

  public void print() {
    System.out.println(firstName + " " + lastName);
  }

  @Override
  public Snapshot makeSnapshot() {
    System.out.println("Created snapshot of: " + this);
    return new Snapshot(firstName, lastName);
  }

  @Override
  public void restore(Memento snapshot) {
    if (!(snapshot instanceof Snapshot personSnapshot)) {
      throw new UnsupportedOperationException("unknown type of snapshot");
    }
    System.out.println("Restored snapshot of: " + snapshot.getName());

    this.firstName = personSnapshot.firstName;
    this.lastName = personSnapshot.lastName;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }

  public static class Snapshot implements Memento {

    private final Instant snapshotDate;

    private final String firstName;
    private final String lastName;

    private Snapshot(String firstName, String lastName) {
      this.snapshotDate = Instant.now();

      this.firstName = firstName;
      this.lastName = lastName;
    }

    @Override
    public String getName() {
      return snapshotDate.toString() + " / " + firstName + " " + lastName;
    }

    @Override
    public Instant getSnapshotDate() {
      return snapshotDate;
    }
  }
}
