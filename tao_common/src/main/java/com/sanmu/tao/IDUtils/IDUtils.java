package com.sanmu.tao.IDUtils;

import java.util.Random;
import java.util.UUID;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-12 12:37
 **/
public class IDUtils {

    public static String getFileNmae(){
        long millis = System.currentTimeMillis();

        Random random = new Random();

        int end3 = random.nextInt(999);

        String string = millis + String.format("%03d",end3);
        return string;
    }

    public static long getItemId(){
        int uuid = UUID.randomUUID().hashCode();
        return Long.valueOf(uuid);
    }
}
