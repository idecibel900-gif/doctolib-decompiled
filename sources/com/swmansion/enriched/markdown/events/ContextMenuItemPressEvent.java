package com.swmansion.enriched.markdown.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ContextMenuItemPressEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String itemText;
    private final String selectedText;
    private final int selectionEnd;
    private final int selectionStart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextMenuItemPressEvent(int i, int i2, String itemText, String selectedText, int i3, int i4) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        this.itemText = itemText;
        this.selectedText = selectedText;
        this.selectionStart = i3;
        this.selectionEnd = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onContextMenuItemPress";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("itemText", this.itemText);
        writableMapCreateMap.putString("selectedText", this.selectedText);
        writableMapCreateMap.putInt("selectionStart", this.selectionStart);
        writableMapCreateMap.putInt("selectionEnd", this.selectionEnd);
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
