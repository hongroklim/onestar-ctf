package bob.rokong.onestarctf.code;

import java.util.Arrays;

public enum PostCategory {
    NOTICE, TIP, TEMP, FLAG;

    public static PostCategory fromString(String categoryString) {
        for (PostCategory category : PostCategory.values()) {
            if (category.toString().equalsIgnoreCase(categoryString)) {
                return category;
            }
        }
        return NOTICE;
    }

    public static String arrayStrings() {
        return "(" + String.join(",", Arrays.stream(PostCategory.values())
                .map(v -> "'" + v.name() + "'")
                .toArray(String[]::new)) + ")";
    }
}
