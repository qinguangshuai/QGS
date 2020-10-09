package com.qgsstrive.qgs.http.response;

import java.io.Serializable;

public class CommonResponse implements Serializable { //BaseBean类
    public String ret;
    public String msg;
    public String toast;
    public String timestamp;
    public Object result;
}
