package bob.rokong.onestarctf.vo;

public class ViewParamVO {
    private int pid;
    private String categories;
    private String keywordOption;
    private String keyword;
    private boolean isAdmin;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getKeywordOption() {
        return keywordOption;
    }

    public void setKeywordOption(String keywordOption) {
        this.keywordOption = keywordOption;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getBoardQueryString() {
        StringBuilder queryString = new StringBuilder();

        if (categories != null && !categories.isEmpty()) {
            queryString.append("categories=").append(categories).append("&");
        }
        if (keywordOption != null && !keywordOption.isEmpty()) {
            queryString.append("keywordOption=").append(keywordOption).append("&");
        }
        if (keyword != null && !keyword.isEmpty()) {
            queryString.append("keyword=").append(keyword).append("&");
        }

        // Remove the trailing '&' if any
        if (queryString.length() > 0 && queryString.charAt(queryString.length() - 1) == '&') {
            queryString.setLength(queryString.length() - 1);
        }

        return queryString.toString();
    }

    @Override
    public String toString() {
        return "ViewParamVO{" +
                "pid=" + pid +
                ", categories='" + categories + '\'' +
                ", keywordOption='" + keywordOption + '\'' +
                ", keyword='" + keyword + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
