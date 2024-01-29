package bob.rokong.onestarctf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bob.rokong.onestarctf.dao.UserDao;
import bob.rokong.onestarctf.utils.CryptoUtil;
import bob.rokong.onestarctf.vo.LoginVO;
import bob.rokong.onestarctf.vo.UserVO;
import jakarta.annotation.Nullable;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private CryptoUtil cryptoUtil;

    @Nullable
    public UserVO authenticate(LoginVO loginVO) {
        // Raw to hashed password
        String hashed = cryptoUtil.sha256(loginVO.getPassword());

        // Get user by its name
        UserVO userVO = userDao.selectUserByUsername(loginVO.getUsername());

        if (userVO != null && !userVO.isBlocked() && userVO.getPassword().equals(hashed)) {
            return userVO;
        } else {
            return null;
        }
    }
}
