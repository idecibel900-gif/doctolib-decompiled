package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UnicodeEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    protected abstract String toUtf16Escape(int i);

    protected UnicodeEscaper(int i, int i2, boolean z) {
        this.below = i;
        this.above = i2;
        this.between = z;
    }

    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i, Writer writer) throws IOException {
        if (this.between) {
            if (i < this.below || i > this.above) {
                return false;
            }
        } else if (i >= this.below && i <= this.above) {
            return false;
        }
        if (i > 65535) {
            writer.write(toUtf16Escape(i));
            return true;
        }
        writer.write("\\u");
        char[] cArr = CharSequenceTranslator.HEX_DIGITS;
        writer.write(cArr[(i >> 12) & 15]);
        writer.write(cArr[(i >> 8) & 15]);
        writer.write(cArr[(i >> 4) & 15]);
        writer.write(cArr[i & 15]);
        return true;
    }
}
