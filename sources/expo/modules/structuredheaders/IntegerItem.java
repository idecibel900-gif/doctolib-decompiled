package expo.modules.structuredheaders;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class IntegerItem implements NumberItem {
    private final Parameters params;
    private final long value;

    private IntegerItem(long j, Parameters parameters) {
        if (j < -999999999999999L || j > 999999999999999L) {
            throw new IllegalArgumentException("value must be in the range from -999999999999999 to 999999999999999");
        }
        this.value = j;
        Objects.requireNonNull(parameters, "params must not be null");
        this.params = parameters;
    }

    public static IntegerItem valueOf(long j) {
        return new IntegerItem(j, Parameters.EMPTY);
    }

    @Override // expo.modules.structuredheaders.Item
    public IntegerItem withParams(Parameters parameters) {
        Objects.requireNonNull(parameters, "params must not be null");
        return parameters.isEmpty() ? this : new IntegerItem(this.value, parameters);
    }

    @Override // expo.modules.structuredheaders.Parametrizable
    public Parameters getParams() {
        return this.params;
    }

    @Override // expo.modules.structuredheaders.Type
    public StringBuilder serializeTo(StringBuilder sb) {
        sb.append(Long.toString(this.value));
        this.params.serializeTo(sb);
        return sb;
    }

    @Override // androidx.core.util.Supplier
    public Long get() {
        return Long.valueOf(this.value);
    }
}
