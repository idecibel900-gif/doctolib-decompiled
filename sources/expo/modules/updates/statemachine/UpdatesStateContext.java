package expo.modules.updates.statemachine;

import android.os.Bundle;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdatesStateContext {
    public static final Companion Companion = new Companion(null);
    private static final Lazy DATE_FORMATTER$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.statemachine.UpdatesStateContext$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return UpdatesStateContext.DATE_FORMATTER_delegate$lambda$10();
        }
    });
    private final UpdatesStateError checkError;
    private final UpdatesStateError downloadError;
    private final Date downloadFinishTime;
    private final double downloadProgress;
    private final Date downloadStartTime;
    private final JSONObject downloadedManifest;
    private final boolean isChecking;
    private final boolean isDownloading;
    private final boolean isRestarting;
    private final boolean isStartupProcedureRunning;
    private final boolean isUpdateAvailable;
    private final boolean isUpdatePending;
    private final Date lastCheckForUpdateTime;
    private final JSONObject latestManifest;
    private final int restartCount;
    private final UpdatesStateContextRollback rollback;
    private final int sequenceNumber;

    private UpdatesStateContext(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, JSONObject jSONObject, JSONObject jSONObject2, UpdatesStateContextRollback updatesStateContextRollback, UpdatesStateError updatesStateError, UpdatesStateError updatesStateError2, double d, Date date, int i2, Date date2, Date date3) {
        this.isStartupProcedureRunning = z;
        this.isUpdateAvailable = z2;
        this.isUpdatePending = z3;
        this.isChecking = z4;
        this.isDownloading = z5;
        this.isRestarting = z6;
        this.restartCount = i;
        this.latestManifest = jSONObject;
        this.downloadedManifest = jSONObject2;
        this.rollback = updatesStateContextRollback;
        this.checkError = updatesStateError;
        this.downloadError = updatesStateError2;
        this.downloadProgress = d;
        this.lastCheckForUpdateTime = date;
        this.sequenceNumber = i2;
        this.downloadStartTime = date2;
        this.downloadFinishTime = date3;
    }

    /* synthetic */ UpdatesStateContext(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, JSONObject jSONObject, JSONObject jSONObject2, UpdatesStateContextRollback updatesStateContextRollback, UpdatesStateError updatesStateError, UpdatesStateError updatesStateError2, double d, Date date, int i2, Date date2, Date date3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? false : z4, (i3 & 16) != 0 ? false : z5, (i3 & 32) != 0 ? false : z6, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? null : jSONObject, (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : jSONObject2, (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : updatesStateContextRollback, (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : updatesStateError, (i3 & 2048) != 0 ? null : updatesStateError2, (i3 & 4096) != 0 ? 0.0d : d, (i3 & 8192) != 0 ? null : date, i2, (32768 & i3) != 0 ? null : date2, (i3 & 65536) != 0 ? null : date3);
    }

    public /* synthetic */ UpdatesStateContext(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, JSONObject jSONObject, JSONObject jSONObject2, UpdatesStateContextRollback updatesStateContextRollback, UpdatesStateError updatesStateError, UpdatesStateError updatesStateError2, double d, Date date, Date date2, Date date3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? false : z4, (i2 & 16) != 0 ? false : z5, (i2 & 32) != 0 ? false : z6, (i2 & 64) == 0 ? i : 0, (i2 & 128) != 0 ? null : jSONObject, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : jSONObject2, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : updatesStateContextRollback, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : updatesStateError, (i2 & 2048) != 0 ? null : updatesStateError2, (i2 & 4096) != 0 ? 0.0d : d, (i2 & 8192) != 0 ? null : date, (i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : date2, (i2 & 32768) != 0 ? null : date3);
    }

    public UpdatesStateContext(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, JSONObject jSONObject, JSONObject jSONObject2, UpdatesStateContextRollback updatesStateContextRollback, UpdatesStateError updatesStateError, UpdatesStateError updatesStateError2, double d, Date date, Date date2, Date date3) {
        this(z, z2, z3, z4, z5, z6, i, jSONObject, jSONObject2, updatesStateContextRollback, updatesStateError, updatesStateError2, d, date, 0, date2, date3);
    }

    public final UpdatesStateContext copyAndIncrementSequenceNumber(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, double d, boolean z6, int i, JSONObject jSONObject, JSONObject jSONObject2, UpdatesStateContextRollback updatesStateContextRollback, UpdatesStateError updatesStateError, UpdatesStateError updatesStateError2, Date date, Date date2, Date date3) {
        return new UpdatesStateContext(z, z2, z3, z4, z5, z6, i, jSONObject, jSONObject2, updatesStateContextRollback, updatesStateError, updatesStateError2, d, date, this.sequenceNumber + 1, date2, date3);
    }

    public final UpdatesStateContext resetCopyWithIncrementedRestartCountAndSequenceNumber() {
        return new UpdatesStateContext(false, false, false, false, false, false, this.restartCount + 1, null, null, null, null, null, 0.0d, null, this.sequenceNumber + 1, null, null, 114623, null);
    }

    public final Map getJson() {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("isStartupProcedureRunning", Boolean.valueOf(this.isStartupProcedureRunning)), TuplesKt.to("isUpdateAvailable", Boolean.valueOf(this.isUpdateAvailable)), TuplesKt.to("isUpdatePending", Boolean.valueOf(this.isUpdatePending)), TuplesKt.to("isChecking", Boolean.valueOf(this.isChecking)), TuplesKt.to("isDownloading", Boolean.valueOf(this.isDownloading)), TuplesKt.to("isRestarting", Boolean.valueOf(this.isRestarting)), TuplesKt.to("restartCount", Integer.valueOf(this.restartCount)), TuplesKt.to("downloadProgress", Double.valueOf(this.downloadProgress)), TuplesKt.to("sequenceNumber", Integer.valueOf(this.sequenceNumber)));
        JSONObject jSONObject = this.latestManifest;
        if (jSONObject != null) {
            mapMutableMapOf.put("latestManifest", jSONObject);
        }
        JSONObject jSONObject2 = this.downloadedManifest;
        if (jSONObject2 != null) {
            mapMutableMapOf.put("downloadedManifest", jSONObject2);
        }
        UpdatesStateContextRollback updatesStateContextRollback = this.rollback;
        if (updatesStateContextRollback != null) {
            mapMutableMapOf.put("rollback", updatesStateContextRollback.getJson());
        }
        UpdatesStateError updatesStateError = this.checkError;
        if (updatesStateError != null) {
            mapMutableMapOf.put("checkError", updatesStateError.getJson());
        }
        UpdatesStateError updatesStateError2 = this.downloadError;
        if (updatesStateError2 != null) {
            mapMutableMapOf.put("downloadError", updatesStateError2.getJson());
        }
        Date date = this.lastCheckForUpdateTime;
        if (date != null) {
            mapMutableMapOf.put("lastCheckForUpdateTime", date);
        }
        Date date2 = this.downloadStartTime;
        if (date2 != null) {
            mapMutableMapOf.put("downloadStartTime", Long.valueOf(date2.getTime()));
        }
        Date date3 = this.downloadFinishTime;
        if (date3 != null) {
            mapMutableMapOf.put("downloadFinishTime", Long.valueOf(date3.getTime()));
        }
        return mapMutableMapOf;
    }

    public final Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isStartupProcedureRunning", this.isStartupProcedureRunning);
        bundle.putBoolean("isUpdateAvailable", this.isUpdateAvailable);
        bundle.putBoolean("isUpdatePending", this.isUpdatePending);
        bundle.putBoolean("isChecking", this.isChecking);
        bundle.putBoolean("isDownloading", this.isDownloading);
        bundle.putBoolean("isRestarting", this.isRestarting);
        bundle.putInt("restartCount", this.restartCount);
        bundle.putInt("sequenceNumber", this.sequenceNumber);
        bundle.putDouble("downloadProgress", this.downloadProgress);
        JSONObject jSONObject = this.latestManifest;
        if (jSONObject != null) {
            bundle.putString("latestManifestString", jSONObject.toString());
        }
        JSONObject jSONObject2 = this.downloadedManifest;
        if (jSONObject2 != null) {
            bundle.putString("downloadedManifestString", jSONObject2.toString());
        }
        if (this.rollback != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("commitTime", this.rollback.getCommitTimeString());
            Unit unit = Unit.INSTANCE;
            bundle.putBundle("rollback", bundle2);
        }
        if (this.checkError != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("message", this.checkError.getMessage());
            bundle.putBundle("checkError", bundle3);
        }
        if (this.downloadError != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putString("message", this.downloadError.getMessage());
            bundle.putBundle("downloadError", bundle4);
        }
        if (this.lastCheckForUpdateTime != null) {
            bundle.putString("lastCheckForUpdateTimeString", Companion.getDATE_FORMATTER().format(this.lastCheckForUpdateTime));
        }
        return bundle;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SimpleDateFormat getDATE_FORMATTER() {
            return (SimpleDateFormat) UpdatesStateContext.DATE_FORMATTER$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleDateFormat DATE_FORMATTER_delegate$lambda$10() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
