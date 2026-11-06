package com.swmansion.enriched.markdown.input;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.PersistableBundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownClipboard {
    public static final MarkdownClipboard INSTANCE = new MarkdownClipboard();

    private MarkdownClipboard() {
    }

    public final ClipData newMarkdownClip(String markdown, String plainText) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        ClipData clipData = new ClipData(new ClipDescription("Markdown", new String[]{"text/vnd.com.swmansion.enriched-markdown", "text/plain"}), new ClipData.Item(plainText));
        ClipDescription description = clipData.getDescription();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("com.swmansion.enriched-markdown.markdown", markdown);
        description.setExtras(persistableBundle);
        return clipData;
    }

    public final String markdownFromClipboard(Context context) {
        ClipData primaryClip;
        PersistableBundle extras;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || !primaryClip.getDescription().hasMimeType("text/vnd.com.swmansion.enriched-markdown") || (extras = primaryClip.getDescription().getExtras()) == null || (string = extras.getString("com.swmansion.enriched-markdown.markdown")) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }
}
