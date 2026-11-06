package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.ui.graphics.Color;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0016JA\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/BadgeInfo;", "", "text", "", "color", "Landroidx/compose/ui/graphics/Color;", "border", "Landroidx/compose/foundation/BorderStroke;", "textColor", "(Ljava/lang/String;Landroidx/compose/ui/graphics/Color;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Color;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBorder", "()Landroidx/compose/foundation/BorderStroke;", "getColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getText", "()Ljava/lang/String;", "getTextColor-QN2ZGVo", "component1", "component2", "component2-QN2ZGVo", "component3", "component4", "component4-QN2ZGVo", "copy", "copy-yw5i9vo", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class BadgeInfo {
    private final BorderStroke border;
    private final Color color;
    private final String text;
    private final Color textColor;

    public /* synthetic */ BadgeInfo(String str, Color color, BorderStroke borderStroke, Color color2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, color, borderStroke, color2);
    }

    /* JADX INFO: renamed from: copy-yw5i9vo$default, reason: not valid java name */
    public static /* synthetic */ BadgeInfo m4365copyyw5i9vo$default(BadgeInfo badgeInfo, String str, Color color, BorderStroke borderStroke, Color color2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = badgeInfo.text;
        }
        if ((i & 2) != 0) {
            color = badgeInfo.color;
        }
        if ((i & 4) != 0) {
            borderStroke = badgeInfo.border;
        }
        if ((i & 8) != 0) {
            color2 = badgeInfo.textColor;
        }
        return badgeInfo.m4368copyyw5i9vo(str, color, borderStroke, color2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BorderStroke getBorder() {
        return this.border;
    }

    /* JADX INFO: renamed from: component4-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: copy-yw5i9vo, reason: not valid java name */
    public final BadgeInfo m4368copyyw5i9vo(String text, Color color, BorderStroke border, Color textColor) {
        return new BadgeInfo(text, color, border, textColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BadgeInfo)) {
            return false;
        }
        BadgeInfo badgeInfo = (BadgeInfo) other;
        return Intrinsics.areEqual(this.text, badgeInfo.text) && Intrinsics.areEqual(this.color, badgeInfo.color) && Intrinsics.areEqual(this.border, badgeInfo.border) && Intrinsics.areEqual(this.textColor, badgeInfo.textColor);
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Color color = this.color;
        int iM1373hashCodeimpl = (iHashCode + (color == null ? 0 : Color.m1373hashCodeimpl(color.m1375unboximpl()))) * 31;
        BorderStroke borderStroke = this.border;
        int iHashCode2 = (iM1373hashCodeimpl + (borderStroke == null ? 0 : borderStroke.hashCode())) * 31;
        Color color2 = this.textColor;
        return iHashCode2 + (color2 != null ? Color.m1373hashCodeimpl(color2.m1375unboximpl()) : 0);
    }

    public String toString() {
        return "BadgeInfo(text=" + this.text + ", color=" + this.color + ", border=" + this.border + ", textColor=" + this.textColor + ')';
    }

    private BadgeInfo(String str, Color color, BorderStroke borderStroke, Color color2) {
        this.text = str;
        this.color = color;
        this.border = borderStroke;
        this.textColor = color2;
    }

    public /* synthetic */ BadgeInfo(String str, Color color, BorderStroke borderStroke, Color color2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, color, (i & 4) != 0 ? null : borderStroke, (i & 8) != 0 ? null : color2, null);
    }

    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: getColor-QN2ZGVo, reason: not valid java name */
    public final Color m4369getColorQN2ZGVo() {
        return this.color;
    }

    public final BorderStroke getBorder() {
        return this.border;
    }

    /* JADX INFO: renamed from: getTextColor-QN2ZGVo, reason: not valid java name */
    public final Color m4370getTextColorQN2ZGVo() {
        return this.textColor;
    }
}
