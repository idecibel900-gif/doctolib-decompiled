package app.screeb.sdk.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0293b0 {
    public static String a(String processName) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        ArrayList arrayList = new ArrayList(processName.length());
        for (int i = 0; i < processName.length(); i++) {
            char cCharAt = processName.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '.' && cCharAt != '_' && cCharAt != '-') {
                cCharAt = '_';
            }
            arrayList.add(Character.valueOf(cCharAt));
        }
        return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null) + "-screeb";
    }
}
