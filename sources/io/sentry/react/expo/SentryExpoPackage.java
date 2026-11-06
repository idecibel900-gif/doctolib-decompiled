package io.sentry.react.expo;

import android.content.Context;
import expo.modules.core.interfaces.Package;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SentryExpoPackage implements Package {
    @Override // expo.modules.core.interfaces.Package
    public List createReactNativeHostHandlers(Context context) {
        return Collections.singletonList(new SentryReactNativeHostHandler());
    }
}
