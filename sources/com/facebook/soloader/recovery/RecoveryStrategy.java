package com.facebook.soloader.recovery;

import com.facebook.soloader.SoSource;

/* JADX INFO: loaded from: classes3.dex */
public interface RecoveryStrategy {
    boolean recover(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr);
}
