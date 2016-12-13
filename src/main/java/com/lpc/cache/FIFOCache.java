package com.lpc.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * FIFO(First In First Out ���Ƚ��ȳ�) ʵ��
 * <P>�㷨�Ǹ����Ƚ��ȳ�ԭ������̭���ݵģ�ʵ��������򵥵�һ�֣������㷨���£�</P>
 * 1. �·��ʵ����ݲ���FIFO����β����������FIFO������˳���ƶ���
 * 2. ��̭FIFO����ͷ�������ݣ�
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
         * ɾ�����ڶ�������,����ɾ�������һ��
         */
        if (firstKey != null && isFull()) {
            cacheMap.remove(firstKey);
        }

        return count;
    }
}
