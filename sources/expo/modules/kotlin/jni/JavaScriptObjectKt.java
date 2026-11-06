package expo.modules.kotlin.jni;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JavaScriptObjectKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int toCppOptions(List list) {
        Iterator it = list.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= ((JavaScriptObject.PropertyDescriptor) it.next()).getValue();
        }
        return value;
    }
}
