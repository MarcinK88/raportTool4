package pl.marcin.raportTool4.Services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import pl.marcin.raportTool4.Models.Ticket;
import pl.marcin.raportTool4.Repositories.ConvertedRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Import {

    public static List<Ticket> createTickets(MultipartFile file, ConvertedRepository convertedRepository) throws IOException {




        XSSFWorkbook myWorkBook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();

        List<Ticket> ticket2s = new ArrayList<>();
        DateConverter dateConverter;

        Row row = rowIterator.next();
        DataFormatter fmt = new DataFormatter();
        while (rowIterator.hasNext()) {
            row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            String valueToInsert = "";
            while (cellIterator.hasNext()) {


                Ticket ticket2 = new Ticket();
                valueToInsert = cellIterator.next().toString();
                ticket2.setNumber(valueToInsert);

                //pobieramy datę z pliku
                valueToInsert = cellIterator.next().toString();

                //tworzymy konwerter daty
                dateConverter = new DateConverter(valueToInsert);

                //używamy konwertera daty
                java.sql.Date sqlDate = dateConverter.toSqlDate();

                //przypisujemy przekonwertowaną datę
                ticket2.setOpen_time(sqlDate);

                ticket2.setOpened_by(fmt.formatCellValue(cellIterator.next()));
                ticket2.setAssignment(cellIterator.next().toString());
                ticket2.setStatus(cellIterator.next().toString());

                //pobieramy datę z pliku
                valueToInsert = cellIterator.next().toString();

                //tworzymy konwerter daty
                dateConverter = new DateConverter(valueToInsert);

                //używamy konwertera daty
                sqlDate = dateConverter.toSqlDate();

                //przypisujemy przekonwertowaną datę
                ticket2.setClose_time(sqlDate);
                ticket2.setResolution_code(cellIterator.next().toString());
                ticket2.setLocation(cellIterator.next().toString());
                //
                ticket2.setAssignee_name(fmt.formatCellValue(cellIterator.next()));
                ticket2.setContact_name(fmt.formatCellValue(cellIterator.next()));
                ticket2.setCompany(cellIterator.next().toString());
                ticket2.setBrief_description(cellIterator.next().toString());
                ticket2.setProblem_status(cellIterator.next().toString());
                ticket2.setRequest_type(cellIterator.next().toString());
                ticket2.setProduct_type(cellIterator.next().toString());
                ticket2.setResolved_by(cellIterator.next().toString());

                //pobieramy datę z pliku
                valueToInsert = cellIterator.next().toString();

                //tworzymy konwerter daty
                dateConverter = new DateConverter(valueToInsert);

                //używamy konwertera daty
                sqlDate = dateConverter.toSqlDate();

                ticket2.setResolved_time(sqlDate);
                ticket2.setContact_service(fmt.formatCellValue(cellIterator.next()));
                ticket2.setTk_contact_fullname(cellIterator.next().toString());
                ticket2.setTk_contact_email(cellIterator.next().toString());
                ticket2.setTk_sap_company_full_name(cellIterator.next().toString());
                ticket2.setTk_assignee_name_fullname(cellIterator.next().toString());
                ticket2.setTk_contact_service_fullname(cellIterator.next().toString());
                ticket2.setTk_callback_contact_ldap_ba(cellIterator.next().toString());
                ticket2.setBa(cellIterator.next().toString());
                ticket2.setTk_country_fullname(cellIterator.next().toString());
                ticket2.setDim_regions_id(cellIterator.next().toString());
                ticket2.setTk_company_id(fmt.formatCellValue(cellIterator.next()));

                ticket2s.add(ticket2);


                convertedRepository.save(TicketConverter.convertTicket(ticket2));

            }


        }
                return ticket2s;
    }

}
