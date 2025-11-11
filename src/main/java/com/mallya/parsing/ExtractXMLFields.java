package com.mallya.parsing;

import com.mallya.parsing.parsers.Document;
import com.mallya.parsing.parsers.Documents;
import com.mallya.parsing.parsers.Version;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class ExtractXMLFields {
    public static void main(String[] args) {
        File file = new File("src/main/resources/10 Method Statements.xml");

        long startTime = System.nanoTime();
        try {
            JAXBContext context = JAXBContext.newInstance(Documents.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Documents docs = (Documents) unmarshaller.unmarshal(file);

            for (Document doc : docs.getDocuments()) {
                for (Version v : doc.getVersions()) {
                    System.out.println("Filename: " + v.getFilename());
                    System.out.println("Title: " + v.getTitle());
                    System.out.println("Folder Path: " + v.getFolderPath());
                    System.out.println("------------------------------------");
                }
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total time taken: " + (System.nanoTime() - startTime)/1_000_000 + "ms");
    }
}
