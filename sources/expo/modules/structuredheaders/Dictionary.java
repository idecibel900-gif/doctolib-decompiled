package expo.modules.structuredheaders;

import com.amazon.a.a.o.b.f;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Dictionary implements Type {
    private final Map value;

    private Dictionary(Map map) {
        this.value = Collections.unmodifiableMap(Utils.checkKeys(map));
    }

    public static Dictionary valueOf(Map map) {
        return new Dictionary(map);
    }

    @Override // androidx.core.util.Supplier
    public Map get() {
        return this.value;
    }

    @Override // expo.modules.structuredheaders.Type
    public StringBuilder serializeTo(StringBuilder sb) {
        String str = "";
        for (Map.Entry entry : this.value.entrySet()) {
            sb.append(str);
            String str2 = (String) entry.getKey();
            ListElement listElement = (ListElement) entry.getValue();
            sb.append(str2);
            if (Boolean.TRUE.equals(listElement.get())) {
                listElement.getParams().serializeTo(sb);
            } else {
                sb.append(f.b);
                listElement.serializeTo(sb);
            }
            str = ", ";
        }
        return sb;
    }

    public String serialize() {
        return serializeTo(new StringBuilder()).toString();
    }
}
