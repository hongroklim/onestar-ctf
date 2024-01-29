package bob.rokong.onestarctf.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import bob.rokong.onestarctf.vo.BoardParamVO;
import bob.rokong.onestarctf.vo.PostVO;

@Repository
public class PostDaoImpl implements PostDao {

    public static final String PREFIX = "bob.rokong.onestarctf.dao.post.";

    @Autowired
    SqlSessionTemplate sqlSession;

    public List<PostVO> selectRecentNotices(int maxCount) {
        return sqlSession.selectList(PREFIX+"selectRecentNotices", maxCount);
    }

    public List<PostVO> selectPosts(BoardParamVO boardParamVO) {
        return sqlSession.selectList(PREFIX+"selectPosts", boardParamVO);
    }

    public PostVO selectPostByPid(int pid) {
        return sqlSession.selectOne(PREFIX+"selectPostByPid", pid);
    }
}
