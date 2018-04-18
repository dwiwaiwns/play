package com.zp.designpatern.create.Singleton;

import java.util.Vector;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class ShadowSingleton {
    private static ShadowSingleton instance;
    private Vector properties = null;

    private ShadowSingleton() {

    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new ShadowSingleton();
        }
    }

    public static ShadowSingleton getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public Vector getProperties() {
        return properties;
    }

    public void updatePreperties() {
        ShadowSingleton shadowSingleton = new ShadowSingleton();
        properties = shadowSingleton.getProperties();
    }
}
