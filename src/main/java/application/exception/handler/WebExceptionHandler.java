package application.exception.handler;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.ModelAndView;

import application.exception.EntityNotFoundException;

@ControllerAdvice
public class WebExceptionHandler {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ModelAndView handleBadRequest(MethodArgumentNotValidException exc) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exception/error400");
		mv.addObject("errorMessage", exc.getMessage());
		return mv;
	}
	
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ModelAndView handleBadRequest(ConstraintViolationException  exc) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exception/error400");
		mv.addObject("errorMessage", exc.getMessage());
		return mv;
	}
	
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleNotFound(Exception exc) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exception/error404");
		mv.addObject("errorMessage", exc.getMessage());
		return mv;
	}
	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handle400(Exception exc) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("exception/error400");
//		mv.addObject("errorMessage", exc.getMessage());
//		return mv;
//	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ModelAndView handle404(EntityNotFoundException exc) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exception/error404");
		mv.addObject("errorMessage", exc.getMessage());
		return mv;
	}

	@ExceptionHandler(InternalServerError.class)
	public ModelAndView handle500(InternalServerError exc) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exception/error500");
		mv.addObject("errorMessage", exc.getMessage());
		return mv;
	}

}
