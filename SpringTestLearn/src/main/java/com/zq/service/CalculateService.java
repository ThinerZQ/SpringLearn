package com.zq.service;

/**
 * Created by Money Zheng on 2016/7/25.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 计算:返回两个整数的和
     *
     * @param first
     * @param second
     * @return
     */
    public int sum(int first, int second) {

        logger.info("求和参数：first={}, second={}", first, second);

        return first + second;
    }
}