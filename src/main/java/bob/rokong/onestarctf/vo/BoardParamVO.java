package bob.rokong.onestarctf.vo;

public class BoardParamVO {
    private String categories;
    private String keywordOption;
    private String keyword;

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

    public String getQueryString() {
        StringBuilder queryString = new StringBuilder();

        if (categories != null && !categories.isEmpty()) {
            queryString.append("&").append("categories=").append(categories);
        }
        if (keywordOption != null && !keywordOption.isEmpty()) {
            queryString.append("&").append("keywordOption=").append(keywordOption);
        }
        if (keyword != null && !keyword.isEmpty()) {
            queryString.append("&").append("keyword=").append(keyword);
        }

        return queryString.toString();
    }

    @Override
    public String toString() {
        return "BoardParamVO{" +
                "categories='" + categories + '\'' +
                ", keywordOption='" + keywordOption + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
