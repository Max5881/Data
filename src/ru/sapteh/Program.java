package ru.sapteh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Program {
    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader ekz = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату экзамена:(число,месяц,год) пример 15.9.2020");
        String DateEkz = ekz.readLine();

        Date date = new Date();
        String strDate1 = DateEkz;

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String Format = dateFormat.format(date);
        DateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
        Date date2 = dateFormat1.parse(strDate1);
        quantity(date,date2);

        System.out.println(switch (date.compareTo(date2)) {
            case 0 -> "Экзамен сегодня"+quantity(date,date2);
            case 1 -> "До экзамена осталось"+quantity(date,date2);
            case -1 -> "Экзамен был"+quantity(date,date2);
            default -> "Not correct";
        });
    }
    public static int quantity(Date date,Date date2){
        int quantityDate = ((int)((date.getTime()- date2.getTime())/1000/24/60/60));


        return quantityDate;
    }

}
