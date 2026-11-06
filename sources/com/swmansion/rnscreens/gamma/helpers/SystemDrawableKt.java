package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SystemDrawableKt {
    public static final Drawable getSystemDrawableResource(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            return null;
        }
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        if (identifier > 0) {
            return AppCompatResources.getDrawable(context, identifier);
        }
        int identifier2 = context.getResources().getIdentifier(str, "drawable", "android");
        if (identifier2 > 0) {
            return AppCompatResources.getDrawable(context, identifier2);
        }
        return null;
    }
}
