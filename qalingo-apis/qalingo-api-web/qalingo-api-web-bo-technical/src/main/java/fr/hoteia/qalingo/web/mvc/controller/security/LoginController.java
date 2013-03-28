/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.7.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2013
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package fr.hoteia.qalingo.web.mvc.controller.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.hoteia.qalingo.core.web.servlet.ModelAndViewThemeDevice;
import fr.hoteia.qalingo.web.mvc.controller.AbstractQalingoController;

/**
 * 
 */
@Controller
public class LoginController extends AbstractQalingoController {

	@RequestMapping("/login.html*")
	public ModelAndView login(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		ModelAndViewThemeDevice modelAndView = new ModelAndViewThemeDevice(getCurrentVelocityPath(request), "security/login");
		
		if(getUser() != null){
			final String urlRedirect = backofficeUrlService.buildHomeUrl();
	        return new ModelAndView(new RedirectView(urlRedirect));
		}
		
		final String titleKeyPrefixSufix = "login";
		initPage(request, response, modelAndView, titleKeyPrefixSufix);
		
		modelAndViewFactory.initLoginModelAndView(request, modelAndView);
		
        return modelAndView;
	}
	
	@RequestMapping("/login-check.html*")
	public ModelAndView loginCheck(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("security/login");
		
		if(getUser() != null){
			final String urlRedirect = backofficeUrlService.buildHomeUrl();
	        return new ModelAndView(new RedirectView(urlRedirect));
		}
		
		final String titleKeyPrefixSufix = "header.title.login";
		initPage(request, response, modelAndView, titleKeyPrefixSufix);
		
        return modelAndView;
	}
	
}