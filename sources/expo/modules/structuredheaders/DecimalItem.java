package expo.modules.structuredheaders;

import com.amazon.a.a.o.c.a.b;
import java.math.BigDecimal;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class DecimalItem implements NumberItem {
    private static final BigDecimal THOUSAND = new BigDecimal(1000);
    private final Parameters params;
    private final long value;

    private DecimalItem(long j, Parameters parameters) {
        if (j < -999999999999999L || j > 999999999999999L) {
            throw new IllegalArgumentException("value must be in the range from -999999999999999 to 999999999999999");
        }
        this.value = j;
        Objects.requireNonNull(parameters, "params must not be null");
        this.params = parameters;
    }

    public static DecimalItem valueOf(long j) {
        return new DecimalItem(j, Parameters.EMPTY);
    }

    public static DecimalItem valueOf(BigDecimal bigDecimal) {
        Objects.requireNonNull(bigDecimal, "value must not be null");
        return valueOf(bigDecimal.multiply(THOUSAND).longValue());
    }

    @Override // expo.modules.structuredheaders.Item
    public DecimalItem withParams(Parameters parameters) {
        Objects.requireNonNull(parameters, "params must not be null");
        return parameters.isEmpty() ? this : new DecimalItem(this.value, parameters);
    }

    @Override // expo.modules.structuredheaders.Parametrizable
    public Parameters getParams() {
        return this.params;
    }

    @Override // expo.modules.structuredheaders.Type
    public StringBuilder serializeTo(StringBuilder sb) {
        long j = this.value;
        String str = j < 0 ? "-" : "";
        long jAbs = Math.abs(j);
        long j2 = jAbs / 1000;
        long j3 = jAbs % 1000;
        if (j3 % 10 == 0) {
            j3 /= 10;
        }
        if (j3 % 10 == 0) {
            j3 /= 10;
        }
        sb.append(str);
        sb.append(Long.toString(j2));
        sb.append(b.a);
        sb.append(Long.toString(j3));
        this.params.serializeTo(sb);
        return sb;
    }

    @Override // androidx.core.util.Supplier
    public BigDecimal get() {
        return BigDecimal.valueOf(this.value, 3);
    }
}
