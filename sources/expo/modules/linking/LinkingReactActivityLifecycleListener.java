package expo.modules.linking;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkingReactActivityLifecycleListener implements ReactActivityLifecycleListener {
    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public void onCreate(Activity activity, Bundle bundle) {
        Intent intent;
        onReceiveURL((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getData());
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public boolean onNewIntent(Intent intent) {
        onReceiveURL(intent != null ? intent.getData() : null);
        return true;
    }

    private final void onReceiveURL(Uri uri) {
        if (uri == null) {
            return;
        }
        ExpoLinkingModule.Companion companion = ExpoLinkingModule.INSTANCE;
        companion.setInitialURL(uri);
        Iterator it = companion.getOnURLReceivedObservers().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(uri);
        }
    }
}
