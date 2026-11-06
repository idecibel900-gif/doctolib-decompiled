package com.adjust.sdk.sig;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ISigner {
    void onResume();

    void sign(Context context, Map<String, String> map, String str, String str2);

    void sign(Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3);
}
