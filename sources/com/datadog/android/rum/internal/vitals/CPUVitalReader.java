package com.datadog.android.rum.internal.vitals;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CPUVitalReader implements VitalReader {
    public static final Companion Companion = new Companion(null);
    private static final File STAT_FILE = new File("/proc/self/stat");
    private final InternalLogger internalLogger;
    private final File statFile;

    public CPUVitalReader(File statFile, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(statFile, "statFile");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.statFile = statFile;
        this.internalLogger = internalLogger;
    }

    public /* synthetic */ CPUVitalReader(File file, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? STAT_FILE : file, internalLogger);
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalReader
    public Double readVitalData() {
        String textSafe$default;
        if (!FileExtKt.existsSafe(this.statFile, this.internalLogger) || !FileExtKt.canReadSafe(this.statFile, this.internalLogger) || (textSafe$default = FileExtKt.readTextSafe$default(this.statFile, null, this.internalLogger, 1, null)) == null) {
            return null;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) textSafe$default, new char[]{' '}, false, 0, 6, (Object) null);
        if (listSplit$default.size() > 13) {
            return StringsKt.toDoubleOrNull((String) listSplit$default.get(13));
        }
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
