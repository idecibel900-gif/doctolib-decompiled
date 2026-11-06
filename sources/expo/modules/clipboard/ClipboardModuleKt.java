package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ClipboardModuleKt {
    private static final String TAG = ClipboardModule.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: private */
    public static final String plainTextFromHtml(String str) {
        Spanned spannedFromHtml = Html.fromHtml(str, 0);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
        char[] cArr = new char[spannedFromHtml.length()];
        TextUtils.getChars(spannedFromHtml, 0, spannedFromHtml.length(), cArr, 0);
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String coerceToPlainText(ClipData.Item item, Context context) {
        if (item.getText() == null && item.getHtmlText() != null) {
            String htmlText = item.getHtmlText();
            Intrinsics.checkNotNullExpressionValue(htmlText, "getHtmlText(...)");
            return plainTextFromHtml(htmlText);
        }
        return item.coerceToText(context).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasTextContent(ClipDescription clipDescription) {
        return clipDescription.hasMimeType("text/plain") || clipDescription.hasMimeType("text/html");
    }
}
