package org.commonmark.node;

/* JADX INFO: loaded from: classes5.dex */
public class OrderedList extends ListBlock {
    private char delimiter;
    private int startNumber;

    public int getStartNumber() {
        return this.startNumber;
    }

    public void setStartNumber(int i) {
        this.startNumber = i;
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(char c) {
        this.delimiter = c;
    }
}
