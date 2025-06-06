package lr8.Excel;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
    public static void main(String[] args) {
        String filePath = "example.xlsx";
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet("Товары");

            if (sheet == null) {
                System.out.println("Ошибка: Лист с именем 'Товары' не найден.");
                return;
            }

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                            break;
                        default:
                            System.out.print("UNKNOWN\t");
                            break;
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: Проверьте, существует ли файл '" + filePath + "' и доступен ли он для чтения.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Файл имеет неправильный формат. Убедитесь, что это файл Excel (.xlsx).");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}