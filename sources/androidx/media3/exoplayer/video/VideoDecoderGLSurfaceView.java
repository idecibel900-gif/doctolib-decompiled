package androidx.media3.exoplayer.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.util.AttributeSet;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {
    public static final /* synthetic */ int $r8$clinit = 0;
    private final Renderer renderer;

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public VideoDecoderGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Renderer renderer = new Renderer(this);
        this.renderer = renderer;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setRenderMode(0);
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.renderer.setOutputBuffer(videoDecoderOutputBuffer);
    }

    private static final class Renderer implements GLSurfaceView.Renderer {
        private int colorMatrixLocation;
        private GlProgram program;
        private final GLSurfaceView surfaceView;
        private static final float[] kColorConversion601 = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        private static final float[] kColorConversion709 = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        private static final float[] kColorConversion2020 = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        private static final String[] TEXTURE_UNIFORMS = {"y_tex", "u_tex", "v_tex"};
        private static final FloatBuffer TEXTURE_VERTICES = GlUtil.createBuffer(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        private final int[] yuvTextures = new int[3];
        private final int[] texLocations = new int[3];
        private final int[] previousWidths = new int[3];
        private final int[] previousStrides = new int[3];
        private final AtomicReference pendingOutputBufferReference = new AtomicReference();
        private final FloatBuffer[] textureCoords = new FloatBuffer[3];

        public Renderer(GLSurfaceView gLSurfaceView) {
            this.surfaceView = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.previousWidths;
                this.previousStrides[i] = -1;
                iArr[i] = -1;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                GlProgram glProgram = new GlProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.program = glProgram;
                GLES20.glVertexAttribPointer(glProgram.getAttributeArrayLocationAndEnable("in_pos"), 2, 5126, false, 0, (Buffer) TEXTURE_VERTICES);
                this.texLocations[0] = this.program.getAttributeArrayLocationAndEnable("in_tc_y");
                this.texLocations[1] = this.program.getAttributeArrayLocationAndEnable("in_tc_u");
                this.texLocations[2] = this.program.getAttributeArrayLocationAndEnable("in_tc_v");
                this.colorMatrixLocation = this.program.getUniformLocation("mColorConversion");
                GlUtil.checkGlError();
                setupTextures();
                GlUtil.checkGlError();
            } catch (GlUtil.GlException unused) {
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.pendingOutputBufferReference.getAndSet(null));
        }

        public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.pendingOutputBufferReference.getAndSet(videoDecoderOutputBuffer));
            this.surfaceView.requestRender();
        }

        private void setupTextures() {
            try {
                GLES20.glGenTextures(3, this.yuvTextures, 0);
                for (int i = 0; i < 3; i++) {
                    GLES20.glUniform1i(this.program.getUniformLocation(TEXTURE_UNIFORMS[i]), i);
                    GLES20.glActiveTexture(33984 + i);
                    GlUtil.bindTexture(3553, this.yuvTextures[i], 9729);
                }
                GlUtil.checkGlError();
            } catch (GlUtil.GlException unused) {
            }
        }
    }
}
