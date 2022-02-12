package interfaceStatistics.v2.storage;

import interfaceStatistics.v2.collect.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * 存储接口
 */
public interface MetricsStorage {
  void saveRequestInfo(RequestInfo requestInfo);

  List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

  Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}

