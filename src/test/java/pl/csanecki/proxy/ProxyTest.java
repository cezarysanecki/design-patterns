package pl.csanecki.proxy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProxyTest {

  @Test
  void cached_video_when_asked_for_it_again() {
    NormalVideoDownloader normalVideoDownloader = new NormalVideoDownloader();
    ProxyVideoDownloader cachedVideoDownloader = new ProxyVideoDownloader(normalVideoDownloader);

    String videoTitle = "Harry Potter";

    cachedVideoDownloader.download(videoTitle);
    cachedVideoDownloader.download(videoTitle);

    assertThat(cachedVideoDownloader.extractCachedVideoTitles())
        .containsExactly(videoTitle);
  }
}
