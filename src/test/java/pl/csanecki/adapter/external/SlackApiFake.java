package pl.csanecki.adapter.external;

import pl.csanecki.adapter.Notification;

import java.util.Map;
import java.util.Queue;

public class SlackApiFake extends SlackApi {

  private final Map<String, SlackUser> USERS_DATABASE = Map.of(
      "csanecki@gmail.com", new SlackUser("csanecki"));

  public SlackApiFake(Queue<Notification> queue) {
    super(queue);
  }

  @Override
  public SlackUser findUserByEmail(String email) {
    SlackUser slackUser = USERS_DATABASE.get(email);

    if (slackUser == null) {
      throw new IllegalStateException();
    }

    return slackUser;
  }

  @Override
  public void sendMessage(SlackUser slackUser, String message) {
    super.sendMessage(slackUser, message);
  }
}
