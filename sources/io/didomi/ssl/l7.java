package io.didomi.ssl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lio/didomi/sdk/l7;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "<init>", "(Landroid/content/Context;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class l7 extends BroadcastReceiver {
    public l7(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.registerReceiver(this, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.LOCALE_CHANGED")) {
            String preferredLanguage = Locale.getDefault().getLanguage();
            try {
                Didomi companion = Didomi.INSTANCE.getInstance();
                Intrinsics.checkNotNullExpressionValue(preferredLanguage, "preferredLanguage");
                companion.updateSelectedLanguage(preferredLanguage);
            } catch (Exception e) {
                Log.e("Unable to change language to " + preferredLanguage, e);
            }
        }
    }
}
