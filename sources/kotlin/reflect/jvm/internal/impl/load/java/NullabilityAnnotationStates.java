package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.MapsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public interface NullabilityAnnotationStates {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object get(FqName fqName);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final NullabilityAnnotationStates EMPTY = new NullabilityAnnotationStatesImpl(MapsKt.emptyMap());

        private Companion() {
        }

        public final NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }
    }
}
