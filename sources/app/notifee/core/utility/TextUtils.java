package app.notifee.core.utility;

import android.text.Spanned;
import androidx.core.text.HtmlCompat;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TextUtils {
    public static Spanned fromHtml(String str) {
        return HtmlCompat.fromHtml(str, 0);
    }
}
