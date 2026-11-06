package expo.modules.kotlin.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ConvertedValue extends DeferredValue {
    private final Object convertedValue;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConvertedValue) && Intrinsics.areEqual(this.convertedValue, ((ConvertedValue) obj).convertedValue);
    }

    public int hashCode() {
        return this.convertedValue.hashCode();
    }

    public String toString() {
        return "ConvertedValue(convertedValue=" + this.convertedValue + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConvertedValue(Object convertedValue) {
        super(null);
        Intrinsics.checkNotNullParameter(convertedValue, "convertedValue");
        this.convertedValue = convertedValue;
    }

    public final Object getConvertedValue() {
        return this.convertedValue;
    }
}
