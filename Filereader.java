import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilFile;

@WebServlet("/MyServletSmith")
public class MyServletSmith extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletSmith() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) //
         throws ServletException, IOException {
      response.setContentType("text/html");
      String filename = "/WEB-INF/numbers.csv";
      List<String> contents = UtilFile.readFile(getServletContext(), filename);
      for (String iLine : contents) {
         System.out.println(iLine);
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletContext;

public class UtilFile {
   public static List<String> readFile(ServletContext context, String filename) {
      List<String> contents = new ArrayList<String>();
      try {
         InputStream is = context.getResourceAsStream(filename);
         if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String text;
            while ((text = reader.readLine()) != null) {
               contents.add(text);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return contents;
   }

   public static List<String> readFile(String filePath) {
      List<String> contents = new ArrayList<String>();
      File file = new File(filePath);
      Scanner scanner = null;
      try {
         scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            contents.add(line);
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } finally {
         if (scanner != null)
            scanner.close();
      }
      return contents;
   }
}