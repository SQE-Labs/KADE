package org.automation.utilities;


import org.automation.base.BaseTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSVHelper extends BaseTest {


    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\r\n";

    public static void ImportMeterNumber(String fileName, String header, String serviceId, String meterNo, String status, String Consumption_Type, String Configuration, String Multiplier, String Constant, String Hazard, String Location, String Additional_Site_Info, String Meter_Point_ID, String Next_Scheduled_Read_Date, String Manufacturer, String Model, String Meter_Read_Type, String Route, String Walk_Order, String Meter_Installation_Type, String Date, String Date2) {

        String FILE_HEADER = header;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(serviceId);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(meterNo);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(status);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Consumption_Type);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Configuration);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Multiplier);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Constant);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Hazard);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Location);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Additional_Site_Info);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Meter_Point_ID);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Next_Scheduled_Read_Date);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Manufacturer);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Model);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Meter_Read_Type);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Route);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Walk_Order);
            fileWriter.append(COMMA_DELIMITER);


            fileWriter.append(Meter_Installation_Type);
            fileWriter.append(COMMA_DELIMITER);


            fileWriter.append(Date);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Date2);
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }


        }

    }

    public static Map<String, String> readCsvFile() throws FileNotFoundException {
        Map<String, String> mapping = new HashMap<String, String>();
        Scanner look = new Scanner(new File("C:\\Users\\sa\\Desktop\\look.csv"));
        String[] keys = look.nextLine().split(",");
        String[] values = look.nextLine().split(",");

        for (int i = 0; i < keys.length; ++i)
            mapping.put(keys[i], values[i]);
        return mapping;
    }

    //    public static void writeCsvFile(String filePath) throws FileNotFoundException {
//        Scanner main = new Scanner(new File("C:\\Users\\sa\\Desktop\\hotel2\\all.csv"));
//
////        PrintWriter mainOutput = new PrintWriter  (new File("C:\\Users\\sa\\Desktop\\hotel2\\all.out.csv"));
////        while (main.hasNext()){
////            String[] nextTokens=main.nextLine().split(",");
////            for(String token:nextTokens)
////                if(mapping.get(token)!=null)
////                {
////                    mainOutput .print(mapping.get(token)+",");
////                }else {
////
////                    mainOutput .print(token+",");
////                }
////            mainOutput .println();
////        }
//
//     //   mainOutput .close();
//    }
//
//        public static void writeDataLineByLine(String filePath)
//    {
//        // first create file object for file placed at location
//        // specified by filepath
//        File file = new File(filePath);
//        try {
//            // create FileWriter object with file as parameter
//            FileWriter outputfile = new FileWriter(file);
//
//            // create CSVWriter object filewriter object as parameter
//            CSVWriter writer = new CSVWriter(outputfile);
//
//            // adding header to csv
//            String[] header = { "Name", "Class", "Marks" };
//            writer.writeNext(header);
//
//            // add data to csv
//            String[] data1 = { "Aman", "10", "620" };
//            writer.writeNext(data1);
//            String[] data2 = { "Suraj", "10", "630" };
//            writer.writeNext(data2);
//
//            // closing writer connection
//            writer.close();
//        }
//        catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
    public static void createCSVGeneric(String fileName, String[] headerList, String[] rowValues) throws Exception {

        FileWriter fileWriter = null;
        ArrayList<String> rowList = new ArrayList<String>(
                Arrays.asList(rowValues));
        ArrayList<String> columnList = new ArrayList<String>(
                Arrays.asList(headerList));


        try {
            if (columnList.size() != rowList.size()) {
                throw new Exception("rows and columns size is not equal in csv file");
            }

            fileWriter = new FileWriter(fileName);
            StringBuilder header = new StringBuilder();
            for (int i = 0; i < columnList.size(); i++) {
                if (i == (columnList.size() - 1)) {
                    header.append(columnList.get(i));
                } else {
                    header.append(columnList.get(i));
                    header.append(",");
                }


            }
            fileWriter.append(header);
            fileWriter.append(NEW_LINE_SEPARATOR);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rowList.size(); i++) {
                if (i == (rowList.size() - 1)) {
                    sb.append(rowList.get(i));
                } else {
                    sb.append(rowList.get(i));
                    sb.append(",");
                }
            }
            fileWriter.append(sb);
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }


        }

    }

    public static void ImportMeterRegister(String fileName, String header, String serviceId, String meterNo, String register, String networkTariffCode, String UnitOfMeasure, String timeOfDay, String multiplier, String dialFormat, String suffix, String controlledLoad, String status, String consumptionType, String Demand1, String Demand2, String dateConnected, String dateRemoved) {

        String FILE_HEADER = header;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file


            fileWriter.append(serviceId);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(meterNo);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(register);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(networkTariffCode);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(UnitOfMeasure);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(timeOfDay);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(multiplier);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(dialFormat);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(suffix);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(controlledLoad);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(status);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(consumptionType);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Demand1);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(Demand2);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(dateConnected);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(dateRemoved);
            //fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(NEW_LINE_SEPARATOR);


            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }


    }

    public static void ImportMeterReads(String fileName, String header, String serviceId, String meterNo, String dateOfRead, String meterRead, String period, String readType, String notes, String isReadrollOver, String unit, String dataStream, String specialType) {

        String FILE_HEADER = header;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file


            fileWriter.append(serviceId);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(meterNo);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(dateOfRead);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(meterRead);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(period);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(readType);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(notes);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(isReadrollOver);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(unit);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(dataStream);
            fileWriter.append(COMMA_DELIMITER);

            fileWriter.append(specialType);
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }


    }

}
