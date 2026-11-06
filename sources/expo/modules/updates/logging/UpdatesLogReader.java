package expo.modules.updates.logging;

import expo.modules.core.logging.PersistentFileLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdatesLogReader {
    public static final Companion Companion = new Companion(null);
    private final PersistentFileLog persistentLog;

    public UpdatesLogReader(File filesDirectory) {
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        this.persistentLog = new PersistentFileLog("dev.expo.updates", filesDirectory);
    }

    public static /* synthetic */ void purgeLogEntries$default(UpdatesLogReader updatesLogReader, Date date, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            date = new Date(new Date().getTime() - 86400000);
        }
        updatesLogReader.purgeLogEntries(date, function1);
    }

    public final void purgeLogEntries(Date olderThan, Function1 completionHandler) {
        Intrinsics.checkNotNullParameter(olderThan, "olderThan");
        Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
        final long jEpochFromDateOrOneDayAgo = epochFromDateOrOneDayAgo(olderThan);
        this.persistentLog.purgeEntriesNotMatchingFilter(new Function1() { // from class: expo.modules.updates.logging.UpdatesLogReader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UpdatesLogReader.purgeLogEntries$lambda$0(this.f$0, jEpochFromDateOrOneDayAgo, (String) obj));
            }
        }, completionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean purgeLogEntries$lambda$0(UpdatesLogReader updatesLogReader, long j, String entryString) {
        Intrinsics.checkNotNullParameter(entryString, "entryString");
        return updatesLogReader.isEntryStringLaterThanTimestamp(entryString, j);
    }

    public final List getLogEntries(Date newerThan) {
        Intrinsics.checkNotNullParameter(newerThan, "newerThan");
        long jEpochFromDateOrOneDayAgo = epochFromDateOrOneDayAgo(newerThan);
        List entries = this.persistentLog.readEntries();
        ArrayList arrayList = new ArrayList();
        for (Object obj : entries) {
            if (isEntryStringLaterThanTimestamp((String) obj, jEpochFromDateOrOneDayAgo)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean isEntryStringLaterThanTimestamp(String str, long j) {
        UpdatesLogEntry updatesLogEntryCreate = UpdatesLogEntry.Companion.create(str);
        return updatesLogEntryCreate != null && updatesLogEntryCreate.getTimestamp() >= j;
    }

    private final long epochFromDateOrOneDayAgo(Date date) {
        return Long.max(date.getTime(), new Date().getTime() - 86400000);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
