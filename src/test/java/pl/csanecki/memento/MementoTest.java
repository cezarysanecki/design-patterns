package pl.csanecki.memento;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MementoTest {

  @Test
  void nothing_changed_when_history_is_empty() {
    Person person = new Person("Jan", "Kowalski");
    Coordinator coordinator = new Coordinator(person);

    coordinator.undo();

    assertThat(person.print()).isEqualTo("Jan Kowalski");
  }

  @Test
  void undo_operation_changed_memorizable_object() {
    Person person = new Person("Jan", "Kowalski");
    Coordinator coordinator = new Coordinator(person);

    person.changeFirstName("Tomasz");
    coordinator.backup();

    person.changeLastName("Nowak");

    coordinator.undo();

    assertThat(person.print()).isEqualTo("Tomasz Kowalski");
  }
}
