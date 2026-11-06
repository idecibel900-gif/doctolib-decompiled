package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class RowColumnMeasurePolicyKt {
    public static final MeasureResult measure(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8) throws Throwable {
        float f;
        float f2;
        String str;
        String str2;
        long j;
        String str3;
        String str4;
        String str5;
        long j2;
        Integer num;
        int i9;
        int iCoerceIn;
        int i10;
        int i11;
        String str6;
        int i12;
        String str7;
        String str8;
        float f3;
        String str9;
        int i13;
        String str10;
        int i14;
        String str11;
        float f4;
        String str12;
        long j3;
        String str13;
        long j4;
        String str14;
        int i15;
        char c;
        int i16;
        int i17;
        int iMax;
        int i18;
        RowColumnMeasurePolicy rowColumnMeasurePolicy2;
        int i19;
        List list2 = list;
        int i20 = i7;
        long j5 = i5;
        int i21 = i20 - i6;
        int[] iArr2 = new int[i21];
        int i22 = 0;
        int i23 = i6;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        float f5 = 0.0f;
        while (true) {
            if (i23 >= i20) {
                break;
            }
            int i29 = i23;
            Measurable measurable = (Measurable) list2.get(i23);
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            int i30 = (i25 != 0 || RowColumnImplKt.isRelative(rowColumnParentData)) ? 1 : i22;
            if (weight > 0.0f) {
                i24++;
                f5 += weight;
                i21 = i21;
                i19 = i27;
                iArr2 = iArr2;
            } else {
                if (i4 != 2147483647 && rowColumnParentData != null) {
                    rowColumnParentData.getFlowLayoutData();
                }
                int i31 = i3 - i27;
                Placeable placeableMo1843measureBRTryo0 = placeableArr[i29];
                if (placeableMo1843measureBRTryo0 == null) {
                    i18 = i31;
                    rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
                    placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(RowColumnMeasurePolicy.m321createConstraintsxF2OJ5Q$default(rowColumnMeasurePolicy2, 0, 0, i3 != Integer.MAX_VALUE ? RangesKt.coerceAtLeast(i31, i22) : Integer.MAX_VALUE, i4, false, 16, null));
                } else {
                    i18 = i31;
                    rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
                }
                int iMainAxisSize = rowColumnMeasurePolicy2.mainAxisSize(placeableMo1843measureBRTryo0);
                int iCrossAxisSize = rowColumnMeasurePolicy2.crossAxisSize(placeableMo1843measureBRTryo0);
                iArr2[i29 - i6] = iMainAxisSize;
                int iMin = Math.min(i5, RangesKt.coerceAtLeast(i18 - iMainAxisSize, 0));
                i19 = iMainAxisSize + iMin + i27;
                int iMax2 = Math.max(i28, iCrossAxisSize);
                placeableArr[i29] = placeableMo1843measureBRTryo0;
                i28 = iMax2;
                i26 = iMin;
                i24 = i24;
                f5 = f5;
            }
            i23 = i29 + 1;
            iArr2 = iArr2;
            i25 = i30;
            i21 = i21;
            i27 = i19;
            i22 = 0;
        }
        int i32 = i24;
        int i33 = i21;
        int i34 = i27;
        int i35 = i28;
        float f6 = f5;
        int[] iArr3 = iArr2;
        if (i32 == 0) {
            i10 = i34 - i26;
            i9 = i35;
            num = null;
            iCoerceIn = 0;
        } else {
            int i36 = i3 != Integer.MAX_VALUE ? i3 : i;
            long j6 = ((long) (i32 - 1)) * j5;
            long jCoerceAtLeast = RangesKt.coerceAtLeast(((long) (i36 - i34)) - j6, 0L);
            float f7 = f6;
            float f8 = jCoerceAtLeast / f7;
            int i37 = i6;
            long jRound = jCoerceAtLeast;
            while (true) {
                f = f8;
                f2 = f7;
                str = "arrangementSpacingTotal ";
                str2 = "fixedSpace ";
                j = jCoerceAtLeast;
                str3 = "weightChildrenCount ";
                str4 = "remainingToTarget ";
                str5 = "targetSpace ";
                j2 = j6;
                if (i37 >= i20) {
                    break;
                }
                float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((Measurable) list2.get(i37)));
                float f9 = f * weight2;
                try {
                    jRound -= (long) Math.round(f9);
                    i37++;
                    list2 = list;
                    f8 = f;
                    f7 = f2;
                    jCoerceAtLeast = j;
                    j6 = j2;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax " + i3 + "mainAxisMin " + i + "targetSpace " + i36 + "arrangementSpacingPx " + j5 + "weightChildrenCount " + i32 + "fixedSpace " + i34 + "arrangementSpacingTotal " + j2 + str4 + j + "totalWeight " + f2 + "weightUnitSpace " + f + "itemWeight " + weight2 + "weightedSize " + f9).initCause(e);
                }
            }
            String str15 = "weightedSize ";
            int i38 = i32;
            String str16 = "weightUnitSpace ";
            String str17 = "mainAxisMin ";
            int i39 = i6;
            int i40 = i35;
            int i41 = 0;
            while (i39 < i20) {
                if (placeableArr[i39] == null) {
                    String str18 = str3;
                    i12 = i39;
                    Measurable measurable2 = (Measurable) list.get(i39);
                    RowColumnParentData rowColumnParentData2 = RowColumnImplKt.getRowColumnParentData(measurable2);
                    float weight3 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    int i42 = i41;
                    String str19 = str;
                    if (i4 != Integer.MAX_VALUE && rowColumnParentData2 != null) {
                        rowColumnParentData2.getFlowLayoutData();
                    }
                    if (weight3 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables");
                    }
                    int sign = MathKt.getSign(jRound);
                    String str20 = str15;
                    jRound -= (long) sign;
                    float f10 = f * weight3;
                    int iMax3 = Math.max(0, Math.round(f10) + sign);
                    try {
                        try {
                            if (RowColumnImplKt.getFill(rowColumnParentData2)) {
                                c = 65535;
                                int i43 = iMax3 != Integer.MAX_VALUE ? iMax3 : 0;
                                str8 = str16;
                                f3 = f;
                                f4 = f10;
                                j3 = j;
                                str13 = str4;
                                j4 = j2;
                                str6 = str19;
                                str14 = str20;
                                str12 = str2;
                                i15 = i38;
                                i13 = i34;
                                str10 = str18;
                                str11 = str17;
                                str9 = str5;
                                Placeable placeableMo1843measureBRTryo1 = measurable2.mo1843measureBRTryo0(rowColumnMeasurePolicy.mo293createConstraintsxF2OJ5Q(i43, 0, iMax3, i4, true));
                                int iMainAxisSize2 = rowColumnMeasurePolicy.mainAxisSize(placeableMo1843measureBRTryo1);
                                int iCrossAxisSize2 = rowColumnMeasurePolicy.crossAxisSize(placeableMo1843measureBRTryo1);
                                iArr3[i12 - i6] = iMainAxisSize2;
                                int iMax4 = Math.max(i40, iCrossAxisSize2);
                                placeableArr[i12] = placeableMo1843measureBRTryo1;
                                i11 = i42 + iMainAxisSize2;
                                i40 = iMax4;
                                str7 = str12;
                                i14 = i15;
                                j2 = j4;
                                j = j3;
                                str15 = str14;
                                str4 = str13;
                            } else {
                                c = 65535;
                            }
                            Placeable placeableMo1843measureBRTryo2 = measurable2.mo1843measureBRTryo0(rowColumnMeasurePolicy.mo293createConstraintsxF2OJ5Q(i43, 0, iMax3, i4, true));
                            int iMainAxisSize3 = rowColumnMeasurePolicy.mainAxisSize(placeableMo1843measureBRTryo2);
                            int iCrossAxisSize3 = rowColumnMeasurePolicy.crossAxisSize(placeableMo1843measureBRTryo2);
                            iArr3[i12 - i6] = iMainAxisSize3;
                            int iMax5 = Math.max(i40, iCrossAxisSize3);
                            placeableArr[i12] = placeableMo1843measureBRTryo2;
                            i11 = i42 + iMainAxisSize3;
                            i40 = iMax5;
                            str7 = str12;
                            i14 = i15;
                            j2 = j4;
                            j = j3;
                            str15 = str14;
                            str4 = str13;
                        } catch (IllegalArgumentException e2) {
                            e = e2;
                            throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + i3 + str11 + i + str9 + i36 + "arrangementSpacingPx " + j5 + str10 + i15 + str12 + i13 + str6 + j4 + str13 + j3 + "totalWeight " + f2 + str8 + f3 + "weight " + weight3 + str14 + f4 + "crossAxisDesiredSize " + ((Object) null) + "remainderUnit " + sign + "childMainAxisSize " + iMax3).initCause(e);
                        }
                        str8 = str16;
                        f3 = f;
                        f4 = f10;
                        j3 = j;
                        str13 = str4;
                        j4 = j2;
                        str6 = str19;
                        str14 = str20;
                        str12 = str2;
                        i15 = i38;
                        i13 = i34;
                        str10 = str18;
                        str11 = str17;
                        str9 = str5;
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        f4 = f10;
                        str12 = str2;
                        str8 = str16;
                        f3 = f;
                        j3 = j;
                        str13 = str4;
                        j4 = j2;
                        str6 = str19;
                        str14 = str20;
                        str9 = str5;
                        i15 = i38;
                        i13 = i34;
                        str10 = str18;
                        str11 = str17;
                    }
                } else {
                    i11 = i41;
                    str6 = str;
                    i12 = i39;
                    str7 = str2;
                    str8 = str16;
                    f3 = f;
                    str9 = str5;
                    i13 = i34;
                    str10 = str3;
                    i14 = i38;
                    str11 = str17;
                }
                i39 = i12 + 1;
                str5 = str9;
                str17 = str11;
                str2 = str7;
                i41 = i11;
                str16 = str8;
                str = str6;
                i20 = i7;
                i38 = i14;
                str3 = str10;
                i34 = i13;
                f = f3;
            }
            num = null;
            int i44 = i34;
            i9 = i40;
            iCoerceIn = RangesKt.coerceIn((int) (((long) i41) + j2), 0, i3 - i44);
            i10 = i44;
        }
        if (i25 != 0) {
            i16 = i7;
            iMax = 0;
            int iMax6 = 0;
            for (int i45 = i6; i45 < i16; i45++) {
                Placeable placeable = placeableArr[i45];
                Intrinsics.checkNotNull(placeable);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable));
                Integer numCalculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable) : num;
                if (numCalculateAlignmentLinePosition$foundation_layout_release != null) {
                    int iIntValue = numCalculateAlignmentLinePosition$foundation_layout_release.intValue();
                    int iCrossAxisSize4 = rowColumnMeasurePolicy.crossAxisSize(placeable);
                    iMax = Math.max(iMax, iIntValue != Integer.MIN_VALUE ? numCalculateAlignmentLinePosition$foundation_layout_release.intValue() : 0);
                    if (iIntValue == Integer.MIN_VALUE) {
                        iIntValue = iCrossAxisSize4;
                    }
                    iMax6 = Math.max(iMax6, iCrossAxisSize4 - iIntValue);
                }
            }
            i17 = iMax6;
        } else {
            i16 = i7;
            i17 = 0;
            iMax = 0;
        }
        int iMax7 = Math.max(RangesKt.coerceAtLeast(i10 + iCoerceIn, 0), i);
        int iMax8 = Math.max(i9, Math.max(i2, i17 + iMax));
        int[] iArr4 = new int[i33];
        for (int i46 = 0; i46 < i33; i46++) {
            iArr4[i46] = 0;
        }
        rowColumnMeasurePolicy.populateMainAxisPositions(iMax7, iArr3, iArr4, measureScope);
        return rowColumnMeasurePolicy.placeHelper(placeableArr, measureScope, iMax, iArr4, iMax7, iMax8, iArr, i8, i6, i16);
    }
}
