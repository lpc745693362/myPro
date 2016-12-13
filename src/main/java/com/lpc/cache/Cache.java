package com.lpc.cache;

/**
 * ����ӿ�
 */
public interface Cache<K, V> {

    /**
     * ���ص�ǰ�����С
     * @return
     */
    int size();

    /**
     * ����Ĭ�ϴ��ʱ��
     * @return
     */
    long getDefaultExpire();

    /**
     * �򻺴������value�������ڻ���������ʱ��ΪĬ��ֵ
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * �򻺴����value����,��ָ�����ʱ��
     * @param key
     * @param value
     * @param expire ����ʱ��
     */
    void put(K key, V value, long expire);

    /**
     * ���һ������
     * @param key
     * @return
     */
    V get(K key);

    /**
     * ��̭����
     * @return ��ɾ�������С
     */
    int eliminate();

    /**
     * �����Ƿ�����
     * @return
     */
    boolean isFull();

    /**
     * ɾ���������
     * @param key
     */
    void remove(K key);


    /**
     * ������л������
     */
    void clear();

    /**
     * ���ػ����С
     * @return
     */
    int getCacheSize();

    /**
     * �������Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();

}
