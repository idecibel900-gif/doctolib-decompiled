package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.graphics.drawable.DrawableKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u001cJ+\u0010\u001d\u001a\u00020\n*\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ(\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\nH\u0002ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/AppStyleExtractor;", "", "()V", "colorKeyToTuple", "Lkotlin/Triple;", "", "colorKey", "", "extractProminentColors", "", "Landroidx/compose/ui/graphics/Color;", "bitmap", "Landroid/graphics/Bitmap;", "count", "extractProminentColors$revenuecatui_defaultsBc8Release", "getAppIconBitmap", "context", "Landroid/content/Context;", "getAppName", "", "getProminentColorsFromBitmap", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/graphics/Bitmap;ILkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalizedColorComponent", "shift", "quantizedColorKeyOrNull", "color", "(I)Ljava/lang/Integer;", "toColor", "toColor-vNxB06k", "(Lkotlin/Triple;)J", "toTriple", "toTriple-8_81llA", "(J)Lkotlin/Triple;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppStyleExtractor {
    public static final int $stable = 0;
    public static final AppStyleExtractor INSTANCE = new AppStyleExtractor();

    private final double normalizedColorComponent(int colorKey, int shift) {
        return ((double) ((colorKey >> shift) & 255)) / 255.0d;
    }

    private AppStyleExtractor() {
    }

    public final String getAppName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public final Bitmap getAppIconBitmap(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Drawable drawable = context.getApplicationInfo().loadIcon(context.getPackageManager());
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            return DrawableKt.toBitmap$default(drawable, 0, 0, Bitmap.Config.ARGB_8888, 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.e("Failed to load app icon bitmap.", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor$getProminentColorsFromBitmap$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/Color;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor$getProminentColorsFromBitmap$2", f = "AppStyleExtractor.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $count;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Bitmap bitmap, int i, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$count = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$bitmap, this.$count, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return AppStyleExtractor.INSTANCE.extractProminentColors$revenuecatui_defaultsBc8Release(this.$bitmap, this.$count);
        }
    }

    public static /* synthetic */ Object getProminentColorsFromBitmap$default(AppStyleExtractor appStyleExtractor, Bitmap bitmap, int i, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        if ((i2 & 4) != 0) {
            coroutineDispatcher = Dispatchers.getDefault();
        }
        return appStyleExtractor.getProminentColorsFromBitmap(bitmap, i, coroutineDispatcher, continuation);
    }

    public final Object getProminentColorsFromBitmap(Bitmap bitmap, int i, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        return BuildersKt.withContext(coroutineDispatcher, new AnonymousClass2(bitmap, i, null), continuation);
    }

    public final List<Color> extractProminentColors$revenuecatui_defaultsBc8Release(Bitmap bitmap, int count) {
        boolean z;
        Double dValueOf = Double.valueOf(1.0d);
        Double dValueOf2 = Double.valueOf(0.0d);
        if (bitmap == null) {
            return CollectionsKt.emptyList();
        }
        if (count <= 0) {
            return CollectionsKt.emptyList();
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight() * width;
        if (height == 0) {
            return CollectionsKt.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, height), (int) Math.max(1L, ((((long) height) + j) - 1) / j));
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                Integer numQuantizedColorKeyOrNull = quantizedColorKeyOrNull(bitmap.getPixel(first % width, first / width));
                if (numQuantizedColorKeyOrNull != null) {
                    linkedHashMap.put(numQuantizedColorKeyOrNull, Integer.valueOf(((Number) linkedHashMap.getOrDefault(numQuantizedColorKeyOrNull, 0)).intValue() + 1));
                }
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        ArrayList arrayList = new ArrayList();
        Triple triple = new Triple(dValueOf2, dValueOf2, dValueOf2);
        Triple triple2 = new Triple(dValueOf, dValueOf, dValueOf);
        Iterator it = CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor$extractProminentColors$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) ((Map.Entry) t2).getValue(), (Integer) ((Map.Entry) t).getValue());
            }
        }).iterator();
        while (it.hasNext()) {
            Triple tripleColorKeyToTuple = colorKeyToTuple(((Number) ((Map.Entry) it.next()).getKey()).intValue());
            boolean z2 = ColorComputationHelpersKt.colorDistance(tripleColorKeyToTuple, triple) >= 0.3d && ColorComputationHelpersKt.colorDistance(tripleColorKeyToTuple, triple2) >= 0.3d;
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    if (ColorComputationHelpersKt.colorDistance(tripleColorKeyToTuple, INSTANCE.m4521toTriple8_81llA(((Color) it2.next()).m1375unboximpl())) < 0.25d) {
                        z = true;
                        break;
                    }
                }
            } else {
                z = false;
                break;
            }
            if (z2 && !z) {
                arrayList.add(Color.m1361boximpl(m4520toColorvNxB06k(tripleColorKeyToTuple)));
                if (arrayList.size() >= count) {
                    break;
                }
            }
        }
        return arrayList;
    }

    private final Integer quantizedColorKeyOrNull(int color) {
        if (((color >> 24) & 255) >= 128) {
            int i = (((color >> 16) & 255) / 16) * 16;
            int i2 = (((color >> 8) & 255) / 16) * 16;
            int i3 = ((color & 255) / 16) * 16;
            int i4 = i + i2 + i3;
            if (i4 >= 50 && i4 <= 700) {
                return Integer.valueOf(i3 | (i << 16) | (i2 << 8));
            }
        }
        return null;
    }

    private final Triple colorKeyToTuple(int colorKey) {
        return new Triple(Double.valueOf(normalizedColorComponent(colorKey, 16)), Double.valueOf(normalizedColorComponent(colorKey, 8)), Double.valueOf(((double) (colorKey & 255)) / 255.0d));
    }

    /* JADX INFO: renamed from: toColor-vNxB06k, reason: not valid java name */
    private final long m4520toColorvNxB06k(Triple triple) {
        return ColorKt.Color$default((float) ((Number) triple.getFirst()).doubleValue(), (float) ((Number) triple.getSecond()).doubleValue(), (float) ((Number) triple.getThird()).doubleValue(), 0.0f, null, 24, null);
    }

    /* JADX INFO: renamed from: toTriple-8_81llA, reason: not valid java name */
    private final Triple m4521toTriple8_81llA(long j) {
        return new Triple(Double.valueOf(Color.m1372getRedimpl(j)), Double.valueOf(Color.m1371getGreenimpl(j)), Double.valueOf(Color.m1369getBlueimpl(j)));
    }
}
