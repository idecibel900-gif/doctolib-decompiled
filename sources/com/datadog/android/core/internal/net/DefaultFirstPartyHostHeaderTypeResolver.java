package com.datadog.android.core.internal.net;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultFirstPartyHostHeaderTypeResolver implements FirstPartyHostHeaderTypeResolver {
    private Map knownHosts;

    public DefaultFirstPartyHostHeaderTypeResolver(Map hosts) {
        Intrinsics.checkNotNullParameter(hosts, "hosts");
        Set<Map.Entry> setEntrySet = hosts.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            String str = (String) entry.getKey();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair = TuplesKt.to(lowerCase, entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.knownHosts = linkedHashMap;
    }

    public boolean isFirstPartyUrl(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strHost = url.host();
        Set<String> setKeySet = this.knownHosts.keySet();
        if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
            return false;
        }
        for (String str : setKeySet) {
            if (Intrinsics.areEqual(str, "*") || Intrinsics.areEqual(strHost, str)) {
                return true;
            }
            if (StringsKt.endsWith$default(strHost, "." + str, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver
    public boolean isFirstPartyUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl httpUrl = HttpUrl.INSTANCE.parse(url);
        if (httpUrl == null) {
            return false;
        }
        return isFirstPartyUrl(httpUrl);
    }

    public final void addKnownHostsWithHeaderTypes$dd_sdk_android_core_release(Map hostsWithHeaderTypes) {
        Intrinsics.checkNotNullParameter(hostsWithHeaderTypes, "hostsWithHeaderTypes");
        Map map = this.knownHosts;
        Set<Map.Entry> setEntrySet = hostsWithHeaderTypes.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            String str = (String) entry.getKey();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair = TuplesKt.to(lowerCase, entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.knownHosts = MapsKt.plus(map, linkedHashMap);
    }
}
