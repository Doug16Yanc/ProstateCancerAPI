package douglas.apiRestDoug.exception;

import org.springframework.http.ProblemDetail;

public class RegionAlreadyExistsException extends RegionException{

    private String detail;

    public RegionAlreadyExistsException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail(){
        return super.toProblemDetail();
    }
}
