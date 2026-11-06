package net.openid.appauth;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: loaded from: classes5.dex */
public class RedirectUriReceiverActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(AuthorizationManagementActivity.createResponseHandlingIntent(this, getIntent().getData()));
        finish();
    }
}
