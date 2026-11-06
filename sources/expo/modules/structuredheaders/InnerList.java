package expo.modules.structuredheaders;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class InnerList implements ListElement, Parametrizable {
    private final Parameters params;
    private final List value;

    private InnerList(List list, Parameters parameters) {
        Objects.requireNonNull(list, "value must not be null");
        this.value = list;
        Objects.requireNonNull(parameters, "params must not be null");
        this.params = parameters;
    }

    public static InnerList valueOf(List list) {
        return new InnerList(list, Parameters.EMPTY);
    }

    public InnerList withParams(Parameters parameters) {
        Objects.requireNonNull(parameters, "params must not be null");
        return parameters.isEmpty() ? this : new InnerList(this.value, parameters);
    }

    @Override // expo.modules.structuredheaders.Type
    public StringBuilder serializeTo(StringBuilder sb) {
        sb.append('(');
        String str = "";
        for (Item item : this.value) {
            sb.append(str);
            item.serializeTo(sb);
            str = " ";
        }
        sb.append(')');
        this.params.serializeTo(sb);
        return sb;
    }

    @Override // expo.modules.structuredheaders.Parametrizable
    public Parameters getParams() {
        return this.params;
    }

    @Override // androidx.core.util.Supplier
    public List get() {
        return this.value;
    }
}
