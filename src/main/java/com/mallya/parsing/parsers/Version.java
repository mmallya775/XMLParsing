package com.mallya.parsing.parsers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Version {

    @XmlElement(name = "filename")
    private String filename;

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "folderpath")
    private String folderPath;

    @XmlElement(name = "company")
    private String company;

    public String getFilename() {
        return filename;
    }

    public String getTitle() {
        return title;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public String getCompany() {
        return company;
    }
}
