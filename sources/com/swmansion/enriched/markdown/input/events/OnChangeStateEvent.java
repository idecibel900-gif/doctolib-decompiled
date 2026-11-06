package com.swmansion.enriched.markdown.input.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class OnChangeStateEvent extends Event {
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
    private final int orderedListDepth;
    private final int unorderedListDepth;

    public OnChangeStateEvent(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, boolean z7, int i4, boolean z8, int i5) {
        super(i, i2);
        this.isBold = z;
        this.isItalic = z2;
        this.isUnderline = z3;
        this.isStrikethrough = z4;
        this.isSpoiler = z5;
        this.isLink = z6;
        this.headingLevel = i3;
        this.isUnorderedList = z7;
        this.unorderedListDepth = i4;
        this.isOrderedList = z8;
        this.orderedListDepth = i5;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onChangeState";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putBoolean("isActive", this.isBold);
        Unit unit = Unit.INSTANCE;
        writableMapCreateMap.putMap("bold", writableMapCreateMap2);
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putBoolean("isActive", this.isItalic);
        writableMapCreateMap.putMap("italic", writableMapCreateMap3);
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putBoolean("isActive", this.isUnderline);
        writableMapCreateMap.putMap("underline", writableMapCreateMap4);
        WritableMap writableMapCreateMap5 = Arguments.createMap();
        writableMapCreateMap5.putBoolean("isActive", this.isStrikethrough);
        writableMapCreateMap.putMap("strikethrough", writableMapCreateMap5);
        WritableMap writableMapCreateMap6 = Arguments.createMap();
        writableMapCreateMap6.putBoolean("isActive", this.isSpoiler);
        writableMapCreateMap.putMap("spoiler", writableMapCreateMap6);
        WritableMap writableMapCreateMap7 = Arguments.createMap();
        writableMapCreateMap7.putBoolean("isActive", this.isLink);
        writableMapCreateMap.putMap("link", writableMapCreateMap7);
        WritableMap writableMapCreateMap8 = Arguments.createMap();
        writableMapCreateMap8.putBoolean("isActive", this.headingLevel > 0);
        writableMapCreateMap8.putInt("level", this.headingLevel);
        writableMapCreateMap.putMap("heading", writableMapCreateMap8);
        WritableMap writableMapCreateMap9 = Arguments.createMap();
        writableMapCreateMap9.putBoolean("isActive", this.isUnorderedList);
        writableMapCreateMap9.putInt("depth", this.unorderedListDepth);
        writableMapCreateMap.putMap("unorderedList", writableMapCreateMap9);
        WritableMap writableMapCreateMap10 = Arguments.createMap();
        writableMapCreateMap10.putBoolean("isActive", this.isOrderedList);
        writableMapCreateMap10.putInt("depth", this.orderedListDepth);
        writableMapCreateMap.putMap("orderedList", writableMapCreateMap10);
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
