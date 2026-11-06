package com.opentok.android;

/* JADX INFO: loaded from: classes4.dex */
public class VideoUtils {

    public static class Size {
        public int height;
        public int width;

        public Size() {
        }

        public final boolean equals(int i, int i2) {
            return this.width == i && this.height == i2;
        }

        public final void set(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Size)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            Size size = (Size) obj;
            return equals(size.width, size.height);
        }

        public final void set(Size size) {
            this.width = size.width;
            this.height = size.height;
        }

        public Size(Size size) {
            this.width = size.width;
            this.height = size.height;
        }
    }
}
