package app.screeb.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import app.screeb.sdk.internal.Z;
import com.adjust.sdk.network.ErrorCodes;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ScreebPermissionActivity extends Activity {
    public static volatile Pair a;

    public final void a() {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("screeb_request_id") : null;
        Pair pair = a;
        if (pair != null && Intrinsics.areEqual(pair.getFirst(), stringExtra)) {
            a = null;
            ((Function0) pair.getSecond()).invoke();
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            a();
            return;
        }
        String[] stringArrayExtra = getIntent().getStringArrayExtra("screeb_permissions");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            a();
            return;
        }
        try {
            ActivityCompat.requestPermissions(this, stringArrayExtra, ErrorCodes.UNSUPPORTED_ENCODING_EXCEPTION);
        } catch (Exception e) {
            Z z = Z.b;
            Z z2 = Z.b;
            Z.a("Permission", "error while requesting permissions", e, 8);
            a();
        }
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        if (i == 1002) {
            a();
        }
    }
}
