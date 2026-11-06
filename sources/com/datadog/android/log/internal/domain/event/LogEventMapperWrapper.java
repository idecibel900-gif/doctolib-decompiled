package com.datadog.android.log.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.event.EventMapper;
import com.datadog.android.log.model.LogEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LogEventMapperWrapper implements EventMapper {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;
    private final EventMapper wrappedEventMapper;

    public LogEventMapperWrapper(EventMapper wrappedEventMapper, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(wrappedEventMapper, "wrappedEventMapper");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.wrappedEventMapper = wrappedEventMapper;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.event.EventMapper
    public LogEvent map(final LogEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LogEvent logEvent = (LogEvent) this.wrappedEventMapper.map(event);
        if (logEvent == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.log.internal.domain.event.LogEventMapperWrapper.map.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "LogEventMapper: the returned mapped object was null. This event will be dropped: %s", Arrays.copyOf(new Object[]{event}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        if (logEvent == event) {
            return logEvent;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.log.internal.domain.event.LogEventMapperWrapper.map.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "LogEventMapper: the returned mapped object was not the same instance as the original object. This event will be dropped: %s", Arrays.copyOf(new Object[]{event}, 1));
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
