package com.femteca;

//import java.sql.SQLException;

//import com.femteca.config.DBManager;
import com.femteca.model.Book;
import com.femteca.repository.BookRepositoryImpl;

public class App 
{
    public static void main( String[] args )
    {
      /*  try {
           DBManager.getConnection();
           System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/ 
        Book book = new Book("El libro sin nombre", "Anonymo", "Durante siglos una libreria perdida en el mundo ha escondido un secreto. En sus estantes hay un misterioso libro sin nombre ni autor. Quien lo lee… acaba muerto.", "978-8-46664-439-6", "Novela");
        BookRepositoryImpl repo = new BookRepositoryImpl();
        repo.createBook(book);

    }
}
