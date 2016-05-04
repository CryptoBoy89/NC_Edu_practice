package com.company.objects;

import com.company.interfaces.PathElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public abstract class ActiveElement implements PathElement, Serializable{
    protected static Collection<IPAddress> ipAddressCollection = new ArrayList<>();
  public static Collection<IPAddress> getIP() {
      return ipAddressCollection;
  }
}
