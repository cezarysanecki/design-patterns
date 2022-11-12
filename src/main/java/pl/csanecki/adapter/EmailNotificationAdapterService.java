package pl.csanecki.adapter;

import java.util.Queue;

public class EmailNotificationAdapterService implements NotificationService {

  private final Queue<Notification> queue;

  public EmailNotificationAdapterService(Queue<Notification> queue) {
    this.queue = queue;
  }

  @Override
  public void send(String email, String message) {
    queue.add(new Notification(email, message));
  }
}
