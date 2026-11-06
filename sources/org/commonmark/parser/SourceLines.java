package org.commonmark.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.commonmark.node.SourceSpan;

/* JADX INFO: loaded from: classes5.dex */
public class SourceLines {
    private final List lines = new ArrayList();

    public static SourceLines empty() {
        return new SourceLines();
    }

    public static SourceLines of(SourceLine sourceLine) {
        SourceLines sourceLines = new SourceLines();
        sourceLines.addLine(sourceLine);
        return sourceLines;
    }

    public static SourceLines of(List list) {
        SourceLines sourceLines = new SourceLines();
        sourceLines.lines.addAll(list);
        return sourceLines;
    }

    public void addLine(SourceLine sourceLine) {
        this.lines.add(sourceLine);
    }

    public List getLines() {
        return this.lines;
    }

    public boolean isEmpty() {
        return this.lines.isEmpty();
    }

    public String getContent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.lines.size(); i++) {
            if (i != 0) {
                sb.append('\n');
            }
            sb.append(((SourceLine) this.lines.get(i)).getContent());
        }
        return sb.toString();
    }

    public List getSourceSpans() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.lines.iterator();
        while (it.hasNext()) {
            SourceSpan sourceSpan = ((SourceLine) it.next()).getSourceSpan();
            if (sourceSpan != null) {
                arrayList.add(sourceSpan);
            }
        }
        return arrayList;
    }
}
