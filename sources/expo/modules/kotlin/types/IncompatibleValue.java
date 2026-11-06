package expo.modules.kotlin.types;

/* JADX INFO: loaded from: classes4.dex */
public final class IncompatibleValue extends DeferredValue {
    public static final IncompatibleValue INSTANCE = new IncompatibleValue();

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof IncompatibleValue);
    }

    public int hashCode() {
        return 1921661369;
    }

    public String toString() {
        return "IncompatibleValue";
    }

    private IncompatibleValue() {
        super(null);
    }
}
