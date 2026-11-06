package io.didomi.ssl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\u0007\u001a\u00020\u0006H\u0017R\u0014\u0010\t\u001a\u00020\u00028\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\b¨\u0006\f"}, d2 = {"Lio/didomi/sdk/x0;", "", "Landroid/content/Context;", "a", "Lio/didomi/sdk/l7;", "b", "Landroid/content/SharedPreferences;", "c", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class x0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    public x0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public Context getContext() {
        return this.context;
    }

    public l7 b() {
        return new l7(this.context);
    }

    public SharedPreferences c() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(context)");
        return defaultSharedPreferences;
    }
}
