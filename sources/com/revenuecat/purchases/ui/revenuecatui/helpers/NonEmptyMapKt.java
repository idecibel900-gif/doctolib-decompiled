package com.revenuecat.purchases.ui.revenuecatui.helpers;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u001ae\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0007\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0000¢\u0006\u0002\u0010\b\u001aH\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\nH\u0000\u001a2\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\nH\u0000¨\u0006\f"}, d2 = {"nonEmptyMapOf", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "K", "V", "entry", "Lkotlin/Pair;", "t", "", "(Lkotlin/Pair;[Lkotlin/Pair;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "map", "", "toNonEmptyMapOrNull", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class NonEmptyMapKt {
    public static final /* synthetic */ NonEmptyMap nonEmptyMapOf(Pair entry, Pair... t) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(t, "t");
        return new NonEmptyMap(entry, MapsKt.toMap(t));
    }

    public static final /* synthetic */ NonEmptyMap nonEmptyMapOf(Pair entry, Map map) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(map, "map");
        return new NonEmptyMap(entry, map);
    }

    public static final /* synthetic */ NonEmptyMap toNonEmptyMapOrNull(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        final LinkedHashMap linkedHashMap = new LinkedHashMap(map.size() - 1);
        final Function1 function1 = new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt.toNonEmptyMapOrNull.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map.Entry) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map.Entry entry2) {
                Intrinsics.checkNotNullParameter(entry2, "<name for destructuring parameter 0>");
                linkedHashMap.put(entry2.getKey(), entry2.getValue());
            }
        };
        it.forEachRemaining(new Consumer() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                function1.invoke(obj);
            }
        });
        return new NonEmptyMap(new Pair(entry.getKey(), entry.getValue()), linkedHashMap);
    }
}
