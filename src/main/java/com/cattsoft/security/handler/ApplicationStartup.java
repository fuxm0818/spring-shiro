package com.cattsoft.security.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Description: XXXXX <br>
 * Copyright:DATANG SOFTWARE CO.LTD<br>
 *
 * @author fuxiangming
 * @date 2018/1/30 下午9:52
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static final Log log = LogFactory.getLog(ApplicationStartup.class);

//    @Autowired
//    private DomainService domainService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        if (applicationEvent.getApplicationContext().getParent() == null) {
            log.info("程序启动完成");
//            this.loadDomain();
        }


    }

//    private void loadDomain() {
//        log.info("\n\n\n加载全部值域开始");
//        try {
//            domainService.domainAll();
//            log.info("加载全部值域完成\n\n\n\n");
//        } catch (Exception e) {
//            log.error("异常：" + e.getMessage(), e);
//            log.error("加载全部值域失败\n\n\n\n");
//        }
//    }


}
