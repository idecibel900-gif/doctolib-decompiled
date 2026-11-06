package coil.util;

import coil.size.Dimension;
import coil.size.Size;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
final class LimitedFileDescriptorHardwareBitmapService implements HardwareBitmapService {
    public static final Companion Companion = new Companion(null);

    public LimitedFileDescriptorHardwareBitmapService(Logger logger) {
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        Dimension width = size.getWidth();
        if ((width instanceof Dimension.Pixels ? ((Dimension.Pixels) width).px : Integer.MAX_VALUE) <= 100) {
            return false;
        }
        Dimension height = size.getHeight();
        return (height instanceof Dimension.Pixels ? ((Dimension.Pixels) height).px : Integer.MAX_VALUE) > 100;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        return FileDescriptorCounter.INSTANCE.hasAvailableFileDescriptors(null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
