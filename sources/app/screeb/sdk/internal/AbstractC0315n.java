package app.screeb.sdk.internal;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: app.screeb.sdk.internal.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0315n {
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(Drawable drawable) {
        if (drawable == 0) {
            return false;
        }
        try {
            return (drawable instanceof Animatable) && ((Animatable) drawable).isRunning();
        } catch (Throwable unused) {
        }
    }
}
