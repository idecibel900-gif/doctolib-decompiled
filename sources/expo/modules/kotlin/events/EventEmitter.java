package expo.modules.kotlin.events;

import android.view.View;
import com.facebook.react.bridge.WritableMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface EventEmitter extends expo.modules.core.interfaces.services.EventEmitter {
    void emit(View view, String str, WritableMap writableMap, Short sh);

    void emit(String str, Map map);
}
