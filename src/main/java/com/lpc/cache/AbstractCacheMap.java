package com.lpc.cache;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Ĭ��ʵ��
 */
public abstract class AbstractCacheMap<K, V> implements Cache<K, V> {

    class CacheObject<K2, V2> {
        CacheObject(K2 key, V2 value, long ttl) {
            this.key = key;
            this.value = value;
            this.ttl = ttl;
            this.lastAccessTime = System.currentTimeMillis();
        }

        final K2 key;
        final V2 value;
        /**
         * ������ʱ��
         */
        long lastAccessTime;
        /**
         * ���ʴ���
         */
        long accessCount;
        /**
         * ������ʱ�䣨time_to_live)
         */
        long ttl;

        /**
         * �����Ƿ��ѹ���
         *
         * @return
         */
        boolean isExpired() {
            if (ttl == 0) {
                return false;
            }
            return lastAccessTime + ttl < System.currentTimeMillis();
        }

        V2 getObject() {
            lastAccessTime = System.currentTimeMillis();
            accessCount++;
            return value;
        }
    }

    protected Map<K, CacheObject<K, V>> cacheMap;

    private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private Lock readLock = cacheLock.readLock();
    private Lock writeLock = cacheLock.writeLock();

    /**
     * �����С��0 -> ������
     */
    protected int cacheSize;
    /**
     * �Ƿ�����Ĭ�Ϲ���ʱ��
     */
    protected boolean existCustomExpire;
    /**
     * Ĭ�Ϲ���ʱ�䣬0 -> ��������
     */
    protected long defaultExpire;

    public AbstractCacheMap(int cacheSize, long defaultExpire) {
        this.cacheSize = cacheSize;
        this.defaultExpire = defaultExpire;
    }


    public int getCacheSize() {
        return cacheSize;
    }

    public long getDefaultExpire() {
        return defaultExpire;
    }

    public void put(K key, V value) {
        put(key, value, defaultExpire);
    }

    public void put(K key, V value, long expire) {
        writeLock.lock();

        try {
            CacheObject<K, V> co = new CacheObject<K, V>(key, value, expire);
            if (expire != 0) {
                existCustomExpire = true;
            }
            if (isFull()) {
                eliminate();
            }
            cacheMap.put(key, co);

        } finally {
            writeLock.unlock();
        }
    }


    public V get(K key) {
        readLock.lock();

        try {
            CacheObject<K, V> co = cacheMap.get(key);
            if (co == null) {
                return null;
            }
            if (co.isExpired()) {
                cacheMap.remove(key);
                return null;
            }
            return co.getObject();

        } finally {
            readLock.unlock();
        }
    }


    public final int eliminate() {
        writeLock.lock();
        try {
            return eliminateCache();
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * ��̭�������ʵ��
     *
     * @return
     */
    protected abstract int eliminateCache();

    public boolean isFull() {
        if (cacheSize == 0) {
            return false;
        }
        return cacheMap.size() > cacheSize;
    }

    public void remove(K key) {
        writeLock.lock();
        try {
            cacheMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }


    public void clear() {
        writeLock.lock();
        try {
            cacheMap.clear();
        } finally {
            writeLock.unlock();
        }
    }

    public int size() {
        return cacheMap.size();
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * �Ƿ���Ҫ������ڶ���
     * @return
     */
    protected boolean isNeedClearExpiredObject(){
        return defaultExpire > 0 || existCustomExpire ;
    }

}
