package factory;

import java.io.InputStream;
import java.util.List;

public interface BeanConfigParser {

  /**
   * 配置bean解析
   * @param inputStream
   * @return
   */
  List<BeanDefinition> parse(InputStream inputStream);
  List<BeanDefinition> parse(String configContent);
}

