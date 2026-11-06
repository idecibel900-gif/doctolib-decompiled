package net.openid.appauth;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import net.openid.appauth.internal.Logger;
import org.json.JSONException;

/* JADX INFO: loaded from: classes5.dex */
public class AuthorizationManagementActivity extends AppCompatActivity {
    static final String KEY_AUTHORIZATION_STARTED = "authStarted";
    static final String KEY_AUTH_INTENT = "authIntent";
    static final String KEY_AUTH_REQUEST = "authRequest";
    static final String KEY_AUTH_REQUEST_TYPE = "authRequestType";
    static final String KEY_CANCEL_INTENT = "cancelIntent";
    static final String KEY_COMPLETE_INTENT = "completeIntent";
    private Intent mAuthIntent;
    private AuthorizationManagementRequest mAuthRequest;
    private boolean mAuthorizationStarted = false;
    private PendingIntent mCancelIntent;
    private PendingIntent mCompleteIntent;

    public static Intent createStartIntent(Context context, AuthorizationManagementRequest authorizationManagementRequest, Intent intent, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.putExtra(KEY_AUTH_INTENT, intent);
        intentCreateBaseIntent.putExtra(KEY_AUTH_REQUEST, authorizationManagementRequest.jsonSerializeString());
        intentCreateBaseIntent.putExtra(KEY_AUTH_REQUEST_TYPE, AuthorizationManagementUtil.requestTypeFor(authorizationManagementRequest));
        intentCreateBaseIntent.putExtra(KEY_COMPLETE_INTENT, pendingIntent);
        intentCreateBaseIntent.putExtra(KEY_CANCEL_INTENT, pendingIntent2);
        return intentCreateBaseIntent;
    }

    public static Intent createStartForResultIntent(Context context, AuthorizationManagementRequest authorizationManagementRequest, Intent intent) {
        return createStartIntent(context, authorizationManagementRequest, intent, null, null);
    }

    public static Intent createResponseHandlingIntent(Context context, Uri uri) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.setData(uri);
        intentCreateBaseIntent.addFlags(603979776);
        return intentCreateBaseIntent;
    }

    private static Intent createBaseIntent(Context context) {
        return new Intent(context, (Class<?>) AuthorizationManagementActivity.class);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            extractState(getIntent().getExtras());
        } else {
            extractState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.mAuthorizationStarted) {
            try {
                startActivity(this.mAuthIntent);
                this.mAuthorizationStarted = true;
                return;
            } catch (ActivityNotFoundException unused) {
                handleBrowserNotFound();
                finish();
                return;
            }
        }
        if (getIntent().getData() != null) {
            handleAuthorizationComplete();
        } else {
            handleAuthorizationCanceled();
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(KEY_AUTHORIZATION_STARTED, this.mAuthorizationStarted);
        bundle.putParcelable(KEY_AUTH_INTENT, this.mAuthIntent);
        bundle.putString(KEY_AUTH_REQUEST, this.mAuthRequest.jsonSerializeString());
        bundle.putString(KEY_AUTH_REQUEST_TYPE, AuthorizationManagementUtil.requestTypeFor(this.mAuthRequest));
        bundle.putParcelable(KEY_COMPLETE_INTENT, this.mCompleteIntent);
        bundle.putParcelable(KEY_CANCEL_INTENT, this.mCancelIntent);
    }

    private void handleAuthorizationComplete() {
        Uri data = getIntent().getData();
        Intent intentExtractResponseData = extractResponseData(data);
        if (intentExtractResponseData == null) {
            Logger.error("Failed to extract OAuth2 response from redirect", new Object[0]);
        } else {
            intentExtractResponseData.setData(data);
            sendResult(this.mCompleteIntent, intentExtractResponseData, -1);
        }
    }

    private void handleAuthorizationCanceled() {
        Logger.debug("Authorization flow canceled by user", new Object[0]);
        sendResult(this.mCancelIntent, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.USER_CANCELED_AUTH_FLOW, null).toIntent(), 0);
    }

    private void handleBrowserNotFound() {
        Logger.debug("Authorization flow canceled due to missing browser", new Object[0]);
        sendResult(this.mCancelIntent, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.PROGRAM_CANCELED_AUTH_FLOW, null).toIntent(), 0);
    }

    private void extractState(Bundle bundle) {
        if (bundle == null) {
            Logger.warn("No stored state - unable to handle response", new Object[0]);
            finish();
            return;
        }
        this.mAuthIntent = (Intent) bundle.getParcelable(KEY_AUTH_INTENT);
        this.mAuthorizationStarted = bundle.getBoolean(KEY_AUTHORIZATION_STARTED, false);
        this.mCompleteIntent = (PendingIntent) bundle.getParcelable(KEY_COMPLETE_INTENT);
        this.mCancelIntent = (PendingIntent) bundle.getParcelable(KEY_CANCEL_INTENT);
        try {
            String string = bundle.getString(KEY_AUTH_REQUEST, null);
            this.mAuthRequest = string != null ? AuthorizationManagementUtil.requestFrom(string, bundle.getString(KEY_AUTH_REQUEST_TYPE, null)) : null;
        } catch (JSONException unused) {
            sendResult(this.mCancelIntent, AuthorizationException.AuthorizationRequestErrors.INVALID_REQUEST.toIntent(), 0);
        }
    }

    private void sendResult(PendingIntent pendingIntent, Intent intent, int i) {
        if (pendingIntent != null) {
            try {
                pendingIntent.send(this, 0, intent);
                return;
            } catch (PendingIntent.CanceledException e) {
                Logger.error("Failed to send cancel intent", e);
                return;
            }
        }
        setResult(i, intent);
    }

    private Intent extractResponseData(Uri uri) {
        if (uri.getQueryParameterNames().contains("error")) {
            return AuthorizationException.fromOAuthRedirect(uri).toIntent();
        }
        AuthorizationManagementResponse authorizationManagementResponseResponseWith = AuthorizationManagementUtil.responseWith(this.mAuthRequest, uri);
        if ((this.mAuthRequest.getState() == null && authorizationManagementResponseResponseWith.getState() != null) || (this.mAuthRequest.getState() != null && !this.mAuthRequest.getState().equals(authorizationManagementResponseResponseWith.getState()))) {
            Logger.warn("State returned in authorization response (%s) does not match state from request (%s) - discarding response", authorizationManagementResponseResponseWith.getState(), this.mAuthRequest.getState());
            return AuthorizationException.AuthorizationRequestErrors.STATE_MISMATCH.toIntent();
        }
        return authorizationManagementResponseResponseWith.toIntent();
    }
}
