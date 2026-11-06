package com.datadog.android.rum.internal.domain.accessibility;

import com.datadog.android.rum.internal.domain.InfoData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AccessibilityInfo implements InfoData {
    private final Boolean isClosedCaptioningEnabled;
    private final Boolean isColorInversionEnabled;
    private final Boolean isReducedAnimationsEnabled;
    private final Boolean isRtlEnabled;
    private final Boolean isScreenPinningEnabled;
    private final Boolean isScreenReaderEnabled;
    private final String textSize;

    public static /* synthetic */ AccessibilityInfo copy$default(AccessibilityInfo accessibilityInfo, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = accessibilityInfo.textSize;
        }
        if ((i & 2) != 0) {
            bool = accessibilityInfo.isScreenReaderEnabled;
        }
        if ((i & 4) != 0) {
            bool2 = accessibilityInfo.isColorInversionEnabled;
        }
        if ((i & 8) != 0) {
            bool3 = accessibilityInfo.isClosedCaptioningEnabled;
        }
        if ((i & 16) != 0) {
            bool4 = accessibilityInfo.isReducedAnimationsEnabled;
        }
        if ((i & 32) != 0) {
            bool5 = accessibilityInfo.isScreenPinningEnabled;
        }
        if ((i & 64) != 0) {
            bool6 = accessibilityInfo.isRtlEnabled;
        }
        Boolean bool7 = bool5;
        Boolean bool8 = bool6;
        Boolean bool9 = bool4;
        Boolean bool10 = bool2;
        return accessibilityInfo.copy(str, bool, bool10, bool3, bool9, bool7, bool8);
    }

    public final AccessibilityInfo copy(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6) {
        return new AccessibilityInfo(str, bool, bool2, bool3, bool4, bool5, bool6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityInfo)) {
            return false;
        }
        AccessibilityInfo accessibilityInfo = (AccessibilityInfo) obj;
        return Intrinsics.areEqual(this.textSize, accessibilityInfo.textSize) && Intrinsics.areEqual(this.isScreenReaderEnabled, accessibilityInfo.isScreenReaderEnabled) && Intrinsics.areEqual(this.isColorInversionEnabled, accessibilityInfo.isColorInversionEnabled) && Intrinsics.areEqual(this.isClosedCaptioningEnabled, accessibilityInfo.isClosedCaptioningEnabled) && Intrinsics.areEqual(this.isReducedAnimationsEnabled, accessibilityInfo.isReducedAnimationsEnabled) && Intrinsics.areEqual(this.isScreenPinningEnabled, accessibilityInfo.isScreenPinningEnabled) && Intrinsics.areEqual(this.isRtlEnabled, accessibilityInfo.isRtlEnabled);
    }

    public int hashCode() {
        String str = this.textSize;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isScreenReaderEnabled;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isColorInversionEnabled;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isClosedCaptioningEnabled;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isReducedAnimationsEnabled;
        int iHashCode5 = (iHashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isScreenPinningEnabled;
        int iHashCode6 = (iHashCode5 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.isRtlEnabled;
        return iHashCode6 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityInfo(textSize=" + this.textSize + ", isScreenReaderEnabled=" + this.isScreenReaderEnabled + ", isColorInversionEnabled=" + this.isColorInversionEnabled + ", isClosedCaptioningEnabled=" + this.isClosedCaptioningEnabled + ", isReducedAnimationsEnabled=" + this.isReducedAnimationsEnabled + ", isScreenPinningEnabled=" + this.isScreenPinningEnabled + ", isRtlEnabled=" + this.isRtlEnabled + ")";
    }

    public AccessibilityInfo(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6) {
        this.textSize = str;
        this.isScreenReaderEnabled = bool;
        this.isColorInversionEnabled = bool2;
        this.isClosedCaptioningEnabled = bool3;
        this.isReducedAnimationsEnabled = bool4;
        this.isScreenPinningEnabled = bool5;
        this.isRtlEnabled = bool6;
    }

    public /* synthetic */ AccessibilityInfo(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : bool5, (i & 64) != 0 ? null : bool6);
    }

    public final String getTextSize() {
        return this.textSize;
    }

    public final Boolean isScreenReaderEnabled() {
        return this.isScreenReaderEnabled;
    }

    public final Boolean isColorInversionEnabled() {
        return this.isColorInversionEnabled;
    }

    public final Boolean isClosedCaptioningEnabled() {
        return this.isClosedCaptioningEnabled;
    }

    public final Boolean isReducedAnimationsEnabled() {
        return this.isReducedAnimationsEnabled;
    }

    public final Boolean isScreenPinningEnabled() {
        return this.isScreenPinningEnabled;
    }

    public final Boolean isRtlEnabled() {
        return this.isRtlEnabled;
    }
}
