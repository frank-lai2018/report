package commonCsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;

import dto.Student;
//        public enum HeaderEnum {
//            Name, Email, Phone
//        }

public class WriteFile {
    public static void main(String[] args) {
        final String[] FILE_HEADER={"ID","Name","Score","payeasyHotelId"};
        final String FILE_NAME="student.csv";

        //創建學生對象
        Student student1=new Student("7601", "中文", 113);
        Student student2=new Student("7301", "拉拉", 121);
        Student student3=new Student("7101", "Yuuki", 130);
        Student student4=new Student("7302", "Jay", 100);
        Student student5=new Student("7500", "Zoe", 98);
        //添加到一個list裏面
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Writer fileWriter=null;
        CSVPrinter csvPrinter=null;
        
        //創建CSVFormat
        Builder builder = CSVFormat.Builder.create(CSVFormat.EXCEL);
        CSVFormat csvFormat = null;
//
        
        
        try {
//            fileWriter=new FileWriter(FILE_NAME);
        	
//            FileOutputStream fos = new FileOutputStream(FILE_NAME);
//            fos.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
//            fileWriter = new OutputStreamWriter(fos, "UTF-8");
//            new FileWriterWithEncoding(FILE_NAME,Charset.forName("UTF-8") , true);
        	File file = new File(FILE_NAME);
            if(!file.exists()) {
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                fos.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
                fileWriter = new OutputStreamWriter(fos, "UTF-8");
//                csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("FirstName", "LastName", "DOB"));
                csvFormat = builder
                		.setHeader(FILE_HEADER)
                		.build();
                csvPrinter=new CSVPrinter(fileWriter, csvFormat);
            }
            else {
            	fileWriter = new FileWriter(file, true);
            	 csvFormat = builder
                 		.setHeader(FILE_HEADER)
                 		.setSkipHeaderRecord(true)
                 		.build();
            	csvPrinter = new CSVPrinter(fileWriter,csvFormat);
            }
            
            for(Student student:students){
                List<String> record=new ArrayList<>();
                record.add(student.getId());
                record.add(student.getName());
                record.add(String.valueOf(student.getScore()));
                csvPrinter.printRecord(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();
                csvPrinter.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
