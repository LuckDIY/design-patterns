package interfaceStatistics.v2.collect;


import interfaceStatistics.v2.storage.MetricsStorage;
import org.apache.commons.lang3.StringUtils;

/**
 * v2 版本面向对象拆封  采集  存储  统计  输出
 * 统计采集信息入口
 */
public class MetricsCollector {

  //基于接口而非实现编程
  private MetricsStorage metricsStorage;

  //依赖注入
  public MetricsCollector(MetricsStorage metricsStorage) {
    this.metricsStorage = metricsStorage;
  }

  //用一个函数代替了最小原型中的两个函数
  public void recordRequest(RequestInfo requestInfo) {
    if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
      return;
    }
    metricsStorage.saveRequestInfo(requestInfo);
  }
}

