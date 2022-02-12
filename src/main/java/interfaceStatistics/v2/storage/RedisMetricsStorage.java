package interfaceStatistics.v2.storage;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import interfaceStatistics.v2.collect.RequestInfo;
import interfaceStatistics.v2.storage.MetricsStorage;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.stream.Collectors;

public class RedisMetricsStorage implements MetricsStorage {

  static Jedis jedis;

  /**
   * 作用,避免查询所有接口是使用keys(*)导致数据量太大
   */
  private static final String apiNamePrefix = "api";

  /**
   * 有机会改为单例
   */
  public RedisMetricsStorage(){
    jedis = new Jedis();

  }

  @Override
  public void saveRequestInfo(RequestInfo requestInfo) {
    //...
    Long zadd = jedis.zadd(apiNamePrefix + requestInfo.getApiName(), requestInfo.getTimestamp(), JSON.toJSONString(requestInfo));
    System.out.println("添加成功"+zadd);

  }

  @Override
  public List<RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
    //...

    Set<String> requestInfoStrSet = jedis.zrangeByScore(apiName, 0, endTimestamp);

    if(CollectionUtil.isEmpty(requestInfoStrSet)){
      return new ArrayList<>();
    }

    return requestInfoStrSet.stream().map(x->new Gson().fromJson(x,RequestInfo.class)).collect(Collectors.toList());
  }

  @Override
  public Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
    //...

    Map<String, List<RequestInfo>> map = new HashMap<>();
    //查询所有keys
    Set<String> keys = jedis.keys(apiNamePrefix + "*");

    //jedis 无法使用管道，暂时就直接循环吧
    for (String key : keys) {
      List<RequestInfo> requestInfos = getRequestInfos(key, startTimestamp, endTimestamp);
      map.put(key,requestInfos);
    }

    return map;
  }
}