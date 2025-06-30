package java基础案例.slf4j.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dou_zhenjun
 * @date 2023/2/16
 */
public class LoggerFactoryDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerFactoryDemo.class);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            LOGGER.info("这是一条数据" + i);
        }
    }
}
