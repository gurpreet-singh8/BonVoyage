package com.gl.app.userservice.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class UserUtils {
    private static final AtomicInteger counter = new AtomicInteger(104); // Start from 100 or any other number

    public static String generateId(String prefix) {
        int currentValue = counter.incrementAndGet();
        return prefix + currentValue;
    }
}
