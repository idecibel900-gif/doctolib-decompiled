package org.apache.commons.lang3.text.translate;

import java.io.Writer;

/* JADX INFO: loaded from: classes5.dex */
public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i, Writer writer) {
        return i >= 55296 && i <= 57343;
    }
}
