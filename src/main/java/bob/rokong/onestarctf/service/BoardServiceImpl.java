package bob.rokong.onestarctf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import bob.rokong.onestarctf.code.PostCategory;
import bob.rokong.onestarctf.dao.PostDao;
import bob.rokong.onestarctf.utils.CryptoUtil;
import bob.rokong.onestarctf.vo.BoardParamVO;
import bob.rokong.onestarctf.vo.PostVO;
import bob.rokong.onestarctf.vo.ViewParamVO;

@Service
public class BoardServiceImpl implements BoardService {
    private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Autowired
    private PostDao postDao;

    @Autowired
    private CryptoUtil cryptoUtil;

    public List<PostVO> getRecentNotices() {
        int maxCount = 3;
        return postDao.selectRecentNotices(maxCount);
    }

    public List<PostVO> getPosts(BoardParamVO boardParamVO) {
        return postDao.selectPosts(boardParamVO);
    }

    public PostVO getPost(ViewParamVO viewParamVO) {
        PostVO postVO = postDao.selectPostByPid(viewParamVO.getPid());

        if (postVO != null && postVO.getPostCategory().equals(PostCategory.FLAG)) {
            if (viewParamVO.isAdmin()) {
                String decrypted = cryptoUtil.decrypt(postVO.getContent());
                postVO.setContent(decrypted);
                log.info("FLAG_2 Captured");
            } else {
                postVO.setContent("**Local Admin Only**");
            }
        }

        return postVO;
    }
}