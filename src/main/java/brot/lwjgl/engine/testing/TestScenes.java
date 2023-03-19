package brot.lwjgl.engine.testing;

import java.util.Arrays;

public class TestScenes {
    public static void testAnimationFrames() {
        float[] durations = new float[]{0f, .2f, .7f, 1.1f};
        float totalDuration = 2f;
        float[] times = new float[]{0.00001f, 0.00017f, 0.13f, 0.37f, 0.8f, 1.2f, 2.001f};
        for (float time : times) {
            float x = time - totalDuration * (float) Math.floor(time / totalDuration);
            for (int i = durations.length - 1; i >= 0; i--) {
                if (x >= durations[i]) {
                    System.out.println(time + ": " + i);
                    break;
                }
            }
        }
    }
}
