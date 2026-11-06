package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.amazon.a.a.o.c.a.b;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ReflectKotlinClassFinderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String toRuntimeFqName(ClassId classId) {
        String strReplace$default = StringsKt.replace$default(classId.getRelativeClassName().asString(), b.a, '$', false, 4, (Object) null);
        if (classId.getPackageFqName().isRoot()) {
            return strReplace$default;
        }
        return classId.getPackageFqName() + b.a + strReplace$default;
    }
}
