package com.gate_machine.result.tips;

/**
 * 返回给前台的成功提示
 *
 * @author
 * @date 2016年11月12日 下午5:05:22
 */
public class SuccessTip extends Tip {

	private Object data;


	public SuccessTip(){
		super();
		super.success = true;
		super.code = 200;
		super.message = "操作成功";
	}

	public SuccessTip(String message){
		super.success = true;
		super.code = 200;
		super.message = message;
	}

	public SuccessTip data(Object data){
		this.data = data;
		return this;
	}
    
    public SuccessTip msg(String msg){
        this.setMessage(msg);
        return this;
    }

    
    public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
