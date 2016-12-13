package com.lpc.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU(Least Recently Used ���������ʹ��) ʵ��
 * <p>�㷨�������ݵ�������ʼ�¼����̭���ݣ���ԭ�������������������ʹ������������ʵļ�������ԱȽϸߣ�
 * �����ʵ����ʹ��һ�������滺�����ݣ���ϸ�����㷨���£�</p>
 * 1. �����ݲ��뵽����ͷ����
 * 2. ÿ�������������У��������Ƶ�����ͷ����
 * 3. ����������ʱ�򣬽�����β�������ݶ�����
 */
public class LRUCache<K, V> extends AbstractCacheMap<K, V> {

    public LRUCache(int cacheSize, long defaultExpire) {

        super(cacheSize, defaultExpire);

        /**
         * linkedHash�Ѿ�ʵ��LRU�㷨 ��ͨ��˫��������ʵ�֣���ĳ��λ�ñ����У�ͨ�����������ָ�򽫸�λ�õ�����ͷλ�ã�
         * �¼��������ֱ�ӷ�������ͷ�����һ������������е����ݾ�������ͷ�ƶ�����Ҫ�滻ʱ����������λ�þ����������ʹ�õ�λ��
         */
        this.cacheMap = new LinkedHashMap<K, CacheObject<K, V>>(cacheSize + 1, 1f, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheObject<K, V>> eldest) {
                return LRUCache.this.removeEldestEntry(eldest);
            }

        };
    }

    private boolean removeEldestEntry(Map.Entry<K, CacheObject<K, V>> eldest) {

        if (cacheSize == 0)
            return false;

        return size() > cacheSize;
    }

    /**
     * ֻ��Ҫʵ��������ڶ���Ϳ�����,linkedHashMap�Ѿ�ʵ��LRU
     */
    @Override
    protected int eliminateCache() {

        if (!isNeedClearExpiredObject()) {
            return 0;
        }

        Iterator<CacheObject<K, V>> iterator = cacheMap.values().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            CacheObject<K, V> cacheObject = iterator.next();

            if (cacheObject.isExpired()) {
                iterator.remove();
                count++;
            }
        }

        return count;
    }

}
