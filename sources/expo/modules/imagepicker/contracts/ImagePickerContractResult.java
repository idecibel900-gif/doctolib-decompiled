package expo.modules.imagepicker.contracts;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImagePickerContractResult {
    public /* synthetic */ ImagePickerContractResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final class Success extends ImagePickerContractResult {
        private final List data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(List data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final List getData() {
            return this.data;
        }
    }

    private ImagePickerContractResult() {
    }

    public static final class Cancelled extends ImagePickerContractResult {
        public static final Cancelled INSTANCE = new Cancelled();

        private Cancelled() {
            super(null);
        }
    }

    public static final class Error extends ImagePickerContractResult {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }
}
