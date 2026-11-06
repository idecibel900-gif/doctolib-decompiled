package org.commonmark.parser.block;

import org.commonmark.parser.SourceLine;

/* JADX INFO: loaded from: classes5.dex */
public interface ParserState {
    BlockParser getActiveBlockParser();

    int getColumn();

    int getIndent();

    int getIndex();

    SourceLine getLine();

    int getNextNonSpaceIndex();

    boolean isBlank();
}
