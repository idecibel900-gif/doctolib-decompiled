package cl.json.social;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public class PinterestShare extends SingleShareIntent {
    public PinterestShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) {
        super.open(readableMap);
        openIntentChooser();
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.pinterest";
    }

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return "https://pinterest.com/pin/create/button/?url={url}&media=$media&description={message}";
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return "market://details?id=com.pinterest";
    }
}
