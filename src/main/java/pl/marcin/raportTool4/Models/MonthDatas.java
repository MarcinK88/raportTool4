package pl.marcin.raportTool4.Models;

import pl.marcin.raportTool4.Repositories.ConvertedRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonthDatas {

    private int selectedYear;
    private String selectedMonth;
    private List<String> months;
    private List<String> bas;
    private int selectedMonthIndex;
    private List<String> sortedMonths;
    private List<Integer> coDatas;
    private List<Integer> isDatas;
    private List<Integer> mxDatas;
    private List<Integer> seDatas;
    private List<Integer> etDatas;
    private List<Integer> ctDatas;
    private List<Integer> apacDatas;
    private List<Integer> emeaDatas;
    private List<Integer> latamDatas;
    private List<Integer> naDatas;
    private int totalDnsDatas;
    private int totalSslDatas;
    private int totalIpDatas;
    private int totalDomainDatas;
    private int totalOtherDatas;
    private List<Double> kpi1;
    private List<Double> kpi2;
    private double kpi3DnsDatas;
    private double kpi3SslDatas;
    private double kpi3IpDatas;
    private double kpi3DomainDatas;
    private double kpi3OtherDatas;
    private String selectedBa;




    public MonthDatas() {
    }

    public MonthDatas(int selectedYear, String selectedMonth, ConvertedRepository convertedRepository, String selectedBa) {
        this.months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        this.selectedYear = selectedYear;
        this.selectedMonth = selectedMonth;
        this.selectedMonthIndex = this.months.indexOf(this.selectedMonth);
        sortedMonths = new ArrayList<>();
        this.bas = new ArrayList<>();

        this.coDatas = new ArrayList<>();
        this.isDatas = new ArrayList<>();
        this.mxDatas = new ArrayList<>();
        this.seDatas = new ArrayList<>();
        this.etDatas = new ArrayList<>();
        this.ctDatas = new ArrayList<>();
        this.apacDatas = new ArrayList<>();
        this.emeaDatas = new ArrayList<>();
        this.latamDatas = new ArrayList<>();
        this.naDatas = new ArrayList<>();
        this.kpi1 = new ArrayList<>();
        this.kpi2 = new ArrayList<>();
        this.selectedBa = selectedBa;
        Date date = Date.valueOf(selectedYear + "-" + (selectedMonthIndex+1) + "-01");

        for(int i = 1; i <= 3; i++) {
            if ((selectedMonthIndex + i - 3) >= 0) {
                sortedMonths.add(months.get(selectedMonthIndex + i - 3));
                coDatas.add(convertedRepository.countRequestPerBa("CO", selectedYear,selectedMonthIndex + i - 2));
                isDatas.add(convertedRepository.countRequestPerBa("IS", selectedYear,selectedMonthIndex + i - 2));
                mxDatas.add(convertedRepository.countRequestPerBa("MX", selectedYear,selectedMonthIndex + i - 2));
                seDatas.add(convertedRepository.countRequestPerBa("SE", selectedYear,selectedMonthIndex + i - 2));
                etDatas.add(convertedRepository.countRequestPerBa("ET", selectedYear,selectedMonthIndex + i - 2));
                ctDatas.add(convertedRepository.countRequestPerBa("CT", selectedYear,selectedMonthIndex + i - 2));
                apacDatas.add(convertedRepository.countRequestPerRegion("APAC", selectedYear, selectedMonthIndex + i - 2));
                emeaDatas.add(convertedRepository.countRequestPerRegion("EMEA", selectedYear, selectedMonthIndex + i - 2));
                latamDatas.add(convertedRepository.countRequestPerRegion("LATAM", selectedYear, selectedMonthIndex + i - 2));
                naDatas.add(convertedRepository.countRequestPerRegion("NA", selectedYear, selectedMonthIndex + i - 2));
            } else {

                sortedMonths.add(months.get(months.size() - 3 + i + selectedMonthIndex));
                coDatas.add(convertedRepository.countRequestPerBa("CO", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                isDatas.add(convertedRepository.countRequestPerBa("IS", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                mxDatas.add(convertedRepository.countRequestPerBa("MX", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                seDatas.add(convertedRepository.countRequestPerBa("SE", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                etDatas.add(convertedRepository.countRequestPerBa("ET", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                ctDatas.add(convertedRepository.countRequestPerBa("CT", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                apacDatas.add(convertedRepository.countRequestPerRegion("APAC",selectedYear-1, months.size() - 2 + i + selectedMonthIndex ));
                emeaDatas.add(convertedRepository.countRequestPerRegion("EMEA",selectedYear-1, months.size() - 2 + i + selectedMonthIndex ));
                latamDatas.add(convertedRepository.countRequestPerRegion("LATAM",selectedYear-1, months.size() - 2 + i + selectedMonthIndex ));
                naDatas.add(convertedRepository.countRequestPerRegion("NA",selectedYear-1, months.size() - 2 + i + selectedMonthIndex ));


            }

            kpi1.add(convertedRepository.kpi1(Date.valueOf(date.toLocalDate().minusMonths(3).plusMonths(i).toString()),
                    Date.valueOf(date.toLocalDate().minusMonths(2).plusMonths(i).toString())));

            kpi2.add(convertedRepository.kpi2(Date.valueOf(date.toLocalDate().minusMonths(3).plusMonths(i).toString()),
                    Date.valueOf(date.toLocalDate().minusMonths(2).plusMonths(i).toString())));

            }

        if(selectedBa.equals("all")) {
            Date dateFrom = Date.valueOf(date.toLocalDate().minusMonths(2).toString());
            Date dateTo = Date.valueOf(date.toLocalDate().plusMonths(1).toString());
            this.totalDnsDatas = convertedRepository.countRequestPerType("DNS", dateFrom, dateTo);
            this.totalSslDatas = convertedRepository.countRequestPerType("SSL Certificate", dateFrom, dateTo);
            this.totalIpDatas = convertedRepository.countRequestPerType("IP mgmt", dateFrom, dateTo);
            this.totalDomainDatas = convertedRepository.countRequestPerType("Domain mgmt", dateFrom, dateTo);
            this.totalOtherDatas = convertedRepository.countRequestPerType("Other", dateFrom, dateTo);
        } else {
            this.totalDnsDatas = convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("DNS", selectedYear, selectedMonthIndex + 1, selectedBa );
            this.totalSslDatas = convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("SSL Certificate", selectedYear, selectedMonthIndex + 1, selectedBa);
            this.totalIpDatas = convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("IP mgmt", selectedYear, selectedMonthIndex + 1, selectedBa);
            this.totalDomainDatas = convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("Domain mgmt", selectedYear, selectedMonthIndex + 1, selectedBa);
            this.totalOtherDatas = convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("Other", selectedYear, selectedMonthIndex + 1, selectedBa);


        }

        this.kpi3DnsDatas = convertedRepository.kpi3("DNS", Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));
        this.kpi3SslDatas = convertedRepository.kpi3("SSL Certificate", Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));
        this.kpi3IpDatas = convertedRepository.kpi3("IP mgmt", Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));
        this.kpi3DomainDatas = convertedRepository.kpi3("Domain mgmt", Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));
        this.kpi3OtherDatas = convertedRepository.kpi3("Other", Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));

        this.bas = Arrays.asList("CO", "IS", "MX", "SE", "ET", "CT");



    }

    public List<Double> getKpi1() {
        return kpi1;
    }

    public List<Double> getKpi2() {
        return kpi2;
    }

    public double getKpi3DnsDatas() {
        return kpi3DnsDatas;
    }

    public double getKpi3SslDatas() {
        return kpi3SslDatas;
    }

    public double getKpi3IpDatas() {
        return kpi3IpDatas;
    }

    public void setKpi3IpDatas(double kpi3IpDatas) {
        this.kpi3IpDatas = kpi3IpDatas;
    }

    public double getKpi3DomainDatas() {
        return kpi3DomainDatas;
    }

    public double getKpi3OtherDatas() {
        return kpi3OtherDatas;
    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public List<String> getMonths() {
        return months;
    }


    public List<String> getBas() {
        return bas;
    }


    public int getSelectedMonthIndex() {
        return selectedMonthIndex;
    }


    public List<String> getSortedMonths() {
        return sortedMonths;
    }


    public List<Integer> getCoDatas() {
        return coDatas;
    }


    public List<Integer> getIsDatas() {
        return isDatas;
    }


    public List<Integer> getMxDatas() {
        return mxDatas;
    }


    public List<Integer> getSeDatas() {
        return seDatas;
    }


    public List<Integer> getEtDatas() {
        return etDatas;
    }


    public List<Integer> getCtDatas() {
        return ctDatas;
    }


    public List<Integer> getApacDatas() {
        return apacDatas;
    }


    public List<Integer> getEmeaDatas() {
        return emeaDatas;
    }


    public List<Integer> getLatamDatas() {
        return latamDatas;
    }


    public List<Integer> getNaDatas() {
        return naDatas;
    }


    public int getTotalDnsDatas() {
        return totalDnsDatas;
    }


    public int getTotalSslDatas() {
        return totalSslDatas;
    }


    public int getTotalIpDatas() {
        return totalIpDatas;
    }


    public int getTotalDomainDatas() {
        return totalDomainDatas;
    }


    public int getTotalOtherDatas() {
        return totalOtherDatas;
    }

}