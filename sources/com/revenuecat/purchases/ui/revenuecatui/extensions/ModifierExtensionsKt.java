package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a=\u0010\n\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u0007*\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u00002\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00000\tH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aS\u0010\n\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\f*\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u00012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00000\u000eH\u0000¢\u0006\u0004\b\n\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "condition", "Lkotlin/Function1;", "modifier", "conditional", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "T", "value", "Lkotlin/Function2;", "applyIfNotNull", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "V", "value2", "Lkotlin/Function3;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModifierExtensionsKt {
    public static final Modifier conditional(Modifier modifier, boolean z, Function1 modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return z ? modifier.then((Modifier) modifier2.invoke(Modifier.Companion)) : modifier;
    }

    public static final <T> Modifier applyIfNotNull(Modifier modifier, T t, Function2 modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return t != null ? modifier.then((Modifier) modifier2.invoke(Modifier.Companion, t)) : modifier;
    }

    public static final <T, V> Modifier applyIfNotNull(Modifier modifier, T t, V v, Function3 modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return (t == null || v == null) ? modifier : modifier.then((Modifier) modifier2.invoke(Modifier.Companion, t, v));
    }
}
