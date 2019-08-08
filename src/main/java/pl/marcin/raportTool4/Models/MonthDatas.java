package pl.marcin.raportTool4.Models;

import pl.marcin.raportTool4.Repositories.ConvertedRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonthDatas {

    private int selectedYear;
    private String selectedMonth;
    private List<String> months;
    private List<String> bas;
    private List<Integer> firstMonthDatas;
    private List<Integer> secondMonthDatas;
    private List<Integer> thirdMonthDatas;
    private int selectedMonthIndex;
    private List<String> sortedMonths;
    private List<Integer> coDatas;
    private List<Integer> isDatas;
    private List<Integer> mxDatas;
    private List<Integer> seDatas;
    private List<Integer> etDatas;
    private List<Integer> ctDatas;



    public MonthDatas() {
    }

    public MonthDatas(int selectedYear, String selectedMonth, ConvertedRepository convertedRepository) {
        this.months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        this.selectedYear = selectedYear;
        this.selectedMonth = selectedMonth;
        this.selectedMonthIndex = this.months.indexOf(this.selectedMonth);
        sortedMonths = new ArrayList<>();
        this.bas = new ArrayList<>();
        this.firstMonthDatas = new ArrayList<>();
        this.secondMonthDatas = new ArrayList<>();
        this.thirdMonthDatas = new ArrayList<>();
        this.coDatas = new ArrayList<>();
        this.isDatas = new ArrayList<>();
        this.mxDatas = new ArrayList<>();
        this.seDatas = new ArrayList<>();
        this.etDatas = new ArrayList<>();
        this.ctDatas = new ArrayList<>();

        for(int i = 1; i <= 3; i++) {
            if ((selectedMonthIndex + i - 3) >= 0) {
                sortedMonths.add(months.get(selectedMonthIndex + i - 3));
                coDatas.add(convertedRepository.countRequestPerBa("CO", selectedYear,selectedMonthIndex + i - 2));
                isDatas.add(convertedRepository.countRequestPerBa("IS", selectedYear,selectedMonthIndex + i - 2));
                mxDatas.add(convertedRepository.countRequestPerBa("MX", selectedYear,selectedMonthIndex + i - 2));
                seDatas.add(convertedRepository.countRequestPerBa("SE", selectedYear,selectedMonthIndex + i - 2));
                etDatas.add(convertedRepository.countRequestPerBa("ET", selectedYear,selectedMonthIndex + i - 2));
                ctDatas.add(convertedRepository.countRequestPerBa("CT", selectedYear,selectedMonthIndex + i - 2));

            } else {

                sortedMonths.add(months.get(months.size() - 3 + i + selectedMonthIndex));
                coDatas.add(convertedRepository.countRequestPerBa("CO", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                isDatas.add(convertedRepository.countRequestPerBa("IS", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                mxDatas.add(convertedRepository.countRequestPerBa("MX", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                seDatas.add(convertedRepository.countRequestPerBa("SE", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                etDatas.add(convertedRepository.countRequestPerBa("ET", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));
                ctDatas.add(convertedRepository.countRequestPerBa("CT", selectedYear-1,months.size() - 2 + i + selectedMonthIndex ));

            }

            }
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

    public List<Integer> getFirstMonthDatas() {
        return firstMonthDatas;
    }

    public void setFirstMonthDatas(List<Integer> firstMonthDatas) {
        this.firstMonthDatas = firstMonthDatas;
    }

    public List<Integer> getSecondMonthDatas() {
        return secondMonthDatas;
    }

    public void setSecondMonthDatas(List<Integer> secondMonthDatas) {
        this.secondMonthDatas = secondMonthDatas;
    }

    public List<Integer> getThirdMonthDatas() {
        return thirdMonthDatas;
    }

    public void setThirdMonthDatas(List<Integer> thirdMonthDatas) {
        this.thirdMonthDatas = thirdMonthDatas;
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
}