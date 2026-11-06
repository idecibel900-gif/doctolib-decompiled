package app.screeb.sdk.internal;

import android.view.View;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0300f {
    public static volatile boolean a;
    public static final HashMap b = new HashMap();

    public static boolean a(View v) {
        boolean z;
        Intrinsics.checkNotNullParameter(v, "v");
        Class<?> cls = v.getClass();
        Boolean bool = (Boolean) b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        for (Class<?> superclass = cls; superclass != null && !Intrinsics.areEqual(superclass, View.class); superclass = superclass.getSuperclass()) {
            if (Intrinsics.areEqual(superclass.getName(), "androidx.compose.ui.platform.AndroidComposeView")) {
                z = true;
                b.put(cls, Boolean.valueOf(z));
                return z;
            }
        }
        z = false;
        b.put(cls, Boolean.valueOf(z));
        return z;
    }
}
