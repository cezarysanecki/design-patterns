package pl.csanecki.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxyVideoDownloader implements VideoDownloader {

  private final Map<String, Video> cache = new HashMap<>();

  private final VideoDownloader videoDownloader;

  public ProxyVideoDownloader(VideoDownloader videoDownloader) {
    this.videoDownloader = videoDownloader;
  }

  @Override
  public Video download(String title) {
    Video cachedVideo = cache.get(title);
    if (cachedVideo != null) {
      System.out.println("Retrieved from cache");
      return cachedVideo;
    }

    Video downloadedVideo = videoDownloader.download(title);
    cache.put(title, downloadedVideo);
    return downloadedVideo;
  }

  public List<String> extractCachedVideoTitles() {
    return cache.values()
        .stream()
        .map(Video::title)
        .toList();
  }
}
