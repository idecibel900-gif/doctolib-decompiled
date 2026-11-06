package com.facebook.react.uimanager;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactRootViewTagGenerator {
    public static final ReactRootViewTagGenerator INSTANCE = new ReactRootViewTagGenerator();
    private static int nextRootViewTag = 1;

    private ReactRootViewTagGenerator() {
    }

    public static final synchronized int getNextRootViewTag() {
        int i;
        i = nextRootViewTag;
        nextRootViewTag = i + 10;
        return i;
    }
}
