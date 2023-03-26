package com.cslink.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateCaptcha {
    public static final char[] sources = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};

    public static String getCode() {
        int length = sources.length;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append(sources[random.nextInt(length)]);
        }
        return String.valueOf(code);
    }
}
