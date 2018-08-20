package site.timely.exception;

/**
 * 应用异常
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/16
 * @since 1.0-SNAPSHOT
 */
public class ApplicationException extends RuntimeException implements ExceptionAdapter {

    private ExceptionBody body;

    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(ExceptionAdapter adapter) {
        this.setAdapter(adapter);
    }

    public ApplicationException(String code, ExceptionLevel level, String description, String solution) {
        this.body = new ExceptionBody(code, level, description, solution);
    }

    public ExceptionBody getBody() {
        return body;
    }

    public void setBody(ExceptionBody body) {
        this.body = body;
    }

    @Override
    public String getCode() {
        return body.getCode();
    }

    @Override
    public void setCode(String code) {
        body.setCode(code);
    }

    @Override
    public ExceptionLevel getLevel() {
        return body.getLevel();
    }

    @Override
    public void setLevel(ExceptionLevel level) {
        body.setLevel(level);
    }

    @Override
    public String getDescription() {
        return body.getDescription();
    }

    @Override
    public void setDescription(String description) {
        body.setDescription(description);
    }

    @Override
    public String getSolution() {
        return body.getSolution();
    }

    @Override
    public void setSolution(String solution) {
        body.setSolution(solution);
    }

    @Override
    public ExceptionAdapter setAdapter(ExceptionAdapter adapter) {
        return body.setAdapter(adapter);
    }

}
