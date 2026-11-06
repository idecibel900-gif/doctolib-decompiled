package expo.modules.kotlin.views;

import com.facebook.react.bridge.ReadableMapKeySetIterator;
import expo.modules.kotlin.Filter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FilteredReadableMapKeySetIterator implements ReadableMapKeySetIterator {
    private final Filter filter;
    private final ReadableMapKeySetIterator iterator;
    private String next;

    public FilteredReadableMapKeySetIterator(ReadableMapKeySetIterator iterator, Filter filter) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.iterator = iterator;
        this.filter = filter;
        findNext();
    }

    @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
    public boolean hasNextKey() {
        return this.next != null;
    }

    @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
    public String nextKey() {
        String str = this.next;
        Intrinsics.checkNotNull(str);
        findNext();
        return str;
    }

    private final void findNext() {
        while (this.iterator.hasNextKey()) {
            String strNextKey = this.iterator.nextKey();
            this.next = strNextKey;
            if (this.filter.apply(strNextKey)) {
                return;
            }
        }
        this.next = null;
    }
}
