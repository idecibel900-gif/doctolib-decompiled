package expo.modules.webbrowser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0014J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/webbrowser/BrowserProxyActivity;", "Landroid/app/Activity;", "<init>", "()V", "hasLaunchedCustomTab", "", "wasPaused", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "returnToMainApp", "onSaveInstanceState", "outState", "onRestoreInstanceState", "Companion", "expo-web-browser_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserProxyActivity extends Activity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference instance = new WeakReference(null);
    private boolean hasLaunchedCustomTab;
    private boolean wasPaused;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WeakReference getInstance() {
            return BrowserProxyActivity.instance;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("expo.modules.webbrowser.EXTRA_URL");
        if (Build.VERSION.SDK_INT >= 33) {
            intent = (Intent) getIntent().getParcelableExtra("expo.modules.webbrowser.EXTRA_CUSTOM_TABS_INTENT_DATA", Intent.class);
        } else {
            intent = (Intent) getIntent().getParcelableExtra("expo.modules.webbrowser.EXTRA_CUSTOM_TABS_INTENT_DATA");
        }
        if (stringExtra == null || intent == null) {
            finish();
            return;
        }
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            customTabsIntentBuild.intent.putExtras(extras);
        }
        String str = intent.getPackage();
        if (str != null) {
            customTabsIntentBuild.intent.setPackage(str);
        }
        customTabsIntentBuild.launchUrl(this, Uri.parse(stringExtra));
        instance = new WeakReference(this);
        this.hasLaunchedCustomTab = true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.hasLaunchedCustomTab && this.wasPaused) {
            returnToMainApp();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.wasPaused = true;
    }

    private final void returnToMainApp() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(603979776);
            startActivity(launchIntentForPackage);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("hasLaunchedCustomTab", this.hasLaunchedCustomTab);
        outState.putBoolean("wasPaused", this.wasPaused);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        this.hasLaunchedCustomTab = savedInstanceState.getBoolean("hasLaunchedCustomTab", false);
        this.wasPaused = savedInstanceState.getBoolean("wasPaused", false);
    }
}
