package androidx.compose.ui.text.android;

import android.text.StaticLayout;

/* JADX INFO: loaded from: classes.dex */
interface StaticLayoutFactoryImpl {
    StaticLayout create(StaticLayoutParams staticLayoutParams);

    boolean isFallbackLineSpacingEnabled(StaticLayout staticLayout, boolean z);
}
