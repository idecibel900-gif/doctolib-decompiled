package com.revenuecat.purchases.backup;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.SharedPreferencesBackupHelper;
import android.os.ParcelFileDescriptor;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/backup/RevenueCatBackupAgent;", "Landroid/app/backup/BackupAgentHelper;", "()V", "onBackup", "", "oldState", "Landroid/os/ParcelFileDescriptor;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/app/backup/BackupDataOutput;", "newState", "onCreate", "onRestore", "Landroid/app/backup/BackupDataInput;", "appVersionCode", "", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RevenueCatBackupAgent extends BackupAgentHelper {
    public static final String REVENUECAT_PREFS_FILE_NAME = "com_revenuecat_purchases_preferences";

    @Override // android.app.backup.BackupAgentHelper, android.app.backup.BackupAgent
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) throws IOException {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "RevenueCatBackupAgent: Initiating backup");
        }
        super.onBackup(oldState, data, newState);
    }

    @Override // android.app.backup.BackupAgent
    public void onRestore(BackupDataInput data, long appVersionCode, ParcelFileDescriptor newState) {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "RevenueCatBackupAgent: Initiating restoration");
        }
        super.onRestore(data, appVersionCode, newState);
    }

    @Override // android.app.backup.BackupAgent
    public void onCreate() {
        addHelper("revenuecat_prefs_backup", new SharedPreferencesBackupHelper(this, REVENUECAT_PREFS_FILE_NAME));
    }
}
