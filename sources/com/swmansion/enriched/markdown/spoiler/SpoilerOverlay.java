package com.swmansion.enriched.markdown.spoiler;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public enum SpoilerOverlay {
    PARTICLES(new Function1() { // from class: com.swmansion.enriched.markdown.spoiler.SpoilerOverlay$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SpoilerOverlay._init_$lambda$0((SpoilerAnimator) obj);
        }
    }),
    SOLID(new Function1() { // from class: com.swmansion.enriched.markdown.spoiler.SpoilerOverlay$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SpoilerOverlay._init_$lambda$1((SpoilerAnimator) obj);
        }
    });

    private final Function1 createStrategy;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    SpoilerOverlay(Function1 function1) {
        this.createStrategy = function1;
    }

    public final Function1 getCreateStrategy$react_native_enriched_markdown_release() {
        return this.createStrategy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SpoilerStrategy _init_$lambda$0(SpoilerAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        return new ParticleStrategy(animator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SpoilerStrategy _init_$lambda$1(SpoilerAnimator spoilerAnimator) {
        Intrinsics.checkNotNullParameter(spoilerAnimator, "<unused var>");
        return new SolidStrategy();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpoilerOverlay fromString(String str) {
            return Intrinsics.areEqual(str, "solid") ? SpoilerOverlay.SOLID : SpoilerOverlay.PARTICLES;
        }
    }
}
