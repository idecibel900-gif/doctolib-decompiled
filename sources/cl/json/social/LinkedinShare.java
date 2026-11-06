package cl.json.social;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes3.dex */
public class LinkedinShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public LinkedinShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) {
        super.open(readableMap);
        openIntentChooser();
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.linkedin.android";
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return "market://details?id=com.linkedin.android";
    }
}
