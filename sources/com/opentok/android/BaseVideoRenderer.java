package com.opentok.android;

import android.view.View;
import com.opentok.otc.SWIGTYPE_p_otc_video_frame;
import com.opentok.otc.b;
import com.opentok.otc.c;
import com.opentok.otc.d;
import com.opentok.otc.k;
import com.opentok.otc.opentokJNI;
import com.opentok.otc.otc_video_frame_format;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseVideoRenderer {
    public static final String STYLE_VIDEO_FILL = "STYLE_VIDEO_FILL";
    public static final String STYLE_VIDEO_FIT = "STYLE_VIDEO_FIT";
    public static final String STYLE_VIDEO_SCALE = "STYLE_VIDEO_SCALE";

    public final class Frame {
        protected ByteBuffer buffer;
        protected otc_video_frame_format format;
        protected int height;
        protected long internalBuffer;
        protected byte[] metadata;
        protected boolean mirrored;
        swig_otc_video_frame otcFrame;
        protected int uvStride;
        protected int width;
        protected int yStride;

        protected Frame() {
        }

        private native void convert_in_place(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2);

        private native long copy_video_frame(long j);

        private native ByteBuffer get_frame_byte_buffer(long j);

        private native ByteBuffer get_frame_plane_byte_buffer(long j, int i);

        public void convertInPlace(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2) {
            convert_in_place(this.otcFrame.getCPtr(), byteBuffer, byteBuffer2, byteBuffer3, i, i2);
        }

        void copyOtcFrame(long j, Boolean bool) {
            swig_otc_video_frame swig_otc_video_frameVar = new swig_otc_video_frame(copy_video_frame(j));
            this.otcFrame = swig_otc_video_frameVar;
            this.buffer = get_frame_byte_buffer(swig_otc_video_frameVar.getCPtr());
            this.format = d.a(this.otcFrame);
            this.height = d.b(this.otcFrame);
            this.width = d.c(this.otcFrame);
            this.yStride = d.b(this.otcFrame, k.c);
            this.uvStride = d.b(this.otcFrame, k.d);
            if (bool != null) {
                this.mirrored = bool.booleanValue();
            }
            b bVarA = d.a();
            c cVarA = d.a(this.otcFrame, bVarA);
            int iA = (int) d.a(bVarA);
            this.metadata = new byte[iA];
            for (int i = 0; i < iA; i++) {
                this.metadata[i] = (byte) d.a(cVarA, i);
            }
        }

        public void destroy() {
            swig_otc_video_frame swig_otc_video_frameVar = this.otcFrame;
            if (swig_otc_video_frameVar != null && swig_otc_video_frameVar.getCPtr() != 0) {
                this.otcFrame.destroy();
            }
            this.buffer = null;
            this.otcFrame = null;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            destroy();
        }

        public ByteBuffer getBuffer() {
            return this.buffer;
        }

        public int getFormat() {
            return this.format.a();
        }

        public int getHeight() {
            return this.height;
        }

        @Deprecated
        public byte[] getMetadata() {
            return this.metadata;
        }

        public int getUVplaneSize() {
            return (int) d.a(this.otcFrame, k.d);
        }

        public ByteBuffer getUplane() {
            return get_frame_plane_byte_buffer(this.otcFrame.getCPtr(), k.d.a());
        }

        public int getUvStride() {
            return this.uvStride;
        }

        public ByteBuffer getVplane() {
            return get_frame_plane_byte_buffer(this.otcFrame.getCPtr(), k.e.a());
        }

        public int getWidth() {
            return this.width;
        }

        public ByteBuffer getYplane() {
            return get_frame_plane_byte_buffer(this.otcFrame.getCPtr(), k.c.a());
        }

        public int getYplaneSize() {
            return (int) d.a(this.otcFrame, k.c);
        }

        public int getYstride() {
            return this.yStride;
        }

        public boolean isMirroredX() {
            return this.mirrored;
        }

        @Deprecated
        public void recycle() {
        }
    }

    static class swig_otc_video_frame extends SWIGTYPE_p_otc_video_frame {
        public swig_otc_video_frame(long j) {
            super(j, true);
        }

        public void destroy() {
            if (getCPtr() != 0) {
                opentokJNI.otc_video_frame_delete(getCPtr());
            }
        }

        public long getCPtr() {
            return SWIGTYPE_p_otc_video_frame.getCPtr(this);
        }
    }

    Frame buildFrameInstance() {
        return new Frame();
    }

    public abstract View getView();

    public abstract void onFrame(Frame frame);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onVideoPropertiesChanged(boolean z);

    public abstract void setStyle(String str, String str2);
}
