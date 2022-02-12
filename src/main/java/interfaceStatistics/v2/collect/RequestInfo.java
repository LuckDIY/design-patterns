package interfaceStatistics.v2.collect;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 接口请求信息采集
 * 参数封装类 对象易于扩展
 */
@Data
@AllArgsConstructor
public class RequestInfo {

  /**
   * 接口名字
   */
  private String apiName;

  /**
   * 响应时间
   */
  private Double responseTime;

  /**
   * 请求时间
   */
  private Long timestamp;
}