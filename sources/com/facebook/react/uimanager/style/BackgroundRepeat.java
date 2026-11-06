package com.facebook.react.uimanager.style;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundRepeat {
    public static final Companion Companion = new Companion(null);
    private final BackgroundRepeatKeyword x;
    private final BackgroundRepeatKeyword y;

    public BackgroundRepeat(BackgroundRepeatKeyword x, BackgroundRepeatKeyword y) {
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        this.x = x;
        this.y = y;
    }

    public final BackgroundRepeatKeyword getX() {
        return this.x;
    }

    public final BackgroundRepeatKeyword getY() {
        return this.y;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BackgroundRepeat parse(ReadableMap readableMap) {
            if (readableMap == null) {
                return null;
            }
            BackgroundRepeatKeyword repeatStyle = parseRepeatStyle(readableMap, "x");
            if (repeatStyle == null) {
                repeatStyle = BackgroundRepeatKeyword.Repeat;
            }
            BackgroundRepeatKeyword repeatStyle2 = parseRepeatStyle(readableMap, "y");
            if (repeatStyle2 == null) {
                repeatStyle2 = BackgroundRepeatKeyword.Repeat;
            }
            return new BackgroundRepeat(repeatStyle, repeatStyle2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private final BackgroundRepeatKeyword parseRepeatStyle(ReadableMap readableMap, String str) {
            String string;
            if (readableMap.hasKey(str) && readableMap.getType(str) == ReadableType.String && (string = readableMap.getString(str)) != null) {
                switch (string.hashCode()) {
                    case -934531685:
                        if (string.equals("repeat")) {
                            return BackgroundRepeatKeyword.Repeat;
                        }
                        break;
                    case -724648153:
                        if (string.equals("no-repeat")) {
                            return BackgroundRepeatKeyword.NoRepeat;
                        }
                        break;
                    case 108704142:
                        if (string.equals("round")) {
                            return BackgroundRepeatKeyword.Round;
                        }
                        break;
                    case 109637894:
                        if (string.equals("space")) {
                            return BackgroundRepeatKeyword.Space;
                        }
                        break;
                }
            }
            return null;
        }
    }
}
