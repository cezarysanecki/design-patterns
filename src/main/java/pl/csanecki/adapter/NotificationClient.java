package pl.csanecki.adapter;

public class NotificationClient {

  private final NotificationService notificationService;

  public NotificationClient(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  public void send(String email, String message) {
    notificationService.send(email, message);
  }

}
