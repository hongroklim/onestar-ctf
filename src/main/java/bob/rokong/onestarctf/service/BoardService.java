package bob.rokong.onestarctf.service;

import java.util.List;

import bob.rokong.onestarctf.vo.BoardParamVO;
import bob.rokong.onestarctf.vo.PostVO;
import bob.rokong.onestarctf.vo.ViewParamVO;

public interface BoardService {
    public List<PostVO> getRecentNotices();
    public List<PostVO> getPosts(BoardParamVO boardParamVO);
    PostVO getPost(ViewParamVO viewParamVO);
}
