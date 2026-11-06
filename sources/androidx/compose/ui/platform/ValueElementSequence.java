package androidx.compose.ui.platform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
public final class ValueElementSequence implements Sequence {
    private final List elements = new ArrayList();

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return this.elements.iterator();
    }

    public final void set(String str, Object obj) {
        this.elements.add(new ValueElement(str, obj));
    }
}
