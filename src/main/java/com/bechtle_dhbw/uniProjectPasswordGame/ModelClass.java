package com.bechtle_dhbw.uniProjectPasswordGame;


public class ModelClass {

    public static boolean isValidPassword(String password) {
        return  isMinLength(password) &&
                containsNumber(password) &&
                containsUppercase(password) &&
                containsSpecialCharacter(password) &&
                digitsSumTo42(password) &&
                containsMonth(password) &&
                containsRomanNumeral(password) &&
                containsSponsor(password) &&
                containsDopamineSymbol(password) &&
                containsRomeYear(password) &&
                containsRainbowColor(password) &&
                containsAnimalStartingWithL(password);
    }

    private static boolean isMinLength(String password) {
        return password.length() >= 5;
    }

    private static boolean containsNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean containsUppercase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()].*");
    }

    private static boolean digitsSumTo42(String password) {
        int sum = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum == 42;
    }

    private static boolean containsMonth(String password) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (String month : months) {
            if (password.contains(month)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsRomanNumeral(String password) {
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String numeral : romanNumerals) {
            if (password.contains(numeral)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSponsor(String password) {
        String[] sponsors = {"Bechtle", "Apple", "DHBW"};
        for (String sponsor : sponsors) {
            if (password.contains(sponsor)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDopamineSymbol(String password) {
        return password.contains("C8H11NO2");
    }

    private static boolean containsRomeYear(String password) {
        return password.contains("753");
    }

    private static boolean containsRainbowColor(String password) {
        String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
        for (String color : colors) {
            if (password.contains(color)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsAnimalStartingWithL(String password) {
        String[] animals = {"Lion", "Leopard", "Llama", "Lynx", "Lobster"};
        for (String animal : animals) {
            if (password.contains(animal)) {
                return true;
            }
        }
        return false;
    }
}
