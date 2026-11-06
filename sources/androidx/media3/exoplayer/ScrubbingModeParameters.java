package androidx.media3.exoplayer;

import com.google.common.collect.ImmutableSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ScrubbingModeParameters {
    public static final ScrubbingModeParameters DEFAULT = new Builder().build();
    public final boolean allowSkippingMediaCodecFlush;
    public final ImmutableSet disabledTrackTypes;
    public final Double fractionalSeekToleranceAfter;
    public final Double fractionalSeekToleranceBefore;
    public final boolean isMediaCodecFlushEnabled;
    public final boolean shouldEnableDynamicScheduling;
    public final boolean shouldIncreaseCodecOperatingRate;
    public final boolean useDecodeOnlyFlag;

    public static final class Builder {
        private Double fractionalSeekToleranceAfter;
        private Double fractionalSeekToleranceBefore;
        private ImmutableSet disabledTrackTypes = ImmutableSet.of((Object) 1, (Object) 5);
        private boolean shouldIncreaseCodecOperatingRate = true;
        private boolean allowSkippingMediaCodecFlush = true;
        private boolean shouldEnableDynamicScheduling = true;
        private boolean useDecodeOnlyFlag = true;

        public Builder setShouldIncreaseCodecOperatingRate(boolean z) {
            this.shouldIncreaseCodecOperatingRate = z;
            return this;
        }

        public Builder setShouldEnableDynamicScheduling(boolean z) {
            this.shouldEnableDynamicScheduling = z;
            return this;
        }

        public Builder setAllowSkippingMediaCodecFlush(boolean z) {
            this.allowSkippingMediaCodecFlush = z;
            return this;
        }

        public Builder setUseDecodeOnlyFlag(boolean z) {
            this.useDecodeOnlyFlag = z;
            return this;
        }

        public ScrubbingModeParameters build() {
            return new ScrubbingModeParameters(this);
        }
    }

    private ScrubbingModeParameters(Builder builder) {
        this.disabledTrackTypes = builder.disabledTrackTypes;
        this.fractionalSeekToleranceBefore = builder.fractionalSeekToleranceBefore;
        this.fractionalSeekToleranceAfter = builder.fractionalSeekToleranceAfter;
        this.shouldIncreaseCodecOperatingRate = builder.shouldIncreaseCodecOperatingRate;
        this.isMediaCodecFlushEnabled = !builder.allowSkippingMediaCodecFlush;
        this.allowSkippingMediaCodecFlush = builder.allowSkippingMediaCodecFlush;
        this.shouldEnableDynamicScheduling = builder.shouldEnableDynamicScheduling;
        this.useDecodeOnlyFlag = builder.useDecodeOnlyFlag;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ScrubbingModeParameters)) {
            return false;
        }
        ScrubbingModeParameters scrubbingModeParameters = (ScrubbingModeParameters) obj;
        return this.disabledTrackTypes.equals(scrubbingModeParameters.disabledTrackTypes) && this.allowSkippingMediaCodecFlush == scrubbingModeParameters.allowSkippingMediaCodecFlush && Objects.equals(this.fractionalSeekToleranceBefore, scrubbingModeParameters.fractionalSeekToleranceBefore) && Objects.equals(this.fractionalSeekToleranceAfter, scrubbingModeParameters.fractionalSeekToleranceAfter) && this.shouldIncreaseCodecOperatingRate == scrubbingModeParameters.shouldIncreaseCodecOperatingRate && this.shouldEnableDynamicScheduling == scrubbingModeParameters.shouldEnableDynamicScheduling && this.useDecodeOnlyFlag == scrubbingModeParameters.useDecodeOnlyFlag;
    }

    public int hashCode() {
        return Objects.hash(this.disabledTrackTypes, this.fractionalSeekToleranceBefore, this.fractionalSeekToleranceAfter, Boolean.valueOf(this.shouldIncreaseCodecOperatingRate), Boolean.valueOf(this.allowSkippingMediaCodecFlush), Boolean.valueOf(this.shouldEnableDynamicScheduling), Boolean.valueOf(this.useDecodeOnlyFlag));
    }
}
