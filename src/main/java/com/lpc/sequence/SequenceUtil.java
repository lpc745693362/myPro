package com.lpc.sequence;

import com.lpc.sequence.Sequence;

import java.util.Map;

/**
 * ϵ������������ָ����Ĭ�ϵ�ϵ���������󣬿��Բ���Ϊÿһ��sequence����һ��ϵ����������<br/>
 * ָ��ϵ����������Ϊ�����ò�ͬ��������ģʽ���磺��ʼֵ��������<br/>
 */
public class SequenceUtil {

    private Map<String, Sequence> sequenceMap;
    private Sequence defaultSequence;

    public void setDefaultSequence(Sequence defaultSequence) {
        this.defaultSequence = defaultSequence;
    }

    public void setSequenceMap(Map<String, Sequence> sequenceMap) {
        this.sequenceMap = sequenceMap;
    }

    /**
     * ���û����map��ָ������ʹ��Ĭ�ϵġ� <br/>
     * ���û��Ĭ�ϵģ������<br/>
     * û��д����������������⡣<br/>
     *
     * @param name sequence����
     * @return
     */
    public long get(String name) {
        Sequence sequence = null;
        if (sequenceMap != null) {
            sequence = sequenceMap.get(name);
        }
        if (sequence == null) {
            if (defaultSequence != null) {
                return defaultSequence.get(name);
            } else {
                throw new RuntimeException("sequence " + name + " undefined!");
            }
        }
        return sequence.get(name);
    }
}
