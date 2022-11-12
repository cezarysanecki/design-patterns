package pl.csanecki.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.csanecki.adapter.external.SlackApi;
import pl.csanecki.adapter.external.SlackApiFake;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class AdapterTest {

  private static final Queue<Notification> QUEUE = new ConcurrentLinkedQueue<>();

  private static final String EMAIL = "csanecki@gmail.com";
  private static final String MESSAGE = "Hello, my dear friend!";
  private static final String SLACK_LOGIN = "csanecki";

  @BeforeEach
  void setUp() {
    QUEUE.clear();
  }

  @Test
  void send_message_via_matching_email_api() {
    NotificationService notificationService = new EmailNotificationAdapterService(QUEUE);
    NotificationClient client = new NotificationClient(notificationService);

    client.send(EMAIL, MESSAGE);

    assertThat(QUEUE.poll()).isEqualTo(new Notification(EMAIL, MESSAGE));
  }

  @Test
  void send_message_via_not_matching_slack_api() {
    SlackApi slackApi = new SlackApiFake(QUEUE);

    NotificationService notificationService = new SlackNotificationAdapterService(slackApi);
    NotificationClient client = new NotificationClient(notificationService);

    client.send(EMAIL, MESSAGE);

    assertThat(QUEUE.poll()).isEqualTo(new Notification(SLACK_LOGIN, MESSAGE));
  }
}
