package com.datadog.android.core.constraints;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.utils.MapUtilsKt;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogDataConstraints implements DataConstraints {
    public static final Companion Companion = new Companion(null);
    private static final Set reservedTagKeys = SetsKt.setOf((Object[]) new String[]{DiagnosticsTracker.HOST_KEY, "device", Constants.ScionAnalytics.PARAM_SOURCE, "service"});
    private final InternalLogger internalLogger;
    private final List tagTransforms;

    public DatadogDataConstraints(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.tagTransforms = CollectionsKt.listOf((Object[]) new Function1[]{new Function1() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = it.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        }, new Function1() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CharRange charRange = new CharRange('a', 'z');
                Character orNull = StringsKt.getOrNull(it, 0);
                if (orNull == null || !charRange.contains(orNull.charValue())) {
                    return null;
                }
                return it;
            }
        }, new Function1() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$3
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new Regex("[^a-z0-9_:./-]").replace(it, "_");
            }
        }, new Function1() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$4
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!StringsKt.endsWith$default((CharSequence) it, ':', false, 2, (Object) null)) {
                    return it;
                }
                String strSubstring = it.substring(0, StringsKt.getLastIndex(it));
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return strSubstring;
            }
        }, new Function1() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$5
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.length() <= 200) {
                    return it;
                }
                String strSubstring = it.substring(0, 200);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return strSubstring;
            }
        }, new Function1() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.this$0.isKeyReserved(it)) {
                    return null;
                }
                return it;
            }
        }});
    }

    @Override // com.datadog.android.core.constraints.DataConstraints
    public List validateTags(List tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        ArrayList arrayList = new ArrayList();
        Iterator it = tags.iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            final String strConvertTag = convertTag(str);
            if (strConvertTag == null) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateTags$convertedTags$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "\"" + str + "\" is an invalid tag, and was ignored.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            } else if (!Intrinsics.areEqual(strConvertTag, str)) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateTags$convertedTags$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "tag \"" + str + "\" was modified to \"" + strConvertTag + "\" to match our constraints.";
                    }
                }, (Throwable) null, true, (Map) null, 40, (Object) null);
            }
            if (strConvertTag != null) {
                arrayList.add(strConvertTag);
            }
        }
        final int size = arrayList.size() - 100;
        if (size > 0) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints.validateTags.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "too many tags were added, " + size + " had to be discarded.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return CollectionsKt.take(arrayList, 100);
    }

    private final String resolveDiscardedAttrsWarning(String str, int i) {
        if (str != null) {
            return "Too many attributes were added for [" + str + "], " + i + " had to be discarded.";
        }
        return "Too many attributes were added, " + i + " had to be discarded.";
    }

    private final String convertTag(String str) {
        Iterator it = this.tagTransforms.iterator();
        while (it.hasNext()) {
            str = str == null ? null : (String) ((Function1) it.next()).invoke(str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isKeyReserved(String str) {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, ':', 0, false, 6, (Object) null);
        if (iIndexOf$default <= 0) {
            return false;
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return reservedTagKeys.contains(strSubstring);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.datadog.android.core.constraints.DataConstraints
    public Map validateAttributes(Map attributes, String str, String str2, Set reservedKeys) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(reservedKeys, "reservedKeys");
        int i = 0;
        if (str != null) {
            int i2 = 0;
            while (i < str.length()) {
                if (str.charAt(i) == '.') {
                    i2++;
                }
                i++;
            }
            i = i2 + 1;
        }
        ArrayList arrayList = new ArrayList();
        for (final Map.Entry entry : attributes.entrySet()) {
            Pair pair = null;
            if (entry.getKey() == null) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateAttributes$convertedAttributes$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "\"" + entry + "\" is an invalid attribute, and was ignored.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            } else if (reservedKeys.contains(entry.getKey())) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateAttributes$convertedAttributes$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "\"" + entry + "\" key was in the reservedKeys set, and was dropped.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            } else {
                final String strConvertAttributeKey = convertAttributeKey((String) entry.getKey(), i);
                if (!Intrinsics.areEqual(strConvertAttributeKey, entry.getKey())) {
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateAttributes$convertedAttributes$1$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Key \"" + entry.getKey() + "\" was modified to \"" + strConvertAttributeKey + "\" to match our constraints.";
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                }
                pair = TuplesKt.to(strConvertAttributeKey, entry.getValue());
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        int size = arrayList.size() - 128;
        if (size > 0) {
            final String strResolveDiscardedAttrsWarning = resolveDiscardedAttrsWarning(str2, size);
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints.validateAttributes.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return strResolveDiscardedAttrsWarning;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return MapUtilsKt.toMutableMap(CollectionsKt.take(arrayList, 128));
    }

    @Override // com.datadog.android.core.constraints.DataConstraints
    public Map validateTimings(Map timings) {
        Intrinsics.checkNotNullParameter(timings, "timings");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(timings.size()));
        for (final Map.Entry entry : timings.entrySet()) {
            final String strReplace = new Regex("[^a-zA-Z0-9\\-_.@$]").replace((CharSequence) entry.getKey(), "_");
            if (!Intrinsics.areEqual(strReplace, entry.getKey())) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateTimings$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, "Invalid timing name: %s, sanitized to: %s", Arrays.copyOf(new Object[]{entry.getKey(), strReplace}, 2));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
            linkedHashMap.put(strReplace, entry.getValue());
        }
        return MapsKt.toMutableMap(linkedHashMap);
    }

    private final String convertAttributeKey(String str, int i) {
        ArrayList arrayList = new ArrayList(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '.' && (i = i + 1) > 9) {
                cCharAt = '_';
            }
            arrayList.add(Character.valueOf(cCharAt));
        }
        return new String(CollectionsKt.toCharArray(arrayList));
    }
}
