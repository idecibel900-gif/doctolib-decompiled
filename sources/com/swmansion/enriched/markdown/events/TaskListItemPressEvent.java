package com.swmansion.enriched.markdown.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskListItemPressEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final boolean checked;
    private final String itemText;
    private final int taskIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskListItemPressEvent(int i, int i2, int i3, boolean z, String itemText) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        this.taskIndex = i3;
        this.checked = z;
        this.itemText = itemText;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onTaskListItemPress";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("index", this.taskIndex);
        writableMapCreateMap.putBoolean("checked", this.checked);
        writableMapCreateMap.putString("text", this.itemText);
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
