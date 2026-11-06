package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import android.os.Build;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.base.Supplier;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.Factory {
    private boolean asyncCryptoFlagEnabled;
    private int asynchronousMode;
    private final Supplier callbackThreadSupplier;
    private final Context context;
    private final Supplier queueingThreadSupplier;

    public DefaultMediaCodecAdapterFactory() {
        this.asynchronousMode = 0;
        this.asyncCryptoFlagEnabled = false;
        this.context = null;
        this.callbackThreadSupplier = null;
        this.queueingThreadSupplier = null;
    }

    public DefaultMediaCodecAdapterFactory(Context context) {
        this(context, null, null);
    }

    public DefaultMediaCodecAdapterFactory(Context context, Supplier supplier, Supplier supplier2) {
        this.context = context;
        this.asynchronousMode = 0;
        this.asyncCryptoFlagEnabled = false;
        this.callbackThreadSupplier = supplier;
        this.queueingThreadSupplier = supplier2;
    }

    public DefaultMediaCodecAdapterFactory forceEnableAsynchronous() {
        this.asynchronousMode = 1;
        return this;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
    public MediaCodecAdapter createAdapter(MediaCodecAdapter.Configuration configuration) {
        AsynchronousMediaCodecAdapter.Factory factory;
        Supplier supplier;
        int i = this.asynchronousMode;
        if (i == 1 || (i == 0 && shouldUseAsynchronousAdapterInDefaultMode())) {
            int trackType = MimeTypes.getTrackType(configuration.format.sampleMimeType);
            Log.i("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + Util.getTrackTypeString(trackType));
            Supplier supplier2 = this.callbackThreadSupplier;
            if (supplier2 != null && (supplier = this.queueingThreadSupplier) != null) {
                factory = new AsynchronousMediaCodecAdapter.Factory(supplier2, supplier);
            } else {
                factory = new AsynchronousMediaCodecAdapter.Factory(trackType);
            }
            factory.experimentalSetAsyncCryptoFlagEnabled(this.asyncCryptoFlagEnabled);
            return factory.createAdapter(configuration);
        }
        return new SynchronousMediaCodecAdapter.Factory().createAdapter(configuration);
    }

    private boolean shouldUseAsynchronousAdapterInDefaultMode() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            return true;
        }
        Context context = this.context;
        return context != null && i >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen");
    }
}
