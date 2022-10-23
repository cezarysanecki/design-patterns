package pl.csanecki.bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

  @Test
  void abstraction_used_implementation() {
    Device radio = new Radio();
    Remote remote = new Remote(radio);

    remote.power();
    remote.increaseVolume();

    assertThat(radio.getVolume()).isEqualTo(10);
  }

  @Test
  void extended_abstraction_used_implementation() {
    Device radio = new Tv();
    AdvancedRemote remote = new AdvancedRemote(radio);

    remote.power();
    remote.increaseVolume();
    remote.mute();

    assertThat(radio.getVolume()).isEqualTo(0);
  }

}