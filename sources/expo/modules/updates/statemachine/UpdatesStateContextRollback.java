package expo.modules.updates.statemachine;

import java.util.Date;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdatesStateContextRollback {
    private final Date commitTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdatesStateContextRollback) && Intrinsics.areEqual(this.commitTime, ((UpdatesStateContextRollback) obj).commitTime);
    }

    public int hashCode() {
        return this.commitTime.hashCode();
    }

    public String toString() {
        return "UpdatesStateContextRollback(commitTime=" + this.commitTime + ")";
    }

    public UpdatesStateContextRollback(Date commitTime) {
        Intrinsics.checkNotNullParameter(commitTime, "commitTime");
        this.commitTime = commitTime;
    }

    public final String getCommitTimeString() {
        String str = UpdatesStateContext.Companion.getDATE_FORMATTER().format(this.commitTime);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final Map getJson() {
        return MapsKt.mapOf(TuplesKt.to("commitTime", getCommitTimeString()));
    }
}
