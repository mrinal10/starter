package com.techmojo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TransactionElement {
    private String transactionId;
    private Date startDate;
    private Date endDate;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransactionElement other = (TransactionElement) obj;
        if (transactionId == null) {
            if (other.transactionId != null)
                return false;
        } else if (!transactionId.equals(other.transactionId))
            return false;
        return true;
    }
}

class TransactionAverageTime {
    private static final String START_TRANSACTION = "start";
    private static Map<String, TransactionElement> transactionsMap = new HashMap<>();
    private static String filePath = "C:\\Users\\MRINAL\\Desktop\\transaction.txt";
    private static String dateFormatString = "yyyy/MM/dd HH:mm aa";

    public static void main(String[] args) throws IOException, ParseException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            String st;
            while ((st = br.readLine()) != null) {
                st = st.replace(" ", "");
                st = st.replace("�", "/");
                processLine(st);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printDetails();
    }

    private static void printDetails() {
        transactionsMap.forEach((tId, transaction) -> {
            if (transaction.getStartDate() != null && transaction.getEndDate() != null) {
                System.out
                        .println(tId + ":::" + calculateDateDiff(transaction.getEndDate(), transaction.getStartDate()));
            } else {
                System.out.println("Insufficient data for transaction id : " + tId);
            }
        });
    }

    private static Date calculateDateDiff(Date endDate, Date startDate) {
        return new Date(startDate.getTime() + ((endDate.getTime() - startDate.getTime()) / 2));
    }

    private static void processLine(String eachLine) throws ParseException {
        List<String> transactionDetaillist = Arrays.asList(eachLine.split(","));
        String transactionId = transactionDetaillist.get(0).trim();
        Date processedDate = processDate(transactionDetaillist, "/");
        TransactionElement tElement = new TransactionElement();
        String transactionState = transactionDetaillist.get(3).trim();

        if (transactionState.contains(START_TRANSACTION)) {
            tElement.setTransactionId(transactionId);
            tElement.setStartDate(processedDate);
        } else {
            if (transactionsMap.containsKey(transactionId)) {
                tElement = transactionsMap.get(transactionId);
                tElement.setEndDate(processedDate);
            }
        }
        transactionsMap.put(transactionId, tElement);
    }

    private static Date processDate(List<String> transactionDetaillist, String parser) throws ParseException {
        String dateOftransaction = transactionDetaillist.get(1).trim();
        String timeOfTransaction = transactionDetaillist.get(2).trim();
        timeOfTransaction = timeOfTransaction.replace(parser, "");
        timeOfTransaction = timeOfTransaction.substring(0, timeOfTransaction.length() - 2) + " "
                + timeOfTransaction.substring(timeOfTransaction.length() - 2, timeOfTransaction.length());
        return new SimpleDateFormat(dateFormatString).parse(dateOftransaction + " " + processTime(timeOfTransaction));
    }

    private static String processTime(String transactionTime) throws NumberFormatException {
        String modHr = transactionTime;
        if (transactionTime.endsWith("pm")) {
            String[] times = transactionTime.split(":");
            modHr = String.valueOf(Integer.parseInt(times[0]) + 12) + ":" + times[1];
        }
        return modHr;
    }
}