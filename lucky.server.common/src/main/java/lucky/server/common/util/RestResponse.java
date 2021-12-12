package lucky.server.common.util;

public class RestResponse {
    private int code;
    private String msg;
    private Object data;

    public RestResponse(int code){
        this.code = code;
    }

    public RestResponse(int code, String msg){
        this(code);
        this.msg = msg;
    }
    public RestResponse(int code, String msg, Object data){
        this(code, msg);
        this.data = data;
    }

    public static RestResponse success(){
        return new RestResponse(200);
    }

    public static RestResponse success(Object data){
        return new RestResponse(200, "", data);
    }

    public static RestResponse successWithMsg(String msg){
        return new RestResponse(200, msg);
    }

    public static RestResponse success(String msg, Object data){
        return new RestResponse(200, msg, data);
    }

    public static RestResponse badRequest(String msg){
        return new RestResponse(400, msg);
    }

    public static RestResponse internalServerError(String msg){
        return new RestResponse(500, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
