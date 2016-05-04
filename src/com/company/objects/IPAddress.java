package com.company.objects;

import java.io.Serializable;

/**
 * @author Maxim
 */
public class IPAddress implements Serializable {
    private String ip;

    public IPAddress(String ip) {
        if((ip == null) || (ip.length() > 15)) {
            throw new IllegalArgumentException("Error!");
        }
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "IPAddress{" +
                "ip='" + ip + '\'' +
                '}';
    }
}
