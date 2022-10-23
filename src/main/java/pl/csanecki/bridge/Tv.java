package pl.csanecki.bridge;

public class Tv implements Device {

  private static final int MIN_VOLUME = 0;
  private static final int MAX_VOLUME = 100;
  private static final int MIN_CHANNEL = 1;
  private static final int MAX_CHANNEL = 999;

  private boolean enabled;
  private int currentVolume;
  private int currentChannel;

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public void enable() {
    System.out.println("TV turned on");
    enabled = true;
  }

  @Override
  public void disable() {
    System.out.println("TV turned off");
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
      System.out.println("TV volume max");
    } else if (percent < MIN_VOLUME) {
      System.out.println("TV volume min");
    } else {
      currentVolume = percent;
      System.out.println("TV current volume: " + currentVolume);
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
    System.out.println("TV current channel: " + currentChannel);
  }

  @Override
  public void printStatus() {
    if (enabled) {
      System.out.println("=== Watching TV ===");
      System.out.println(" -> current channel: " + currentChannel);
      System.out.println(" -> current volume: " + currentVolume);
    } else {
      System.out.println("Power off...");
    }
  }
}
