package cl.json.social;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public class MessengerShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public MessengerShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) {
        super.open(readableMap);
        openIntentChooser();
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.facebook.orca";
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return "market://details?id=com.facebook.orca";
    }
}
