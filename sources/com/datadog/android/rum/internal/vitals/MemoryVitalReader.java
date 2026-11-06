package com.datadog.android.rum.internal.vitals;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class MemoryVitalReader implements VitalReader {
    public static final Companion Companion = new Companion(null);
    private static final File STATUS_FILE = new File("/proc/self/status");
    private static final Regex VM_RSS_REGEX = new Regex("VmRSS:\\s+(\\d+) kB");
    private final InternalLogger internalLogger;
    private final File statusFile;

    public MemoryVitalReader(File statusFile, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(statusFile, "statusFile");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.statusFile = statusFile;
        this.internalLogger = internalLogger;
    }

    public /* synthetic */ MemoryVitalReader(File file, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? STATUS_FILE : file, internalLogger);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0061  */
    @Override // com.datadog.android.rum.internal.vitals.VitalReader
    public Double readVitalData() {
        Double doubleOrNull;
        List groupValues;
        if (!FileExtKt.existsSafe(this.statusFile, this.internalLogger) || !FileExtKt.canReadSafe(this.statusFile, this.internalLogger)) {
            return null;
        }
        List linesSafe$default = FileExtKt.readLinesSafe$default(this.statusFile, null, this.internalLogger, 1, null);
        if (linesSafe$default != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = linesSafe$default.iterator();
            while (it.hasNext()) {
                MatchResult matchResultMatchEntire = VM_RSS_REGEX.matchEntire((String) it.next());
                String str = (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1);
                if (str != null) {
                    arrayList.add(str);
                }
            }
            String str2 = (String) CollectionsKt.firstOrNull((List) arrayList);
            if (str2 != null) {
                doubleOrNull = StringsKt.toDoubleOrNull(str2);
            } else {
                doubleOrNull = null;
            }
        } else {
            doubleOrNull = null;
        }
        if (doubleOrNull == null) {
            return null;
        }
        return Double.valueOf(doubleOrNull.doubleValue() * ((double) 1000));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
