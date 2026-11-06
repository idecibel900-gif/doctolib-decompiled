package org.commonmark.parser.delimiter;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public interface DelimiterRun {
    boolean canClose();

    boolean canOpen();

    Text getCloser();

    Iterable getClosers(int i);

    Text getOpener();

    Iterable getOpeners(int i);

    int length();

    int originalLength();
}
