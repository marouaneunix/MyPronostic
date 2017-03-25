package fr.norsys.pronostic.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * controller advice for detecting handling exceptions controller Created by
 *
 */
@ControllerAdvice
public class GlobalDefaultException {

	private static final String DEFAULT_ERROR_VIEW = "errorPage";

	/**
	 * default handler for NoHandlerFoundException exception
	 *
	 * @throws NoHandlerFoundException
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public ModelAndView badRequestErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception ex)
			throws NoHandlerFoundException {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.addObject("status", res.getStatus());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	/**
	 * default handler for Any exception
	 *
	 */
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse res, DataServiceException e)
			throws DataServiceException {
		/**
		 * If the exception is annotated with @ResponseStatus rethrow it and let
		 * the framework handle it - at the start of this post. AnnotationUtils
		 * is a Spring Framework utility class.
		 */
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
			throw e;
		}

		/**
		 * Otherwise setup and send the user to a default error-view.
		 */
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.addObject("status", res.getStatus());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

}
