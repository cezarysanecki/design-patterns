package pl.csanecki.memento;

import java.time.Instant;

public class Person implements Memorizable {

  private String firstName;
  private String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void changeFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void changeLastName(String lastName) {
    this.lastName = lastName;
  }

  public String print() {
    return firstName + " " + lastName;
  }

  @Override
  public Snapshot makeSnapshot() {
    return new Snapshot(firstName, lastName);
  }

  @Override
  public void restore(Memento snapshot) {
    if (!(snapshot instanceof Snapshot personSnapshot)) {
      throw new UnsupportedOperationException("unknown type of snapshot");
    }
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
