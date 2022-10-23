package pl.csanecki.bridge;

public class Remote {

  protected final Device device;

  public Remote(Device device) {
    this.device = device;
  }

  public void power() {
    if (device.isEnabled()) {
      device.disable();
    } else {
      device.enable();
    }
  }

  public void increaseVolume() {
    device.setVolume(device.getVolume() + 10);
  }

  public void decreaseVolume() {
    device.setVolume(device.getVolume() - 10);
  }

  public void channelUp() {
    device.setChannel(device.getChannel() + 1);
  }

  public void channelDown() {
    device.setChannel(device.getChannel() - 1);
  }

  public void showInfo() {
    device.printStatus();
  }
}
