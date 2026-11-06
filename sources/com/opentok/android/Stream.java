package com.opentok.android;

import com.opentok.otc.SWIGTYPE_p_otc_stream;
import com.opentok.otc.d;
import com.opentok.otc.otc_stream_video_type;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public final class Stream implements Comparable {
    SWIGTYPE_p_otc_stream otc_stream;
    private final boolean shouldDestroyOnFinalize;

    public enum StreamVideoType {
        StreamVideoTypeCamera(1),
        StreamVideoTypeScreen(2),
        StreamVideoTypeCustom(3);

        private final int videoType;

        StreamVideoType(int i) {
            this.videoType = i;
        }

        static StreamVideoType fromSwig(otc_stream_video_type otc_stream_video_typeVar) {
            for (StreamVideoType streamVideoType : values()) {
                if (streamVideoType.getVideoType() == otc_stream_video_typeVar.a()) {
                    return streamVideoType;
                }
            }
            throw new IllegalArgumentException("unknown type " + otc_stream_video_typeVar);
        }

        static StreamVideoType fromType(int i) {
            for (StreamVideoType streamVideoType : values()) {
                if (streamVideoType.getVideoType() == i) {
                    return streamVideoType;
                }
            }
            throw new IllegalArgumentException("unknown type " + i);
        }

        public int getVideoType() {
            return this.videoType;
        }
    }

    static class swig_otc_stream extends SWIGTYPE_p_otc_stream {
        public swig_otc_stream(long j) {
            super(j, true);
        }
    }

    Stream(long j, boolean z) {
        if (z) {
            this.otc_stream = d.a(new swig_otc_stream(j));
        } else {
            this.otc_stream = new swig_otc_stream(j);
        }
        this.shouldDestroyOnFinalize = z;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return getStreamId().compareTo(((Stream) obj).getStreamId());
    }

    public boolean equals(Object obj) {
        return (obj instanceof Stream) && ((Stream) obj).getStreamId().equals(getStreamId());
    }

    protected void finalize() throws Throwable {
        SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream = this.otc_stream;
        if (sWIGTYPE_p_otc_stream != null && this.shouldDestroyOnFinalize) {
            d.b(sWIGTYPE_p_otc_stream);
        }
        super.finalize();
    }

    public Connection getConnection() {
        return new Connection(d.c(this.otc_stream), false);
    }

    public Date getCreationTime() {
        return new Date(d.d(this.otc_stream));
    }

    public String getName() {
        return d.f(this.otc_stream);
    }

    SWIGTYPE_p_otc_stream getOtc_stream() {
        return this.otc_stream;
    }

    @Deprecated
    public Session getSession() {
        return null;
    }

    public String getStreamId() {
        return d.e(this.otc_stream);
    }

    public StreamVideoType getStreamVideoType() {
        return StreamVideoType.fromSwig(d.h(this.otc_stream));
    }

    public int getVideoHeight() {
        return d.g(this.otc_stream);
    }

    public int getVideoWidth() {
        return d.i(this.otc_stream);
    }

    public boolean hasAudio() {
        return Utils.intToBoolean(d.j(this.otc_stream));
    }

    public boolean hasCaptions() {
        return Utils.intToBoolean(d.k(this.otc_stream));
    }

    public boolean hasVideo() {
        return Utils.intToBoolean(d.l(this.otc_stream));
    }

    public int hashCode() {
        return getStreamId().hashCode();
    }

    public String toString() {
        return "streamId = " + getStreamId();
    }

    Stream(SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_stream, boolean z) {
        if (z) {
            this.otc_stream = d.a(sWIGTYPE_p_otc_stream);
        } else {
            this.otc_stream = sWIGTYPE_p_otc_stream;
        }
        this.shouldDestroyOnFinalize = z;
    }
}
