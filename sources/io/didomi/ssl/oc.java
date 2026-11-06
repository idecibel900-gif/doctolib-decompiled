package io.didomi.ssl;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lio/didomi/sdk/oc;", "", "Landroid/content/SharedPreferences;", "sharedPreferences", "", "", "keys", "", "a", "(Landroid/content/SharedPreferences;[Ljava/lang/String;)V", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class oc {
    public static final oc a = new oc();

    private oc() {
    }

    public final void a(SharedPreferences sharedPreferences, String[] keys) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(keys, "keys");
        ArrayList arrayList = new ArrayList();
        for (String str : keys) {
            if (sharedPreferences.contains(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }
}
