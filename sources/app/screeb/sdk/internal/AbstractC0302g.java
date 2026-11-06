package app.screeb.sdk.internal;

/* JADX INFO: renamed from: app.screeb.sdk.internal.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0302g {
    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (('A' > cCharAt || cCharAt >= '[') && (('a' > cCharAt || cCharAt >= '{') && (('0' > cCharAt || cCharAt >= ':') && cCharAt != '_' && cCharAt != '-'))) {
                cCharAt = '-';
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }
}
