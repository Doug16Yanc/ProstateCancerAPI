package douglas.apiRestDoug.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class RegionException extends RuntimeException{

    public ProblemDetail toProblemDetail(){
        var problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("Region data already exists. Check the possibility of updating, please!");

        return problemDetail;
    }
}
