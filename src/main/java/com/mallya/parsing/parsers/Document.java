package com.mallya.parsing.parsers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Document {

    @XmlElementWrapper(name = "versions")
    @XmlElement(name = "version")
    private List<Version> versions;

    public List<Version> getVersions() {
        return versions;
    }
}
