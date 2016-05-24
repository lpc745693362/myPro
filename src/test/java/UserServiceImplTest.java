import com.lpc.user.dao.UserDao;
import com.lpc.user.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by liupengcheng1 on 2016/5/16.
 */
public class UserServiceImplTest extends BaseTest {

    private Logger logger = Logger.getLogger(UserServiceImplTest.class);

    @Resource
    private UserDao userDao;

    @Test
    public void testSelectById(){
        long id = 1001l;
        User user = userDao.selectById(id);
        logger.info("user is ============ " + user);
    }


}
