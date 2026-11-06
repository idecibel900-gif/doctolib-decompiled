package app.screeb.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.ConsoleMessage;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import app.screeb.sdk.ScreebFilePickerActivity;
import app.screeb.sdk.ScreebPermissionActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0297d0 extends WebChromeClient {
    public final /* synthetic */ C0303g0 a;
    public final /* synthetic */ Context b;

    public C0297d0(C0303g0 c0303g0, Context context) {
        this.a = c0303g0;
        this.b = context;
    }

    public static final Unit a(C0303g0 c0303g0, PermissionRequest permissionRequest) {
        C0303g0.a(c0303g0, permissionRequest);
        return Unit.INSTANCE;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage cm) {
        Intrinsics.checkNotNullParameter(cm, "cm");
        return !this.a.i;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(final PermissionRequest request) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(request, "request");
        String[] resources = request.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        C0303g0 c0303g0 = this.a;
        ArrayList arrayList = new ArrayList();
        int length = resources.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length) {
                break;
            }
            String str2 = resources[i];
            Intrinsics.checkNotNull(str2);
            c0303g0.getClass();
            if (Intrinsics.areEqual(str2, "android.webkit.resource.VIDEO_CAPTURE")) {
                str = "android.permission.CAMERA";
            } else if (Intrinsics.areEqual(str2, "android.webkit.resource.AUDIO_CAPTURE")) {
                str = "android.permission.RECORD_AUDIO";
            }
            if (str != null) {
                arrayList.add(str);
            }
            i++;
        }
        List listDistinct = CollectionsKt.distinct(arrayList);
        Context context = this.b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listDistinct) {
            if (ContextCompat.checkSelfPermission(context, (String) obj) != 0) {
                arrayList2.add(obj);
            }
        }
        Activity activity = (Activity) this.a.b.invoke();
        if (arrayList2.isEmpty() || activity == null) {
            C0303g0.a(this.a, request);
            return;
        }
        Pair pair = ScreebPermissionActivity.a;
        Pair pair2 = ScreebPermissionActivity.a;
        if (pair2 != null && (function0 = (Function0) pair2.getSecond()) != null) {
            function0.invoke();
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        final C0303g0 c0303g1 = this.a;
        ScreebPermissionActivity.a = new Pair(string, new Function0() { // from class: app.screeb.sdk.internal.d0$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C0297d0.a(c0303g1, request);
            }
        });
        try {
            Intent intent = new Intent(activity, (Class<?>) ScreebPermissionActivity.class);
            intent.putExtra("screeb_permissions", (String[]) arrayList2.toArray(new String[0]));
            intent.putExtra("screeb_request_id", string);
            activity.startActivity(intent);
        } catch (Exception e) {
            Z.a("Permission", "error while launching permission request", e, 8);
            Pair pair3 = ScreebPermissionActivity.a;
            ScreebPermissionActivity.a = null;
            request.deny();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Activity activity = (Activity) this.a.b.invoke();
        if (activity != null && valueCallback != null && fileChooserParams != null) {
            ValueCallback valueCallback2 = ScreebFilePickerActivity.a;
            ValueCallback valueCallback3 = ScreebFilePickerActivity.a;
            if (valueCallback3 != null) {
                valueCallback3.onReceiveValue(null);
            }
            ScreebFilePickerActivity.a = valueCallback;
            try {
                Intent intentCreateIntent = fileChooserParams.createIntent();
                Intent intent = new Intent(activity, (Class<?>) ScreebFilePickerActivity.class);
                intent.putExtra("screeb_file_chooser_intent", intentCreateIntent);
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                Z.a("FilePicker", "error while launching file picker", e, 8);
                ValueCallback valueCallback4 = ScreebFilePickerActivity.a;
                ScreebFilePickerActivity.a = null;
                valueCallback.onReceiveValue(null);
            }
        }
        return false;
    }
}
