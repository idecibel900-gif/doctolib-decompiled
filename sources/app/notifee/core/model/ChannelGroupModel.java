package app.notifee.core.model;

import android.os.Bundle;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ChannelGroupModel {
    private final Bundle mChannelGroupBundle;

    private ChannelGroupModel(Bundle bundle) {
        this.mChannelGroupBundle = bundle;
    }

    public static ChannelGroupModel fromBundle(Bundle bundle) {
        return new ChannelGroupModel(bundle);
    }

    public String getId() {
        String string = this.mChannelGroupBundle.getString(DiagnosticsEntry.ID_KEY);
        Objects.requireNonNull(string);
        return string;
    }

    public String getName() {
        String string = this.mChannelGroupBundle.getString("name");
        Objects.requireNonNull(string);
        return string;
    }

    public String getDescription() {
        return this.mChannelGroupBundle.getString(b.c);
    }
}
