package com.snackbar.util;

public enum Icon {
    // System feedback
    SUCCESS ("[✔️]", "[✓]"),
    ERROR   ("[✖️]", "[X]"),
    WARNING ("[⚠️]", "[!]"),
    INFO    ("[ℹ️]", "[i]"),
    SYSTEM  ("[⚙️]", "[SYS]"),
    SAVE    ("[💾]", "[SAVE]"),
    CART    ("[🛒]", "[CART]"),

    // Menu Items
    HAMBURGER("[🍔]", "[BURG]"),
    SANDWICH ("[🥖]", "[SUB ]"),
    WIENER   ("[🌭]", "[HDOG]"),
    SIDE     ("[🍟]", "[SIDE]"),
    DRINK    ("[🍹]", "[DRNK]"),
    DESSERT  ("[🍰]", "[DSRT]"),
    COMBO    ("[📦]", "[PACK]"),
    RECEIPT  ("[🧾]", "[RCPT]");

    private final String symbol;
    private final String fallback;
    public static boolean useEmojis;

    Icon(String symbol, String fallback) {
        this.symbol = symbol;
        this.fallback = fallback;
    }

    @Override
    public String toString() {
        try {
            return useEmojis ? symbol : fallback;
        } catch (Exception e) {
            return fallback;
        }
    }
}
