package com.reactnativekeyboardcontroller.listeners;

/* JADX INFO: loaded from: classes4.dex */
public final class Dimensions {
    private final double height;
    private final double width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dimensions)) {
            return false;
        }
        Dimensions dimensions = (Dimensions) obj;
        return Double.compare(this.width, dimensions.width) == 0 && Double.compare(this.height, dimensions.height) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this.width) * 31) + Double.hashCode(this.height);
    }

    public String toString() {
        return "Dimensions(width=" + this.width + ", height=" + this.height + ")";
    }

    public Dimensions(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getHeight() {
        return this.height;
    }
}
