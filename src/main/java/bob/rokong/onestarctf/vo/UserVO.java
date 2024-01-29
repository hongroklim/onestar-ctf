package bob.rokong.onestarctf.vo;

import bob.rokong.onestarctf.code.UserRole;

public class UserVO {
    private int uid;
    private String username;
    private String password;
    private UserRole userRole;
    private boolean isBlocked;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRawPassword(String raw) {
        // TODO SHA-256 on password
        this.password = password;
    }

    public String getRole() {
        return userRole.getRoleCode();
    }

    public void setRole(String roleCode) {
        this.userRole = UserRole.fromRoleCode(roleCode);
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String getBlockedYn() {
        return isBlocked ? "Y" : "N";
    }

    public void setBlocked(String blockedYn) {
        isBlocked = "Y".equals(blockedYn);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + getRole() +
                ", blockedYn=" + getBlockedYn() +
                '}';
    }
}
