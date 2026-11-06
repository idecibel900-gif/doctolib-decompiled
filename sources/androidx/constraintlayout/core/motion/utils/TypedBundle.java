package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class TypedBundle {
    int[] mTypeInt = new int[10];
    int[] mValueInt = new int[10];
    int mCountInt = 0;
    int[] mTypeFloat = new int[10];
    float[] mValueFloat = new float[10];
    int mCountFloat = 0;
    int[] mTypeString = new int[5];
    String[] mValueString = new String[5];
    int mCountString = 0;
    int[] mTypeBoolean = new int[4];
    boolean[] mValueBoolean = new boolean[4];
    int mCountBoolean = 0;

    public void add(int i, int i2) {
        int i3 = this.mCountInt;
        int[] iArr = this.mTypeInt;
        if (i3 >= iArr.length) {
            this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.mValueInt;
            this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.mTypeInt;
        int i4 = this.mCountInt;
        iArr3[i4] = i;
        int[] iArr4 = this.mValueInt;
        this.mCountInt = i4 + 1;
        iArr4[i4] = i2;
    }

    public void add(int i, float f) {
        int i2 = this.mCountFloat;
        int[] iArr = this.mTypeFloat;
        if (i2 >= iArr.length) {
            this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValueFloat;
            this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTypeFloat;
        int i3 = this.mCountFloat;
        iArr2[i3] = i;
        float[] fArr2 = this.mValueFloat;
        this.mCountFloat = i3 + 1;
        fArr2[i3] = f;
    }

    public void add(int i, String str) {
        int i2 = this.mCountString;
        int[] iArr = this.mTypeString;
        if (i2 >= iArr.length) {
            this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.mValueString;
            this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.mTypeString;
        int i3 = this.mCountString;
        iArr2[i3] = i;
        String[] strArr2 = this.mValueString;
        this.mCountString = i3 + 1;
        strArr2[i3] = str;
    }

    public String toString() {
        return "TypedBundle{mCountInt=" + this.mCountInt + ", mCountFloat=" + this.mCountFloat + ", mCountString=" + this.mCountString + ", mCountBoolean=" + this.mCountBoolean + '}';
    }
}
