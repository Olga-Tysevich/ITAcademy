package com.example.final_project_java.template;

import com.example.final_project_java.model.recyclableUnits.RecyclableType;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Map;

public class BillTemplate {
    private final String actNumber;
    private final String[] waybillArray;
    private final LocalDate date;
    private final int totalPositions;
    private final double sum;
    private final Map<RecyclableType, Integer> amountInAct;
    private final Map<RecyclableType, Double> price;
    private final Map<RecyclableType, Double> totalPrice;

    public BillTemplate(String actNumber, String[] waybillArray, LocalDate date, int totalPositions, double sum, Map<RecyclableType, Integer> amountInAct,
                        Map<RecyclableType, Double> price, Map<RecyclableType, Double> totalPrice) {
        this.actNumber = actNumber;
        this.waybillArray = waybillArray;
        this.date = date;
        this.totalPositions = totalPositions;
        this.sum = sum;
        this.amountInAct = amountInAct;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public void generateBill() throws FileNotFoundException {
        try {
            XWPFDocument docxModel = new XWPFDocument();

            XWPFParagraph actName = docxModel.createParagraph();
            actName.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun actNameConfig = actName.createRun();
            setSettings(actNameConfig);
            actNameConfig.setBold(true);
            actNameConfig.setText("АКТ");
            actNameConfig.addBreak();

            XWPFRun actNumberConfig = actName.createRun();
            actName.addRun(actNumberConfig);
            actNumberConfig.setText("выполненных работ №" + actNumber + " к накладным:");
            setSettings(actNumberConfig);
            actNumberConfig.addBreak();

            XWPFRun ttnNumbersConfig = actName.createRun();
            actName.addRun(ttnNumbersConfig);
            ttnNumbersConfig.setText(addTTN(waybillArray));
            setSettings(ttnNumbersConfig);
            ttnNumbersConfig.addBreak();

            XWPFParagraph actCity = docxModel.createParagraph();
            actCity.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun actCityConfig = actCity.createRun();
            setSettings(actCityConfig);
            actCityConfig.setText("г. Минск");
            actCityConfig.addBreak();

            XWPFParagraph actDate = docxModel.createParagraph();
            actDate.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun actDateConfig = actDate.createRun();
            setSettings(actDateConfig);
            actDateConfig.setText(String.valueOf(date));
            actDateConfig.addBreak();

            XWPFParagraph actFirstParagraph = docxModel.createParagraph();
            actFirstParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun actFirstParagraphConfig = actFirstParagraph.createRun();
            setSettings(actFirstParagraphConfig);
            actFirstParagraphConfig.setText("     Настоящий акт составлен комиссией в составе: председателя комиссии Директора ООО «ВторТехУтилизация» Морякова Д.В." +
                    " и члена комиссии − технического специалиста Д.М. Никипоронка, о том, что ООО «ВторТехУтилизация» выполнены работы по демонтажу (разборке), " +
                    "сортировке по видам отходов и подготовке к передаче отходов для окончательной " +
                    "утилизации, согласно следующей таблице:");
            actFirstParagraphConfig.addBreak();

            XWPFTable table = docxModel.createTable(7, 4);
            setTableValues(docxModel, table);

            XWPFParagraph totalProcessedParagraph = docxModel.createParagraph();
            totalProcessedParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun totalProcessedConfig = totalProcessedParagraph.createRun();
            setSettings(totalProcessedConfig);
            totalProcessedConfig.setText("         Всего переработано: " + totalPositions + " единиц бытовой техники на сумму: " + sum);
            totalProcessedConfig.addBreak();

            XWPFParagraph noComplaintsParagraph = docxModel.createParagraph();
            noComplaintsParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun noComplaintsConfig = noComplaintsParagraph.createRun();
            setSettings(noComplaintsConfig);
            noComplaintsConfig.setText("        Замечаний к оказанию услуг Заказчик не имеет.");
            noComplaintsConfig.addBreak();

            // сохраняем модель docx документа в файл
            FileOutputStream outputStream = new FileOutputStream("Final_Project_Java/src/main/java/com/example/final_project_java/template/Bill" + actNumber + ".docx");
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
        System.out.println("Successfully written to file");
    }

    private void setTableValues(XWPFDocument docxModel, XWPFTable table) {
        setCell(docxModel, table.getRows().get(0).getCell(0), "Вид отходов");
        setCell(docxModel, table.getRows().get(0).getCell(1), "Кол-во переработанных отходов, шт");
        setCell(docxModel, table.getRows().get(1).getCell(1), amountInAct.get(RecyclableType.LARGE).toString());
        setCell(docxModel, table.getRows().get(2).getCell(1), amountInAct.get(RecyclableType.MID).toString());
        setCell(docxModel, table.getRows().get(3).getCell(1), amountInAct.get(RecyclableType.SMALL).toString());
        setCell(docxModel, table.getRows().get(4).getCell(1), amountInAct.get(RecyclableType.ACCESSORY).toString());
        setCell(docxModel, table.getRows().get(5).getCell(1), amountInAct.get(RecyclableType.TV).toString());
        setCell(docxModel, table.getRows().get(0).getCell(2), "Стоимость работ по переработке за 1 штуку, руб (без НДС)");
        setCell(docxModel, table.getRows().get(1).getCell(2), String.valueOf(price.get(RecyclableType.LARGE)));
        setCell(docxModel, table.getRows().get(2).getCell(2), String.valueOf(price.get(RecyclableType.MID)));
        setCell(docxModel, table.getRows().get(3).getCell(2), String.valueOf(price.get(RecyclableType.SMALL)));
        setCell(docxModel, table.getRows().get(4).getCell(2), String.valueOf(price.get(RecyclableType.ACCESSORY)));
        setCell(docxModel, table.getRows().get(5).getCell(2), String.valueOf(price.get(RecyclableType.TV)));
        setCell(docxModel, table.getRows().get(0).getCell(3), "Стоимость работ по переработке всего, руб (без НДС)");
        setCell(docxModel, table.getRows().get(1).getCell(3), String.valueOf(totalPrice.get(RecyclableType.LARGE)));
        setCell(docxModel, table.getRows().get(2).getCell(3), String.valueOf(totalPrice.get(RecyclableType.MID)));
        setCell(docxModel, table.getRows().get(3).getCell(3), String.valueOf(totalPrice.get(RecyclableType.SMALL)));
        setCell(docxModel, table.getRows().get(4).getCell(3), String.valueOf(totalPrice.get(RecyclableType.ACCESSORY)));
        setCell(docxModel, table.getRows().get(5).getCell(3), String.valueOf(totalPrice.get(RecyclableType.TV)));
        setCell(docxModel, table.getRows().get(6).getCell(3), String.valueOf(sum));
        setCell(docxModel, table.getRows().get(1).getCell(0), "Отходы крупногабаритного электрического и электронного оборудования");
        setCell(docxModel, table.getRows().get(2).getCell(0), "Отходы среднегабаритного электрического и электронного оборудования");
        setCell(docxModel, table.getRows().get(3).getCell(0), "Отходы мелкогабаритного электрического и электронного оборудования");
        setCell(docxModel, table.getRows().get(4).getCell(0), "Отходы (аксессуары)");
        setCell(docxModel, table.getRows().get(5).getCell(0), "TV");
        setCell(docxModel, table.getRows().get(6).getCell(2), "Итого:");
    }

    public static void setCell(XWPFDocument docxModel, XWPFTableCell cell, String cellName) {
        cell.setParagraph(docxModel.createParagraph());
        XWPFRun run = cell.getParagraphs().get(0).createRun();
        run.setText(cellName);
        setSettings(run);
    }

    public static String addTTN(String... ttnNumber) {
        StringBuilder ttn = new StringBuilder();
        for (String s : ttnNumber) {
            ttn.append(s).append("\t");
        }
        return String.valueOf(ttn);
    }

    public static void setSettings(XWPFRun runConfig) {
        runConfig.setFontFamily("Times New Roman");
        runConfig.setFontSize(12);
        runConfig.setColor("000000");
    }

}
