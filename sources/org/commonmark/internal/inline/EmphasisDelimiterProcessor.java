package org.commonmark.internal.inline;

import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.commonmark.node.Nodes;
import org.commonmark.node.SourceSpans;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EmphasisDelimiterProcessor implements DelimiterProcessor {
    private final char delimiterChar;

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return 1;
    }

    protected EmphasisDelimiterProcessor(char c) {
        this.delimiterChar = c;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.delimiterChar;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.delimiterChar;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int process(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        Node emphasis;
        if ((delimiterRun.canClose() || delimiterRun2.canOpen()) && delimiterRun2.originalLength() % 3 != 0 && (delimiterRun.originalLength() + delimiterRun2.originalLength()) % 3 == 0) {
            return 0;
        }
        int i = 2;
        if (delimiterRun.length() >= 2 && delimiterRun2.length() >= 2) {
            emphasis = new StrongEmphasis(String.valueOf(this.delimiterChar) + this.delimiterChar);
        } else {
            emphasis = new Emphasis(String.valueOf(this.delimiterChar));
            i = 1;
        }
        SourceSpans sourceSpansEmpty = SourceSpans.empty();
        sourceSpansEmpty.addAllFrom(delimiterRun.getOpeners(i));
        Text opener = delimiterRun.getOpener();
        for (Node node : Nodes.between(opener, delimiterRun2.getCloser())) {
            emphasis.appendChild(node);
            sourceSpansEmpty.addAll(node.getSourceSpans());
        }
        sourceSpansEmpty.addAllFrom(delimiterRun2.getClosers(i));
        emphasis.setSourceSpans(sourceSpansEmpty.getSourceSpans());
        opener.insertAfter(emphasis);
        return i;
    }
}
