package com.logArchieve;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateFileArchieve {
	
	private static void getAllFilesDetails(String path, long threshHold_Archieve,
					long threshHold_Delete){
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		File currentFile = null;
	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	    	  currentFile = listOfFiles[i];
	    	  try {
				long miliSecond_LastModified_Time = getDateDiff(currentFile);
				if (threshHold_Archieve<=miliSecond_LastModified_Time 
						&& miliSecond_LastModified_Time<threshHold_Delete) {
					archieveFiles(currentFile, path);
				} else if (threshHold_Delete<=miliSecond_LastModified_Time) {
					deleteFiles(currentFile);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
	      }
	    }
	}
	
	private static long getDateDiff(File file) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date d1 = format.parse(format.format(file.lastModified()).toString());
		Date d2 = format.parse(format.format(new Date()).toString());
		long diff = d2.getTime() - d1.getTime();
		System.out.println(diff);
		return diff;
	}
	
	private static void archieveFiles(File file,String path){
		System.out.println("File to be Zipped : "+file.getName());
		//createZipFIle(file,path);
		//System.out.println("Now this files needs to be deleted!! ");
		//deleteFiles(file);
		zipSingleFile(file,"abc.zip");
	}
    private static void zipSingleFile(File file, String zipFileName) {
        try {
            //create ZipOutputStream to write to the zip file
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            //add a new Zip Entry to the ZipOutputStream
            ZipEntry ze = new ZipEntry(file.getName());
            zos.putNextEntry(ze);
            //read the file and write to ZipOutputStream
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            
            //Close the zip entry to write to zip file
            zos.closeEntry();
            //Close resources
            zos.close();
            fis.close();
            fos.close();
            System.out.println(file.getCanonicalPath()+" is zipped to "+zipFileName);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
	private static void createZipFIle(File file, String path){
		String filePath = path+"\\"+file.getName();
		System.out.println(filePath);
		try {
		    String zipFileName = file.getName().concat(".zip");
		    System.out.println("zipFileName :: "+zipFileName);
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
 
            zos.putNextEntry(new ZipEntry(file.getName()));
 
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();
 
        } catch (FileNotFoundException ex) {
            System.err.format("The file %s does not exist", filePath);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Zip Created !!");
		}
	}
	
	private static void deleteFiles(File file){
		System.out.println("File to be Deleted : "+file.getName());
	}
	
	public static void createTheArchieve(String path){
		getAllFilesDetails(path,7700000, 7900000);
	}
}

class TestArchieve{
    public static void main(String[] args) 
    {
    	String path="C:\\Users\\MRINAL\\Desktop\\org"; 
    	CreateFileArchieve.createTheArchieve(path);
    }
}