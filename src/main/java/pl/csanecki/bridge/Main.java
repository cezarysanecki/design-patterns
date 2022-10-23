package pl.csanecki.bridge;

public class Main {

  public static void main(String[] args) {
    Device radio = new Radio();
    Remote remote = new Remote(radio);

    remote.showInfo();

    remote.power();
    remote.decreaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();
    remote.increaseVolume();

    remote.showInfo();

    AdvancedRemote advancedRemote = new AdvancedRemote(radio);
    advancedRemote.mute();
    advancedRemote.showInfo();
  }
}
