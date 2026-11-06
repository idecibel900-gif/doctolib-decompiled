package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityResultCaller {
    ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback);
}
