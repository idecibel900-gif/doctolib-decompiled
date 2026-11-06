package com.facebook.react.uimanager;

import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import java.util.Comparator;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewAtIndex {
    public final int mIndex;
    public final int mTag;
    public static final Companion Companion = new Companion(null);
    public static Comparator COMPARATOR = new Comparator() { // from class: com.facebook.react.uimanager.ViewAtIndex$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ViewAtIndex.COMPARATOR$lambda$0((ViewAtIndex) obj, (ViewAtIndex) obj2);
        }
    };

    public ViewAtIndex(int i, int i2) {
        this.mTag = i;
        this.mIndex = i2;
    }

    public boolean equals(Object obj) {
        if (obj != null && Intrinsics.areEqual(obj.getClass(), ViewAtIndex.class)) {
            ViewAtIndex viewAtIndex = (ViewAtIndex) obj;
            if (this.mIndex == viewAtIndex.mIndex && this.mTag == viewAtIndex.mTag) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mTag), Integer.valueOf(this.mIndex));
    }

    public String toString() {
        return "[" + this.mTag + ", " + this.mIndex + "]";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("ViewAtIndex", LegacyArchitectureLogLevel.ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int COMPARATOR$lambda$0(ViewAtIndex viewAtIndex, ViewAtIndex viewAtIndex2) {
        return viewAtIndex.mIndex - viewAtIndex2.mIndex;
    }
}
