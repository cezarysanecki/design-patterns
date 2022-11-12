package pl.csanecki.adapter;

import pl.csanecki.adapter.external.SlackApi;
import pl.csanecki.adapter.external.SlackUser;

public class SlackNotificationAdapterService implements NotificationService {

  private final SlackApi slackApi;

  public SlackNotificationAdapterService(SlackApi slackApi) {
    this.slackApi = slackApi;
  }

  @Override
  public void send(String email, String message) {
    SlackUser user = slackApi.findUserByEmail(email);
    slackApi.sendMessage(user, message);
  }
}
