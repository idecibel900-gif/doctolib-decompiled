package com.swmansion.enriched.markdown;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class EnrichedMarkdown$setContextMenuItems$1$1 extends FunctionReferenceImpl implements Function4 {
    EnrichedMarkdown$setContextMenuItems$1$1(Object obj) {
        super(4, obj, EnrichedMarkdown.class, "forwardContextMenuItemPress", "forwardContextMenuItemPress(Ljava/lang/String;Ljava/lang/String;II)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((String) obj, (String) obj2, ((Number) obj3).intValue(), ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String p0, String p1, int i, int i2) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((EnrichedMarkdown) this.receiver).forwardContextMenuItemPress(p0, p1, i, i2);
    }
}
