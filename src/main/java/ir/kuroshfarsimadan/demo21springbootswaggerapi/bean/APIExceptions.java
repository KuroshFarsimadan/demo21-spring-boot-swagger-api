package ir.kuroshfarsimadan.demo21springbootswaggerapi.bean;

import java.util.Date;

public class APIExceptions {

	private Date datetime;
	private String message;
	private String description;
	private String remoteUser;
	private String localizedMessage;

	public APIExceptions() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param timestamp
	 * @param message
	 * @param description
	 * @param cause
	 * @param localizedMessage
	 */
	public APIExceptions(Date timestamp, String message, String description, String cause, String localizedMessage) {
		super();
		this.datetime = timestamp;
		this.message = message;
		this.description = description;
		this.remoteUser = cause;
		this.localizedMessage = localizedMessage;
	}

	/**
	 * @param datetime
	 * @param message
	 * @param description
	 */
	public APIExceptions(Date datetime, String message, String description) {
		super();
		this.datetime = datetime;
		this.message = message;
		this.description = description;
	}

	/**
	 * @return the datetime
	 */
	public Date getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cause
	 */
	public String getCause() {
		return remoteUser;
	}

	/**
	 * @param cause the cause to set
	 */
	public void setCause(String cause) {
		this.remoteUser = cause;
	}

	/**
	 * @return the localizedMessage
	 */
	public String getLocalizedMessage() {
		return localizedMessage;
	}

	/**
	 * @param localizedMessage the localizedMessage to set
	 */
	public void setLocalizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Exception [datetime=" + datetime + ", message=" + message + ", description=" + description
				+ ", remoteUser=" + remoteUser + ", localizedMessage=" + localizedMessage + "]";
	}

}