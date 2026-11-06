package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PolymorphicKind extends SerialKind {
    public /* synthetic */ PolymorphicKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PolymorphicKind() {
        super(null);
    }

    public static final class SEALED extends PolymorphicKind {
        public static final SEALED INSTANCE = new SEALED();

        private SEALED() {
            super(null);
        }
    }
}
