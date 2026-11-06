package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(float f) {
        super(null);
        this.mValue = f;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Integer.parseInt(content());
        }
        return (int) this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Float.parseFloat(content());
        }
        return this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            float f = getFloat();
            float f2 = ((CLNumber) obj).getFloat();
            if ((Float.isNaN(f) && Float.isNaN(f2)) || f == f2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        float f = this.mValue;
        return iHashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0);
    }
}
