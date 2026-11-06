package com.revenuecat.purchases.ui.revenuecatui.components.button;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/button/ButtonComponentInteraction;", "", "value", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ButtonComponentInteraction {
    public static final int $stable = 0;
    private final String url;
    private final String value;

    public static /* synthetic */ ButtonComponentInteraction copy$default(ButtonComponentInteraction buttonComponentInteraction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buttonComponentInteraction.value;
        }
        if ((i & 2) != 0) {
            str2 = buttonComponentInteraction.url;
        }
        return buttonComponentInteraction.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ButtonComponentInteraction copy(String value, String url) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new ButtonComponentInteraction(value, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonComponentInteraction)) {
            return false;
        }
        ButtonComponentInteraction buttonComponentInteraction = (ButtonComponentInteraction) other;
        return Intrinsics.areEqual(this.value, buttonComponentInteraction.value) && Intrinsics.areEqual(this.url, buttonComponentInteraction.url);
    }

    public int hashCode() {
        int iHashCode = this.value.hashCode() * 31;
        String str = this.url;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ButtonComponentInteraction(value=" + this.value + ", url=" + this.url + ')';
    }

    public ButtonComponentInteraction(String value, String str) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.url = str;
    }

    public /* synthetic */ ButtonComponentInteraction(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getValue() {
        return this.value;
    }

    public final String getUrl() {
        return this.url;
    }
}
