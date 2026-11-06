package expo.modules.speechrecognition;

import android.content.Context;
import android.media.AudioRecord;
import android.os.ParcelFileDescriptor;
import com.google.firebase.messaging.Constants;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoAudioRecorder {
    public static final Companion Companion = new Companion(null);
    private final int audioFormat;
    private AudioRecord audioRecorder;
    private final int bufferSizeInBytes;
    private final int channelConfig;
    private final Context context;
    private boolean isRecordingAudio;
    private File outputFile;
    private final String outputFilePath;
    private String outputFileUri;
    private ParcelFileDescriptor.AutoCloseOutputStream outputStream;
    private final ParcelFileDescriptor recordingParcel;
    private Thread recordingThread;
    private final int sampleRateInHz;
    private final File tempPcmFile;

    public ExpoAudioRecorder(Context context, String str) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.outputFilePath = str;
        this.outputFileUri = "file://" + str;
        this.tempPcmFile = createTempPcmFile();
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
            Intrinsics.checkNotNullExpressionValue(parcelFileDescriptor, "get(...)");
            this.recordingParcel = parcelFileDescriptor;
            this.outputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
            this.sampleRateInHz = 16000;
            this.channelConfig = 16;
            this.audioFormat = 2;
            this.bufferSizeInBytes = AudioRecord.getMinBufferSize(16000, 16, 2);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public final File getOutputFile() {
        return this.outputFile;
    }

    public final String getOutputFileUri() {
        return this.outputFileUri;
    }

    public final ParcelFileDescriptor getRecordingParcel() {
        return this.recordingParcel;
    }

    public final int getSampleRateInHz() {
        return this.sampleRateInHz;
    }

    public final int getAudioFormat() {
        return this.audioFormat;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int shortReverseBytes(short s) {
            return Short.reverseBytes(s);
        }

        public final File appendWavHeader(String outputFilePath, File pcmFile, int i) throws IOException {
            Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
            Intrinsics.checkNotNullParameter(pcmFile, "pcmFile");
            File file = new File(outputFilePath);
            long length = pcmFile.length();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            long j = ((long) 36) + length;
            try {
                dataOutputStream.writeBytes("RIFF");
                dataOutputStream.writeInt(Integer.reverseBytes((int) j));
                dataOutputStream.writeBytes("WAVE");
                dataOutputStream.writeBytes("fmt ");
                dataOutputStream.writeInt(Integer.reverseBytes(16));
                Companion companion = ExpoAudioRecorder.Companion;
                dataOutputStream.writeShort(companion.shortReverseBytes((short) 1));
                dataOutputStream.writeShort(companion.shortReverseBytes((short) 1));
                dataOutputStream.writeInt(Integer.reverseBytes(i));
                dataOutputStream.writeInt(Integer.reverseBytes((i * 16) / 8));
                dataOutputStream.writeShort(companion.shortReverseBytes((short) 2));
                dataOutputStream.writeShort(companion.shortReverseBytes((short) 16));
                dataOutputStream.writeBytes(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
                dataOutputStream.writeInt(Integer.reverseBytes((int) length));
                try {
                    dataOutputStream.write(FilesKt.readBytes(pcmFile));
                    pcmFile.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                    Unit unit = Unit.INSTANCE;
                }
                CloseableKt.closeFinally(dataOutputStream, null);
                return file;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(dataOutputStream, th);
                    throw th2;
                }
            }
        }
    }

    private final File createTempPcmFile() {
        File file = new File(this.context.getCacheDir(), "temp_" + UUID.randomUUID() + ".pcm");
        if (!file.exists()) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private final AudioRecord createRecorder() {
        return new AudioRecord(6, this.sampleRateInHz, this.channelConfig, 2, this.bufferSizeInBytes);
    }

    public void start() {
        AudioRecord audioRecordCreateRecorder = createRecorder();
        this.audioRecorder = audioRecordCreateRecorder;
        if (audioRecordCreateRecorder.getState() != 1) {
            return;
        }
        audioRecordCreateRecorder.startRecording();
        this.isRecordingAudio = true;
        this.recordingThread = ThreadsKt.thread$default(false, false, null, null, 0, new Function0() { // from class: expo.modules.speechrecognition.ExpoAudioRecorder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExpoAudioRecorder.start$lambda$1$lambda$0(this.f$0);
            }
        }, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$1$lambda$0(ExpoAudioRecorder expoAudioRecorder) throws IOException {
        expoAudioRecorder.streamAudioToPipe();
        return Unit.INSTANCE;
    }

    public void stop() {
        this.isRecordingAudio = false;
        AudioRecord audioRecord = this.audioRecorder;
        if (audioRecord != null) {
            audioRecord.stop();
        }
        AudioRecord audioRecord2 = this.audioRecorder;
        if (audioRecord2 != null) {
            audioRecord2.release();
        }
        this.audioRecorder = null;
        this.recordingThread = null;
        String str = this.outputFilePath;
        if (str != null) {
            try {
                this.outputFile = Companion.appendWavHeader(str, this.tempPcmFile, this.sampleRateInHz);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.recordingParcel.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = this.outputStream;
            if (autoCloseOutputStream != null) {
                autoCloseOutputStream.close();
            }
            this.outputStream = null;
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private final void streamAudioToPipe() throws IOException {
        AudioRecord audioRecord;
        FileOutputStream fileOutputStream = new FileOutputStream(this.tempPcmFile);
        int i = this.bufferSizeInBytes;
        byte[] bArr = new byte[i];
        while (this.isRecordingAudio && (audioRecord = this.audioRecorder) != null) {
            int i2 = audioRecord.read(bArr, 0, i, 0);
            if (i2 <= 0) {
                if (i2 != 0) {
                    if (i2 == -6 || (i2 != -3 && i2 != -2)) {
                        break;
                        break;
                    }
                    Thread.sleep(10L);
                } else {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException unused) {
                    }
                }
            } else {
                try {
                    ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = this.outputStream;
                    if (autoCloseOutputStream != null) {
                        autoCloseOutputStream.write(bArr, 0, i2);
                    }
                    ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = this.outputStream;
                    if (autoCloseOutputStream2 != null) {
                        autoCloseOutputStream2.flush();
                    }
                    if (this.outputFilePath != null) {
                        fileOutputStream.write(bArr, 0, i2);
                        fileOutputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        fileOutputStream.close();
    }
}
