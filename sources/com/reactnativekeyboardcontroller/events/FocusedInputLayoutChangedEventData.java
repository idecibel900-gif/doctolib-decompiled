package com.reactnativekeyboardcontroller.events;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusedInputLayoutChangedEventData {
    private final double absoluteX;
    private final double absoluteY;
    private final double height;
    private final int parentScrollViewTarget;
    private final int target;
    private final double width;
    private final double x;
    private final double y;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FocusedInputLayoutChangedEventData)) {
            return false;
        }
        FocusedInputLayoutChangedEventData focusedInputLayoutChangedEventData = (FocusedInputLayoutChangedEventData) obj;
        return Double.compare(this.x, focusedInputLayoutChangedEventData.x) == 0 && Double.compare(this.y, focusedInputLayoutChangedEventData.y) == 0 && Double.compare(this.width, focusedInputLayoutChangedEventData.width) == 0 && Double.compare(this.height, focusedInputLayoutChangedEventData.height) == 0 && Double.compare(this.absoluteX, focusedInputLayoutChangedEventData.absoluteX) == 0 && Double.compare(this.absoluteY, focusedInputLayoutChangedEventData.absoluteY) == 0 && this.target == focusedInputLayoutChangedEventData.target && this.parentScrollViewTarget == focusedInputLayoutChangedEventData.parentScrollViewTarget;
    }

    public int hashCode() {
        return (((((((((((((Double.hashCode(this.x) * 31) + Double.hashCode(this.y)) * 31) + Double.hashCode(this.width)) * 31) + Double.hashCode(this.height)) * 31) + Double.hashCode(this.absoluteX)) * 31) + Double.hashCode(this.absoluteY)) * 31) + Integer.hashCode(this.target)) * 31) + Integer.hashCode(this.parentScrollViewTarget);
    }

    public String toString() {
        return "FocusedInputLayoutChangedEventData(x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", absoluteX=" + this.absoluteX + ", absoluteY=" + this.absoluteY + ", target=" + this.target + ", parentScrollViewTarget=" + this.parentScrollViewTarget + ")";
    }

    public FocusedInputLayoutChangedEventData(double d, double d2, double d3, double d4, double d5, double d6, int i, int i2) {
        this.x = d;
        this.y = d2;
        this.width = d3;
        this.height = d4;
        this.absoluteX = d5;
        this.absoluteY = d6;
        this.target = i;
        this.parentScrollViewTarget = i2;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getAbsoluteX() {
        return this.absoluteX;
    }

    public final double getAbsoluteY() {
        return this.absoluteY;
    }

    public final int getTarget() {
        return this.target;
    }

    public final int getParentScrollViewTarget() {
        return this.parentScrollViewTarget;
    }
}
