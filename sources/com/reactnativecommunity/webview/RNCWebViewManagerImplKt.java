package com.reactnativecommunity.webview;

import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RNCWebViewManagerImplKt {
    private static final Regex invalidCharRegex = new Regex("[\\\\/%\"]");

    public static final Regex getInvalidCharRegex() {
        return invalidCharRegex;
    }
}
