package io.didomi.ssl;

import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 \u00102\u00020\u0001:\u0001\u0007B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0012J\b\u0010\u0004\u001a\u00020\u0002H\u0012J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\"\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u0007\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/ph;", "", "", "c", "f", "e", "Landroid/content/SharedPreferences;", "a", "Landroid/content/SharedPreferences;", "()Landroid/content/SharedPreferences;", "sharedPreferences", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "userId", "d", "userIdType", "<init>", "(Landroid/content/SharedPreferences;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class ph {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private String userId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String userIdType;

    public ph(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
        this.userId = c();
        this.userIdType = "uuid";
    }

    private String c() {
        String string = getSharedPreferences().getString("Didomi_User_Id", null);
        if (string == null) {
            string = f();
        }
        Intrinsics.checkNotNullExpressionValue(string, "sharedPreferences.getStr…?: resetUserIdInStorage()");
        return string;
    }

    private String f() {
        String string = UUID.randomUUID().toString();
        getSharedPreferences().edit().putString("Didomi_User_Id", string).apply();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()\n…       .apply()\n        }");
        return string;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public String getUserIdType() {
        return this.userIdType;
    }

    public String e() {
        String strF = f();
        a(strF);
        return strF;
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }
}
