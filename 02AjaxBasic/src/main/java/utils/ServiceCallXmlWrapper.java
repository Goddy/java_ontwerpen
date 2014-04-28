package utils;

import model.ServiceCall;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by u0090265 on 4/25/14.
 */
@XmlRootElement(name = "serviceCalls")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceCallXmlWrapper {

    public ServiceCallXmlWrapper(List<ServiceCall> serviceCallList) {
        this.serviceCallList = serviceCallList;
    }

    public ServiceCallXmlWrapper() {
        //no arg default constructor
    }

    @XmlElement
    private List<ServiceCall> serviceCallList;

    public List<ServiceCall> getServiceCallList() {
        return serviceCallList;
    }

    public void setServiceCallList(List<ServiceCall> serviceCallList) {
        this.serviceCallList = serviceCallList;
    }
}
