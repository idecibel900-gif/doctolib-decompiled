package org.commonmark.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SourceSpans {
    private List sourceSpans;

    public static SourceSpans empty() {
        return new SourceSpans();
    }

    public List getSourceSpans() {
        List list = this.sourceSpans;
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public void addAllFrom(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            addAll(((Node) it.next()).getSourceSpans());
        }
    }

    public void addAll(List list) {
        if (list.isEmpty()) {
            return;
        }
        if (this.sourceSpans == null) {
            this.sourceSpans = new ArrayList();
        }
        if (this.sourceSpans.isEmpty()) {
            this.sourceSpans.addAll(list);
            return;
        }
        int size = this.sourceSpans.size() - 1;
        SourceSpan sourceSpan = (SourceSpan) this.sourceSpans.get(size);
        SourceSpan sourceSpan2 = (SourceSpan) list.get(0);
        if (sourceSpan.getLineIndex() == sourceSpan2.getLineIndex() && sourceSpan.getColumnIndex() + sourceSpan.getLength() == sourceSpan2.getColumnIndex()) {
            this.sourceSpans.set(size, SourceSpan.of(sourceSpan.getLineIndex(), sourceSpan.getColumnIndex(), sourceSpan.getLength() + sourceSpan2.getLength()));
            this.sourceSpans.addAll(list.subList(1, list.size()));
        } else {
            this.sourceSpans.addAll(list);
        }
    }
}
