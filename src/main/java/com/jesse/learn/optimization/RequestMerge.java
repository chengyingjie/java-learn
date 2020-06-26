package com.jesse.learn.optimization;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 请求合并原则：
 * 1. 不同接口的请求，不能合并
 * 2. 接口相同，且参数相同
 * 3. 接口相同，参数不同
 */
@Component
public class RequestMerge {


    private LinkedBlockingDeque<RequestCode> queue = new LinkedBlockingDeque();

    private List<RequestCode> requests = new ArrayList<>();

    @Data
    class RequestCode {
        private String code;
        private CompletableFuture<ResponsCode> future;
    }



    @PostConstruct
    public void init() {

        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(2);
        scheduledService.scheduleAtFixedRate(() -> {
            if (queue.size() == 0) {
                return;
            }

            // 从队列中取数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                requests.add(queue.poll());
            }

            System.out.println("合并了：" + size);

            List<String> codes = requests.stream().map(RequestCode::getCode).collect(Collectors.toList());

            Map<String, ResponsCode> responsMap = batchGetByCodes(codes).stream().collect(Collectors.toMap(ResponsCode::getCode, one -> one));
            for (RequestCode request : requests) {
                request.getFuture().complete(responsMap.get(request.getCode()));
            }

        }, 0, 10, TimeUnit.MILLISECONDS);

    }

    public ResponsCode getByCode(String code) throws ExecutionException, InterruptedException {

        RequestCode requestCode = new RequestCode();
        requestCode.setCode(code);

        CompletableFuture<ResponsCode> future = new CompletableFuture();
        requestCode.setFuture(future);

        queue.add(requestCode);

        ResponsCode responsCode = future.get();
        return responsCode;
    }


    private List<ResponsCode> batchGetByCodes(List<String> codes) {
        if (CollectionUtils.isEmpty(codes)) {
            return Lists.newArrayList();
        }

        return codes.stream()
                .map(one -> ResponsCode.builder().code(one).result("singleCode:" + one).build())
                .collect(Collectors.toList());
    }

}
