package cn.hniu.mooc.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/10/7
 */
@Slf4j
public class ImmutableExample {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());

    static {
        map.put(1, 2);
        map.put(1, 3);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        log.info("{}", map.get(1));
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 3);
        // 修改 map对象中 key为 "1"的值
        map.put("1", 2);
        log.info("{}", map.get("1"));

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    }
}
