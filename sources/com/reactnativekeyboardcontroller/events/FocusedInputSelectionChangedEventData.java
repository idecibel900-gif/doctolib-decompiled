package com.reactnativekeyboardcontroller.events;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusedInputSelectionChangedEventData {
    private final int end;
    private final double endX;
    private final double endY;
    private final int start;
    private final double startX;
    private final double startY;
    private final int target;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FocusedInputSelectionChangedEventData)) {
            return false;
        }
        FocusedInputSelectionChangedEventData focusedInputSelectionChangedEventData = (FocusedInputSelectionChangedEventData) obj;
        return this.target == focusedInputSelectionChangedEventData.target && Double.compare(this.startX, focusedInputSelectionChangedEventData.startX) == 0 && Double.compare(this.startY, focusedInputSelectionChangedEventData.startY) == 0 && Double.compare(this.endX, focusedInputSelectionChangedEventData.endX) == 0 && Double.compare(this.endY, focusedInputSelectionChangedEventData.endY) == 0 && this.start == focusedInputSelectionChangedEventData.start && this.end == focusedInputSelectionChangedEventData.end;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.target) * 31) + Double.hashCode(this.startX)) * 31) + Double.hashCode(this.startY)) * 31) + Double.hashCode(this.endX)) * 31) + Double.hashCode(this.endY)) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end);
    }

    public String toString() {
        return "FocusedInputSelectionChangedEventData(target=" + this.target + ", startX=" + this.startX + ", startY=" + this.startY + ", endX=" + this.endX + ", endY=" + this.endY + ", start=" + this.start + ", end=" + this.end + ")";
    }

    public FocusedInputSelectionChangedEventData(int i, double d, double d2, double d3, double d4, int i2, int i3) {
        this.target = i;
        this.startX = d;
        this.startY = d2;
        this.endX = d3;
        this.endY = d4;
        this.start = i2;
        this.end = i3;
    }

    public final int getTarget() {
        return this.target;
    }

    public final double getStartX() {
        return this.startX;
    }

    public final double getStartY() {
        return this.startY;
    }

    public final double getEndX() {
        return this.endX;
    }

    public final double getEndY() {
        return this.endY;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }
}
