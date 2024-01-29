package bob.rokong.onestarctf.dao;

import java.util.List;

import bob.rokong.onestarctf.vo.BoardParamVO;
import bob.rokong.onestarctf.vo.PostVO;

public interface PostDao {
    public List<PostVO> selectRecentNotices(int maxCount);
    public List<PostVO> selectPosts(BoardParamVO boardParamVO);
    public PostVO selectPostByPid(int pid);
}
