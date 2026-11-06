package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentTransitionScopeImpl rootScope;

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).maxIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).maxIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).maxIntrinsicWidth(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).maxIntrinsicWidth(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).minIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).minIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).minIntrinsicWidth(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i2 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((IntrinsicMeasurable) list.get(i2)).minIntrinsicWidth(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
        this.rootScope = animatedContentTransitionScopeImpl;
    }

    public final AnimatedContentTransitionScopeImpl getRootScope() {
        return this.rootScope;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:68:0x0101  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00db A[SYNTHETIC] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo30measure3p2s80s(MeasureScope measureScope, List list, long j) {
        Placeable placeable;
        Placeable placeable2;
        final int i;
        int width;
        int lastIndex;
        int height;
        IntIterator it;
        Placeable placeable3;
        int height2;
        final int i2;
        int size = list.size();
        final Placeable[] placeableArr = new Placeable[size];
        long jM2613getZeroYbymL2g = IntSize.Companion.m2613getZeroYbymL2g();
        int size2 = list.size();
        int height3 = 0;
        int i3 = 0;
        while (true) {
            placeable = null;
            if (i3 >= size2) {
                break;
            }
            Measurable measurable = (Measurable) list.get(i3);
            Object parentData = measurable.getParentData();
            AnimatedContentTransitionScopeImpl.ChildData childData = parentData instanceof AnimatedContentTransitionScopeImpl.ChildData ? (AnimatedContentTransitionScopeImpl.ChildData) parentData : null;
            if (childData != null && childData.isTarget()) {
                Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
                long jIntSize = IntSizeKt.IntSize(placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight());
                Unit unit = Unit.INSTANCE;
                placeableArr[i3] = placeableMo1843measureBRTryo0;
                jM2613getZeroYbymL2g = jIntSize;
            }
            i3++;
        }
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            Measurable measurable2 = (Measurable) list.get(i4);
            if (placeableArr[i4] == null) {
                placeableArr[i4] = measurable2.mo1843measureBRTryo0(j);
            }
        }
        if (measureScope.isLookingAhead()) {
            width = IntSize.m2609getWidthimpl(jM2613getZeroYbymL2g);
        } else {
            if (size == 0) {
                placeable2 = null;
            } else {
                placeable2 = placeableArr[0];
                int lastIndex2 = ArraysKt.getLastIndex(placeableArr);
                if (lastIndex2 != 0) {
                    int width2 = placeable2 != null ? placeable2.getWidth() : 0;
                    IntIterator it2 = new IntRange(1, lastIndex2).iterator();
                    while (it2.hasNext()) {
                        Placeable placeable4 = placeableArr[it2.nextInt()];
                        int width3 = placeable4 != null ? placeable4.getWidth() : 0;
                        if (width2 < width3) {
                            placeable2 = placeable4;
                            width2 = width3;
                        }
                    }
                }
            }
            if (placeable2 != null) {
                width = placeable2.getWidth();
            } else {
                i = 0;
            }
            if (measureScope.isLookingAhead()) {
                height3 = IntSize.m2608getHeightimpl(jM2613getZeroYbymL2g);
            } else {
                if (size != 0) {
                    placeable = placeableArr[0];
                    lastIndex = ArraysKt.getLastIndex(placeableArr);
                    if (lastIndex != 0) {
                        if (placeable != null) {
                            height = placeable.getHeight();
                        } else {
                            height = 0;
                        }
                        it = new IntRange(1, lastIndex).iterator();
                        while (it.hasNext()) {
                            placeable3 = placeableArr[it.nextInt()];
                            if (placeable3 != null) {
                                height2 = placeable3.getHeight();
                            } else {
                                height2 = 0;
                            }
                            if (height < height2) {
                                placeable = placeable3;
                                height = height2;
                            }
                        }
                    }
                }
                if (placeable != null) {
                    height3 = placeable.getHeight();
                }
            }
            i2 = height3;
            if (!measureScope.isLookingAhead()) {
                this.rootScope.m31setMeasuredSizeozmzZPI$animation_release(IntSizeKt.IntSize(i, i2));
            }
            return MeasureScope.layout$default(measureScope, i, i2, null, new Function1() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope placementScope2;
                    Placeable[] placeableArr2 = placeableArr;
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this;
                    int i5 = i;
                    int i6 = i2;
                    int length = placeableArr2.length;
                    int i7 = 0;
                    while (i7 < length) {
                        Placeable placeable5 = placeableArr2[i7];
                        if (placeable5 != null) {
                            long jMo1118alignKFBX0sM = animatedContentMeasurePolicy.getRootScope().getContentAlignment().mo1118alignKFBX0sM(IntSizeKt.IntSize(placeable5.getWidth(), placeable5.getHeight()), IntSizeKt.IntSize(i5, i6), LayoutDirection.Ltr);
                            placementScope2 = placementScope;
                            Placeable.PlacementScope.place$default(placementScope2, placeable5, IntOffset.m2591getXimpl(jMo1118alignKFBX0sM), IntOffset.m2592getYimpl(jMo1118alignKFBX0sM), 0.0f, 4, null);
                        } else {
                            placementScope2 = placementScope;
                        }
                        i7++;
                        placementScope = placementScope2;
                    }
                }
            }, 4, null);
        }
        i = width;
        if (measureScope.isLookingAhead()) {
            height3 = IntSize.m2608getHeightimpl(jM2613getZeroYbymL2g);
        } else {
            if (size != 0) {
                placeable = placeableArr[0];
                lastIndex = ArraysKt.getLastIndex(placeableArr);
                if (lastIndex != 0) {
                    if (placeable != null) {
                        height = placeable.getHeight();
                    } else {
                        height = 0;
                    }
                    it = new IntRange(1, lastIndex).iterator();
                    while (it.hasNext()) {
                        placeable3 = placeableArr[it.nextInt()];
                        if (placeable3 != null) {
                            height2 = placeable3.getHeight();
                        } else {
                            height2 = 0;
                        }
                        if (height < height2) {
                            placeable = placeable3;
                            height = height2;
                        }
                    }
                }
            }
            if (placeable != null) {
                height3 = placeable.getHeight();
            }
        }
        i2 = height3;
        if (!measureScope.isLookingAhead()) {
            this.rootScope.m31setMeasuredSizeozmzZPI$animation_release(IntSizeKt.IntSize(i, i2));
        }
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope placementScope2;
                Placeable[] placeableArr2 = placeableArr;
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this;
                int i5 = i;
                int i6 = i2;
                int length = placeableArr2.length;
                int i7 = 0;
                while (i7 < length) {
                    Placeable placeable5 = placeableArr2[i7];
                    if (placeable5 != null) {
                        long jMo1118alignKFBX0sM = animatedContentMeasurePolicy.getRootScope().getContentAlignment().mo1118alignKFBX0sM(IntSizeKt.IntSize(placeable5.getWidth(), placeable5.getHeight()), IntSizeKt.IntSize(i5, i6), LayoutDirection.Ltr);
                        placementScope2 = placementScope;
                        Placeable.PlacementScope.place$default(placementScope2, placeable5, IntOffset.m2591getXimpl(jMo1118alignKFBX0sM), IntOffset.m2592getYimpl(jMo1118alignKFBX0sM), 0.0f, 4, null);
                    } else {
                        placementScope2 = placementScope;
                    }
                    i7++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }
}
