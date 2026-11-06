package com.facebook.react.uimanager.style;

import com.opentok.android.BaseVideoCapturer;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public enum LogicalEdge {
    ALL { // from class: com.facebook.react.uimanager.style.LogicalEdge.ALL
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 8;
        }
    },
    LEFT { // from class: com.facebook.react.uimanager.style.LogicalEdge.LEFT
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 0;
        }
    },
    RIGHT { // from class: com.facebook.react.uimanager.style.LogicalEdge.RIGHT
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 2;
        }
    },
    TOP { // from class: com.facebook.react.uimanager.style.LogicalEdge.TOP
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 1;
        }
    },
    BOTTOM { // from class: com.facebook.react.uimanager.style.LogicalEdge.BOTTOM
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 3;
        }
    },
    START { // from class: com.facebook.react.uimanager.style.LogicalEdge.START
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 4;
        }
    },
    END { // from class: com.facebook.react.uimanager.style.LogicalEdge.END
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 5;
        }
    },
    HORIZONTAL { // from class: com.facebook.react.uimanager.style.LogicalEdge.HORIZONTAL
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 6;
        }
    },
    VERTICAL { // from class: com.facebook.react.uimanager.style.LogicalEdge.VERTICAL
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 7;
        }
    },
    BLOCK_START { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK_START
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 11;
        }
    },
    BLOCK_END { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK_END
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 10;
        }
    },
    BLOCK { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 9;
        }
    };

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    /* synthetic */ LogicalEdge(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public abstract int toSpacingType();

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LogicalEdge fromSpacingType(int i) {
            switch (i) {
                case 0:
                    return LogicalEdge.LEFT;
                case 1:
                    return LogicalEdge.TOP;
                case 2:
                    return LogicalEdge.RIGHT;
                case 3:
                    return LogicalEdge.BOTTOM;
                case 4:
                    return LogicalEdge.START;
                case 5:
                    return LogicalEdge.END;
                case 6:
                    return LogicalEdge.HORIZONTAL;
                case 7:
                    return LogicalEdge.VERTICAL;
                case 8:
                    return LogicalEdge.ALL;
                case 9:
                    return LogicalEdge.BLOCK;
                case 10:
                    return LogicalEdge.BLOCK_END;
                case BaseVideoCapturer.RGBA /* 11 */:
                    return LogicalEdge.BLOCK_START;
                default:
                    throw new IllegalArgumentException("Unknown spacing type: " + i);
            }
        }
    }
}
