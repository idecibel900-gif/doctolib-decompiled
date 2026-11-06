package com.swmansion.enriched.markdown.input.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OnContextMenuItemPressEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final int headingLevel;
    private final boolean isBold;
    private final boolean isItalic;
    private final boolean isLink;
    private final boolean isOrderedList;
    private final boolean isSpoiler;
    private final boolean isStrikethrough;
    private final boolean isUnderline;
    private final boolean isUnorderedList;
    private final String itemText;
    private final int orderedListDepth;
    private final String selectedText;
    private final int selectionEnd;
    private final int selectionStart;
    private final int unorderedListDepth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnContextMenuItemPressEvent(int i, int i2, String itemText, String selectedText, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i5, boolean z7, int i6, boolean z8, int i7) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        this.itemText = itemText;
        this.selectedText = selectedText;
        this.selectionStart = i3;
        this.selectionEnd = i4;
        this.isBold = z;
        this.isItalic = z2;
        this.isUnderline = z3;
        this.isStrikethrough = z4;
        this.isSpoiler = z5;
        this.isLink = z6;
        this.headingLevel = i5;
        this.isUnorderedList = z7;
        this.unorderedListDepth = i6;
        this.isOrderedList = z8;
        this.orderedListDepth = i7;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onContextMenuItemPress";
    }

    private static final WritableMap getEventData$styleEntry(boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("isActive", z);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("itemText", this.itemText);
        writableMapCreateMap.putString("selectedText", this.selectedText);
        writableMapCreateMap.putInt("selectionStart", this.selectionStart);
        writableMapCreateMap.putInt("selectionEnd", this.selectionEnd);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap("bold", getEventData$styleEntry(this.isBold));
        writableMapCreateMap2.putMap("italic", getEventData$styleEntry(this.isItalic));
        writableMapCreateMap2.putMap("underline", getEventData$styleEntry(this.isUnderline));
        writableMapCreateMap2.putMap("strikethrough", getEventData$styleEntry(this.isStrikethrough));
        writableMapCreateMap2.putMap("spoiler", getEventData$styleEntry(this.isSpoiler));
        writableMapCreateMap2.putMap("link", getEventData$styleEntry(this.isLink));
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putBoolean("isActive", this.headingLevel > 0);
        writableMapCreateMap3.putInt("level", this.headingLevel);
        Unit unit = Unit.INSTANCE;
        writableMapCreateMap2.putMap("heading", writableMapCreateMap3);
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putBoolean("isActive", this.isUnorderedList);
        writableMapCreateMap4.putInt("depth", this.unorderedListDepth);
        writableMapCreateMap2.putMap("unorderedList", writableMapCreateMap4);
        WritableMap writableMapCreateMap5 = Arguments.createMap();
        writableMapCreateMap5.putBoolean("isActive", this.isOrderedList);
        writableMapCreateMap5.putInt("depth", this.orderedListDepth);
        writableMapCreateMap2.putMap("orderedList", writableMapCreateMap5);
        writableMapCreateMap.putMap("styleState", writableMapCreateMap2);
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
