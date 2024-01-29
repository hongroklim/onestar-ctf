package bob.rokong.onestarctf.dao;

import bob.rokong.onestarctf.vo.UserVO;

public interface UserDao {
    public UserVO selectUserByUsername(String username);
}
