package bob.rokong.onestarctf.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bob.rokong.onestarctf.vo.UserVO;

@Repository
public class UserDaoImpl implements UserDao {
    public static final String PREFIX = "bob.rokong.onestarctf.dao.user.";

    @Autowired
    SqlSessionTemplate sqlSession;

    public UserVO selectUserByUsername(String username) {
        return sqlSession.selectOne(PREFIX+"selectUserByUsername", username);
    }
}
