package com.dxc.assessment;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.dxc.assessment.dao.AuthorDao;
import com.dxc.assessment.modal.Author;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        findAllAuthor();
    }

    static void findAllAuthor() {

        AuthorDao dao = new AuthorDao();

        try {
            List<Author> author = dao.findAll();
            if (author.size() == 0) {
                System.out.println("No author found");
                return;
            }
            author.forEach(au -> System.out.println(au));
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    static void createAuthor() {
        Author swetha = new Author(0, "suneel", "attipati", "11th", "suneelgmail.com");
        Author rahul = new Author(0, "ramurahul", "kannam", "10th", "rahul@gmail.com");
        Author sai = new Author(0, "sai", "kumar", "10th", "kumar@gmail.com");

        List<Author> author = List.of(suneel, ramurahul, sai);
        AuthorDao authorDao = new AuthorDao();

        author.forEach(au -> {
            try {
                Author rows = authorDao.create(au);
                System.out.println("Rows affected: " + rows);
            } catch (SQLDataException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });
    }
}