package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;

/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivity extends Activity {
    private static final zzei variantFlags = zzeg.zza;
    private int activityCode;
    private long billingClientTransactionId;
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    private boolean sendCancelledBroadcastIfFinished;
    private boolean wasServiceAutoReconnected;

    private zzjd getLoggingErrorReason(int i, Intent intent) {
        if (intent != null) {
            if (intent.getExtras() == null) {
                return zzjd.NULL_BUNDLE_IN_ACTIVITY_RESULT;
            }
            return i == 5 ? zzjd.PLAY_STORE_ON_CREATE_RUNTIME_EXCEPTION : zzjd.REASON_UNSPECIFIED;
        }
        if (i == -1) {
            return zzjd.NULL_DATA_WITH_OK_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
        }
        if (i == 0) {
            return zzjd.NULL_DATA_WITH_CANCELLED_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT;
        }
        if (i != 3) {
            return i != 4 ? zzjd.NULL_DATA_WITH_OTHER_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzjd.NULL_DATA_WITH_PLAY_CANCELED_WITHOUT_COMPLETE_ACTION_RESULT_CODE;
        }
        return zzjd.NULL_DATA_WITH_PLAY_CANCELED_RESULT_CODE;
    }

    private boolean isKnownError(int i, Intent intent) {
        return !getLoggingErrorReason(i, intent).equals(zzjd.REASON_UNSPECIFIED);
    }

    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent makePurchaseUpdatedIntentWithInternalErrorReason(zzjd zzjdVar, long j, boolean z) {
        Intent intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
        intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
        intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(6);
        builderNewBuilder.setDebugMessage("An internal error occurred.");
        BillingResult billingResultBuild = builderNewBuilder.build();
        int i = zzcy.$r8$clinit;
        intentMakePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", zzcy.zzb(zzjdVar, 2, billingResultBuild, null, zzjk.BROADCAST_ACTION_UNSPECIFIED).zzQ());
        intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", j);
        intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
        return intentMakePurchasesUpdatedIntent;
    }

    private Intent makePurchasesUpdatedIntent() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0059  */
    /* JADX WARN: Code duplicated, block: B:23:0x005a A[PHI: r10
      0x005a: PHI (r10v1 int) = (r10v0 int), (r10v15 int) binds: [B:20:0x0055, B:22:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:26:0x0093  */
    /* JADX WARN: Code duplicated, block: B:28:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:6:0x0011  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x005a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x0079, please report this as an issue */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        int responseCode;
        int i3;
        String string;
        Intent intentMakePurchasesUpdatedIntent;
        boolean z2;
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (intent == null) {
                z = false;
            } else {
                z = true;
            }
            responseCode = zzc.zzi(intent, "ProxyBillingActivity").getResponseCode();
            i3 = -1;
            if (i2 != -1) {
                zzc.zzo("ProxyBillingActivity", "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
                i3 = i2;
            } else if (responseCode != 0) {
                i2 = -1;
                zzc.zzo("ProxyBillingActivity", "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
                i3 = i2;
            }
            if (true != z) {
                zzc.zzo("ProxyBillingActivity", "Got null data with resultCode " + i3 + "!");
            } else if (intent.getExtras() == null) {
                zzc.zzo("ProxyBillingActivity", "Got null bundle!");
            }
            if (isKnownError(i3, intent)) {
                zzjd loggingErrorReason = getLoggingErrorReason(i3, intent);
                long j = this.billingClientTransactionId;
                if (intent == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                intentMakePurchasesUpdatedIntent = makePurchaseUpdatedIntentWithInternalErrorReason(loggingErrorReason, j, z2);
            } else {
                string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string != null) {
                    intentMakePurchasesUpdatedIntent = makeAlternativeBillingIntent(string);
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                } else {
                    intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                    intentMakePurchasesUpdatedIntent.putExtras(intent.getExtras());
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
                intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
            }
            if (i == 110) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        } else if (i == 110) {
            if (intent == null) {
                z = false;
            } else {
                z = true;
            }
            responseCode = zzc.zzi(intent, "ProxyBillingActivity").getResponseCode();
            i3 = -1;
            if (i2 != -1) {
                zzc.zzo("ProxyBillingActivity", "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
                i3 = i2;
            } else if (responseCode != 0) {
                i2 = -1;
                zzc.zzo("ProxyBillingActivity", "Activity finished with resultCode " + i2 + " and billing's responseCode: " + responseCode);
                i3 = i2;
            }
            if (true != z) {
                zzc.zzo("ProxyBillingActivity", "Got null data with resultCode " + i3 + "!");
            } else if (intent.getExtras() == null) {
                zzc.zzo("ProxyBillingActivity", "Got null bundle!");
            }
            if (isKnownError(i3, intent)) {
                zzjd loggingErrorReason2 = getLoggingErrorReason(i3, intent);
                long j2 = this.billingClientTransactionId;
                if (intent == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                intentMakePurchasesUpdatedIntent = makePurchaseUpdatedIntentWithInternalErrorReason(loggingErrorReason2, j2, z2);
            } else {
                string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string != null) {
                    intentMakePurchasesUpdatedIntent = makeAlternativeBillingIntent(string);
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                } else {
                    intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                    intentMakePurchasesUpdatedIntent.putExtras(intent.getExtras());
                    intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                }
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
                intentMakePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
            }
            if (i == 110) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        } else if (i == 101) {
            int iZza = zzc.zza(intent, "ProxyBillingActivity");
            ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(iZza, intent == null ? null : intent.getExtras());
            }
        } else {
            zzc.zzo("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + i + "; skipping...");
        }
        this.sendCancelledBroadcastIfFinished = false;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle != null) {
            zzc.zzn("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("in_app_message_result_receiver")) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.activityCode = bundle.getInt("activity_code", 100);
            if (bundle.containsKey("billingClientTransactionId")) {
                this.billingClientTransactionId = bundle.getLong("billingClientTransactionId");
            }
            if (bundle.containsKey("wasServiceAutoReconnected")) {
                this.wasServiceAutoReconnected = bundle.getBoolean("wasServiceAutoReconnected");
                return;
            }
            return;
        }
        zzc.zzn("ProxyBillingActivity", "Launching Play Store billing flow");
        this.activityCode = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.isFlowFromFirstPartyClient = true;
                this.activityCode = 110;
            }
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            this.activityCode = 101;
        } else {
            pendingIntent = null;
        }
        if (getIntent().hasExtra("billingClientTransactionId")) {
            this.billingClientTransactionId = getIntent().getLongExtra("billingClientTransactionId", 0L);
        }
        if (getIntent().hasExtra("wasServiceAutoReconnected")) {
            this.wasServiceAutoReconnected = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
        }
        try {
            this.sendCancelledBroadcastIfFinished = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            zzc.zzp("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e);
            ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            } else {
                Intent intentMakePurchaseUpdatedIntentWithInternalErrorReason = makePurchaseUpdatedIntentWithInternalErrorReason(zzjd.INTENT_SENDER_EXCEPTION, this.billingClientTransactionId, false);
                if (this.isFlowFromFirstPartyClient) {
                    intentMakePurchaseUpdatedIntentWithInternalErrorReason.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentMakePurchaseUpdatedIntentWithInternalErrorReason);
            }
            this.sendCancelledBroadcastIfFinished = false;
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            if (this.isFlowFromFirstPartyClient) {
                intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i = this.activityCode;
            if (i == 110 || i == 100) {
                intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                intentMakePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
            }
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
        bundle.putInt("activity_code", this.activityCode);
        bundle.putLong("billingClientTransactionId", this.billingClientTransactionId);
        bundle.putBoolean("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
    }
}
