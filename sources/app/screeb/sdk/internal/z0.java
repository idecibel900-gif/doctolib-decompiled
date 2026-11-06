package app.screeb.sdk.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z0 {
    public static final ArrayList a = new ArrayList(64);
    public static final ArrayList b = new ArrayList(64);

    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d3  */
    public static List a(ArrayList tiles) {
        Intrinsics.checkNotNullParameter(tiles, "tiles");
        if (tiles.size() > 1) {
            ArrayList arrayList = a;
            arrayList.clear();
            C0312l c0312l = (C0312l) tiles.get(0);
            int size = tiles.size();
            C0312l c0312lA = c0312l;
            for (int i = 1; i < size; i++) {
                C0312l c0312l2 = (C0312l) tiles.get(i);
                if (c0312l2.i == c0312lA.i && c0312l2.g == c0312lA.h + 1 && c0312l2.b == c0312lA.b && c0312l2.d == c0312lA.d && c0312l2.f == c0312lA.f) {
                    int i2 = c0312l2.a;
                    int i3 = c0312lA.a;
                    int i4 = c0312lA.e;
                    if (i2 == i3 + i4 && c0312l2.c == c0312lA.c + i4) {
                        c0312lA = C0312l.a(c0312lA, i4 + c0312l2.e, 0, c0312l2.h, 0, 1903);
                    } else {
                        arrayList.add(c0312lA);
                        c0312lA = c0312l2;
                    }
                } else {
                    arrayList.add(c0312lA);
                    c0312lA = c0312l2;
                }
            }
            arrayList.add(c0312lA);
            tiles = arrayList;
        }
        if (tiles.size() <= 1) {
            return tiles;
        }
        ArrayList arrayList2 = b;
        arrayList2.clear();
        C0312l c0312l3 = (C0312l) tiles.get(0);
        int size2 = tiles.size();
        C0312l c0312lA2 = c0312l3;
        for (int i5 = 1; i5 < size2; i5++) {
            C0312l c0312l4 = (C0312l) tiles.get(i5);
            if (c0312l4.g == c0312lA2.g && c0312l4.h == c0312lA2.h && c0312l4.i == c0312lA2.j + 1 && c0312l4.a == c0312lA2.a && c0312l4.c == c0312lA2.c && c0312l4.e == c0312lA2.e) {
                int i6 = c0312l4.b;
                int i7 = c0312lA2.b;
                int i8 = c0312lA2.f;
                if (i6 == i7 + i8 && c0312l4.d == c0312lA2.d + i8) {
                    c0312lA2 = C0312l.a(c0312lA2, 0, c0312l4.f + i8, 0, c0312l4.j, 1503);
                } else {
                    arrayList2.add(c0312lA2);
                    c0312lA2 = c0312l4;
                }
            } else {
                arrayList2.add(c0312lA2);
                c0312lA2 = c0312l4;
            }
        }
        arrayList2.add(c0312lA2);
        return arrayList2;
    }
}
