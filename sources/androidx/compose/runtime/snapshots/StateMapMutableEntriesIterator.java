package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes.dex */
final class StateMapMutableEntriesIterator extends StateMapMutableIterator implements Iterator, KMappedMarker {
    public StateMapMutableEntriesIterator(SnapshotStateMap snapshotStateMap, Iterator it) {
        super(snapshotStateMap, it);
    }

    @Override // java.util.Iterator
    public Map.Entry next() {
        advance();
        if (getCurrent() != null) {
            return new AnonymousClass1();
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.StateMapMutableEntriesIterator$next$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Map.Entry, KMutableMap.Entry {
        private final Object key;
        private Object value;

        AnonymousClass1() {
            Map.Entry current = StateMapMutableEntriesIterator.this.getCurrent();
            Intrinsics.checkNotNull(current);
            this.key = current.getKey();
            Map.Entry current2 = StateMapMutableEntriesIterator.this.getCurrent();
            Intrinsics.checkNotNull(current2);
            this.value = current2.getValue();
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public void setValue(Object obj) {
            this.value = obj;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            StateMapMutableEntriesIterator stateMapMutableEntriesIterator = StateMapMutableEntriesIterator.this;
            if (stateMapMutableEntriesIterator.getMap().getModification$runtime_release() != ((StateMapMutableIterator) stateMapMutableEntriesIterator).modification) {
                throw new ConcurrentModificationException();
            }
            Object value = getValue();
            stateMapMutableEntriesIterator.getMap().put(getKey(), obj);
            setValue(obj);
            return value;
        }
    }
}
