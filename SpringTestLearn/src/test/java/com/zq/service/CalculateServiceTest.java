package com.zq.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Money Zheng on 2016/7/25.
 */
public class CalculateServiceTest extends BaseTest {

    @Autowired
    private CalculateService calculateService;

    @Test
    public void testSum() {
        int expected = 5, first = 3, second = 2;
        int real = calculateService.sum(first, second);

        // 验证
        assertEquals(expected, real);
    }

}