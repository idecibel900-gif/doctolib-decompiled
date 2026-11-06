package com.swmansion.enriched.markdown.spoiler;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.swmansion.enriched.markdown.spans.SpoilerSpan;
import com.swmansion.enriched.markdown.styles.SpoilerStyle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ParticleStrategy implements SpoilerStrategy {
    private final SpoilerAnimator animator;
    private final Paint backgroundPaint;
    private int particleColor;
    private float particleDensity;
    private float particleSpeed;
    private final Map segments;

    public ParticleStrategy(SpoilerAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.animator = animator;
        this.segments = new LinkedHashMap();
        this.backgroundPaint = new Paint();
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void applyStyle(SpoilerStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.particleColor = style.getColor();
        this.particleDensity = style.getParticleDensity();
        this.particleSpeed = style.getParticleSpeed();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void drawSegment(Canvas canvas, SpoilerDrawContext context, SegmentKey key, SegmentRect rect) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Map map = this.segments;
        Object obj = map.get(key);
        Object obj2 = obj;
        if (obj == null) {
            SpoilerParticleDrawable spoilerParticleDrawable = new SpoilerParticleDrawable(this.particleColor, this.particleDensity, this.particleSpeed);
            this.animator.register(spoilerParticleDrawable);
            map.put(key, spoilerParticleDrawable);
            obj2 = spoilerParticleDrawable;
        }
        SpoilerParticleDrawable spoilerParticleDrawable2 = (SpoilerParticleDrawable) obj2;
        spoilerParticleDrawable2.setSize(rect.getWidth(), rect.getHeight());
        this.backgroundPaint.setColor(SpoilerDrawUtilsKt.colorWithAlpha(context.getBackgroundColor(), spoilerParticleDrawable2.getOverallAlpha()));
        canvas.drawRect(rect.getLeft(), rect.getTop(), rect.getLeft() + rect.getWidth(), rect.getTop() + rect.getHeight(), this.backgroundPaint);
        spoilerParticleDrawable2.draw(canvas, rect.getLeft(), rect.getTop());
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void pruneStaleSegments(Set activeKeys) {
        Intrinsics.checkNotNullParameter(activeKeys, "activeKeys");
        Iterator it = SetsKt.minus(this.segments.keySet(), (Iterable) activeKeys).iterator();
        while (it.hasNext()) {
            SpoilerParticleDrawable spoilerParticleDrawable = (SpoilerParticleDrawable) this.segments.remove((SegmentKey) it.next());
            if (spoilerParticleDrawable != null) {
                this.animator.unregister(spoilerParticleDrawable);
            }
        }
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void revealSpan(SpoilerSpan span, SpoilerDrawContext context, Function0 onAllComplete) {
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onAllComplete, "onAllComplete");
        SpoilerStrategyKt.revealSegments(span, this.segments.keySet(), onAllComplete, new Function1() { // from class: com.swmansion.enriched.markdown.spoiler.ParticleStrategy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ParticleStrategy.revealSpan$lambda$5(this.f$0, (List) obj);
            }
        }, new Function2() { // from class: com.swmansion.enriched.markdown.spoiler.ParticleStrategy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParticleStrategy.revealSpan$lambda$6(this.f$0, (SegmentKey) obj, (Function0) obj2);
            }
        });
        this.animator.ensureRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit revealSpan$lambda$5(ParticleStrategy particleStrategy, List keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            SpoilerParticleDrawable spoilerParticleDrawable = (SpoilerParticleDrawable) particleStrategy.segments.remove((SegmentKey) it.next());
            if (spoilerParticleDrawable != null) {
                particleStrategy.animator.unregister(spoilerParticleDrawable);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit revealSpan$lambda$6(ParticleStrategy particleStrategy, SegmentKey key, Function0 onComplete) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        SpoilerParticleDrawable spoilerParticleDrawable = (SpoilerParticleDrawable) particleStrategy.segments.get(key);
        if (spoilerParticleDrawable != null) {
            spoilerParticleDrawable.startReveal(onComplete);
        }
        return Unit.INSTANCE;
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerStrategy
    public void stop() {
        Iterator it = this.segments.values().iterator();
        while (it.hasNext()) {
            this.animator.unregister((SpoilerParticleDrawable) it.next());
        }
        this.segments.clear();
    }
}
