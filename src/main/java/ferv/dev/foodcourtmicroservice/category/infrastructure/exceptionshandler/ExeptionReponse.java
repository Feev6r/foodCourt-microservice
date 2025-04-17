package ferv.dev.foodcourtmicroservice.category.infrastructure.exceptionshandler;

public class ExeptionReponse {

    private final String message;

    ExeptionReponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
