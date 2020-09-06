package com.book;

public class BookTest {

    public static void main(String[] args) {

        // checking book
        Book testBook = new Book("K. Marx", "Das Kapital", 1867, "9781512111521");

        System.out.println(testBook);



        // giving that book a wrong isbn
        testBook.setIsbn("9781681972712"); // test with wrong control digit
        System.out.println("\n" + testBook);

        testBook.setIsbn("978168197271a"); // testing with non-numeric strings
        System.out.println("\n" + testBook);

        testBook.setIsbn("97816819727123333333"); // testing with amount of characters more than 13
        System.out.println("\n" + testBook);

        testBook.setIsbn("978168197"); // testing with amount of characters less than 13
        System.out.println("\n" + testBook);

        testBook.setIsbn("978168ab19cd7271A2"); // combining more characters and non-digits
        System.out.println("\n" + testBook);

        testBook.setIsbn("9!781?a6819"); // combining less characters and non-digits
        System.out.println("\n" + testBook);



        // changing properties of book and printing them
        testBook.setAuthor("Unknown");
        testBook.setName("Domostroy");
        testBook.setYearOfWriting(1547);
        testBook.setIsbn("9785171044121");



        // summary
        System.out.println("\n" + testBook);

    }

}
