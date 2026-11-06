package app.notifee.core.event;

import android.os.Bundle;
import app.notifee.core.KeepForSdk;
import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.utility.ObjectUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class BlockStateEvent {

    @KeepForSdk
    public static final int TYPE_APP_BLOCKED = 4;

    @KeepForSdk
    public static final int TYPE_CHANNEL_BLOCKED = 5;

    @KeepForSdk
    public static final int TYPE_CHANNEL_GROUP_BLOCKED = 6;
    private boolean blocked;
    private Bundle channelOrGroupBundle;
    private boolean completed = false;
    private MethodCallResult<Void> result;
    private int type;

    public BlockStateEvent(int i, Bundle bundle, boolean z, MethodCallResult<Void> methodCallResult) {
        this.type = i;
        this.result = methodCallResult;
        this.blocked = z;
        this.channelOrGroupBundle = bundle;
    }

    @KeepForSdk
    public void setCompletionResult() {
        if (this.completed) {
            return;
        }
        this.completed = true;
        this.result.onComplete(null, null);
    }

    @KeepForSdk
    public int getType() {
        return this.type;
    }

    @KeepForSdk
    public boolean isBlocked() {
        return this.blocked;
    }

    @KeepForSdk
    public Bundle getChannelOrGroupBundle() {
        return this.channelOrGroupBundle;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map.put("type", Integer.valueOf(this.type));
        int i = this.type;
        if (i == 5 || i == 6) {
            String str = i == 5 ? "channel" : "channelGroup";
            Bundle bundle = this.channelOrGroupBundle;
            if (bundle != null) {
                map2.put(str, ObjectUtils.bundleToMap(bundle));
            }
        }
        if (this.type == 4) {
            map2.put("blocked", Boolean.valueOf(isBlocked()));
        }
        map.put("detail", map2);
        return map;
    }
}
