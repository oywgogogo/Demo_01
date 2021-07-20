package com.ccut.utils;

import com.mchange.v2.c3p0.DataSources;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.mysql.cj.jdbc.Driver;
import org.springframework.jdbc.support.JdbcUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import static com.mchange.v2.c3p0.DataSources.*;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //手动取消c3p0数据库连接池
  /*      try {
            destroy(JdbcUtils.getDataSource());//getDataSource方法获取c3p0数据源
            System.out.println("关闭数据库连接池成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //手动取消驱动程序的注册：
        Enumeration drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = (Driver) drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("deregistering jdbc driver: "+driver);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error deregistering driver"+driver);
            }
        }
        //手动停止名为[mysql-cj-abandoned-connection-cleanup]的线程
        AbandonedConnectionCleanupThread.uncheckedShutdown();
    }
}
