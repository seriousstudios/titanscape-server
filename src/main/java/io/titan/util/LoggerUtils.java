package io.titan.util;

import java.util.logging.Logger;

public final class LoggerUtils {

  public static Logger getLogger(Class<?> clazz) {
    return Logger.getLogger(clazz.getName());
  }

}
