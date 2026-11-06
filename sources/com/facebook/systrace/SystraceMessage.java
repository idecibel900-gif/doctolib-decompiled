package com.facebook.systrace;

import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SystraceMessage {
    public static boolean INCLUDE_ARGS;
    public static final SystraceMessage INSTANCE = new SystraceMessage();

    public static abstract class Builder {
        public abstract Builder arg(String str, int i);

        public abstract Builder arg(String str, Object obj);

        public abstract void flush();
    }

    private SystraceMessage() {
    }

    public static final Builder beginSection(long j, String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        return new StartSectionBuilder(j, sectionName);
    }

    public static final Builder endSection(long j) {
        return new EndSectionBuilder(j);
    }

    private static final class StartSectionBuilder extends Builder {
        private final List args;
        private final String sectionName;
        private final long tag;

        public StartSectionBuilder(long j, String sectionName) {
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            this.tag = j;
            this.sectionName = sectionName;
            this.args = new ArrayList();
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public void flush() {
            String str;
            long j = this.tag;
            String str2 = this.sectionName;
            if (SystraceMessage.INCLUDE_ARGS && !this.args.isEmpty()) {
                str = " (" + HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0.m(", ", this.args) + ")";
            } else {
                str = "";
            }
            Systrace.beginSection(j, str2 + str);
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            addArg(key, value.toString());
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            addArg(key, String.valueOf(i));
            return this;
        }

        private final void addArg(String str, String str2) {
            this.args.add(str + ": " + str2);
        }
    }

    private static final class EndSectionBuilder extends Builder {
        private final long tag;

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this;
        }

        public EndSectionBuilder(long j) {
            this.tag = j;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public void flush() {
            Systrace.endSection(this.tag);
        }
    }
}
