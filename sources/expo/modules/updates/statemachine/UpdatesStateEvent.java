package expo.modules.updates.statemachine;

import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UpdatesStateEvent {
    private final UpdatesStateEventType type;

    public /* synthetic */ UpdatesStateEvent(UpdatesStateEventType updatesStateEventType, DefaultConstructorMarker defaultConstructorMarker) {
        this(updatesStateEventType);
    }

    public static final class StartStartup extends UpdatesStateEvent {
        public StartStartup() {
            super(UpdatesStateEventType.StartStartup, null);
        }
    }

    private UpdatesStateEvent(UpdatesStateEventType updatesStateEventType) {
        this.type = updatesStateEventType;
    }

    public final UpdatesStateEventType getType() {
        return this.type;
    }

    public static final class EndStartup extends UpdatesStateEvent {
        public EndStartup() {
            super(UpdatesStateEventType.EndStartup, null);
        }
    }

    public static final class Check extends UpdatesStateEvent {
        public Check() {
            super(UpdatesStateEventType.Check, null);
        }
    }

    public static final class CheckCompleteWithUpdate extends UpdatesStateEvent {
        private final JSONObject manifest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckCompleteWithUpdate(JSONObject manifest) {
            super(UpdatesStateEventType.CheckCompleteAvailable, null);
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            this.manifest = manifest;
        }

        public final JSONObject getManifest() {
            return this.manifest;
        }
    }

    public static final class CheckCompleteWithRollback extends UpdatesStateEvent {
        private final Date commitTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckCompleteWithRollback(Date commitTime) {
            super(UpdatesStateEventType.CheckCompleteAvailable, null);
            Intrinsics.checkNotNullParameter(commitTime, "commitTime");
            this.commitTime = commitTime;
        }

        public final Date getCommitTime() {
            return this.commitTime;
        }
    }

    public static final class CheckCompleteUnavailable extends UpdatesStateEvent {
        public CheckCompleteUnavailable() {
            super(UpdatesStateEventType.CheckCompleteUnavailable, null);
        }
    }

    public static final class CheckError extends UpdatesStateEvent {
        private final String errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckError(String errorMessage) {
            super(UpdatesStateEventType.CheckError, null);
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public final UpdatesStateError getError() {
            return new UpdatesStateError(this.errorMessage);
        }
    }

    public static final class Download extends UpdatesStateEvent {
        public Download() {
            super(UpdatesStateEventType.Download, null);
        }
    }

    public static final class DownloadProgress extends UpdatesStateEvent {
        private final double progress;

        public DownloadProgress(double d) {
            super(UpdatesStateEventType.DownloadProgress, null);
            this.progress = d;
        }

        public final double getProgress() {
            return this.progress;
        }
    }

    public static final class DownloadComplete extends UpdatesStateEvent {
        public DownloadComplete() {
            super(UpdatesStateEventType.DownloadComplete, null);
        }
    }

    public static final class DownloadCompleteWithUpdate extends UpdatesStateEvent {
        private final JSONObject manifest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadCompleteWithUpdate(JSONObject manifest) {
            super(UpdatesStateEventType.DownloadComplete, null);
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            this.manifest = manifest;
        }

        public final JSONObject getManifest() {
            return this.manifest;
        }
    }

    public static final class DownloadCompleteWithRollback extends UpdatesStateEvent {
        public DownloadCompleteWithRollback() {
            super(UpdatesStateEventType.DownloadComplete, null);
        }
    }

    public static final class DownloadError extends UpdatesStateEvent {
        private final String errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadError(String errorMessage) {
            super(UpdatesStateEventType.DownloadError, null);
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public final UpdatesStateError getError() {
            return new UpdatesStateError(this.errorMessage);
        }
    }

    public static final class Restart extends UpdatesStateEvent {
        public Restart() {
            super(UpdatesStateEventType.Restart, null);
        }
    }
}
