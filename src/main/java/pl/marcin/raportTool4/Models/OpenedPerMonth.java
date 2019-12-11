package pl.marcin.raportTool4.Models;

import pl.marcin.raportTool4.Repositories.ConvertedRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenedPerMonth {

    private int selectedYear;
    private String selectedMonth;

    private List<Integer> years;
    private List<String> months;
    private List<String> types;

    private List<Integer> dnsDatas;
    private List<Integer> sslDatas;
    private List<Integer> ipMgmtDatas;
    private List<Integer> domainMgmtDatas;
    private List<Integer> otherDatas;
    private int selectedMonthIndex;
    private List<String> sortedMonths;
    private String ba;

    public List<String> getSortedMonths() {
        return sortedMonths;
    }

    public OpenedPerMonth() {
    }

    public OpenedPerMonth(int selectedYear, String selectedMonth, ConvertedRepository convertedRepository, String ba) {
        this.months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        this.selectedYear = selectedYear;
        this.selectedMonth = selectedMonth;
        this.selectedMonthIndex = this.months.indexOf(this.selectedMonth);
        sortedMonths = new ArrayList<>();
        this.otherDatas = new ArrayList<>();
        this.domainMgmtDatas = new ArrayList<>();
        this.ipMgmtDatas = new ArrayList<>();
        this.sslDatas = new ArrayList<>();
        this.dnsDatas = new ArrayList<>();

        int j = 0;

        if(ba.equals("all")) {
            for (int i = 1; i <= months.size(); i++) {
                if ((selectedMonthIndex + i) < months.size()) {
                    sortedMonths.add(months.get(selectedMonthIndex + i));
                    this.otherDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("Other", selectedYear - 1, (selectedMonthIndex + i + 1)));
                    this.domainMgmtDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("Domain mgmt", selectedYear - 1, (selectedMonthIndex + i + 1)));
                    this.ipMgmtDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("IP mgmt", selectedYear - 1, (selectedMonthIndex + i + 1)));
                    this.sslDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("SSL Certificate", selectedYear - 1, (selectedMonthIndex + i + 1)));
                    this.dnsDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("DNS", selectedYear - 1, (selectedMonthIndex + i + 1)));


                } else {
                    sortedMonths.add(months.get(selectedMonthIndex - (months.size() - i)));
                    this.otherDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("Other", selectedYear, j + 1));
                    this.domainMgmtDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("Domain mgmt", selectedYear, j + 1));
                    this.ipMgmtDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("IP Mgmt", selectedYear, j + 1));
                    this.sslDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("SSL Certificate", selectedYear, j + 1));
                    this.dnsDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWith("DNS", selectedYear, j + 1));
                    j++;
                }
            }
        } else {
            for (int i = 1; i <= months.size(); i++) {
                if ((selectedMonthIndex + i) < months.size()) {
                    sortedMonths.add(months.get(selectedMonthIndex + i));
                    this.otherDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("Other", selectedYear - 1, (selectedMonthIndex + i + 1), ba));
                    this.domainMgmtDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("Domain mgmt", selectedYear - 1, (selectedMonthIndex + i + 1), ba));
                    this.ipMgmtDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("IP mgmt", selectedYear - 1, (selectedMonthIndex + i + 1), ba));
                    this.sslDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("SSL Certificate", selectedYear - 1, (selectedMonthIndex + i + 1), ba));
                    this.dnsDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("DNS", selectedYear - 1, (selectedMonthIndex + i + 1), ba));


                } else {
                    sortedMonths.add(months.get(selectedMonthIndex - (months.size() - i)));
                    this.otherDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("Other", selectedYear, j + 1, ba));
                    this.domainMgmtDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("Domain mgmt", selectedYear, j + 1, ba));
                    this.ipMgmtDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("IP Mgmt", selectedYear, j + 1, ba));
                    this.sslDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("SSL Certificate", selectedYear, j + 1, ba));
                    this.dnsDatas.add(convertedRepository.countByRequestTypeAndOpenDateStartsWithAndBa("DNS", selectedYear, j + 1, ba));
                    j++;
                }
            }
        }
        this.years = new ArrayList<>();
        for(int i = LocalDate.now().getYear(); i >= 2016; i--) {
            years.add(i);
        }
        this.types = Arrays.asList("Other", "Domain mgmt", "IP mgmt", "SSL Certificate", "DNS");
    }

    public List<String> getTypes() {
        return types;
    }

    public List<Integer> getDnsDatas() {
        return dnsDatas;
    }

    public void setDnsDatas(List<Integer> dnsDatas) {
        this.dnsDatas = dnsDatas;
    }

    public void addDnsData(Integer dnsData) {
        this.dnsDatas.add(dnsData);
    }

    public List<Integer> getSslDatas() {
        return sslDatas;
    }

    public void setSslDatas(List<Integer> sslDatas) {
        sslDatas = sslDatas;
    }

    public void addSslData(Integer sslData) {
        this.sslDatas.add(sslData);
    }

    public List<Integer> getIpMgmtDatas() {
        return ipMgmtDatas;
    }

    public void setIpMgmtDatas(List<Integer> ipMgmtDatas) {
        ipMgmtDatas = ipMgmtDatas;
    }

    public void addIpMgmtData(Integer ipMgmtData) {
        this.ipMgmtDatas.add(ipMgmtData);
    }

    public List<Integer> getDomainMgmtDatas() {
        return domainMgmtDatas;
    }

    public int getSelectedMonthIndex() {
        return selectedMonthIndex;
    }

    public void setDomainMgmtDatas(List<Integer> domainMgmtData) {
        domainMgmtDatas = domainMgmtData;
    }

    public void addDomainMgmtData(Integer domainMgmtData) {
        this.dnsDatas.add(domainMgmtData);
    }

    public List<Integer> getOtherDatas() {
        return otherDatas;
    }

    public void setOtherDatas(List<Integer> otherDatas) {
        otherDatas = otherDatas;
    }

    public void addOtherData(Integer otherData) {
        this.otherDatas.add(otherData);
    }

    public List<String> getMonths() {
        return months;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }
}
