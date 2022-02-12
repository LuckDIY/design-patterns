package interfaceStatistics.v2.statistics;

import lombok.Data;

/**
 * 接口需要统计的信息
 */
@Data
public class RequestStat {
  private double maxResponseTime;
  private double minResponseTime;
  private double avgResponseTime;
  private double p999ResponseTime;
  private double p99ResponseTime;
  private long count;
  private long tps;
}