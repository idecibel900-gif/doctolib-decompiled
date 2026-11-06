package com.vonage.webrtc;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public interface NetworkChangeDetectorFactory {
    NetworkChangeDetector create(NetworkChangeDetector.Observer observer, Context context);
}
