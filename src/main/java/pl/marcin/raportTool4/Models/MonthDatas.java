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




    public MonthDatas() {
    }

    public MonthDatas(int selectedYear, String selectedMonth, ConvertedRepository convertedRepository) {
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

            }
        Date date = Date.valueOf(selectedYear + "-" + (selectedMonthIndex+1) + "-01");
        this.totalDnsDatas = convertedRepository.countRequestPerType("DNS",Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));
        this.totalSslDatas = convertedRepository.countRequestPerType("SSL Certificate",Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));
        this.totalIpDatas = convertedRepository.countRequestPerType("IP mgmt",Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));
        this.totalDomainDatas = convertedRepository.countRequestPerType("Domain mgmt",Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));
        this.totalOtherDatas = convertedRepository.countRequestPerType("Other",Date.valueOf(date.toLocalDate().minusMonths(2).toString()), Date.valueOf(date.toLocalDate().plusMonths(1).toString()));

        this.bas = Arrays.asList("CO", "IS", "MX", "SE", "ET", "CT");

    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }

    public List<String> getBas() {
        return bas;
    }

    public void setBas(List<String> bas) {
        this.bas = bas;
    }

    public int getSelectedMonthIndex() {
        return selectedMonthIndex;
    }

    public void setSelectedMonthIndex(int selectedMonthIndex) {
        this.selectedMonthIndex = selectedMonthIndex;
    }

    public List<String> getSortedMonths() {
        return sortedMonths;
    }

    public void setSortedMonths(List<String> sortedMonths) {
        this.sortedMonths = sortedMonths;
    }

    public List<Integer> getCoDatas() {
        return coDatas;
    }

    public void setCoDatas(List<Integer> coDatas) {
        this.coDatas = coDatas;
    }

    public List<Integer> getIsDatas() {
        return isDatas;
    }

    public void setIsDatas(List<Integer> isDatas) {
        this.isDatas = isDatas;
    }

    public List<Integer> getMxDatas() {
        return mxDatas;
    }

    public void setMxDatas(List<Integer> mxDatas) {
        this.mxDatas = mxDatas;
    }

    public List<Integer> getSeDatas() {
        return seDatas;
    }

    public void setSeDatas(List<Integer> seDatas) {
        this.seDatas = seDatas;
    }

    public List<Integer> getEtDatas() {
        return etDatas;
    }

    public void setEtDatas(List<Integer> etDatas) {
        this.etDatas = etDatas;
    }

    public List<Integer> getCtDatas() {
        return ctDatas;
    }

    public void setCtDatas(List<Integer> ctDatas) {
        this.ctDatas = ctDatas;
    }

    public List<Integer> getApacDatas() {
        return apacDatas;
    }

    public void setApacDatas(List<Integer> apacDatas) {
        this.apacDatas = apacDatas;
    }

    public List<Integer> getEmeaDatas() {
        return emeaDatas;
    }

    public void setEmeaDatas(List<Integer> emeaDatas) {
        this.emeaDatas = emeaDatas;
    }

    public List<Integer> getLatamDatas() {
        return latamDatas;
    }

    public void setLatamDatas(List<Integer> latamDatas) {
        this.latamDatas = latamDatas;
    }

    public List<Integer> getNaDatas() {
        return naDatas;
    }

    public void setNaDatas(List<Integer> naDatas) {
        this.naDatas = naDatas;
    }

    public int getTotalDnsDatas() {
        return totalDnsDatas;
    }

    public void setTotalDnsDatas(int totalDnsDatas) {
        this.totalDnsDatas = totalDnsDatas;
    }

    public int getTotalSslDatas() {
        return totalSslDatas;
    }

    public void setTotalSslDatas(int totalSslDatas) {
        this.totalSslDatas = totalSslDatas;
    }

    public int getTotalIpDatas() {
        return totalIpDatas;
    }

    public void setTotalIpDatas(int totalIpDatas) {
        this.totalIpDatas = totalIpDatas;
    }

    public int getTotalDomainDatas() {
        return totalDomainDatas;
    }

    public void setTotalDomainDatas(int totalDomainDatas) {
        this.totalDomainDatas = totalDomainDatas;
    }

    public int getTotalOtherDatas() {
        return totalOtherDatas;
    }

    public void setTotalOtherDatas(int totalOtherDatas) {
        this.totalOtherDatas = totalOtherDatas;
    }
}