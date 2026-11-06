package expo.modules.updates;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.events.IUpdatesEventManager;
import expo.modules.updates.loader.LoaderTask;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.statemachine.UpdatesStateContext;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface IUpdatesController {
    Object checkForUpdate(Continuation continuation);

    Object fetchUpdate(Continuation continuation);

    String getBundleAssetName();

    UpdatesModuleConstants getConstantsForModule();

    IUpdatesEventManager getEventManager();

    Object getExtraParams(Continuation continuation);

    String getLaunchAssetFile();

    WeakReference getReactHost();

    ReloadScreenManager getReloadScreenManager();

    boolean isActiveController();

    void onDidCreateDevSupportManager(DevSupportManager devSupportManager);

    void onDidCreateReactInstance(ReactContext reactContext);

    void onEventListenerStartObserving();

    void onReactInstanceException(Exception exc);

    Object relaunchReactApplicationForModule(Continuation continuation);

    Object setExtraParam(String str, String str2, Continuation continuation);

    void setReactHost(WeakReference weakReference);

    void setUpdateRequestHeadersOverride(Map map);

    void setUpdateURLAndRequestHeadersOverride(UpdatesConfigurationOverride updatesConfigurationOverride);

    void start();

    public static final class UpdatesModuleConstants {
        private final UpdatesConfiguration.CheckAutomaticallyConfiguration checkOnLaunch;
        private final UpdateEntity embeddedUpdate;
        private final Exception emergencyLaunchException;
        private final UpdatesStateContext initialContext;
        private final boolean isEnabled;
        private final boolean isUsingEmbeddedAssets;
        private final Duration launchDuration;
        private final UpdateEntity launchedUpdate;
        private final Map localAssetFiles;
        private final Map requestHeaders;
        private final String runtimeVersion;
        private final boolean shouldDeferToNativeForAPIMethodAvailabilityInDevelopment;

        public /* synthetic */ UpdatesModuleConstants(UpdateEntity updateEntity, Duration duration, UpdateEntity updateEntity2, Exception exc, boolean z, boolean z2, String str, UpdatesConfiguration.CheckAutomaticallyConfiguration checkAutomaticallyConfiguration, Map map, Map map2, boolean z3, UpdatesStateContext updatesStateContext, DefaultConstructorMarker defaultConstructorMarker) {
            this(updateEntity, duration, updateEntity2, exc, z, z2, str, checkAutomaticallyConfiguration, map, map2, z3, updatesStateContext);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdatesModuleConstants)) {
                return false;
            }
            UpdatesModuleConstants updatesModuleConstants = (UpdatesModuleConstants) obj;
            return Intrinsics.areEqual(this.launchedUpdate, updatesModuleConstants.launchedUpdate) && Intrinsics.areEqual(this.launchDuration, updatesModuleConstants.launchDuration) && Intrinsics.areEqual(this.embeddedUpdate, updatesModuleConstants.embeddedUpdate) && Intrinsics.areEqual(this.emergencyLaunchException, updatesModuleConstants.emergencyLaunchException) && this.isEnabled == updatesModuleConstants.isEnabled && this.isUsingEmbeddedAssets == updatesModuleConstants.isUsingEmbeddedAssets && Intrinsics.areEqual(this.runtimeVersion, updatesModuleConstants.runtimeVersion) && this.checkOnLaunch == updatesModuleConstants.checkOnLaunch && Intrinsics.areEqual(this.requestHeaders, updatesModuleConstants.requestHeaders) && Intrinsics.areEqual(this.localAssetFiles, updatesModuleConstants.localAssetFiles) && this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment == updatesModuleConstants.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment && Intrinsics.areEqual(this.initialContext, updatesModuleConstants.initialContext);
        }

        public int hashCode() {
            UpdateEntity updateEntity = this.launchedUpdate;
            int iHashCode = (updateEntity == null ? 0 : updateEntity.hashCode()) * 31;
            Duration duration = this.launchDuration;
            int iM5416hashCodeimpl = (iHashCode + (duration == null ? 0 : Duration.m5416hashCodeimpl(duration.m5431unboximpl()))) * 31;
            UpdateEntity updateEntity2 = this.embeddedUpdate;
            int iHashCode2 = (iM5416hashCodeimpl + (updateEntity2 == null ? 0 : updateEntity2.hashCode())) * 31;
            Exception exc = this.emergencyLaunchException;
            int iHashCode3 = (((((iHashCode2 + (exc == null ? 0 : exc.hashCode())) * 31) + Boolean.hashCode(this.isEnabled)) * 31) + Boolean.hashCode(this.isUsingEmbeddedAssets)) * 31;
            String str = this.runtimeVersion;
            int iHashCode4 = (((((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.checkOnLaunch.hashCode()) * 31) + this.requestHeaders.hashCode()) * 31;
            Map map = this.localAssetFiles;
            return ((((iHashCode4 + (map != null ? map.hashCode() : 0)) * 31) + Boolean.hashCode(this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment)) * 31) + this.initialContext.hashCode();
        }

        public String toString() {
            return "UpdatesModuleConstants(launchedUpdate=" + this.launchedUpdate + ", launchDuration=" + this.launchDuration + ", embeddedUpdate=" + this.embeddedUpdate + ", emergencyLaunchException=" + this.emergencyLaunchException + ", isEnabled=" + this.isEnabled + ", isUsingEmbeddedAssets=" + this.isUsingEmbeddedAssets + ", runtimeVersion=" + this.runtimeVersion + ", checkOnLaunch=" + this.checkOnLaunch + ", requestHeaders=" + this.requestHeaders + ", localAssetFiles=" + this.localAssetFiles + ", shouldDeferToNativeForAPIMethodAvailabilityInDevelopment=" + this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment + ", initialContext=" + this.initialContext + ")";
        }

        private UpdatesModuleConstants(UpdateEntity updateEntity, Duration duration, UpdateEntity updateEntity2, Exception exc, boolean z, boolean z2, String str, UpdatesConfiguration.CheckAutomaticallyConfiguration checkOnLaunch, Map requestHeaders, Map map, boolean z3, UpdatesStateContext initialContext) {
            Intrinsics.checkNotNullParameter(checkOnLaunch, "checkOnLaunch");
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            Intrinsics.checkNotNullParameter(initialContext, "initialContext");
            this.launchedUpdate = updateEntity;
            this.launchDuration = duration;
            this.embeddedUpdate = updateEntity2;
            this.emergencyLaunchException = exc;
            this.isEnabled = z;
            this.isUsingEmbeddedAssets = z2;
            this.runtimeVersion = str;
            this.checkOnLaunch = checkOnLaunch;
            this.requestHeaders = requestHeaders;
            this.localAssetFiles = map;
            this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment = z3;
            this.initialContext = initialContext;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0045  */
        public final Map toModuleConstantsMap() {
            boolean z;
            UUID id;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z2 = true;
            linkedHashMap.put("isEmergencyLaunch", Boolean.valueOf(this.emergencyLaunchException != null));
            Exception exc = this.emergencyLaunchException;
            linkedHashMap.put("emergencyLaunchReason", exc != null ? exc.getMessage() : null);
            if (this.embeddedUpdate == null) {
                z = false;
            } else {
                UpdateEntity updateEntity = this.launchedUpdate;
                if ((updateEntity == null || (id = updateEntity.getId()) == null) ? false : id.equals(this.embeddedUpdate.getId())) {
                    z = true;
                } else {
                    z = false;
                }
            }
            linkedHashMap.put("isEmbeddedLaunch", Boolean.valueOf(z));
            linkedHashMap.put("isEnabled", Boolean.valueOf(this.isEnabled));
            Duration duration = this.launchDuration;
            linkedHashMap.put("launchDuration", duration != null ? Long.valueOf(Duration.m5427toLongimpl(duration.m5431unboximpl(), DurationUnit.MILLISECONDS)) : null);
            linkedHashMap.put("isUsingEmbeddedAssets", Boolean.valueOf(this.isUsingEmbeddedAssets));
            String str = this.runtimeVersion;
            if (str == null) {
                str = "";
            }
            linkedHashMap.put("runtimeVersion", str);
            linkedHashMap.put("checkAutomatically", this.checkOnLaunch.toJSString());
            String str2 = (String) this.requestHeaders.get("expo-channel-name");
            linkedHashMap.put("channel", str2 != null ? str2 : "");
            if (!this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment && !UpdatesPackage.INSTANCE.isUsingNativeDebug()) {
                z2 = false;
            }
            linkedHashMap.put("shouldDeferToNativeForAPIMethodAvailabilityInDevelopment", Boolean.valueOf(z2));
            linkedHashMap.put("initialContext", this.initialContext.getBundle());
            UpdateEntity updateEntity2 = this.launchedUpdate;
            if (updateEntity2 != null) {
                linkedHashMap.put("updateId", updateEntity2.getId().toString());
                linkedHashMap.put("commitTime", Long.valueOf(this.launchedUpdate.getCommitTime().getTime()));
                linkedHashMap.put("manifestString", this.launchedUpdate.getManifest().toString());
            }
            Map map = this.localAssetFiles;
            if (map != null) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (AssetEntity assetEntity : map.keySet()) {
                    if (assetEntity.getKey() != null) {
                        String key = assetEntity.getKey();
                        Intrinsics.checkNotNull(key);
                        Object obj = map.get(assetEntity);
                        Intrinsics.checkNotNull(obj);
                        linkedHashMap2.put(key, obj);
                    }
                }
                linkedHashMap.put("localAssets", linkedHashMap2);
            }
            return linkedHashMap;
        }
    }

    public static abstract class CheckForUpdateResult {
        private final Status status;

        private enum Status {
            NO_UPDATE_AVAILABLE,
            UPDATE_AVAILABLE,
            ROLL_BACK_TO_EMBEDDED,
            ERROR;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        }

        public /* synthetic */ CheckForUpdateResult(Status status, DefaultConstructorMarker defaultConstructorMarker) {
            this(status);
        }

        private CheckForUpdateResult(Status status) {
            this.status = status;
        }

        public static final class NoUpdateAvailable extends CheckForUpdateResult {
            private final LoaderTask.RemoteCheckResultNotAvailableReason reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NoUpdateAvailable(LoaderTask.RemoteCheckResultNotAvailableReason reason) {
                super(Status.NO_UPDATE_AVAILABLE, null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public final LoaderTask.RemoteCheckResultNotAvailableReason getReason() {
                return this.reason;
            }
        }

        public static final class UpdateAvailable extends CheckForUpdateResult {
            private final Update update;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateAvailable(Update update) {
                super(Status.UPDATE_AVAILABLE, null);
                Intrinsics.checkNotNullParameter(update, "update");
                this.update = update;
            }

            public final Update getUpdate() {
                return this.update;
            }
        }

        public static final class RollBackToEmbedded extends CheckForUpdateResult {
            private final Date commitTime;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RollBackToEmbedded(Date commitTime) {
                super(Status.ROLL_BACK_TO_EMBEDDED, null);
                Intrinsics.checkNotNullParameter(commitTime, "commitTime");
                this.commitTime = commitTime;
            }
        }

        public static final class ErrorResult extends CheckForUpdateResult {
            private final Exception error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ErrorResult(Exception error) {
                super(Status.ERROR, null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final Exception getError() {
                return this.error;
            }
        }
    }

    public static abstract class FetchUpdateResult {
        private final Status status;

        private enum Status {
            SUCCESS,
            FAILURE,
            ROLL_BACK_TO_EMBEDDED,
            ERROR;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        }

        public /* synthetic */ FetchUpdateResult(Status status, DefaultConstructorMarker defaultConstructorMarker) {
            this(status);
        }

        private FetchUpdateResult(Status status) {
            this.status = status;
        }

        public static final class Success extends FetchUpdateResult {
            private final UpdateEntity update;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(UpdateEntity update) {
                super(Status.SUCCESS, null);
                Intrinsics.checkNotNullParameter(update, "update");
                this.update = update;
            }

            public final UpdateEntity getUpdate() {
                return this.update;
            }
        }

        public static final class Failure extends FetchUpdateResult {
            public Failure() {
                super(Status.FAILURE, null);
            }
        }

        public static final class RollBackToEmbedded extends FetchUpdateResult {
            public RollBackToEmbedded() {
                super(Status.ROLL_BACK_TO_EMBEDDED, null);
            }
        }

        public static final class ErrorResult extends FetchUpdateResult {
            private final Exception error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ErrorResult(Exception error) {
                super(Status.ERROR, null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final Exception getError() {
                return this.error;
            }
        }
    }
}
