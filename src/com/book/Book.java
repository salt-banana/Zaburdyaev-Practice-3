package com.book;

public class Book {

    private String author;
    private String name;
    private long yearOfPublishing;
    private String isbn;
    private static final int isbnLength = 13;



    public Book() {}

    public Book(String author, String name, long yearOfPublishing, String isbn) {
        this.author = author;
        this.name = name;
        this.yearOfPublishing = yearOfPublishing;
        this.isbn = isbn;
    }



    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }



    public void setYearOfWriting(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public long getYearOfWriting() {
        return this.yearOfPublishing;
    }



    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return this.isbn;
    }


    private boolean checkIsbn() {

        try {
            Long.parseLong(this.isbn);
        }
        catch(NumberFormatException e) {
            return false;
        }


        if (this.isbn.length() != 13)
            return false;



        // by this algo you should multiply digits by 3 and 1 in turn backwards.
        // for example 12th digit is multiplied by 3, 11th digit is multiplied by 1 and so on.
        // then you should add this numbers, then divide that sum by 10 and get the remainder.
        // if result is not zero then subtract that result from 10.
        // check if result equals to 13th digit of isbn.
        // SOURCE: https://isbn-information.com/check-digit-for-the-13-digit-isbn.html

        // Expression (3-2*(i%2)) switches between 3 and 1 at every step.



        int digit;
        int controlDigit;
        int initialControlDigit = Integer.parseInt( Character.toString( this.isbn.charAt(isbnLength-1) ) );
        int digitSum = 0;



        for (int i = 0; i < isbnLength-1; i++) {
            digit = Integer.parseInt( ( Character.toString( this.isbn.charAt(isbnLength-2-i) ) ) );
            digitSum += digit * (3-2*(i%2));
        }



        controlDigit = digitSum % 10;

        if (controlDigit != 0)
            controlDigit = 10 - controlDigit;



        return controlDigit == initialControlDigit;

    }



    @Override
    public String toString() {
        String out = "SUMMARY:\n" + "AUTHOR: " + this.author + "\nNAME: " + this.name + "\nYEAR OF PUBLISHING: " + this.yearOfPublishing
        + "\nISBN: ";
        if (checkIsbn())
            out += this.isbn;
        else
            out += "INVALID ISBN (" + this.isbn + ")";
        return out;
    }

}
