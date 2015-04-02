//http://blog.db.idv.tw/2010/12/javachecked-exception-runtime.html
package com.iisi.api.execption;

/**
 * FileSysException
 * 繼承RuntimeException自定例外類別
 * 因RuntimeException在執行時才會發生，不需強制放try-catch或往上層拋例外(throws Exception)
 * @author User
 *
 */
public class FileSysException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileSysException(){
		super();
	}
	
	public FileSysException(String message){
		super(message);
	}
	
	public FileSysException(String message, Throwable cause){
		super(message, cause);
	}
	
	public FileSysException(Throwable cause){
		super(cause);
	}

}
