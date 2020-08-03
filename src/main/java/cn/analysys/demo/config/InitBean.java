package cn.analysys.demo.config;

import org.springframework.beans.factory.InitializingBean;

public class InitBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("启动前的初始化");
    }
}
