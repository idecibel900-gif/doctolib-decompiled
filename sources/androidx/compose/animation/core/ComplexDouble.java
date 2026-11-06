package androidx.compose.animation.core;

/* JADX INFO: loaded from: classes.dex */
public final class ComplexDouble {
    private double _imaginary;
    private double _real;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplexDouble)) {
            return false;
        }
        ComplexDouble complexDouble = (ComplexDouble) obj;
        return Double.compare(this._real, complexDouble._real) == 0 && Double.compare(this._imaginary, complexDouble._imaginary) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this._real) * 31) + Double.hashCode(this._imaginary);
    }

    public String toString() {
        return "ComplexDouble(_real=" + this._real + ", _imaginary=" + this._imaginary + ')';
    }

    public ComplexDouble(double d, double d2) {
        this._real = d;
        this._imaginary = d2;
    }

    public final double getReal() {
        return this._real;
    }

    public final double getImaginary() {
        return this._imaginary;
    }
}
