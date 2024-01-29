package bob.rokong.onestarctf.service;

import bob.rokong.onestarctf.vo.LoginVO;
import bob.rokong.onestarctf.vo.UserVO;

public interface AuthService {
    public UserVO authenticate(LoginVO loginVO);
}
