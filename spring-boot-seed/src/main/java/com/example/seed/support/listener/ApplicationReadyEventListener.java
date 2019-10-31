package com.example.seed.support.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

/**
 * @author Leon
 * @date 2019/09/3
 */
@Component
@Slf4j
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info(">>>>>> Application Ready .....");
        log.info("================================================================");
        ConfigurableApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();
        pringRequestMappingHandlerMapping(applicationContext);
    }


    private void pringRequestMappingHandlerMapping(ApplicationContext applicationContext) {
        RequestMappingHandlerMapping mapping = applicationContext.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        Iterator<Map.Entry<RequestMappingInfo, HandlerMethod>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            String logMsg = "Mapped ";
            Map.Entry<RequestMappingInfo, HandlerMethod> entry = it.next();
            RequestMappingInfo requestMappingInfo = entry.getKey();
            HandlerMethod handlerMethod = entry.getValue();

            Set<String> patterns = requestMappingInfo.getPatternsCondition().getPatterns();
            Set<RequestMethod> methods = requestMappingInfo.getMethodsCondition().getMethods();

            logMsg += "\"{";
            List<String> patternsList = new ArrayList<>(patterns);
            logMsg += patternsList.toString();

            logMsg += ",";
            List<String> methodList = new ArrayList<>();
            List<RequestMethod> methodsList = new ArrayList<>(methods);
            for (int i = 0; i < methodsList.size(); i++) {
                methodList.add(methodsList.get(i).name());
            }
            logMsg += methodList.toString();
            logMsg += "}\"";

            String method = handlerMethod.getMethod().toString();
            logMsg += " onto " + method +" ";

            log.info(logMsg);

        }
        log.info("================================================================");
    }

}
