package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppLocalesMetadataHolderService extends Service {

    private static class Api24Impl {
        static int getDisabledComponentFlag() {
            return IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
        }
    }

    public static ServiceInfo getServiceInfo(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), Api24Impl.getDisabledComponentFlag() | 128);
    }
}
