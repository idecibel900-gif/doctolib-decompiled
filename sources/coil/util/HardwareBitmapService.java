package coil.util;

import coil.size.Size;

/* JADX INFO: loaded from: classes3.dex */
public interface HardwareBitmapService {
    boolean allowHardwareMainThread(Size size);

    boolean allowHardwareWorkerThread();
}
