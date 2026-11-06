package expo.modules.updates;

import android.os.Bundle;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.updates.logging.UpdatesLogEntry;
import expo.modules.updates.logging.UpdatesLogReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
final class UpdatesModule$Companion$readLogEntries$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ File $filesDirectory;
    final /* synthetic */ long $maxAge;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdatesModule$Companion$readLogEntries$2(File file, long j, Continuation continuation) {
        super(2, continuation);
        this.$filesDirectory = file;
        this.$maxAge = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UpdatesModule$Companion$readLogEntries$2(this.$filesDirectory, this.$maxAge, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UpdatesModule$Companion$readLogEntries$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List logEntries = new UpdatesLogReader(this.$filesDirectory).getLogEntries(new Date(new Date().getTime() - this.$maxAge));
        ArrayList<UpdatesLogEntry> arrayList = new ArrayList();
        Iterator it = logEntries.iterator();
        while (it.hasNext()) {
            UpdatesLogEntry updatesLogEntryCreate = UpdatesLogEntry.Companion.create((String) it.next());
            if (updatesLogEntryCreate != null) {
                arrayList.add(updatesLogEntryCreate);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (UpdatesLogEntry updatesLogEntry : arrayList) {
            Bundle bundle = new Bundle();
            bundle.putLong(DiagnosticsEntry.TIMESTAMP_KEY, updatesLogEntry.getTimestamp());
            bundle.putString("message", updatesLogEntry.getMessage());
            bundle.putString(ResponseTypeValues.CODE, updatesLogEntry.getCode());
            bundle.putString("level", updatesLogEntry.getLevel());
            if (updatesLogEntry.getUpdateId() != null) {
                bundle.putString("updateId", updatesLogEntry.getUpdateId());
            }
            if (updatesLogEntry.getAssetId() != null) {
                bundle.putString("assetId", updatesLogEntry.getAssetId());
            }
            if (updatesLogEntry.getStacktrace() != null) {
                bundle.putStringArray("stacktrace", (String[]) updatesLogEntry.getStacktrace().toArray(new String[0]));
            }
            arrayList2.add(bundle);
        }
        return arrayList2;
    }
}
