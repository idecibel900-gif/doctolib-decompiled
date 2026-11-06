package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.google.firebase.messaging.Constants;
import com.horcrux.svg.events.SvgLoadEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageLoadEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String errorMessage;
    private final int eventType;
    private final int height;
    private final int loaded;
    private final String sourceUri;
    private final int total;
    private final int width;

    public /* synthetic */ ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, str, str2, i4, i5, i6, i7);
    }

    /* synthetic */ ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i8 & 8) != 0 ? null : str, (i8 & 16) != 0 ? null : str2, (i8 & 32) != 0 ? 0 : i4, (i8 & 64) != 0 ? 0 : i5, (i8 & 128) != 0 ? 0 : i6, (i8 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? 0 : i7);
    }

    private ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7) {
        super(i, i2);
        this.eventType = i3;
        this.errorMessage = str;
        this.sourceUri = str2;
        this.width = i4;
        this.height = i5;
        this.loaded = i6;
        this.total = i7;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return Companion.eventNameForType(this.eventType);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) this.eventType;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        int i = this.eventType;
        if (i == 1) {
            writableMapCreateMap.putString("error", this.errorMessage);
            return writableMapCreateMap;
        }
        if (i == 2) {
            writableMapCreateMap.putMap(Constants.ScionAnalytics.PARAM_SOURCE, createEventDataSource());
            return writableMapCreateMap;
        }
        if (i != 5) {
            return writableMapCreateMap;
        }
        writableMapCreateMap.putInt("loaded", this.loaded);
        writableMapCreateMap.putInt("total", this.total);
        writableMapCreateMap.putDouble(ReactProgressBarViewManager.PROP_PROGRESS, ((double) this.loaded) / ((double) this.total));
        return writableMapCreateMap;
    }

    private final WritableMap createEventDataSource() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("uri", this.sourceUri);
        writableMapCreateMap.putDouble("width", this.width);
        writableMapCreateMap.putDouble("height", this.height);
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageLoadEvent createLoadStartEvent(int i, int i2) {
            return new ImageLoadEvent(i, i2, 4, null, null, 0, 0, 0, 0, 504, null);
        }

        public final ImageLoadEvent createProgressEvent(int i, int i2, String str, int i3, int i4) {
            return new ImageLoadEvent(i, i2, 5, null, str, 0, 0, i3, i4, null);
        }

        public final ImageLoadEvent createLoadEvent(int i, int i2, String str, int i3, int i4) {
            return new ImageLoadEvent(i, i2, 2, null, str, i3, i4, 0, 0, null);
        }

        public final ImageLoadEvent createErrorEvent(int i, int i2, Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return new ImageLoadEvent(i, i2, 1, throwable.getMessage(), null, 0, 0, 0, 0, null);
        }

        public final ImageLoadEvent createLoadEndEvent(int i, int i2) {
            return new ImageLoadEvent(i, i2, 3, null, null, 0, 0, 0, 0, 504, null);
        }

        public final String eventNameForType(int i) {
            if (i == 1) {
                return "topError";
            }
            if (i == 2) {
                return SvgLoadEvent.EVENT_NAME;
            }
            if (i == 3) {
                return "topLoadEnd";
            }
            if (i == 4) {
                return "topLoadStart";
            }
            if (i == 5) {
                return "topProgress";
            }
            throw new IllegalStateException(("Invalid image event: " + i).toString());
        }
    }
}
