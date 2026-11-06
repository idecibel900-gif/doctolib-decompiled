package expo.modules.kotlin.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u0003*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0004\u0005\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ValueOrUndefined;", "T", "", "Companion", "Value", "Undefined", "Lexpo/modules/kotlin/types/ValueOrUndefined$Undefined;", "Lexpo/modules/kotlin/types/ValueOrUndefined$Value;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ValueOrUndefined<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    static Object getUndefined() {
        return INSTANCE.getUndefined();
    }

    public static final class Value implements ValueOrUndefined {
        private final Object value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Value) && Intrinsics.areEqual(this.value, ((Value) obj).value);
        }

        public int hashCode() {
            Object obj = this.value;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Value(value=" + this.value + ")";
        }

        public Value(Object obj) {
            this.value = obj;
        }
    }

    public static final class Undefined implements ValueOrUndefined {
        public static final Undefined INSTANCE = new Undefined();

        private Undefined() {
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Object getUndefined() {
            return Undefined.INSTANCE;
        }
    }
}
