package pl.csanecki.proxy;

public class NormalVideoDownloader implements VideoDownloader {

  private static long idSequence = 1;

  @Override
  public Video download(String title) {
    System.out.println("Connecting to external service...");
    return new Video(idSequence++, title, new byte[0]);
  }
}
