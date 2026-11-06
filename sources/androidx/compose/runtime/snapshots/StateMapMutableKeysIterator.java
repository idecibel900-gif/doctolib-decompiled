package androidx.compose.runtime.snapshots;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
final class StateMapMutableKeysIterator extends StateMapMutableIterator implements Iterator, KMappedMarker {
    public StateMapMutableKeysIterator(SnapshotStateMap snapshotStateMap, Iterator it) {
        super(snapshotStateMap, it);
    }

    @Override // java.util.Iterator
    public Object next() {
        Map.Entry next = getNext();
        if (next == null) {
            throw new IllegalStateException();
        }
        advance();
        return next.getKey();
    }
}
