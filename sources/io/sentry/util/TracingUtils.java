package io.sentry.util;

import io.sentry.Baggage;
import io.sentry.FilterString;
import io.sentry.IScope;
import io.sentry.IScopes;
import io.sentry.NoOpLogger;
import io.sentry.PropagationContext;
import io.sentry.Scope;
import io.sentry.ScopeCallback;
import io.sentry.SentryOptions;
import io.sentry.TracesSamplingDecision;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TracingUtils {
    public static void startNewTrace(IScopes iScopes) {
        iScopes.configureScope(new ScopeCallback() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda1
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                iScope.withPropagationContext(new Scope.IWithPropagationContext() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda2
                    @Override // io.sentry.Scope.IWithPropagationContext
                    public final void accept(PropagationContext propagationContext) {
                        iScope.setPropagationContext(new PropagationContext());
                    }
                });
            }
        });
    }

    public static PropagationContext maybeUpdateBaggage(final IScope iScope, final SentryOptions sentryOptions) {
        return iScope.withPropagationContext(new Scope.IWithPropagationContext() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda0
            @Override // io.sentry.Scope.IWithPropagationContext
            public final void accept(PropagationContext propagationContext) {
                TracingUtils.$r8$lambda$ZIzksLxmFA7avqQxvNiZNy6iKZ4(iScope, sentryOptions, propagationContext);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$ZIzksLxmFA7avqQxvNiZNy6iKZ4(IScope iScope, SentryOptions sentryOptions, PropagationContext propagationContext) {
        Baggage baggage = propagationContext.getBaggage();
        if (baggage.isMutable()) {
            baggage.setValuesFromScope(iScope, sentryOptions);
            baggage.freeze();
        }
    }

    public static boolean isIgnored(List list, String str) {
        if (str != null && list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((FilterString) it.next()).getFilterString().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                try {
                    if (((FilterString) it2.next()).matches(str)) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public static Baggage ensureBaggage(Baggage baggage, TracesSamplingDecision tracesSamplingDecision) {
        return ensureBaggage(baggage, tracesSamplingDecision == null ? null : tracesSamplingDecision.getSampled(), tracesSamplingDecision == null ? null : tracesSamplingDecision.getSampleRate(), tracesSamplingDecision != null ? tracesSamplingDecision.getSampleRand() : null);
    }

    public static Baggage ensureBaggage(Baggage baggage, Boolean bool, Double d, Double d2) {
        if (baggage == null) {
            baggage = new Baggage(NoOpLogger.getInstance());
        }
        if (baggage.getSampleRand() == null) {
            Double sampleRate = baggage.getSampleRate();
            if (sampleRate != null) {
                d = sampleRate;
            }
            baggage.setSampleRand(SampleRateUtils.backfilledSampleRand(d2, d, bool));
        }
        if (baggage.isMutable() && baggage.isShouldFreeze()) {
            baggage.freeze();
        }
        return baggage;
    }
}
