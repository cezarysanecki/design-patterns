package pl.csanecki.bridge;

public class Radio implements Device {

  private static final int MIN_VOLUME = 0;
  private static final int MAX_VOLUME = 100;
  private static final int MIN_CHANNEL = 1;
  private static final int MAX_CHANNEL = 30;

  private boolean enabled;
  private int currentVolume;
  private int currentChannel;

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public void enable() {
    System.out.println("Radio turned on");
    enabled = true;
  }

  @Override
  public void disable() {
    System.out.println("Radio turned off");
    enabled = false;
  }

  @Override
  public int getVolume() {
    if (!enabled) {
      return 0;
    }
    return currentVolume;
  }

  @Override
  public void setVolume(int percent) {
    if (!enabled) {
      return;
    }
    if (percent > MAX_VOLUME) {
      System.out.println("Radio volume max");
    } else if (percent < MIN_VOLUME) {
      System.out.println("Radio volume min");
    } else {
      currentVolume = percent;
      System.out.println("Radio current volume: " + currentVolume);
    }
  }

  @Override
  public int getChannel() {
    if (!enabled) {
      return 0;
    }
    return currentChannel;
  }

  @Override
  public void setChannel(int channel) {
    if (!enabled) {
      return;
    }
    if (channel > MAX_CHANNEL) {
      currentChannel = MIN_CHANNEL;
    } else if (channel < MIN_VOLUME) {
      currentChannel = MAX_CHANNEL;
    } else {
      currentChannel = channel;
    }
    System.out.println("Radio current channel: " + currentChannel);
  }

  @Override
  public void printStatus() {
    if (enabled) {
      System.out.println("=== Listing to radio ===");
      System.out.println(" -> current channel: " + currentChannel);
      System.out.println(" -> current volume: " + currentVolume);
    } else {
      System.out.println("Power off...");
    }
  }
}
