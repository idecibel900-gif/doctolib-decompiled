package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TrieNodeEntriesIterator extends TrieNodeBaseIterator {
    @Override // java.util.Iterator
    public Map.Entry next() {
        CommonFunctionsKt.m1105assert(hasNextKey());
        setIndex(getIndex() + 2);
        return new MapEntry(getBuffer()[getIndex() - 2], getBuffer()[getIndex() - 1]);
    }
}
