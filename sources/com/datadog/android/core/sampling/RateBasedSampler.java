package com.datadog.android.core.sampling;

import com.datadog.android.api.InternalLogger;
import java.security.SecureRandom;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class RateBasedSampler implements Sampler {
    private static final Companion Companion = new Companion(null);
    private final Lazy random$delegate;
    private final Function0 sampleRateProvider;

    public RateBasedSampler(Function0 sampleRateProvider) {
        Intrinsics.checkNotNullParameter(sampleRateProvider, "sampleRateProvider");
        this.sampleRateProvider = sampleRateProvider;
        this.random$delegate = LazyKt.lazy(new Function0() { // from class: com.datadog.android.core.sampling.RateBasedSampler$random$2
            @Override // kotlin.jvm.functions.Function0
            public final SecureRandom invoke() {
                return new SecureRandom();
            }
        });
    }

    public RateBasedSampler(final float f) {
        this(new Function0() { // from class: com.datadog.android.core.sampling.RateBasedSampler.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(f);
            }
        });
    }

    private final SecureRandom getRandom() {
        return (SecureRandom) this.random$delegate.getValue();
    }

    @Override // com.datadog.android.core.sampling.Sampler
    public boolean sample(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        float fFloatValue = getSampleRate().floatValue();
        if (fFloatValue == 0.0f) {
            return false;
        }
        return fFloatValue == 100.0f || getRandom().nextFloat() * ((float) 100) <= fFloatValue;
    }

    public Float getSampleRate() {
        final float fFloatValue = ((Number) this.sampleRateProvider.invoke()).floatValue();
        float f = 0.0f;
        if (fFloatValue < 0.0f) {
            InternalLogger.DefaultImpls.log$default(InternalLogger.Companion.getUNBOUND(), InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.sampling.RateBasedSampler.getSampleRate.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Sample rate value provided " + fFloatValue + " is below 0, setting it to 0.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            f = 100.0f;
            if (fFloatValue > 100.0f) {
                InternalLogger.DefaultImpls.log$default(InternalLogger.Companion.getUNBOUND(), InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.sampling.RateBasedSampler.getSampleRate.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Sample rate value provided " + fFloatValue + " is above 100, setting it to 100.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
            return Float.valueOf(fFloatValue);
        }
        fFloatValue = f;
        return Float.valueOf(fFloatValue);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
