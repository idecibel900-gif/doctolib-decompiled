package androidx.media3.extractor.metadata.emsg;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final DataOutputStream dataOutputStream;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING);
        this.byteArrayOutputStream = byteArrayOutputStream;
        this.dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    }

    public byte[] encode(EventMessage eventMessage) {
        this.byteArrayOutputStream.reset();
        try {
            writeNullTerminatedString(this.dataOutputStream, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            writeNullTerminatedString(this.dataOutputStream, str);
            this.dataOutputStream.writeLong(eventMessage.durationMs);
            this.dataOutputStream.writeLong(eventMessage.id);
            this.dataOutputStream.write(eventMessage.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }
}
