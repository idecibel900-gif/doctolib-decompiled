package com.facebook.react.views.scroll;

import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class OnScrollDispatchHelper {
    private static final Companion Companion = new Companion(null);
    private float xFlingVelocity;
    private float yFlingVelocity;
    private int prevX = LinearLayoutManager.INVALID_OFFSET;
    private int prevY = LinearLayoutManager.INVALID_OFFSET;
    private long lastScrollEventTimeMs = -11;

    public final float getXFlingVelocity() {
        return this.xFlingVelocity;
    }

    public final float getYFlingVelocity() {
        return this.yFlingVelocity;
    }

    public final boolean onScrollChanged(int i, int i2) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = this.lastScrollEventTimeMs;
        boolean z = (jUptimeMillis - j <= 10 && this.prevX == i && this.prevY == i2) ? false : true;
        if (jUptimeMillis - j != 0) {
            this.xFlingVelocity = (i - this.prevX) / (jUptimeMillis - j);
            this.yFlingVelocity = (i2 - this.prevY) / (jUptimeMillis - j);
        }
        this.lastScrollEventTimeMs = jUptimeMillis;
        this.prevX = i;
        this.prevY = i2;
        return z;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
