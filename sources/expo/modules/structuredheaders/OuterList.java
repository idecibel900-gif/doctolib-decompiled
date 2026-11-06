package expo.modules.structuredheaders;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class OuterList implements Type {
    private final List value;

    private OuterList(List list) {
        Objects.requireNonNull(list, "value must not be null");
        this.value = list;
    }

    public static OuterList valueOf(List list) {
        return new OuterList(list);
    }

    @Override // expo.modules.structuredheaders.Type
    public StringBuilder serializeTo(StringBuilder sb) {
        String str = "";
        for (ListElement listElement : this.value) {
            sb.append(str);
            listElement.serializeTo(sb);
            str = ", ";
        }
        return sb;
    }

    public String serialize() {
        return serializeTo(new StringBuilder()).toString();
    }

    @Override // androidx.core.util.Supplier
    public List get() {
        return this.value;
    }
}
