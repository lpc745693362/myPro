import com.lpc.sequence.SequenceUtil;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by liupengcheng1 on 2016/5/19.
 */
public class SequenceTest extends BaseTest {

    private Logger logger = Logger.getLogger(SequenceTest.class);

    @Resource
    private SequenceUtil sequenceUtil;

    @Test
    public void testGet() {

        for (int i = 0; i < 20; i++) {
            long userId = sequenceUtil.get("PERSON_ID");
            logger.info("userId is =========== " + userId);
        }

    }

}
