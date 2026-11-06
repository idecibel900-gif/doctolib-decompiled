package expo.modules.kotlin.typedarray;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class TypedArrayIterator implements Iterator, KMappedMarker {
    private int current;
    private final GenericTypedArray typedArray;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public TypedArrayIterator(GenericTypedArray typedArray) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        this.typedArray = typedArray;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.current < this.typedArray.getLength();
    }

    @Override // java.util.Iterator
    public Object next() {
        GenericTypedArray genericTypedArray = this.typedArray;
        int i = this.current;
        this.current = i + 1;
        return genericTypedArray.get(i);
    }
}
