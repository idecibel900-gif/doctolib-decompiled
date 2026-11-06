package com.reactnativekeyboardcontroller.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardTransitionEvent extends Event {
    private final int duration;
    private final Companion.EventName event;
    private final double height;
    private final double progress;
    private final int target;
    public static final Companion Companion = new Companion(null);
    private static final Companion.EventName Move = Companion.EventName.Move;
    private static final Companion.EventName Start = Companion.EventName.Start;
    private static final Companion.EventName End = Companion.EventName.End;
    private static final Companion.EventName Interactive = Companion.EventName.Interactive;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardTransitionEvent(int i, int i2, Companion.EventName event, double d, double d2, int i3, int i4) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
        this.height = d;
        this.progress = d2;
        this.duration = i3;
        this.target = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return this.event.getValue();
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(ReactProgressBarViewManager.PROP_PROGRESS, this.progress);
        writableMapCreateMap.putDouble("height", this.height);
        writableMapCreateMap.putInt("duration", this.duration);
        writableMapCreateMap.putInt("target", this.target);
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public enum EventName {
            Move("topKeyboardMove"),
            Start("topKeyboardMoveStart"),
            End("topKeyboardMoveEnd"),
            Interactive("topKeyboardMoveInteractive");

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
            private final String value;

            EventName(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }
        }

        private Companion() {
        }

        public final EventName getMove() {
            return KeyboardTransitionEvent.Move;
        }

        public final EventName getStart() {
            return KeyboardTransitionEvent.Start;
        }

        public final EventName getEnd() {
            return KeyboardTransitionEvent.End;
        }

        public final EventName getInteractive() {
            return KeyboardTransitionEvent.Interactive;
        }
    }
}
