package softuni.fashionshop.exceptions;

public class ArticleNotFoundException extends Throwable{
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
