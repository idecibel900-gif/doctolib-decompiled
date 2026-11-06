package coil.util;

import coil.size.Size;

/* JADX INFO: loaded from: classes3.dex */
final class ImmutableHardwareBitmapService implements HardwareBitmapService {
    private final boolean allowHardware;

    public ImmutableHardwareBitmapService(boolean z) {
        this.allowHardware = z;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        return this.allowHardware;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        return this.allowHardware;
    }
}
