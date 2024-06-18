package ImageToText;

import java.io.File;
import java.io.PrintWriter;

public class Main {
    private static String text1;

    public static void setText1(String text) {
        text1 = text;
    }

    public static void startConversion(MenuUI menuUI) {
        if (text1 == null || text1.isEmpty()) {
            showErrorUI("No input file provided.", menuUI);
            return;
        }

        String input_file = "E:\\TesseractOCR\\Input\\" + text1;
        String output_file = "E:\\TesseractOCR\\Output\\out";
        String tesseract_install_path = "E:\\TesseractOCR\\Tesseract-OCR\\tesseract";

        // Check if input file exists
        File inputFile = new File(input_file);
        if (!inputFile.exists()) {
            showErrorUI("Input file does not exist: " + input_file, menuUI);
            return;
        }

        String[] command = {"cmd"};
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            new Thread(new ImageFormat(p.getErrorStream(), System.err)).start();
            new Thread(new ImageFormat(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("\"" + tesseract_install_path + "\" \"" + input_file + "\" \"" + output_file + "\" -l eng");
            stdin.close();
            p.waitFor();

            // Check if output file was created
            File outputFile = new File(output_file + ".txt");
            if (outputFile.exists()) {
                showConvertedUI(output_file + ".txt", menuUI);
            } else {
                showErrorUI("Failed to create output file.", menuUI);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorUI("An error occurred during image conversion. " + e.getMessage(), menuUI);
        }
    }

    private static void showErrorUI(String errorMessage, MenuUI menuUI) {
        if (menuUI != null) {
            menuUI.dispose();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new ErrorUI(errorMessage).setVisible(true);
        });
    }

    private static void showConvertedUI(String filePath, MenuUI menuUI) {
        if (menuUI != null) {
            menuUI.dispose();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new ConvertedUI(filePath).setVisible(true);
        });
    }
}
