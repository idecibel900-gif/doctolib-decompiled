package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* JADX INFO: loaded from: classes.dex */
public abstract class HtmlCompat {
    public static Spanned fromHtml(String str, int i) {
        return Api24Impl.fromHtml(str, i);
    }

    public static Spanned fromHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return Api24Impl.fromHtml(str, i, imageGetter, tagHandler);
    }

    static class Api24Impl {
        static Spanned fromHtml(String str, int i) {
            return Html.fromHtml(str, i);
        }

        static Spanned fromHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i, imageGetter, tagHandler);
        }
    }
}
