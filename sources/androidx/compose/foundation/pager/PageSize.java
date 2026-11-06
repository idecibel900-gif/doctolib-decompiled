package androidx.compose.foundation.pager;

import androidx.compose.ui.unit.Density;

/* JADX INFO: loaded from: classes.dex */
public interface PageSize {
    int calculateMainAxisPageSize(Density density, int i, int i2);

    public static final class Fill implements PageSize {
        public static final Fill INSTANCE = new Fill();

        @Override // androidx.compose.foundation.pager.PageSize
        public int calculateMainAxisPageSize(Density density, int i, int i2) {
            return i;
        }

        private Fill() {
        }
    }
}
