package com.gate_machine.result.tips;



/**
 * 返回给前台的错误提示
 *
 * @author
 * @date 2016年11月12日 下午5:05:22
 */
public class ErrorTip extends Tip {

    private Object data;

    public ErrorTip(int code, String message) {
        super();
        this.success = false;
        this.code = code;
        this.message = message;
    }


    public ErrorTip data(Object data){
        this.data = data;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
