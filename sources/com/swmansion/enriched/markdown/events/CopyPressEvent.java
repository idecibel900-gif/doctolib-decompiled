package com.swmansion.enriched.markdown.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
public final class CopyPressEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String code;
    private final String language;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CopyPressEvent(int i, int i2, String code, String language) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(language, "language");
        this.code = code;
        this.language = language;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onCopyPress";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(ResponseTypeValues.CODE, this.code);
        writableMapCreateMap.putString("language", this.language);
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
