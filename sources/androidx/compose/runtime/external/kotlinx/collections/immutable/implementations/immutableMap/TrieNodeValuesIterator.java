package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class TrieNodeValuesIterator extends TrieNodeBaseIterator {
    @Override // java.util.Iterator
    public Object next() {
        CommonFunctionsKt.m1105assert(hasNextKey());
        setIndex(getIndex() + 2);
        return getBuffer()[getIndex() - 1];
    }
}
