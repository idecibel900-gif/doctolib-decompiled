package com.facebook.react.uimanager.style;

import android.content.Context;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BorderRadiusStyle {
    private LengthPercentage bottomEnd;
    private LengthPercentage bottomLeft;
    private LengthPercentage bottomRight;
    private LengthPercentage bottomStart;
    private LengthPercentage endEnd;
    private LengthPercentage endStart;
    private LengthPercentage startEnd;
    private LengthPercentage startStart;
    private LengthPercentage topEnd;
    private LengthPercentage topLeft;
    private LengthPercentage topRight;
    private LengthPercentage topStart;
    private LengthPercentage uniform;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BorderRadiusProp.values().length];
            try {
                iArr[BorderRadiusProp.BORDER_RADIUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_TOP_LEFT_RADIUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_TOP_RIGHT_RADIUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_BOTTOM_LEFT_RADIUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_BOTTOM_RIGHT_RADIUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_TOP_START_RADIUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_TOP_END_RADIUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_BOTTOM_START_RADIUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_BOTTOM_END_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_START_START_RADIUS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_START_END_RADIUS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_END_START_RADIUS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BorderRadiusProp.BORDER_END_END_RADIUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderRadiusStyle)) {
            return false;
        }
        BorderRadiusStyle borderRadiusStyle = (BorderRadiusStyle) obj;
        return Intrinsics.areEqual(this.uniform, borderRadiusStyle.uniform) && Intrinsics.areEqual(this.topLeft, borderRadiusStyle.topLeft) && Intrinsics.areEqual(this.topRight, borderRadiusStyle.topRight) && Intrinsics.areEqual(this.bottomLeft, borderRadiusStyle.bottomLeft) && Intrinsics.areEqual(this.bottomRight, borderRadiusStyle.bottomRight) && Intrinsics.areEqual(this.topStart, borderRadiusStyle.topStart) && Intrinsics.areEqual(this.topEnd, borderRadiusStyle.topEnd) && Intrinsics.areEqual(this.bottomStart, borderRadiusStyle.bottomStart) && Intrinsics.areEqual(this.bottomEnd, borderRadiusStyle.bottomEnd) && Intrinsics.areEqual(this.startStart, borderRadiusStyle.startStart) && Intrinsics.areEqual(this.startEnd, borderRadiusStyle.startEnd) && Intrinsics.areEqual(this.endStart, borderRadiusStyle.endStart) && Intrinsics.areEqual(this.endEnd, borderRadiusStyle.endEnd);
    }

    public int hashCode() {
        LengthPercentage lengthPercentage = this.uniform;
        int iHashCode = (lengthPercentage == null ? 0 : lengthPercentage.hashCode()) * 31;
        LengthPercentage lengthPercentage2 = this.topLeft;
        int iHashCode2 = (iHashCode + (lengthPercentage2 == null ? 0 : lengthPercentage2.hashCode())) * 31;
        LengthPercentage lengthPercentage3 = this.topRight;
        int iHashCode3 = (iHashCode2 + (lengthPercentage3 == null ? 0 : lengthPercentage3.hashCode())) * 31;
        LengthPercentage lengthPercentage4 = this.bottomLeft;
        int iHashCode4 = (iHashCode3 + (lengthPercentage4 == null ? 0 : lengthPercentage4.hashCode())) * 31;
        LengthPercentage lengthPercentage5 = this.bottomRight;
        int iHashCode5 = (iHashCode4 + (lengthPercentage5 == null ? 0 : lengthPercentage5.hashCode())) * 31;
        LengthPercentage lengthPercentage6 = this.topStart;
        int iHashCode6 = (iHashCode5 + (lengthPercentage6 == null ? 0 : lengthPercentage6.hashCode())) * 31;
        LengthPercentage lengthPercentage7 = this.topEnd;
        int iHashCode7 = (iHashCode6 + (lengthPercentage7 == null ? 0 : lengthPercentage7.hashCode())) * 31;
        LengthPercentage lengthPercentage8 = this.bottomStart;
        int iHashCode8 = (iHashCode7 + (lengthPercentage8 == null ? 0 : lengthPercentage8.hashCode())) * 31;
        LengthPercentage lengthPercentage9 = this.bottomEnd;
        int iHashCode9 = (iHashCode8 + (lengthPercentage9 == null ? 0 : lengthPercentage9.hashCode())) * 31;
        LengthPercentage lengthPercentage10 = this.startStart;
        int iHashCode10 = (iHashCode9 + (lengthPercentage10 == null ? 0 : lengthPercentage10.hashCode())) * 31;
        LengthPercentage lengthPercentage11 = this.startEnd;
        int iHashCode11 = (iHashCode10 + (lengthPercentage11 == null ? 0 : lengthPercentage11.hashCode())) * 31;
        LengthPercentage lengthPercentage12 = this.endStart;
        int iHashCode12 = (iHashCode11 + (lengthPercentage12 == null ? 0 : lengthPercentage12.hashCode())) * 31;
        LengthPercentage lengthPercentage13 = this.endEnd;
        return iHashCode12 + (lengthPercentage13 != null ? lengthPercentage13.hashCode() : 0);
    }

    public String toString() {
        return "BorderRadiusStyle(uniform=" + this.uniform + ", topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ", topStart=" + this.topStart + ", topEnd=" + this.topEnd + ", bottomStart=" + this.bottomStart + ", bottomEnd=" + this.bottomEnd + ", startStart=" + this.startStart + ", startEnd=" + this.startEnd + ", endStart=" + this.endStart + ", endEnd=" + this.endEnd + ")";
    }

    public BorderRadiusStyle(LengthPercentage lengthPercentage, LengthPercentage lengthPercentage2, LengthPercentage lengthPercentage3, LengthPercentage lengthPercentage4, LengthPercentage lengthPercentage5, LengthPercentage lengthPercentage6, LengthPercentage lengthPercentage7, LengthPercentage lengthPercentage8, LengthPercentage lengthPercentage9, LengthPercentage lengthPercentage10, LengthPercentage lengthPercentage11, LengthPercentage lengthPercentage12, LengthPercentage lengthPercentage13) {
        this.uniform = lengthPercentage;
        this.topLeft = lengthPercentage2;
        this.topRight = lengthPercentage3;
        this.bottomLeft = lengthPercentage4;
        this.bottomRight = lengthPercentage5;
        this.topStart = lengthPercentage6;
        this.topEnd = lengthPercentage7;
        this.bottomStart = lengthPercentage8;
        this.bottomEnd = lengthPercentage9;
        this.startStart = lengthPercentage10;
        this.startEnd = lengthPercentage11;
        this.endStart = lengthPercentage12;
        this.endEnd = lengthPercentage13;
    }

    public /* synthetic */ BorderRadiusStyle(LengthPercentage lengthPercentage, LengthPercentage lengthPercentage2, LengthPercentage lengthPercentage3, LengthPercentage lengthPercentage4, LengthPercentage lengthPercentage5, LengthPercentage lengthPercentage6, LengthPercentage lengthPercentage7, LengthPercentage lengthPercentage8, LengthPercentage lengthPercentage9, LengthPercentage lengthPercentage10, LengthPercentage lengthPercentage11, LengthPercentage lengthPercentage12, LengthPercentage lengthPercentage13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lengthPercentage, (i & 2) != 0 ? null : lengthPercentage2, (i & 4) != 0 ? null : lengthPercentage3, (i & 8) != 0 ? null : lengthPercentage4, (i & 16) != 0 ? null : lengthPercentage5, (i & 32) != 0 ? null : lengthPercentage6, (i & 64) != 0 ? null : lengthPercentage7, (i & 128) != 0 ? null : lengthPercentage8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : lengthPercentage9, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : lengthPercentage10, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : lengthPercentage11, (i & 2048) != 0 ? null : lengthPercentage12, (i & 4096) != 0 ? null : lengthPercentage13);
    }

    public final void set(BorderRadiusProp property, LengthPercentage lengthPercentage) {
        Intrinsics.checkNotNullParameter(property, "property");
        switch (WhenMappings.$EnumSwitchMapping$0[property.ordinal()]) {
            case 1:
                this.uniform = lengthPercentage;
                return;
            case 2:
                this.topLeft = lengthPercentage;
                return;
            case 3:
                this.topRight = lengthPercentage;
                return;
            case 4:
                this.bottomLeft = lengthPercentage;
                return;
            case 5:
                this.bottomRight = lengthPercentage;
                return;
            case 6:
                this.topStart = lengthPercentage;
                return;
            case 7:
                this.topEnd = lengthPercentage;
                return;
            case 8:
                this.bottomStart = lengthPercentage;
                return;
            case 9:
                this.bottomEnd = lengthPercentage;
                return;
            case 10:
                this.startStart = lengthPercentage;
                return;
            case BaseVideoCapturer.RGBA /* 11 */:
                this.startEnd = lengthPercentage;
                return;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                this.endStart = lengthPercentage;
                return;
            case 13:
                this.endEnd = lengthPercentage;
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean hasRoundedBorders() {
        return (this.uniform == null && this.topLeft == null && this.topRight == null && this.bottomLeft == null && this.bottomRight == null && this.topStart == null && this.topEnd == null && this.bottomStart == null && this.bottomEnd == null && this.startStart == null && this.startEnd == null && this.endStart == null && this.endEnd == null) ? false : true;
    }

    public final ComputedBorderRadius resolve(int i, Context context, float f, float f2) {
        Intrinsics.checkNotNullParameter(context, "context");
        CornerRadii cornerRadii = new CornerRadii(0.0f, 0.0f);
        if (i == 0) {
            LengthPercentage lengthPercentage = this.startStart;
            if (lengthPercentage == null && (lengthPercentage = this.topStart) == null && (lengthPercentage = this.topLeft) == null) {
                lengthPercentage = this.uniform;
            }
            CornerRadii cornerRadii2 = lengthPercentage != null ? new CornerRadii(lengthPercentage, f, f2) : cornerRadii;
            LengthPercentage lengthPercentage2 = this.endStart;
            if (lengthPercentage2 == null && (lengthPercentage2 = this.topEnd) == null && (lengthPercentage2 = this.topRight) == null) {
                lengthPercentage2 = this.uniform;
            }
            CornerRadii cornerRadii3 = lengthPercentage2 != null ? new CornerRadii(lengthPercentage2, f, f2) : cornerRadii;
            LengthPercentage lengthPercentage3 = this.startEnd;
            if (lengthPercentage3 == null && (lengthPercentage3 = this.bottomStart) == null && (lengthPercentage3 = this.bottomLeft) == null) {
                lengthPercentage3 = this.uniform;
            }
            CornerRadii cornerRadii4 = lengthPercentage3 != null ? new CornerRadii(lengthPercentage3, f, f2) : cornerRadii;
            LengthPercentage lengthPercentage4 = this.endEnd;
            if (lengthPercentage4 == null && (lengthPercentage4 = this.bottomEnd) == null && (lengthPercentage4 = this.bottomRight) == null) {
                lengthPercentage4 = this.uniform;
            }
            if (lengthPercentage4 != null) {
                cornerRadii = new CornerRadii(lengthPercentage4, f, f2);
            }
            return ensureNoOverlap(cornerRadii2, cornerRadii3, cornerRadii4, cornerRadii, f, f2);
        }
        if (i == 1) {
            if (I18nUtil.Companion.getInstance().doLeftAndRightSwapInRTL(context)) {
                LengthPercentage lengthPercentage5 = this.endStart;
                if (lengthPercentage5 == null && (lengthPercentage5 = this.topEnd) == null && (lengthPercentage5 = this.topRight) == null) {
                    lengthPercentage5 = this.uniform;
                }
                CornerRadii cornerRadii5 = lengthPercentage5 != null ? new CornerRadii(lengthPercentage5, f, f2) : cornerRadii;
                LengthPercentage lengthPercentage6 = this.startStart;
                if (lengthPercentage6 == null && (lengthPercentage6 = this.topStart) == null && (lengthPercentage6 = this.topLeft) == null) {
                    lengthPercentage6 = this.uniform;
                }
                CornerRadii cornerRadii6 = lengthPercentage6 != null ? new CornerRadii(lengthPercentage6, f, f2) : cornerRadii;
                LengthPercentage lengthPercentage7 = this.endEnd;
                if (lengthPercentage7 == null && (lengthPercentage7 = this.bottomEnd) == null && (lengthPercentage7 = this.bottomRight) == null) {
                    lengthPercentage7 = this.uniform;
                }
                CornerRadii cornerRadii7 = lengthPercentage7 != null ? new CornerRadii(lengthPercentage7, f, f2) : cornerRadii;
                LengthPercentage lengthPercentage8 = this.startEnd;
                if (lengthPercentage8 == null && (lengthPercentage8 = this.bottomStart) == null && (lengthPercentage8 = this.bottomLeft) == null) {
                    lengthPercentage8 = this.uniform;
                }
                if (lengthPercentage8 != null) {
                    cornerRadii = new CornerRadii(lengthPercentage8, f, f2);
                }
                return ensureNoOverlap(cornerRadii5, cornerRadii6, cornerRadii7, cornerRadii, f, f2);
            }
            LengthPercentage lengthPercentage9 = this.endStart;
            if (lengthPercentage9 == null && (lengthPercentage9 = this.topEnd) == null && (lengthPercentage9 = this.topLeft) == null) {
                lengthPercentage9 = this.uniform;
            }
            CornerRadii cornerRadii8 = lengthPercentage9 != null ? new CornerRadii(lengthPercentage9, f, f2) : cornerRadii;
            LengthPercentage lengthPercentage10 = this.startStart;
            if (lengthPercentage10 == null && (lengthPercentage10 = this.topStart) == null && (lengthPercentage10 = this.topRight) == null) {
                lengthPercentage10 = this.uniform;
            }
            CornerRadii cornerRadii9 = lengthPercentage10 != null ? new CornerRadii(lengthPercentage10, f, f2) : cornerRadii;
            LengthPercentage lengthPercentage11 = this.endEnd;
            if (lengthPercentage11 == null && (lengthPercentage11 = this.bottomStart) == null && (lengthPercentage11 = this.bottomLeft) == null) {
                lengthPercentage11 = this.uniform;
            }
            CornerRadii cornerRadii10 = lengthPercentage11 != null ? new CornerRadii(lengthPercentage11, f, f2) : cornerRadii;
            LengthPercentage lengthPercentage12 = this.startEnd;
            if (lengthPercentage12 == null && (lengthPercentage12 = this.bottomEnd) == null && (lengthPercentage12 = this.bottomRight) == null) {
                lengthPercentage12 = this.uniform;
            }
            if (lengthPercentage12 != null) {
                cornerRadii = new CornerRadii(lengthPercentage12, f, f2);
            }
            return ensureNoOverlap(cornerRadii8, cornerRadii9, cornerRadii10, cornerRadii, f, f2);
        }
        throw new IllegalArgumentException("Expected?.resolved layout direction");
    }

    private final ComputedBorderRadius ensureNoOverlap(CornerRadii cornerRadii, CornerRadii cornerRadii2, CornerRadii cornerRadii3, CornerRadii cornerRadii4, float f, float f2) {
        float vertical = cornerRadii.getVertical() + cornerRadii3.getVertical();
        float horizontal = cornerRadii.getHorizontal() + cornerRadii2.getHorizontal();
        float vertical2 = cornerRadii2.getVertical() + cornerRadii4.getVertical();
        float horizontal2 = cornerRadii3.getHorizontal() + cornerRadii4.getHorizontal();
        float fMin = vertical > 0.0f ? Math.min(f2 / vertical, 1.0f) : 0.0f;
        float fMin2 = horizontal > 0.0f ? Math.min(f / horizontal, 1.0f) : 0.0f;
        float fMin3 = vertical2 > 0.0f ? Math.min(f2 / vertical2, 1.0f) : 0.0f;
        float fMin4 = horizontal2 > 0.0f ? Math.min(f / horizontal2, 1.0f) : 0.0f;
        return new ComputedBorderRadius(new CornerRadii(cornerRadii.getHorizontal() * Math.min(fMin2, fMin), cornerRadii.getVertical() * Math.min(fMin2, fMin)), new CornerRadii(cornerRadii2.getHorizontal() * Math.min(fMin3, fMin2), cornerRadii2.getVertical() * Math.min(fMin3, fMin2)), new CornerRadii(cornerRadii3.getHorizontal() * Math.min(fMin4, fMin), cornerRadii3.getVertical() * Math.min(fMin4, fMin)), new CornerRadii(cornerRadii4.getHorizontal() * Math.min(fMin4, fMin3), cornerRadii4.getVertical() * Math.min(fMin4, fMin3)));
    }
}
