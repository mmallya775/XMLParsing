package com.mallya.parsing;

import com.mallya.parsing.parsers.Document;
import com.mallya.parsing.parsers.Documents;
import com.mallya.parsing.parsers.Version;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExtractXMLFields {
    public static void main(String[] args) {
        File file = new File("src/main/resources/10 Method Statements.xml");

        long startTime = System.nanoTime();
        List<Map<String, String>> records = new ArrayList<>();

        try {
            JAXBContext context = JAXBContext.newInstance(Documents.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Documents docs = (Documents) unmarshaller.unmarshal(file);

            for (Document doc : docs.getDocuments()) {
                for (Version v : doc.getVersions()) {
                    Map<String, String> record = new LinkedHashMap<>();
                    record.put("Filename", v.getFilename());
                    record.put("Title", v.getTitle());
                    record.put("Folder Path", v.getFolderPath());
                    records.add(record);
                }
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Extracted " + records.size() + " records:");
//        for (Map<String, String> rec : records) {
//            rec.forEach((k, v) -> System.out.println(k + ": " + v));
//            System.out.println("------------------------------------");
//        }
        System.out.println(records);

        System.out.println("Total time taken: " + (System.nanoTime() - startTime) / 1_000_000 + " ms");
    }
}
