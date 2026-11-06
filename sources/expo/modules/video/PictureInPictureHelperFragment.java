package expo.modules.video;

import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class PictureInPictureHelperFragment extends Fragment {
    private final String id;
    private final WeakReference listener;

    public PictureInPictureHelperFragment(PictureInPictureFragmentListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.id = PictureInPictureHelperFragment.class.getSimpleName() + "_" + UUID.randomUUID();
        this.listener = new WeakReference(listener);
    }

    public final String getId() {
        return this.id;
    }

    public final void release() {
        this.listener.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
        if (z) {
            PictureInPictureFragmentListener pictureInPictureFragmentListener = (PictureInPictureFragmentListener) this.listener.get();
            if (pictureInPictureFragmentListener != null) {
                pictureInPictureFragmentListener.onPictureInPictureStart();
                return;
            }
            return;
        }
        PictureInPictureFragmentListener pictureInPictureFragmentListener2 = (PictureInPictureFragmentListener) this.listener.get();
        if (pictureInPictureFragmentListener2 != null) {
            pictureInPictureFragmentListener2.onPictureInPictureStop();
        }
    }
}
