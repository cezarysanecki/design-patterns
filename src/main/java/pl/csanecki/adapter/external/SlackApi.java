package pl.csanecki.adapter.external;

import pl.csanecki.adapter.Notification;

import java.util.Queue;

public class SlackApi {

  private final Queue<Notification> queue;

  public SlackApi(Queue<Notification> queue) {
    this.queue = queue;
  }

  public SlackUser findUserByEmail(String email) {
    throw new UnsupportedOperationException();
  }

  public void sendMessage(SlackUser slackUser, String message) {
    queue.add(new Notification(slackUser.login(), message));
  }
}
