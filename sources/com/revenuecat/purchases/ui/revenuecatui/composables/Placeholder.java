package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÂ\u0003J\u0016\u0010\u001f\u001a\u00020\u0005HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\t\u0010\"\u001a\u00020\u0007HÂ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÂ\u0003J\u0015\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bHÂ\u0003J\u0015\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bHÂ\u0003Ji\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\u0010\u0010-\u001a\u00020.H\u0080@¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020.H\u0080@¢\u0006\u0004\b2\u00100J\t\u00103\u001a\u000204HÖ\u0001J\u0011\u00105\u001a\u00020.*\u000206H\u0000¢\u0006\u0002\b7R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "", "visible", "", "color", "Landroidx/compose/ui/graphics/Color;", "shape", "Landroidx/compose/ui/graphics/Shape;", "highlight", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;", "placeholderFadeTransitionSpec", "Lkotlin/Function0;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "contentFadeTransitionSpec", "(ZJLandroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "contentAlpha", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "highlightProgress", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastSize", "Landroidx/compose/ui/geometry/Size;", "paint", "Landroidx/compose/ui/graphics/Paint;", "placeholderAlpha", "component1", "component2", "component2-0d7_KjU", "()J", "component3", "component4", "component5", "component6", "copy", "copy-3IgeMak", "(ZJLandroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderHighlight;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "startAnimation", "", "startAnimation$revenuecatui_defaultsBc8Release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAnimation", "stopAnimation$revenuecatui_defaultsBc8Release", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw$revenuecatui_defaultsBc8Release", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Placeholder {
    public static final int $stable = 0;
    private final long color;
    private final Animatable contentAlpha;
    private final Function0 contentFadeTransitionSpec;
    private final PlaceholderHighlight highlight;
    private final Animatable highlightProgress;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Size lastSize;
    private final Paint paint;
    private final Animatable placeholderAlpha;
    private final Function0 placeholderFadeTransitionSpec;
    private final Shape shape;
    private final boolean visible;

    public /* synthetic */ Placeholder(boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, shape, placeholderHighlight, function0, function1);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    private final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final PlaceholderHighlight getHighlight() {
        return this.highlight;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final Function0 getPlaceholderFadeTransitionSpec() {
        return this.placeholderFadeTransitionSpec;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final Function0 getContentFadeTransitionSpec() {
        return this.contentFadeTransitionSpec;
    }

    /* JADX INFO: renamed from: copy-3IgeMak$default, reason: not valid java name */
    public static /* synthetic */ Placeholder m4271copy3IgeMak$default(Placeholder placeholder, boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = placeholder.visible;
        }
        if ((i & 2) != 0) {
            j = placeholder.color;
        }
        if ((i & 4) != 0) {
            shape = placeholder.shape;
        }
        if ((i & 8) != 0) {
            placeholderHighlight = placeholder.highlight;
        }
        if ((i & 16) != 0) {
            function0 = placeholder.placeholderFadeTransitionSpec;
        }
        if ((i & 32) != 0) {
            function1 = placeholder.contentFadeTransitionSpec;
        }
        return placeholder.m4272copy3IgeMak(z, j, shape, placeholderHighlight, function0, function1);
    }

    /* JADX INFO: renamed from: copy-3IgeMak, reason: not valid java name */
    public final Placeholder m4272copy3IgeMak(boolean visible, long color, Shape shape, PlaceholderHighlight highlight, Function0 placeholderFadeTransitionSpec, Function0 contentFadeTransitionSpec) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(placeholderFadeTransitionSpec, "placeholderFadeTransitionSpec");
        Intrinsics.checkNotNullParameter(contentFadeTransitionSpec, "contentFadeTransitionSpec");
        return new Placeholder(visible, color, shape, highlight, placeholderFadeTransitionSpec, contentFadeTransitionSpec, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) other;
        return this.visible == placeholder.visible && Color.m1367equalsimpl0(this.color, placeholder.color) && Intrinsics.areEqual(this.shape, placeholder.shape) && Intrinsics.areEqual(this.highlight, placeholder.highlight) && Intrinsics.areEqual(this.placeholderFadeTransitionSpec, placeholder.placeholderFadeTransitionSpec) && Intrinsics.areEqual(this.contentFadeTransitionSpec, placeholder.contentFadeTransitionSpec);
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.visible) * 31) + Color.m1373hashCodeimpl(this.color)) * 31) + this.shape.hashCode()) * 31;
        PlaceholderHighlight placeholderHighlight = this.highlight;
        return ((((iHashCode + (placeholderHighlight == null ? 0 : placeholderHighlight.hashCode())) * 31) + this.placeholderFadeTransitionSpec.hashCode()) * 31) + this.contentFadeTransitionSpec.hashCode();
    }

    public String toString() {
        return "Placeholder(visible=" + this.visible + ", color=" + ((Object) Color.m1374toStringimpl(this.color)) + ", shape=" + this.shape + ", highlight=" + this.highlight + ", placeholderFadeTransitionSpec=" + this.placeholderFadeTransitionSpec + ", contentFadeTransitionSpec=" + this.contentFadeTransitionSpec + ')';
    }

    private Placeholder(boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 placeholderFadeTransitionSpec, Function0 contentFadeTransitionSpec) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(placeholderFadeTransitionSpec, "placeholderFadeTransitionSpec");
        Intrinsics.checkNotNullParameter(contentFadeTransitionSpec, "contentFadeTransitionSpec");
        this.visible = z;
        this.color = j;
        this.shape = shape;
        this.highlight = placeholderHighlight;
        this.placeholderFadeTransitionSpec = placeholderFadeTransitionSpec;
        this.contentFadeTransitionSpec = contentFadeTransitionSpec;
        this.placeholderAlpha = AnimatableKt.Animatable$default(z ? 1.0f : 0.0f, 0.0f, 2, null);
        this.contentAlpha = AnimatableKt.Animatable$default(z ? 0.0f : 1.0f, 0.0f, 2, null);
        this.highlightProgress = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.setAntiAlias(true);
        Paint.mo1296setStylek9PVt8s(PaintingStyle.Companion.m1461getFillTiuSbCo());
        Paint.mo1291setBlendModes9anfk8(Paint.mo1286getBlendMode0nO6VwU());
        this.paint = Paint;
    }

    public /* synthetic */ Placeholder(boolean z, long j, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, (i & 4) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i & 8) != 0 ? null : placeholderHighlight, (i & 16) != 0 ? new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.1
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec invoke() {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        } : function0, (i & 32) != 0 ? new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.2
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec invoke() {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        } : function1, null);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00de  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:58:0x0117  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0111, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r3, r1, r5, null, null, r8, 12, null) == r2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0125, code lost:
    
        if (r1.snapTo(r3, r8) == r2) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startAnimation$revenuecatui_defaultsBc8Release(kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.startAnimation$revenuecatui_defaultsBc8Release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        if (r7.stop(r0) == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object stopAnimation$revenuecatui_defaultsBc8Release(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1
            if (r0 == 0) goto L13
            r0 = r7
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            goto L73
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            java.lang.Object r2 = r0.L$0
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder r2 = (com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L65
        L3f:
            java.lang.Object r2 = r0.L$0
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder r2 = (com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L58
        L47:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.animation.core.Animatable r7 = r6.placeholderAlpha
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r7.stop(r0)
            if (r7 != r1) goto L57
            goto L72
        L57:
            r2 = r6
        L58:
            androidx.compose.animation.core.Animatable r7 = r2.contentAlpha
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.stop(r0)
            if (r7 != r1) goto L65
            goto L72
        L65:
            androidx.compose.animation.core.Animatable r7 = r2.highlightProgress
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.stop(r0)
            if (r7 != r1) goto L73
        L72:
            return r1
        L73:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.stopAnimation$revenuecatui_defaultsBc8Release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void draw$revenuecatui_defaultsBc8Release(ContentDrawScope contentDrawScope) {
        ContentDrawScope contentDrawScope2;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        float fFloatValue = ((Number) this.placeholderAlpha.getValue()).floatValue();
        float fFloatValue2 = ((Number) this.contentAlpha.getValue()).floatValue();
        if (fFloatValue2 > 0.01f) {
            this.paint.setAlpha(fFloatValue2);
            Paint paint = this.paint;
            Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
            canvas.saveLayer(SizeKt.m1269toRectuvyYCjk(contentDrawScope.mo1599getSizeNHjbRc()), paint);
            contentDrawScope.drawContent();
            canvas.restore();
        }
        if (fFloatValue > 0.01f) {
            this.paint.setAlpha(fFloatValue);
            Paint paint2 = this.paint;
            Canvas canvas2 = contentDrawScope.getDrawContext().getCanvas();
            canvas2.saveLayer(SizeKt.m1269toRectuvyYCjk(contentDrawScope.mo1599getSizeNHjbRc()), paint2);
            contentDrawScope2 = contentDrawScope;
            this.lastOutline = PlaceholderKt.m4274drawPlaceholderhpmOzss(contentDrawScope2, this.shape, this.color, this.highlight, ((Number) this.highlightProgress.getValue()).floatValue(), this.lastOutline, this.lastLayoutDirection, this.lastSize);
            canvas2.restore();
        } else {
            contentDrawScope2 = contentDrawScope;
        }
        this.lastSize = Size.m1255boximpl(contentDrawScope2.mo1599getSizeNHjbRc());
        this.lastLayoutDirection = contentDrawScope2.getLayoutDirection();
    }
}
