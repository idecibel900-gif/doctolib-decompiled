package com.revenuecat.purchases;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\bH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/SimulatedStoreErrorDialogActivity;", "Landroid/app/Activity;", "()V", SimulatedStoreErrorDialogActivity.redactedApiKeyExtra, "", "getRedactedApiKey", "()Ljava/lang/String;", "crashApp", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "wasLaunchedThroughSDK", "", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimulatedStoreErrorDialogActivity extends Activity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String redactedApiKeyExtra = "redactedApiKey";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/SimulatedStoreErrorDialogActivity$Companion;", "", "()V", "redactedApiKeyExtra", "", "show", "", "context", "Landroid/content/Context;", SimulatedStoreErrorDialogActivity.redactedApiKeyExtra, "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void show(Context context, String redactedApiKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(redactedApiKey, "redactedApiKey");
            Intent intent = new Intent(context, (Class<?>) SimulatedStoreErrorDialogActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(SimulatedStoreErrorDialogActivity.redactedApiKeyExtra, redactedApiKey);
            context.startActivity(intent);
        }
    }

    public final String getRedactedApiKey() {
        String stringExtra = getIntent().getStringExtra(redactedApiKeyExtra);
        return stringExtra == null ? "" : stringExtra;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFinishOnTouchOutside(false);
        new AlertDialog.Builder(this).setTitle("Wrong API Key").setMessage("This app is using a test API key: " + getRedactedApiKey() + ".\n\nTo prepare for release, update your RevenueCat settings to use a production key.\n\nFor more info, visit the RevenueCat dashboard.\n\nThe app will close now to protect the security of test purchases.").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.SimulatedStoreErrorDialogActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) throws PurchasesException {
                this.f$0.crashApp();
            }
        }).show();
    }

    @Override // android.app.Activity
    public void onBackPressed() throws PurchasesException {
        crashApp();
    }

    @Override // android.app.Activity
    protected void onPause() throws PurchasesException {
        super.onPause();
        crashApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void crashApp() throws PurchasesException {
        if (!wasLaunchedThroughSDK()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "SimulatedStoreErrorDialogActivity was launched incorrectly. This activity is only meant to be launched internally by the SDK.", null);
            finish();
            return;
        }
        throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ConfigurationError, null, 2, null), "Test Store API key used in release build: " + getRedactedApiKey() + ". Please configure the Play Store/Amazon app on the RevenueCat dashboard and use its corresponding API key before releasing. Visit https://rev.cat/sdk-test-store to learn more.");
    }

    private final boolean wasLaunchedThroughSDK() {
        return getIntent().hasExtra(redactedApiKeyExtra);
    }
}
