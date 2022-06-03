package commonCsv;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.yaml.snakeyaml.reader.UnicodeReader;
import org.apache.commons.csv.CSVFormat.Builder;
import org.apache.commons.csv.CSVParser;

public class ReaderFile {
	static final String[] FILE_HEADER = { "ID", "Name", "Score", "payeasyHotelId" };

    public static void main(String[] args) {
        try {
        	UnicodeReader in=new UnicodeReader(new FileInputStream("readerstudent.csv")); 
//            bufferedReader = new BufferedReader(ur);
            Builder builder = CSVFormat.Builder.create(CSVFormat.EXCEL);
            CSVFormat csvFormat = builder
            		.setHeader(FILE_HEADER)
            		.build();
            Iterable<CSVRecord> records=csvFormat.parse(in);
            for(CSVRecord record:records){
                System.out.print(record.get("ID") + " ");
                System.out.print(record.get("Name") + " ");
                System.out.print(record.get("Score")+ " ");
                System.out.println(record.get("payeasyHotelId"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
