package com.lpc.sequence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * ϵ��������
 */
public class Sequence {
    private final static Log log = LogFactory.getLog(Sequence.class);

    private int blockSize = 5;
    private long startValue = 0;
    private final static String GET_SQL = "select id from sequence_value where name = ?";
    private final static String NEW_SQL = "insert into sequence_value (id,name) values (?,?)";
    private final static String UPDATE_SQL = "update sequence_value set id = ?  where name = ? and id = ?";

    /**
     * ������ͬ����
     */
    private Map<String, Step> stepMap = new HashMap<String, Step>();

//    sequence_value �������
//    CREATE TABLE `sequence_value` (
//            `uid` bigint(20) NOT NULL AUTO_INCREMENT,
//            `name` varchar(100) NOT NULL,
//            `id` bigint(20) NOT NULL,
//            PRIMARY KEY (`uid`),
//            UNIQUE KEY `sequence_value_unique` (`name`)
//    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='sequence��';


    /**
     * ֻ��һ����ڣ����ԡ�ֻ��Ҫ��ͬ������
     *
     * @return
     */
    public synchronized long get(String sequenceName) {
        Step step = stepMap.get(sequenceName);
        if (step == null) {
            //���û�У���Ҫ�����ݿ��ж���
            step = new Step(startValue, startValue + blockSize);
            stepMap.put(sequenceName, step);
        } else {
            if (step.currentValue < step.endValue) {//Ĭ��Ϊ0��0������û�д�
                return step.incrementAndGet();
            }
        }
        for (int i = 0; i < blockSize; i++) {
            if (getNextBlock(sequenceName, step)) {
                return step.incrementAndGet();
            }
        }
        throw new RuntimeException("No more value.");
    }


    private boolean getNextBlock(String sequenceName, Step step) {
        Long value = getPersistenceValue(sequenceName);
        if (value == null) {//���û�У��ͳ�ʼ��
            try {
                value = newPersistenceValue(sequenceName); //��ʼ�������س�ʼ����ֵ
            } catch (Exception e) {
                log.error("newPersistenceValue error!");
                value = getPersistenceValue(sequenceName); //�����ʼ��ʧ�ܣ�˵���г����ȳ�ʼ����
            }
        }
        boolean b = saveValue(value, sequenceName) == 1;
        if (b) {
            step.setCurrentValue(value);
            step.setEndValue(value + blockSize);
        }
        return b;
    }


    private int saveValue(long value, String sequenceName) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(UPDATE_SQL);
            statement.setLong(1, value + blockSize);
            statement.setString(2, sequenceName);
            statement.setLong(3, value);
            return statement.executeUpdate();
        } catch (Exception e) {
            log.error("newPersistenceValue error!", e);
            throw new RuntimeException("newPersistenceValue error!", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("close statement error!", e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("close connection error!", e);
                }
            }
        }
    }

    private Long getPersistenceValue(String sequenceName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(GET_SQL);
            statement.setString(1, sequenceName);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("id");
            }
        } catch (Exception e) {
            log.error("getPersistenceValue error!", e);
            throw new RuntimeException("getPersistenceValue error!", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    log.error("close resultset error!", e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("close statement error!", e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("close connection error!", e);
                }
            }
        }
        return null;
    }

    private Long newPersistenceValue(String sequenceName) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(NEW_SQL);
            statement.setLong(1, startValue);
            statement.setString(2, sequenceName);
            statement.executeUpdate();
        } catch (Exception e) {
            log.error("newPersistenceValue error!", e);
            throw new RuntimeException("newPersistenceValue error!", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("close statement error!", e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("close connection error!", e);
                }
            }
        }
        return startValue;
    }


    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public void setStartValue(long startValue) {
        this.startValue = startValue;
    }

    static class Step {
        private long currentValue;
        private long endValue;

        Step(long currentValue, long endValue) {
            this.currentValue = currentValue;
            this.endValue = endValue;
        }

        public void setCurrentValue(long currentValue) {
            this.currentValue = currentValue;
        }

        public void setEndValue(long endValue) {
            this.endValue = endValue;
        }

        public long incrementAndGet() {
            return ++currentValue;
        }
    }
}
