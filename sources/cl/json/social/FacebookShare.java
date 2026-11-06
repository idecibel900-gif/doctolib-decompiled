package cl.json.social;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public class FacebookShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return null;
    }

    public FacebookShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) {
        super.open(readableMap);
        openIntentChooser();
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.facebook.katana";
    }

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return "https://www.facebook.com/sharer/sharer.php?u={url}";
    }
}
