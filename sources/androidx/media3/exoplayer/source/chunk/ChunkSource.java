package androidx.media3.exoplayer.source.chunk;

import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ChunkSource {
    long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters);

    void getNextChunk(LoadingInfo loadingInfo, long j, List list, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j, List list);

    void maybeThrowError();

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    void release();

    boolean shouldCancelLoad(long j, Chunk chunk, List list);
}
