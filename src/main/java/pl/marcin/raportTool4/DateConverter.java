package pl.marcin.raportTool4;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter {

    private String dateToConvert;
    private java.util.Date utilDate;
    private Date sqlDate;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");


    public DateConverter(String dateToConvert) {
        this.dateToConvert = dateToConvert;
    }

    public Date toSqlDate(){

        try {

            utilDate = format.parse(dateToConvert);
            sqlDate = new Date(utilDate.getTime());
            return sqlDate;

        } catch (ParseException e) {
            return null;
        }

    }


}
