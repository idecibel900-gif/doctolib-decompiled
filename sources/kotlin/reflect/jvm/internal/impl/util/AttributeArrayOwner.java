package kotlin.reflect.jvm.internal.impl.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AttributeArrayOwner extends AbstractArrayMapOwner {
    private ArrayMap arrayMap;

    protected AttributeArrayOwner(ArrayMap arrayMap) {
        Intrinsics.checkNotNullParameter(arrayMap, "arrayMap");
        this.arrayMap = arrayMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected final ArrayMap getArrayMap() {
        return this.arrayMap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AttributeArrayOwner() {
        EmptyArrayMap emptyArrayMap = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(emptyArrayMap, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(emptyArrayMap);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected final void registerComponent(String keyQualifiedName, Object value) {
        Intrinsics.checkNotNullParameter(keyQualifiedName, "keyQualifiedName");
        Intrinsics.checkNotNullParameter(value, "value");
        int id = getTypeRegistry().getId(keyQualifiedName);
        int size = this.arrayMap.getSize();
        if (size == 0) {
            ArrayMap arrayMap = this.arrayMap;
            if (!(arrayMap instanceof EmptyArrayMap)) {
                throw new IllegalStateException(buildDiagnosticMessage(arrayMap, 0, "EmptyArrayMap"));
            }
            this.arrayMap = new OneElementArrayMap(value, id);
            return;
        }
        if (size == 1) {
            ArrayMap arrayMap2 = this.arrayMap;
            try {
                Intrinsics.checkNotNull(arrayMap2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                OneElementArrayMap oneElementArrayMap = (OneElementArrayMap) arrayMap2;
                if (oneElementArrayMap.getIndex() == id) {
                    this.arrayMap = new OneElementArrayMap(value, id);
                    return;
                } else {
                    ArrayMapImpl arrayMapImpl = new ArrayMapImpl();
                    arrayMapImpl.set(oneElementArrayMap.getIndex(), oneElementArrayMap.getValue());
                    this.arrayMap = arrayMapImpl;
                }
            } catch (ClassCastException e) {
                throw new IllegalStateException(buildDiagnosticMessage(arrayMap2, 1, "OneElementArrayMap"), e);
            }
        }
        this.arrayMap.set(id, value);
    }

    private final String buildDiagnosticMessage(ArrayMap arrayMap, int i, String str) {
        Object next;
        StringBuilder sb = new StringBuilder();
        sb.append("Race condition happened, the size of ArrayMap is " + i + " but it isn't an `" + str + '`');
        sb.append('\n');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Type: ");
        sb2.append(arrayMap.getClass());
        sb.append(sb2.toString());
        sb.append('\n');
        StringBuilder sb3 = new StringBuilder();
        Map mapAllValuesThreadUnsafeForRendering = getTypeRegistry().allValuesThreadUnsafeForRendering();
        sb3.append("[");
        sb3.append('\n');
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayMap, 10));
        int i2 = 0;
        for (Object obj : arrayMap) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Iterator it = mapAllValuesThreadUnsafeForRendering.entrySet().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((Number) ((Map.Entry) next).getValue()).intValue() != i2);
            sb3.append("  " + ((Map.Entry) next) + '[' + i2 + "]: " + obj);
            sb3.append('\n');
            arrayList.add(sb3);
            i2 = i3;
        }
        sb3.append("]");
        sb3.append('\n');
        sb.append("Content: " + sb3.toString());
        sb.append('\n');
        return sb.toString();
    }
}
