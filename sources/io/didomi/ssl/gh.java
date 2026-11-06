package io.didomi.ssl;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00028\u0016@PX\u0096.¢\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\u0006\u0010\t\"\u0004\b\u0006\u0010\n¨\u0006\u000e"}, d2 = {"Lio/didomi/sdk/gh;", "", "", "name", DiagnosticsEntry.VERSION_KEY, "", "a", "<set-?>", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "userAgent", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public class gh {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public String userAgent;

    public gh() {
        a("Didomi SDK", "1.86.1");
    }

    public String a() {
        String str = this.userAgent;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userAgent");
        return null;
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userAgent = str;
    }

    public final void a(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        if (!StringsKt.isBlank(name) && !StringsKt.isBlank(version)) {
            a(name + '/' + version + ' ' + System.getProperty("http.agent"));
            return;
        }
        Log.e$default("Invalid arguments: name='" + name + "' version='" + version, null, 2, null);
    }
}
