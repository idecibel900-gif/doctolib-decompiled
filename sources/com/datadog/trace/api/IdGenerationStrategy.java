package com.datadog.trace.api;

import android.os.Build;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IdGenerationStrategy {
    protected final boolean traceId128BitGenerationEnabled;

    interface ThrowingSupplier {
        Object get();
    }

    protected abstract long getNonZeroPositiveLong();

    private IdGenerationStrategy(boolean z) {
        this.traceId128BitGenerationEnabled = z;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static IdGenerationStrategy fromName(String str, boolean z) {
        String upperCase = str.toUpperCase(Locale.US);
        upperCase.getClass();
        byte b = -1;
        switch (upperCase.hashCode()) {
            case -1884956477:
                if (upperCase.equals("RANDOM")) {
                    b = 0;
                }
                break;
            case 321080575:
                if (upperCase.equals("SEQUENTIAL")) {
                    b = 1;
                }
                break;
            case 709657227:
                if (upperCase.equals("SECURE_RANDOM")) {
                    b = 2;
                }
                break;
        }
        switch (b) {
            case 0:
                return new Random(z);
            case 1:
                return new Sequential(z);
            case 2:
                return new SRandom(z);
            default:
                return null;
        }
    }

    public DDTraceId generateTraceId() {
        if (this.traceId128BitGenerationEnabled) {
            return DD128bTraceId.from(generateHighOrderBits(), getNonZeroPositiveLong());
        }
        return DD64bTraceId.from(getNonZeroPositiveLong());
    }

    protected long generateHighOrderBits() {
        return (System.currentTimeMillis() / 1000) << 32;
    }

    static final class Random extends IdGenerationStrategy {
        private Random(boolean z) {
            super(z);
        }

        @Override // com.datadog.trace.api.IdGenerationStrategy
        protected long getNonZeroPositiveLong() {
            return ThreadLocalRandom.current().nextLong(0L, Long.MAX_VALUE) + 1;
        }
    }

    static final class Sequential extends IdGenerationStrategy {
        private final AtomicLong id;

        private Sequential(boolean z) {
            super(z);
            this.id = new AtomicLong(0L);
        }

        @Override // com.datadog.trace.api.IdGenerationStrategy
        public DDTraceId generateTraceId() {
            return DD64bTraceId.from(getNonZeroPositiveLong());
        }

        @Override // com.datadog.trace.api.IdGenerationStrategy
        protected long getNonZeroPositiveLong() {
            return this.id.incrementAndGet();
        }
    }

    static final class SRandom extends IdGenerationStrategy {
        private final SecureRandom secureRandom;

        private static ThrowingSupplier getSecureRandomSupplier() {
            if (Build.VERSION.SDK_INT >= 26) {
                return new ThrowingSupplier() { // from class: com.datadog.trace.api.IdGenerationStrategy$SRandom$$ExternalSyntheticLambda0
                    @Override // com.datadog.trace.api.IdGenerationStrategy.ThrowingSupplier
                    public final Object get() {
                        return SecureRandom.getInstanceStrong();
                    }
                };
            }
            return new ThrowingSupplier() { // from class: com.datadog.trace.api.IdGenerationStrategy$SRandom$$ExternalSyntheticLambda1
                @Override // com.datadog.trace.api.IdGenerationStrategy.ThrowingSupplier
                public final Object get() {
                    return new SecureRandom();
                }
            };
        }

        SRandom(boolean z) {
            this(z, getSecureRandomSupplier());
        }

        SRandom(boolean z, ThrowingSupplier throwingSupplier) {
            super(z);
            try {
                this.secureRandom = (SecureRandom) throwingSupplier.get();
            } catch (Throwable th) {
                throw new ExceptionInInitializerError(th);
            }
        }

        @Override // com.datadog.trace.api.IdGenerationStrategy
        protected long getNonZeroPositiveLong() {
            long jNextLong = this.secureRandom.nextLong();
            while (true) {
                long j = jNextLong & Long.MAX_VALUE;
                if (j != 0) {
                    return j;
                }
                jNextLong = this.secureRandom.nextLong();
            }
        }
    }
}
