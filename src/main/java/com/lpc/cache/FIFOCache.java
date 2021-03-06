package com.lpc.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * FIFO(First In First Out ，先进先出) 实现
 * <P>算法是根据先进先出原理来淘汰数据的，实现上是最简单的一种，具体算法如下：</P>
 * 1. 新访问的数据插入FIFO队列尾部，数据在FIFO队列中顺序移动；
 * 2. 淘汰FIFO队列头部的数据；
 */
public class FIFOCache<K, V> extends AbstractCacheMap<K, V> {
    public FIFOCache(int cacheSize, long defaultExpire) {
        super(cacheSize, defaultExpire);
        cacheMap = new LinkedHashMap<K, CacheObject<K, V>>(cacheSize + 1);
    }

    @Override
    protected int eliminateCache() {

        int count = 0;
        K firstKey = null;

        Iterator<CacheObject<K, V>> iterator = cacheMap.values().iterator();
        while (iterator.hasNext()) {
            CacheObject<K, V> cacheObject = iterator.next();

            if (cacheObject.isExpired()) {
                iterator.remove();
                count++;
            } else {
                if (firstKey == null)
                    firstKey = cacheObject.key;
            }
        }

        /**
         * 删除过期对象还是满,继续删除链表第一个
         */
        if (firstKey != null && isFull()) {
            cacheMap.remove(firstKey);
        }

        return count;
    }
}
