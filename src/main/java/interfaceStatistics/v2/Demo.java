package interfaceStatistics.v2;

import interfaceStatistics.UserController;
import interfaceStatistics.v2.collect.MetricsCollector;
import interfaceStatistics.v2.collect.MetricsCollectorProxy;
import interfaceStatistics.v2.collect.RequestInfo;
import interfaceStatistics.v2.output.ConsoleReporter;
import interfaceStatistics.v2.output.EmailReporter;
import interfaceStatistics.v2.storage.MetricsStorage;
import interfaceStatistics.v2.storage.RedisMetricsStorage;

public class Demo {
  public static void main(String[] args) {
    MetricsStorage storage = new RedisMetricsStorage();
    ConsoleReporter consoleReporter = new ConsoleReporter(storage);
    consoleReporter.startRepeatedReport(10, 60);

    /*
    //邮件输出的暂时不实现
    EmailReporter emailReporter = new EmailReporter(storage);
    emailReporter.addToAddress("wangzheng@xzg.com");
    emailReporter.startDailyReport();*/

    MetricsCollector collector = new MetricsCollector(storage);
    collector.recordRequest(new RequestInfo("register", 123d, System.currentTimeMillis()));
    collector.recordRequest(new RequestInfo("register", 223d, System.currentTimeMillis()));
    collector.recordRequest(new RequestInfo("register", 323d, System.currentTimeMillis()));
    collector.recordRequest(new RequestInfo("login", 23d, System.currentTimeMillis()));
    collector.recordRequest(new RequestInfo("login", 1223d, System.currentTimeMillis()));

    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }




    //
    //MetricsCollectorProxy使用举例
    MetricsCollectorProxy proxy = new MetricsCollectorProxy();
    //IUserController userController = (IUserController) proxy.createProxy(new UserController());
  }
}