package utils;

public class ExceptionMessages {

    public static String amountOfResultsError(int expectedNumberOfResults) {
        return "amount of results is NOT sufficient, it's less than " + expectedNumberOfResults;
    }
}