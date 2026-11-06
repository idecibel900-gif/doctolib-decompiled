package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FontMatcher {
    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List m2280matchFontRetOiIg(List list, FontWeight fontWeight, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            Font font = (Font) obj;
            if (Intrinsics.areEqual(font.getWeight(), fontWeight) && FontStyle.m2284equalsimpl0(font.mo2254getStyle_LCdwA(), i)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Object obj2 = list.get(i4);
            if (FontStyle.m2284equalsimpl0(((Font) obj2).mo2254getStyle_LCdwA(), i)) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            list = arrayList2;
        }
        List list2 = list;
        FontWeight.Companion companion = FontWeight.Companion;
        FontWeight fontWeight2 = null;
        if (fontWeight.compareTo(companion.getW400()) < 0) {
            int size3 = list2.size();
            FontWeight fontWeight3 = null;
            for (int i5 = 0; i5 < size3; i5++) {
                FontWeight weight = ((Font) list2.get(i5)).getWeight();
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight3 = weight;
                        fontWeight2 = fontWeight3;
                        break;
                    }
                    if (fontWeight3 == null || weight.compareTo(fontWeight3) < 0) {
                        fontWeight3 = weight;
                    }
                } else if (fontWeight2 == null || weight.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight;
                }
            }
            if (fontWeight2 != null) {
                fontWeight3 = fontWeight2;
            }
            ArrayList arrayList3 = new ArrayList(list2.size());
            int size4 = list2.size();
            while (i2 < size4) {
                Object obj3 = list2.get(i2);
                if (Intrinsics.areEqual(((Font) obj3).getWeight(), fontWeight3)) {
                    arrayList3.add(obj3);
                }
                i2++;
            }
            return arrayList3;
        }
        if (fontWeight.compareTo(companion.getW500()) > 0) {
            int size5 = list2.size();
            FontWeight fontWeight4 = null;
            for (int i6 = 0; i6 < size5; i6++) {
                FontWeight weight2 = ((Font) list2.get(i6)).getWeight();
                if (weight2.compareTo(fontWeight) >= 0) {
                    if (weight2.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight2;
                        fontWeight2 = fontWeight4;
                        break;
                    }
                    if (fontWeight4 == null || weight2.compareTo(fontWeight4) < 0) {
                        fontWeight4 = weight2;
                    }
                } else if (fontWeight2 == null || weight2.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight2;
                }
            }
            if (fontWeight4 == null) {
                fontWeight4 = fontWeight2;
            }
            ArrayList arrayList4 = new ArrayList(list2.size());
            int size6 = list2.size();
            while (i2 < size6) {
                Object obj4 = list2.get(i2);
                if (Intrinsics.areEqual(((Font) obj4).getWeight(), fontWeight4)) {
                    arrayList4.add(obj4);
                }
                i2++;
            }
            return arrayList4;
        }
        FontWeight w500 = companion.getW500();
        int size7 = list2.size();
        FontWeight fontWeight5 = null;
        FontWeight fontWeight6 = null;
        for (int i7 = 0; i7 < size7; i7++) {
            FontWeight weight3 = ((Font) list2.get(i7)).getWeight();
            if (w500 == null || weight3.compareTo(w500) <= 0) {
                if (weight3.compareTo(fontWeight) >= 0) {
                    if (weight3.compareTo(fontWeight) <= 0) {
                        fontWeight5 = weight3;
                        fontWeight6 = fontWeight5;
                        break;
                    }
                    if (fontWeight6 == null || weight3.compareTo(fontWeight6) < 0) {
                        fontWeight6 = weight3;
                    }
                } else if (fontWeight5 == null || weight3.compareTo(fontWeight5) > 0) {
                    fontWeight5 = weight3;
                }
            }
        }
        if (fontWeight6 != null) {
            fontWeight5 = fontWeight6;
        }
        ArrayList arrayList5 = new ArrayList(list2.size());
        int size8 = list2.size();
        for (int i8 = 0; i8 < size8; i8++) {
            Object obj5 = list2.get(i8);
            if (Intrinsics.areEqual(((Font) obj5).getWeight(), fontWeight5)) {
                arrayList5.add(obj5);
            }
        }
        if (!arrayList5.isEmpty()) {
            return arrayList5;
        }
        FontWeight w501 = FontWeight.Companion.getW500();
        int size9 = list2.size();
        FontWeight fontWeight7 = null;
        for (int i9 = 0; i9 < size9; i9++) {
            FontWeight weight4 = ((Font) list2.get(i9)).getWeight();
            if (w501 == null || weight4.compareTo(w501) >= 0) {
                if (weight4.compareTo(fontWeight) >= 0) {
                    if (weight4.compareTo(fontWeight) <= 0) {
                        fontWeight2 = weight4;
                        fontWeight7 = fontWeight2;
                        break;
                    }
                    if (fontWeight7 == null || weight4.compareTo(fontWeight7) < 0) {
                        fontWeight7 = weight4;
                    }
                } else if (fontWeight2 == null || weight4.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight4;
                }
            }
        }
        if (fontWeight7 != null) {
            fontWeight2 = fontWeight7;
        }
        ArrayList arrayList6 = new ArrayList(list2.size());
        int size10 = list2.size();
        while (i2 < size10) {
            Object obj6 = list2.get(i2);
            if (Intrinsics.areEqual(((Font) obj6).getWeight(), fontWeight2)) {
                arrayList6.add(obj6);
            }
            i2++;
        }
        return arrayList6;
    }
}
