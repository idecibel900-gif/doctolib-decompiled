package expo.modules.updates.errorrecovery;

import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.launcher.Launcher;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
public interface ErrorRecoveryDelegate {

    public enum RemoteLoadStatus {
        IDLE,
        NEW_UPDATE_LOADING,
        NEW_UPDATE_LOADED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    UpdatesConfiguration.CheckAutomaticallyConfiguration getCheckAutomaticallyConfiguration();

    int getLaunchedUpdateSuccessfulLaunchCount();

    RemoteLoadStatus getRemoteLoadStatus();

    void loadRemoteUpdate();

    void markFailedLaunchForLaunchedUpdate();

    void markSuccessfulLaunchForLaunchedUpdate();

    void relaunch(Launcher.LauncherCallback launcherCallback);

    void throwException(Exception exc);
}
