package ch04.app.main;

import ch04.app.entity.Author;
import ch04.app.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("unit07").createEntityManager();
        em.getTransaction().begin();
        Author author = new Author();
        author.setName("Author1");
        //em.persist(author);

        Book book = new Book();
        book.setAuthor(author);
        book.setPages(1);
        book.setTitle("Book1");

        //author.setBook(book);

        em.persist(book);

        em.getTransaction().commit();
    }
}
