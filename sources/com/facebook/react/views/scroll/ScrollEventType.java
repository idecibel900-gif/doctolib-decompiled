package com.facebook.react.views.scroll;

import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum ScrollEventType {
    BEGIN_DRAG,
    END_DRAG,
    SCROLL,
    MOMENTUM_BEGIN,
    MOMENTUM_END;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static final String getJSEventName(ScrollEventType scrollEventType) {
        return Companion.getJSEventName(scrollEventType);
    }

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ScrollEventType.values().length];
                try {
                    iArr[ScrollEventType.BEGIN_DRAG.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ScrollEventType.END_DRAG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ScrollEventType.SCROLL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ScrollEventType.MOMENTUM_BEGIN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ScrollEventType.MOMENTUM_END.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getJSEventName(ScrollEventType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return "topScrollBeginDrag";
            }
            if (i == 2) {
                return "topScrollEndDrag";
            }
            if (i == 3) {
                return "topScroll";
            }
            if (i == 4) {
                return "topMomentumScrollBegin";
            }
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            return "topMomentumScrollEnd";
        }
    }
}
