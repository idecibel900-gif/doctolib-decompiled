package com.datadog.android.rum.internal.domain.accessibility;

import com.datadog.android.rum.internal.domain.InfoProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAccessibilitySnapshotManager implements AccessibilitySnapshotManager {
    private final InfoProvider accessibilityReader;
    private volatile AccessibilityInfo lastSnapshot;

    public DefaultAccessibilitySnapshotManager(InfoProvider accessibilityReader) {
        Intrinsics.checkNotNullParameter(accessibilityReader, "accessibilityReader");
        this.accessibilityReader = accessibilityReader;
    }

    @Override // com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager
    public synchronized AccessibilityInfo getIfChanged() {
        AccessibilityInfo accessibilityInfo = (AccessibilityInfo) this.accessibilityReader.getState();
        if (Intrinsics.areEqual(accessibilityInfo, this.lastSnapshot)) {
            return null;
        }
        AccessibilityInfo accessibilityInfoCreateDelta = createDelta(accessibilityInfo, this.lastSnapshot);
        this.lastSnapshot = accessibilityInfo;
        return hasAnyNonNullValues(accessibilityInfoCreateDelta) ? accessibilityInfoCreateDelta : null;
    }

    private final AccessibilityInfo createDelta(AccessibilityInfo accessibilityInfo, AccessibilityInfo accessibilityInfo2) {
        String textSize = accessibilityInfo.getTextSize();
        String str = !Intrinsics.areEqual(textSize, accessibilityInfo2 != null ? accessibilityInfo2.getTextSize() : null) ? textSize : null;
        Boolean boolIsScreenReaderEnabled = accessibilityInfo.isScreenReaderEnabled();
        Boolean bool = !Intrinsics.areEqual(boolIsScreenReaderEnabled, accessibilityInfo2 != null ? accessibilityInfo2.isScreenReaderEnabled() : null) ? boolIsScreenReaderEnabled : null;
        Boolean boolIsColorInversionEnabled = accessibilityInfo.isColorInversionEnabled();
        Boolean bool2 = !Intrinsics.areEqual(boolIsColorInversionEnabled, accessibilityInfo2 != null ? accessibilityInfo2.isColorInversionEnabled() : null) ? boolIsColorInversionEnabled : null;
        Boolean boolIsClosedCaptioningEnabled = accessibilityInfo.isClosedCaptioningEnabled();
        Boolean bool3 = !Intrinsics.areEqual(boolIsClosedCaptioningEnabled, accessibilityInfo2 != null ? accessibilityInfo2.isClosedCaptioningEnabled() : null) ? boolIsClosedCaptioningEnabled : null;
        Boolean boolIsReducedAnimationsEnabled = accessibilityInfo.isReducedAnimationsEnabled();
        Boolean bool4 = !Intrinsics.areEqual(boolIsReducedAnimationsEnabled, accessibilityInfo2 != null ? accessibilityInfo2.isReducedAnimationsEnabled() : null) ? boolIsReducedAnimationsEnabled : null;
        Boolean boolIsScreenPinningEnabled = accessibilityInfo.isScreenPinningEnabled();
        Boolean bool5 = !Intrinsics.areEqual(boolIsScreenPinningEnabled, accessibilityInfo2 != null ? accessibilityInfo2.isScreenPinningEnabled() : null) ? boolIsScreenPinningEnabled : null;
        Boolean boolIsRtlEnabled = accessibilityInfo.isRtlEnabled();
        return new AccessibilityInfo(str, bool, bool2, bool3, bool4, bool5, !Intrinsics.areEqual(boolIsRtlEnabled, accessibilityInfo2 != null ? accessibilityInfo2.isRtlEnabled() : null) ? boolIsRtlEnabled : null);
    }

    private final boolean hasAnyNonNullValues(AccessibilityInfo accessibilityInfo) {
        Set of = SetsKt.setOf(accessibilityInfo.getTextSize(), accessibilityInfo.isScreenReaderEnabled(), accessibilityInfo.isRtlEnabled(), accessibilityInfo.isScreenPinningEnabled(), accessibilityInfo.isColorInversionEnabled(), accessibilityInfo.isClosedCaptioningEnabled(), accessibilityInfo.isReducedAnimationsEnabled());
        if ((of instanceof Collection) && of.isEmpty()) {
            return false;
        }
        Iterator it = of.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                return true;
            }
        }
        return false;
    }
}
