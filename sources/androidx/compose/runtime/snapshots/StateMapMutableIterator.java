package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
abstract class StateMapMutableIterator {
    private Map.Entry current;
    private final Iterator iterator;
    private final SnapshotStateMap map;
    private int modification;
    private Map.Entry next;

    public StateMapMutableIterator(SnapshotStateMap snapshotStateMap, Iterator it) {
        this.map = snapshotStateMap;
        this.iterator = it;
        this.modification = snapshotStateMap.getModification$runtime_release();
        advance();
    }

    public final SnapshotStateMap getMap() {
        return this.map;
    }

    protected final Map.Entry getCurrent() {
        return this.current;
    }

    protected final Map.Entry getNext() {
        return this.next;
    }

    public final boolean hasNext() {
        return this.next != null;
    }

    protected final void advance() {
        this.current = this.next;
        this.next = this.iterator.hasNext() ? (Map.Entry) this.iterator.next() : null;
    }

    public final void remove() {
        if (getMap().getModification$runtime_release() == this.modification) {
            Map.Entry entry = this.current;
            if (entry != null) {
                this.map.remove(entry.getKey());
                this.current = null;
                Unit unit = Unit.INSTANCE;
                this.modification = getMap().getModification$runtime_release();
                return;
            }
            throw new IllegalStateException();
        }
        throw new ConcurrentModificationException();
    }
}
