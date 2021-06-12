package com.fileappend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFileExample {

	private static final String FILENAME = "C:\\Users\\MRINAL\\Desktop\\filename.txt";

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String data = "\n This is new content \n";

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);
			bw.write("\n");
			bw.write(data);
			bw.write("\n");
			bw.write(data);
			bw.write("\n");

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

}