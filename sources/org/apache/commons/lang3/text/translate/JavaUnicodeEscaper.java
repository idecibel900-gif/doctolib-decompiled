package org.apache.commons.lang3.text.translate;

/* JADX INFO: loaded from: classes5.dex */
public class JavaUnicodeEscaper extends UnicodeEscaper {
    public static JavaUnicodeEscaper outsideOf(int i, int i2) {
        return new JavaUnicodeEscaper(i, i2, false);
    }

    public JavaUnicodeEscaper(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    @Override // org.apache.commons.lang3.text.translate.UnicodeEscaper
    protected String toUtf16Escape(int i) {
        char[] chars = Character.toChars(i);
        return "\\u" + CharSequenceTranslator.hex(chars[0]) + "\\u" + CharSequenceTranslator.hex(chars[1]);
    }
}
