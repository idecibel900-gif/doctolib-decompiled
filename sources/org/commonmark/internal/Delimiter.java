package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: loaded from: classes5.dex */
public class Delimiter implements DelimiterRun {
    private final boolean canClose;
    private final boolean canOpen;
    public final List characters;
    public final char delimiterChar;
    public Delimiter next;
    private final int originalLength;
    public Delimiter previous;

    public Delimiter(List list, char c, boolean z, boolean z2, Delimiter delimiter) {
        this.characters = list;
        this.delimiterChar = c;
        this.canOpen = z;
        this.canClose = z2;
        this.previous = delimiter;
        this.originalLength = list.size();
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public boolean canOpen() {
        return this.canOpen;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public boolean canClose() {
        return this.canClose;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public int length() {
        return this.characters.size();
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public int originalLength() {
        return this.originalLength;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public Text getOpener() {
        List list = this.characters;
        return (Text) list.get(list.size() - 1);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public Text getCloser() {
        return (Text) this.characters.get(0);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public Iterable getOpeners(int i) {
        if (i < 1 || i > length()) {
            throw new IllegalArgumentException("length must be between 1 and " + length() + ", was " + i);
        }
        List list = this.characters;
        return list.subList(list.size() - i, this.characters.size());
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public Iterable getClosers(int i) {
        if (i < 1 || i > length()) {
            throw new IllegalArgumentException("length must be between 1 and " + length() + ", was " + i);
        }
        return this.characters.subList(0, i);
    }
}
