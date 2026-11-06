package expo.modules.kotlin.typedarray;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public interface GenericTypedArray extends TypedArray, Iterable, KMappedMarker {
    Object get(int i);

    public static final class DefaultImpls {
        public static Iterator iterator(GenericTypedArray genericTypedArray) {
            return new TypedArrayIterator(genericTypedArray);
        }
    }
}
