package com.datadog.android.rum;

import com.opentok.android.PublisherKit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.openid.appauth.RegistrationRequest;

/* JADX INFO: loaded from: classes3.dex */
public enum RumResourceKind {
    BEACON("beacon"),
    FETCH("fetch"),
    XHR("xhr"),
    DOCUMENT("document"),
    NATIVE(RegistrationRequest.APPLICATION_TYPE_NATIVE),
    UNKNOWN("unknown"),
    IMAGE("image"),
    JS("js"),
    FONT("font"),
    CSS("css"),
    MEDIA("media"),
    OTHER(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER);

    public static final Companion Companion = new Companion(null);
    private final String value;

    RumResourceKind(String str) {
        this.value = str;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
