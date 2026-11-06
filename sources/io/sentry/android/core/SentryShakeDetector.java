package io.sentry.android.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import io.sentry.ILogger;
import io.sentry.SentryLevel;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryShakeDetector implements SensorEventListener {
    private Sensor accelerometer;
    private Handler handler;
    private HandlerThread handlerThread;
    private volatile Listener listener;
    private ILogger logger;
    private final SampleQueue queue = new SampleQueue();
    private SensorManager sensorManager;

    public interface Listener {
        void onShake();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public SentryShakeDetector(ILogger iLogger) {
        this.logger = iLogger;
    }

    void init(Context context, ILogger iLogger) {
        this.logger = iLogger;
        init(context);
    }

    private void init(Context context) {
        if (this.sensorManager == null) {
            this.sensorManager = (SensorManager) context.getSystemService("sensor");
        }
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null && this.accelerometer == null) {
            this.accelerometer = sensorManager.getDefaultSensor(1, false);
        }
        if (this.accelerometer == null || this.handlerThread != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("sentry-shake");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper());
    }

    public void start(Context context, Listener listener) {
        this.listener = listener;
        init(context);
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager == null) {
            this.logger.log(SentryLevel.WARNING, "SensorManager is not available. Shake detection disabled.", new Object[0]);
            return;
        }
        Sensor sensor = this.accelerometer;
        if (sensor == null) {
            this.logger.log(SentryLevel.WARNING, "Accelerometer sensor not available. Shake detection disabled.", new Object[0]);
        } else {
            sensorManager.registerListener(this, sensor, 3, this.handler);
        }
    }

    public void stop() {
        this.listener = null;
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: io.sentry.android.core.SentryShakeDetector$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.queue.clear();
                }
            });
        }
    }

    public void close() {
        stop();
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.handlerThread = null;
            this.handler = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 1) {
            return;
        }
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        this.queue.add(sensorEvent.timestamp, Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3))) > 13.0d);
        if (this.queue.isShaking()) {
            this.queue.clear();
            Listener listener = this.listener;
            if (listener != null) {
                listener.onShake();
            }
        }
    }

    static class SampleQueue {
        private int acceleratingCount;
        private Sample newest;
        private Sample oldest;
        private final SamplePool pool = new SamplePool();
        private int sampleCount;

        SampleQueue() {
        }

        void add(long j, boolean z) {
            purge(j - 500000000);
            Sample sampleAcquire = this.pool.acquire();
            sampleAcquire.timestamp = j;
            sampleAcquire.accelerating = z;
            sampleAcquire.next = null;
            Sample sample = this.newest;
            if (sample != null) {
                sample.next = sampleAcquire;
            }
            this.newest = sampleAcquire;
            if (this.oldest == null) {
                this.oldest = sampleAcquire;
            }
            this.sampleCount++;
            if (z) {
                this.acceleratingCount++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            while (true) {
                Sample sample = this.oldest;
                if (sample != null) {
                    this.oldest = sample.next;
                    this.pool.release(sample);
                } else {
                    this.newest = null;
                    this.sampleCount = 0;
                    this.acceleratingCount = 0;
                    return;
                }
            }
        }

        private void purge(long j) {
            Sample sample;
            while (true) {
                int i = this.sampleCount;
                if (i < 4 || (sample = this.oldest) == null || j - sample.timestamp <= 0) {
                    return;
                }
                if (sample.accelerating) {
                    this.acceleratingCount--;
                }
                this.sampleCount = i - 1;
                Sample sample2 = sample.next;
                this.oldest = sample2;
                if (sample2 == null) {
                    this.newest = null;
                }
                this.pool.release(sample);
            }
        }

        boolean isShaking() {
            Sample sample;
            int i;
            Sample sample2 = this.newest;
            return sample2 != null && (sample = this.oldest) != null && (i = this.sampleCount) >= 4 && sample2.timestamp - sample.timestamp >= 250000000 && this.acceleratingCount >= (i >> 1) + (i >> 2);
        }
    }

    static class Sample {
        boolean accelerating;
        Sample next;
        long timestamp;

        Sample() {
        }
    }

    static class SamplePool {
        private Sample head;

        SamplePool() {
        }

        Sample acquire() {
            Sample sample = this.head;
            if (sample == null) {
                return new Sample();
            }
            this.head = sample.next;
            return sample;
        }

        void release(Sample sample) {
            sample.next = this.head;
            this.head = sample;
        }
    }
}
