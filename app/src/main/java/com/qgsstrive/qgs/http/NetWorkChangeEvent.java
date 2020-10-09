package com.qgsstrive.qgs.http;
/**
*  全局网络监听
* */
public class NetWorkChangeEvent {
    public  boolean isConnected;//是否存在网络

    public NetWorkChangeEvent(boolean isConnected) {
        this.isConnected = isConnected;
    }
}
