package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InsetsChangeEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final Rect mFrame;
    private final EdgeInsets mInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsetsChangeEvent(int i, int i2, EdgeInsets mInsets, Rect mFrame) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(mInsets, "mInsets");
        Intrinsics.checkNotNullParameter(mFrame, "mFrame");
        this.mInsets = mInsets;
        this.mFrame = mFrame;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topInsetsChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("insets", SerializationUtilsKt.edgeInsetsToJsMap(this.mInsets));
        writableMapCreateMap.putMap("frame", SerializationUtilsKt.rectToJsMap(this.mFrame));
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
