package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/JsonTools;", "", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson$annotations", "getJson", "()Lkotlinx/serialization/json/Json;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsonTools {
    public static final JsonTools INSTANCE = new JsonTools();
    private static final Json json = JsonKt.Json$default(null, new Function1() { // from class: com.revenuecat.purchases.JsonTools$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JsonBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
            Json.setExplicitNulls(false);
        }
    }, 1, null);

    public static /* synthetic */ void getJson$annotations() {
    }

    private JsonTools() {
    }

    public final Json getJson() {
        return json;
    }
}
