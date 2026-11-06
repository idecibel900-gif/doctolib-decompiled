package com.adjust.sdk.sig;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 extends IllegalArgumentException {
    public final String a;

    public m1(String str, String str2) {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            for (int i = 0; i < str2.length(); i++) {
                char cCharAt = str2.charAt(i);
                if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                    strConcat = "\n".concat(str2);
                }
            }
            strConcat = "";
        } else {
            strConcat = "";
        }
        sb.append(strConcat);
        String string = sb.toString();
        super(string);
        this.a = string;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.a;
    }
}
