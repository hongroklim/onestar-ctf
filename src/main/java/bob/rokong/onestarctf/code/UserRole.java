package bob.rokong.onestarctf.code;

public enum UserRole {
    USER_NORMAL("U0"),
    ADMIN_SUPER("A0");

    private final String roleCode;

    private UserRole(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public static UserRole fromRoleCode(String roleCode) {
        for (UserRole role : UserRole.values()) {
            if (role.getRoleCode().equals(roleCode)) {
                return role;
            }
        }
        return USER_NORMAL;
    }
}