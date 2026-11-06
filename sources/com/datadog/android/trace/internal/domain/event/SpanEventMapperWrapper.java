package com.datadog.android.trace.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.event.EventMapper;
import com.datadog.android.trace.event.SpanEventMapper;
import com.datadog.android.trace.model.SpanEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SpanEventMapperWrapper implements EventMapper {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;
    private final SpanEventMapper wrappedEventMapper;

    public SpanEventMapperWrapper(SpanEventMapper wrappedEventMapper, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(wrappedEventMapper, "wrappedEventMapper");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.wrappedEventMapper = wrappedEventMapper;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.event.EventMapper
    public SpanEvent map(final SpanEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpanEvent map = this.wrappedEventMapper.map(event);
        if (map == event) {
            return map;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.trace.internal.domain.event.SpanEventMapperWrapper.map.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "SpanEventMapper: the returned mapped object was not the same instance as the original object. This event will be dropped: %s", Arrays.copyOf(new Object[]{event}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
