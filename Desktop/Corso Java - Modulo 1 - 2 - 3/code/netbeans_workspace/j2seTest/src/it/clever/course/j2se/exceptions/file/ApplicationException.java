package it.clever.course.j2se.exceptions.file;

public class ApplicationException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String description;
	private String detailedDescription;
	private String methodName;
	private String className;	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ApplicationException(Throwable t) {
		super(t);
	}
	
	public ApplicationException(String errorCode) {
		String msg =  ErrorFileManager.getInstance().retrieveErrorDescription(errorCode, null);
		setCode(errorCode);
		setDescription(msg);
		setDetailedDescription(msg);
	}
	public ApplicationException(String errorCode, String[] params) {
		String msg = ErrorFileManager.getInstance().retrieveErrorDescription(errorCode, params);
		setCode(errorCode);
		setDescription(msg);
		setDetailedDescription(msg);
	}
	

	public String getMessage() {
		return getCode() + " - " + getDescription() + (super.getMessage() == null ?"":super.getMessage());
	}	

}
