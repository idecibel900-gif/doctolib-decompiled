package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskListStyle {
    public static final Companion Companion = new Companion(null);
    private final int borderColor;
    private final float checkboxBorderRadius;
    private final float checkboxSize;
    private final int checkedColor;
    private final boolean checkedStrikethrough;
    private final int checkedTextColor;
    private final int checkmarkColor;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskListStyle)) {
            return false;
        }
        TaskListStyle taskListStyle = (TaskListStyle) obj;
        return this.checkedColor == taskListStyle.checkedColor && this.borderColor == taskListStyle.borderColor && Float.compare(this.checkboxSize, taskListStyle.checkboxSize) == 0 && Float.compare(this.checkboxBorderRadius, taskListStyle.checkboxBorderRadius) == 0 && this.checkmarkColor == taskListStyle.checkmarkColor && this.checkedTextColor == taskListStyle.checkedTextColor && this.checkedStrikethrough == taskListStyle.checkedStrikethrough;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.checkedColor) * 31) + Integer.hashCode(this.borderColor)) * 31) + Float.hashCode(this.checkboxSize)) * 31) + Float.hashCode(this.checkboxBorderRadius)) * 31) + Integer.hashCode(this.checkmarkColor)) * 31) + Integer.hashCode(this.checkedTextColor)) * 31) + Boolean.hashCode(this.checkedStrikethrough);
    }

    public String toString() {
        return "TaskListStyle(checkedColor=" + this.checkedColor + ", borderColor=" + this.borderColor + ", checkboxSize=" + this.checkboxSize + ", checkboxBorderRadius=" + this.checkboxBorderRadius + ", checkmarkColor=" + this.checkmarkColor + ", checkedTextColor=" + this.checkedTextColor + ", checkedStrikethrough=" + this.checkedStrikethrough + ")";
    }

    public TaskListStyle(int i, int i2, float f, float f2, int i3, int i4, boolean z) {
        this.checkedColor = i;
        this.borderColor = i2;
        this.checkboxSize = f;
        this.checkboxBorderRadius = f2;
        this.checkmarkColor = i3;
        this.checkedTextColor = i4;
        this.checkedStrikethrough = z;
    }

    public final int getCheckedColor() {
        return this.checkedColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final float getCheckboxSize() {
        return this.checkboxSize;
    }

    public final float getCheckboxBorderRadius() {
        return this.checkboxBorderRadius;
    }

    public final int getCheckmarkColor() {
        return this.checkmarkColor;
    }

    public final int getCheckedTextColor() {
        return this.checkedTextColor;
    }

    public final boolean getCheckedStrikethrough() {
        return this.checkedStrikethrough;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TaskListStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new TaskListStyle(parser.parseColor(map, "checkedColor"), parser.parseColor(map, "borderColor"), parser.toPixelFromDIP((float) map.getDouble("checkboxSize")), parser.toPixelFromDIP((float) map.getDouble("checkboxBorderRadius")), parser.parseColor(map, "checkmarkColor"), parser.parseColor(map, "checkedTextColor"), map.getBoolean("checkedStrikethrough"));
        }
    }
}
