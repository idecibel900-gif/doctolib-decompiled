package expo.modules.structuredheaders;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class StringItem implements Item {
    private final Parameters params;
    private final String value;

    private StringItem(String str, Parameters parameters) {
        Objects.requireNonNull(str, "value must not be null");
        this.value = checkParam(str);
        Objects.requireNonNull(parameters, "params must not be null");
        this.params = parameters;
    }

    public static StringItem valueOf(String str) {
        return new StringItem(str, Parameters.EMPTY);
    }

    @Override // expo.modules.structuredheaders.Item
    public StringItem withParams(Parameters parameters) {
        Objects.requireNonNull(parameters, "params must not be null");
        return parameters.isEmpty() ? this : new StringItem(this.value, parameters);
    }

    @Override // expo.modules.structuredheaders.Parametrizable
    public Parameters getParams() {
        return this.params;
    }

    @Override // expo.modules.structuredheaders.Type
    public StringBuilder serializeTo(StringBuilder sb) {
        sb.append('\"');
        for (int i = 0; i < this.value.length(); i++) {
            char cCharAt = this.value.charAt(i);
            if (cCharAt == '\\' || cCharAt == '\"') {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        sb.append('\"');
        this.params.serializeTo(sb);
        return sb;
    }

    @Override // androidx.core.util.Supplier
    public String get() {
        return this.value;
    }

    private static String checkParam(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(String.format("Invalid character in String at position %d: '%c' (0x%04x)", Integer.valueOf(i), Character.valueOf(cCharAt), Integer.valueOf(cCharAt)));
            }
        }
        return str;
    }
}
