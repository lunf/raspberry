package com.jmango360.server.cont;

import java.util.EnumSet;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * This class will provide all the error codes & messages that will be returned
 * back to mobile client
 * 
 * @author alexandra
 *
 */
public enum JmErrorCont {

	// Generic message error code start from 1000
	GENERAL_ERROR(1000), ACCESS_DENIED(1001);

	private final int code;

	private String technicalMessage;

	private String userMessage;

	private MessageSource messageSourceBean;

	// Technical code = usercode + prefix
	private static final String TECHNICAL_PREFIX = "_tech";

	@Component
	public static class JmErrorContServiceInjector {

		@Qualifier("messageSource")
		@Autowired(required = true)
		private MessageSource messageSource;

		@PostConstruct
		public void postConstruct() {
			for (JmErrorCont rt : EnumSet.allOf(JmErrorCont.class))
				rt.setMessageSourceBean(messageSource);
		}
	}

	public void setMessageSourceBean(MessageSource messageSourceBean) {
		this.messageSourceBean = messageSourceBean;
	}

	private JmErrorCont(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public String getTechnicalMessage() {

		try {
			String techCode = String
					.format("%d%s", this.code, TECHNICAL_PREFIX);

			this.technicalMessage = messageSourceBean.getMessage(techCode,
					null, Locale.getDefault());
		} catch (Exception ex) {
			// If error, then ignored
		}

		return technicalMessage;
	}

	public String getUserMessage() {

		this.userMessage = messageSourceBean.getMessage(
				String.valueOf(this.code), null, Locale.getDefault());

		return userMessage;
	}

	@Override
	public String toString() {
		return code + ": " + userMessage;
	}

}
