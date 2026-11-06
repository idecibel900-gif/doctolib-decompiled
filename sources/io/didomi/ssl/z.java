package io.didomi.ssl;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0007¨\u0006\r"}, d2 = {"Lio/didomi/sdk/z;", "", "", "value", "", "c", "color", "a", "colorString", "", "b", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class z {
    public static final z a = new z();

    private z() {
    }

    private final boolean c(String value) {
        return new Regex("^#([0-9a-f]{6}|[0-9a-f]{3})$", RegexOption.IGNORE_CASE).matches(value);
    }

    public final String a(String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return (c(color) && ColorUtils.calculateContrast(b(color), -16777216) < 4.5d) ? "#ffffff" : "#000000";
    }

    public final int b(String colorString) {
        String strReplace;
        Intrinsics.checkNotNullParameter(colorString, "colorString");
        if (new Regex("#[0-9a-f][0-9a-f][0-9a-f]", RegexOption.IGNORE_CASE).matches(colorString)) {
            strReplace = new Regex("#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])").replace(colorString, "#$1$1$2$2$3$3");
        } else {
            strReplace = c(colorString) ? colorString : "#05687b";
        }
        try {
            return Color.parseColor(strReplace);
        } catch (Exception unused) {
            Log.e$default("Error parsing color " + colorString, null, 2, null);
            return Color.parseColor("#05687b");
        }
    }
}
